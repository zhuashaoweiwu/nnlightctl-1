package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.PubMethod;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.EleboxMapper;
import com.nnlightctl.dao.EleboxModelLoopMapper;
import com.nnlightctl.dao.EleboxModelMapper;
import com.nnlightctl.dao.EleboxRelationMapper;
import com.nnlightctl.dao.LampControllerMapper;
import com.nnlightctl.jdbcdao.EleboxDao;
import com.nnlightctl.po.*;
import com.nnlightctl.request.*;
import com.nnlightctl.server.AreaServer;
import com.nnlightctl.server.EleboxModelServer;
import com.nnlightctl.server.EleboxServer;
import com.nnlightctl.server.ElectricityMeterServer;
import com.nnlightctl.server.ModelLoopServer;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EleboxServerImpl implements EleboxServer {

    @Autowired
    private EleboxMapper eleboxMapper;

    @Autowired
    private EleboxRelationMapper eleboxRelationMapper;

    @Autowired
    private EleboxModelServer eleboxModelServer;

    @Autowired
    private EleboxModelMapper eleboxModelMapper;

    @Autowired
    private EleboxModelLoopMapper eleboxModelLoopMapper;

    @Autowired
    private ModelLoopServer modelLoopServer;

    @Autowired
    private EleboxDao eleboxDao;

    @Autowired
    private LampControllerMapper lampControllerMapper;

    @Autowired
    private AreaServer areaServer;

    @Autowired
    private ElectricityMeterServer meterServer;

    @Override
    public int insertElebox(EleboxAddModelRequest request) {
        int ret = -1;
        int count = request.getCount() > 0 ? request.getCount() : 1;
        for (int i = 0; i < count; ++i) {
            Elebox elebox = new Elebox();
            elebox.setGmtCreated(new Date());
            elebox.setGmtUpdated(new Date());

            ret = eleboxMapper.insertSelective(elebox);

            List<EleboxModelRequest> eleboxModelRequestList = request.getDeviceList();
            for (EleboxModelRequest eleboxModelRequest : eleboxModelRequestList) {
                eleboxModelRequest.setNnlightctlEleboxId(elebox.getId());
                ret = eleboxModelServer.addEleboxModel(eleboxModelRequest);
            }
        }
        return ret;
    }

    @Override
    public int getCountModelByUid(String uid) {
        EleboxModelExample eleboxModelExample = new EleboxModelExample();
        eleboxModelExample.createCriteria().andUidEqualTo(uid);
        int total = eleboxModelMapper.countByExample(eleboxModelExample);
        return total;
    }

    @Override
    public int getCountModelLoopByLoopCode(ModelLoopByLoopCodeRequest request) {
        EleboxModelLoopExample eleboxModelExample = new EleboxModelLoopExample();
        EleboxModelLoopExample.Criteria criteria = eleboxModelExample.createCriteria();
        criteria.andLoopCodeEqualTo(request.getLoopCode());
        criteria.andNnlightctlEleboxModelIdEqualTo(request.getModelId());
        int total = eleboxModelLoopMapper.countByExample(eleboxModelExample);
        return total;
    }

    @Override
    public Elebox getEleboxById(Long id) {
        return eleboxMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateElebox(EleboxRequest request) {
        Elebox elebox = new Elebox();
        ReflectCopyUtil.beanSameFieldCopy(request, elebox);
        elebox.setGmtUpdated(new Date());

        return eleboxMapper.updateByPrimaryKeySelective(elebox);
    }

    @Override
    public int getCountEleboxByUid(String uid) {
        EleboxExample eleboxExample = new EleboxExample();
        eleboxExample.createCriteria().andUidEqualTo(uid);
        int total = eleboxMapper.countByExample(eleboxExample);
        return total;
    }

    @Override
    public int getCountEleboxByCodeNumber(String codeNumber) {
        EleboxExample eleboxExample = new EleboxExample();
        eleboxExample.createCriteria().andCodeNumberEqualTo(codeNumber);
        int total = eleboxMapper.countByExample(eleboxExample);
        return total;
    }

    @Override
    public int updateEleboxDevice(EleboxConditionRequest request) {
        List<Long> deleteDeviceIdList = request.getDeleteModelIdList();
        List<Long> addDeviceIdList = request.getAddModelIdList();

        /*处理删除的设备*/
        EleboxModelConditionRequest deleteModelRequest = new EleboxModelConditionRequest();
        deleteModelRequest.setEleboxModelIdList(deleteDeviceIdList);
        eleboxModelServer.deleteEleboxModel(deleteModelRequest);

        /*添加新增的设备*/
        for (Long addDeviceId : addDeviceIdList) {
            EleboxModelRequest addModelRequest = new EleboxModelRequest();
            addModelRequest.setId(addDeviceId);
            addModelRequest.setNnlightctlEleboxId(request.getId());
            eleboxModelServer.updateEleboxModel(addModelRequest);
        }

        return 1;
    }

    @Override
    public int updateModelLoopSplite(EleboxConditionRequest request) {
        //获取被拆分的回路
        EleboxModelLoop spliteModelLoop = eleboxModelLoopMapper.selectByPrimaryKey(request.getBeSplitId());

        //添加新的回路到数据库
        List<ModelLoopRequest> addModelLoopList = request.getSplitModelLoopList();
        for (ModelLoopRequest addModelLoop : addModelLoopList) {
            addModelLoop.setNnlightctlEleboxModelId(spliteModelLoop.getNnlightctlEleboxModelId());
            modelLoopServer.addOrUpdateModelLoop(addModelLoop);
        }

        //删除原回路
        eleboxModelLoopMapper.deleteByPrimaryKey(request.getBeSplitId());

        return 1;
    }

    @Override
    public int deleteElebox(EleboxConditionRequest request) {
        List<Long> deleteEleboxIdList = request.getEleboxIdList();
        for (Long deleteEleboxId : deleteEleboxIdList) {
            //先删除控制柜对应的设备
//            EleboxModelExample eleboxModelExample = new EleboxModelExample();
//            eleboxModelExample.createCriteria().andNnlightctlEleboxIdEqualTo(deleteEleboxId);
//            List<EleboxModel> eleboxModelList = eleboxModelMapper.selectByExample(eleboxModelExample);
//
//            List<Long> eleboxModelIdList = new ArrayList<>(10);
//            for (EleboxModel eleboxModel : eleboxModelList) {
//                eleboxModelIdList.add(eleboxModel.getId());
//            }
//            EleboxModelConditionRequest eleboxModelConditionRequest = new EleboxModelConditionRequest();
//            eleboxModelConditionRequest.setEleboxModelIdList(eleboxModelIdList);

//            eleboxModelServer.deleteEleboxModel(eleboxModelConditionRequest);
//            //删除关联表数据
//            this.eleboxRelationMapper.deleteByEleboxId(deleteEleboxId);
//            //取消box关联
//            this.eleboxModelMapper.modifyEleboxId(deleteEleboxId);

            //更改所有单灯loop为控部署状态置为0
            List<Long> modelIds = eleboxModelMapper.selectModelIdByEleboxId(deleteEleboxId);
            lampControllerMapper.updateByEleboxId(deleteEleboxId);
            if(!PubMethod.isEmpty(modelIds))
            //删除所有回路
            eleboxModelLoopMapper.deleteByEleboxModelIds(modelIds);
            //置空开关模块的控制柜ID
            eleboxModelMapper.modifyEleboxId(deleteEleboxId);
            //删除关照计
            meterServer.deleteDeployEletricityMeterAndPhotoriod(deleteEleboxId,(byte) 4);
            //删除电表
            meterServer.deleteDeployEletricityMeterAndPhotoriod(deleteEleboxId,(byte)3);
            //删除关联表
            eleboxRelationMapper.deleteByEleboxId(deleteEleboxId);
            //再删除控制柜本身
            this.eleboxMapper.deleteByPrimaryKey(deleteEleboxId);

        }
        return 1;
    }

    @Override
    public Tuple.TwoTuple<List<Elebox>, Integer> listElebox(EleboxConditionRequest request) {
        Tuple.TwoTuple<List<Elebox>, Integer> tuple = new Tuple.TwoTuple<>();

        EleboxExample eleboxExample = new EleboxExample();
        EleboxExample.Criteria criteria = eleboxExample.createCriteria();

        Long projectId = request.getProjectId();
        if (projectId != null) {
            criteria.andNnlightctlProjectIdEqualTo(projectId);
        }

        if (!StringUtils.isEmpty(request.getUid())) {
            criteria.andUidLike("%" + request.getUid() + "%");
        }

        if (!StringUtils.isEmpty(request.getCodeNumber())) {
            criteria.andCodeNumberLike("%" + request.getCodeNumber() + "%");
        }
        if (!StringUtils.isEmpty(request.getEleboxName())) {
            criteria.andEleboxName("%" + request.getEleboxName() + "%");
        }
        int total = eleboxMapper.countByExample(eleboxExample);
        tuple.setSecond(total);
        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        eleboxExample.setOrderByClause("id DESC");
        List<Elebox> eleboxList = eleboxMapper.selectByExample(eleboxExample);
//        List<EleboxView> eleboxViewList = new ArrayList<>(8);
//        for (Elebox elebox : eleboxList) {
//            EleboxView eleboxView = new EleboxView();
//            ReflectCopyUtil.beanSameFieldCopy(elebox, eleboxView);
//            if (elebox.getNnlightctlRegionId() != null && elebox.getNnlightctlRegionId() > 0) {
//                eleboxView.setRegionLevelDesc(areaServer.getLevelRegionDesc(elebox.getNnlightctlRegionId()));
//            }
//            eleboxViewList.add(eleboxView);
//        }

        tuple.setFirst(eleboxList);
        return tuple;
    }

    @Override
    public Tuple.TwoTuple<List<EleboxModel>, Integer> listEleboxModel(EleboxConditionRequest request) {
        Tuple.TwoTuple<List<EleboxModel>, Integer> twoTuple = new Tuple.TwoTuple<>();
        EleboxModelExample eleboxModelExample = new EleboxModelExample();
        EleboxModelExample.Criteria criteria = eleboxModelExample.createCriteria();


        if (!PubMethod.isEmpty(request.getEleboxId())) {
            criteria.andNnlightctlEleboxIdEqualTo(request.getEleboxId());
            criteria.andNnlightctlDeployStatusEqualTo((byte) 1);
        } else {
            criteria.andNnlightctlDeployStatusEqualTo((byte) 0);
        }

        if (!PubMethod.isEmpty(request.getModelName()))
            criteria.andModelNameLike("%" + request.getModelName() + "%");

        int total = eleboxModelMapper.countByExample(eleboxModelExample);
        twoTuple.setSecond(total);
        PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        eleboxModelExample.setOrderByClause("id DESC");
        List<EleboxModel> eleboxModelList = eleboxModelMapper.selectByExample(eleboxModelExample);
        twoTuple.setFirst(eleboxModelList);
        return twoTuple;
    }

    @Override
    public Tuple.TwoTuple<List<EleboxModelLoop>, Integer> listModelLoop(Long modelId) {
        Tuple.TwoTuple<List<EleboxModelLoop>, Integer> twoTuple = new Tuple.TwoTuple<>();
        EleboxModelLoopExample eleboxModelLoopExample = new EleboxModelLoopExample();
        eleboxModelLoopExample.createCriteria().andNnlightctlEleboxModelIdEqualTo(modelId);
        int total = eleboxModelLoopMapper.countByExample(eleboxModelLoopExample);
        twoTuple.setSecond(total);

        eleboxModelLoopExample.setOrderByClause("id DESC");
        List<EleboxModelLoop> eleboxModelLoops = eleboxModelLoopMapper.selectByExample(eleboxModelLoopExample);
        twoTuple.setFirst(eleboxModelLoops);
        return twoTuple;
    }

    @Override
    public int importElebox(InputStream is, String fileName) throws IOException {
        if (is == null) {
            throw new RuntimeException("导入控制柜文档打开失败！");
        }

        Workbook hssfWorkbook = null;
        if (fileName.endsWith("xlsx")) {
            hssfWorkbook = new XSSFWorkbook(is);//Excel 2007
        } else if (fileName.endsWith("xls")) {
            hssfWorkbook = new HSSFWorkbook(is);//Excel 2003

        }

        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                Row hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    Elebox elebox = new Elebox();

                    elebox.setUid(hssfRow.getCell(0).getStringCellValue());
                    elebox.setCodeNumber(hssfRow.getCell(1).getStringCellValue());
                    elebox.setManufacture(hssfRow.getCell(2).getDateCellValue());
                    elebox.setLongitude(hssfRow.getCell(3).getStringCellValue());
                    elebox.setLatitude(hssfRow.getCell(4).getStringCellValue());
                    elebox.setUseDate(hssfRow.getCell(5).getDateCellValue());
                    elebox.setRatedVoltage(new BigDecimal(hssfRow.getCell(6).getStringCellValue()));
                    elebox.setRatedElectricty(new BigDecimal(hssfRow.getCell(7).getStringCellValue()));
                    elebox.setPowerRating(new BigDecimal(hssfRow.getCell(8).getStringCellValue()));
                    try {
                        elebox.setMaxUseTime(Math.round(hssfRow.getCell(9).getNumericCellValue()));
                    } catch (NumberFormatException e) {
                        elebox.setMaxUseTime(null);
                    }
                    elebox.setSpd(hssfRow.getCell(10).getStringCellValue());
                    elebox.setMainSwitch(hssfRow.getCell(11).getStringCellValue());

                    elebox.setGmtCreated(new Date());
                    elebox.setGmtUpdated(new Date());

                    eleboxMapper.insertSelective(elebox);
                }
            }
        }

        is.close();

        return 1;
    }

    @Override
    public HSSFWorkbook exportElebox(List<Long> eleboxIds) {
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("控制柜");

        //创建表头
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);

        HSSFCellStyle cellStyle = wb.createCellStyle();

        cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);

        cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);

        cellStyle.setRightBorderColor(HSSFColor.BLACK.index);

        cellStyle.setTopBorderColor(HSSFColor.BLACK.index);

        row1.setRowStyle(cellStyle);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        row1.createCell(0).setCellValue("UID");
        row1.createCell(1).setCellValue("唯一编码");
        row1.createCell(2).setCellValue("生产日期");
        row1.createCell(3).setCellValue("经度");
        row1.createCell(4).setCellValue("纬度");
        row1.createCell(5).setCellValue("使用日期");
        row1.createCell(6).setCellValue("额定电压");
        row1.createCell(7).setCellValue("额定电流");
        row1.createCell(8).setCellValue("额定功率");
        row1.createCell(9).setCellValue("最大使用时间（年）");
        row1.createCell(10).setCellValue("SPD");
        row1.createCell(11).setCellValue("主进线开关");

        //生成数据
        int rowIndex = 1;
        for (Long id : eleboxIds) {
            Elebox elebox = eleboxMapper.selectByPrimaryKey(id);
            HSSFRow row = sheet.createRow(rowIndex++);
            //创建单元格并设置单元格内容
            row.createCell(0).setCellValue(elebox.getUid());
            row.createCell(1).setCellValue(elebox.getCodeNumber());
            if (elebox.getManufacture() != null) {
                row.createCell(2).setCellValue(elebox.getManufacture() + "");
            } else {
                row.createCell(2).setCellValue("");
            }
            row.createCell(3).setCellValue(elebox.getLongitude());
            row.createCell(4).setCellValue(elebox.getLatitude());
            if (elebox.getUseDate() != null) {
                row.createCell(5).setCellValue(elebox.getUseDate() + "");
            } else {
                row.createCell(5).setCellValue("");
            }
            row.createCell(6).setCellValue(elebox.getRatedVoltage().toString());
            row.createCell(7).setCellValue(elebox.getRatedElectricty().toString());
            row.createCell(8).setCellValue(elebox.getPowerRating().toString());
            row.createCell(9).setCellValue(String.valueOf(elebox.getMaxUseTime()));
            row.createCell(10).setCellValue(elebox.getSpd());
            row.createCell(11).setCellValue(elebox.getMainSwitch());
        }

        return wb;
    }

    @Override
    public int batchSetLightingArea(BatchSetEleboxAreaRequest batchSetEleboxAreaRequest) {

        return eleboxDao.batchSetEleboxArea(batchSetEleboxAreaRequest);
    }

    @Override
    public int batchSetLightingArea(BatchSetLightingAreaRequest batchSetLightingAreaRequest) {
        return eleboxDao.batchSetLightingArea(batchSetLightingAreaRequest);
    }

    public int batchConfigLightsBeElebox(BatchConfigLightsBeEleboxRequest batchConfigLightsBeEleboxRequest) {
        return eleboxDao.batchConfigLightsBeElebox(batchConfigLightsBeEleboxRequest);
    }

    @Override
    public int addOrUpdateElebox(EleboxRequest request) {

        Elebox elebox=new Elebox();

        ReflectCopyUtil.beanSameFieldCopy(request,elebox);

        int flag=-1;

        if (request.getId()==null){

            //新增
            flag = eleboxMapper.insertSelective(elebox);

        }else{

            flag=eleboxMapper.updateByPrimaryKeySelective(elebox);
        }
        return flag;
    }

    @Override
    public int deleteEleboxPrimaryKey(EleboxConditionRequest request) {

        List<Long> eleboxIdList = request.getEleboxIdList();

        int flag=-1;

        for (Long aLong : eleboxIdList) {

            flag = eleboxMapper.deleteByPrimaryKey(aLong);
        }
        return flag;
    }

    @Override
    public Tuple.TwoTuple<List<Elebox>,Integer> listEleboxMessage(EleboxConditionRequest request) {

        Tuple.TwoTuple<List<Elebox>,Integer> twoTuple=new Tuple.TwoTuple<>();

        List<Elebox> eleboxes=new ArrayList<>(8);

        EleboxExample eleboxExample=new EleboxExample();

        EleboxExample.Criteria criteria = eleboxExample.createCriteria();

        if (!StringUtils.isEmpty(request.getEquipmentNumber())){

            criteria.andEquipmentNumberLike("%"+request.getEquipmentNumber()+"%");
        }

        if (!StringUtils.isEmpty(request.getEleboxMode())){

            criteria.andEleboxModeLike("%"+request.getEleboxMode()+"%");
        }

        if (!StringUtils.isEmpty(request.getEleboxName())){

            criteria.andEleboxNameLike("%"+request.getEleboxName()+"%");
        }

        int total = eleboxMapper.countByExample(eleboxExample);

        twoTuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(),request.getPageSize());

        List<Elebox> eleboxList = eleboxMapper.selectByExample(eleboxExample);

        twoTuple.setFirst(eleboxList);

        return twoTuple;
    }

    @Override
    public Elebox selectEleboxById(EleboxConditionRequest request) {

        Elebox elebox = eleboxMapper.selectByPrimaryKey(request.getId());


        return elebox;
    }



    public void uploadImageElebox(MultipartFile eleboxGisIcon, String imagePath) {

    }
}
