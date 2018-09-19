package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.GisPointUtil;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.LightingMapper;
import com.nnlightctl.jdbcdao.LightDao;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.po.LightingExample;
import com.nnlightctl.request.LightConditionRequest;
import com.nnlightctl.request.LightRequest;
import com.nnlightctl.server.LightServer;
import com.nnlightctl.vo.LightingView;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LightServerImpl implements LightServer {
    @Autowired
    private LightingMapper lightingMapper;

    @Autowired
    private LightDao lightDao;

    @Override
    public int addOrUpdateLight(LightRequest request) {
        Lighting lighting = new Lighting();
        ReflectCopyUtil.beanSameFieldCopy(request, lighting);
        lighting.setGmtUpdated(new Date());
        if (!StringUtils.isEmpty(request.getDecay())) {
            lighting.setDecay(new BigDecimal(request.getDecay()));
        }
        int ret = -1;
        if (request.getId() != null) {  //修改
            ret = lightingMapper.updateByPrimaryKeySelective(lighting);
        } else {
            lighting.setGmtCreated(new Date());
            ret = lightingMapper.insertSelective(lighting);
        }
        return ret;
    }

    @Override
    public int batchAddLight(LightRequest.BatchLightRequest request) {
        List<LightRequest> lightRequestList = request.getAddLightings();
        for (LightRequest lightRequest : lightRequestList) {
            Lighting lighting = new Lighting();
            lighting.setDecay(new BigDecimal(lightRequest.getDecay()));
            ReflectCopyUtil.beanSameFieldCopy(lightRequest, lighting);
            lighting.setGmtCreated(new Date());

            lighting.setGmtUpdated(new Date());
            lightingMapper.insertSelective(lighting);
        }

        return 1;
    }

    @Override
    public int deleteLight(LightConditionRequest request) {
        List<Long> deleteLightIdList = request.getDeleteLightIdList();
        int ret = -1;
        for (Long deleteLightId : deleteLightIdList) {
            ret = lightingMapper.deleteByPrimaryKey(deleteLightId);
        }
        return ret;
    }

    @Override
    public Tuple.TwoTuple<List<Lighting>, Integer> listLighting(LightConditionRequest request) {
        Tuple.TwoTuple<List<Lighting>, Integer> tuple = new Tuple.TwoTuple<>();
        LightingExample lightingExample = new LightingExample();
        LightingExample.Criteria criteria = lightingExample.createCriteria();

        if (request.getNotBe() != null && request.getNotBe() == 1) {
            //搜索不属于任何控制柜的灯具
            criteria.andNnlightctlEleboxIdIsNull();
        } else if (request.getEleboxId() != null) {
            //搜索某控制柜下全部灯具
            criteria.andNnlightctlEleboxIdEqualTo(request.getEleboxId());
        }

        if (request.getProjectId() != null) {
            criteria.andNnlightctlProjectIdEqualTo(request.getProjectId());
        }

        int total = this.lightingMapper.countByExample(lightingExample);
        PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        lightingExample.setOrderByClause("id DESC");
        List<Lighting> lightings = this.lightingMapper.selectByExample(lightingExample);

        tuple.setFirst(lightings);
        tuple.setSecond(total);
        return tuple;
    }

    @Override
    public int updateLightBeElebox(LightConditionRequest request) {
        List<Long> lightIdList = request.getLightIdList();
        for (Long lightId : lightIdList) {
            Lighting lighting = new Lighting();
            lighting.setId(lightId);
            lighting.setNnlightctlEleboxId(request.getBeEleboxId());
            this.lightingMapper.updateByPrimaryKeySelective(lighting);
        }
        return 1;
    }

    @Override
    public Lighting getLighting(Long id) {
        return lightingMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Lighting> getLightByLoopId(Long id) {
        LightingExample lightingExample = new LightingExample();
        lightingExample.createCriteria().andNnlightctlEleboxModelLoopIdEqualTo(id);
        lightingExample.setOrderByClause("id DESC");

        return lightingMapper.selectByExample(lightingExample);
    }

    @Override
    public int updateLightBeEleboxBeLoop(LightConditionRequest request) {
        lightDao.clearLightBeEleboxBeLoop(request.getLightIdList());
        List<Long> lightIdList = request.getLightIdList();
        for (Long lightId : lightIdList) {
            Lighting lighting = new Lighting();
            lighting.setId(lightId);
            lighting.setNnlightctlEleboxId(request.getEleboxId());
            lighting.setNnlightctlEleboxModelLoopId(request.getModelLoopId());
            lightingMapper.updateByPrimaryKeySelective(lighting);
        }
        return 1;
    }

    @Override
    public int updateLightBeEleboxBeLoop2(LightConditionRequest request) {
        lightDao.clearLightBeEleboxBeLoop(request.getOriginalLightIds());
        List<Long> lightIdList = request.getLightIdList();
        for (Long lightId : lightIdList) {
            Lighting lighting = new Lighting();
            lighting.setId(lightId);
            lighting.setNnlightctlEleboxId(request.getBeEleboxId());
            lighting.setNnlightctlEleboxModelLoopId(request.getModelLoopId());
            lightingMapper.updateByPrimaryKeySelective(lighting);
        }
        return 1;
    }

    @Override
    public int importLighting(InputStream is, String fileName) throws IOException {
        if (is == null) {
            throw new RuntimeException("导入灯具文档打开失败！");
        }

        Workbook hssfWorkbook = null;
        if (fileName.endsWith("xlsx")){
            hssfWorkbook = new XSSFWorkbook(is);//Excel 2007
        }else if (fileName.endsWith("xls")){
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
                    Lighting lighting = new Lighting();

                    lighting.setUid(hssfRow.getCell(0).getStringCellValue());
                    lighting.setManufacture(hssfRow.getCell(1).getDateCellValue());
                    lighting.setUseDate(hssfRow.getCell(2).getDateCellValue());
                    lighting.setLamppost(hssfRow.getCell(3).getStringCellValue());
                    lighting.setLamphead(hssfRow.getCell(4).getStringCellValue());
                    lighting.setPropertySerialNumber(hssfRow.getCell(5).getStringCellValue());
                    lighting.setDecay(new BigDecimal(hssfRow.getCell(6).getNumericCellValue()));
                    lighting.setMaxUseTime(Math.round((hssfRow.getCell(7).getNumericCellValue())));
                    lighting.setMem(hssfRow.getCell(8).getStringCellValue());

                    lighting.setGmtCreated(new Date());
                    lighting.setGmtUpdated(new Date());

                    lightingMapper.insertSelective(lighting);
                }
            }
        }

        is.close();

        return 1;
    }

    @Override
    public HSSFWorkbook exportLighting(List<Long> lightIdList) {
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("灯具");

        //创建表头
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        Font font = wb.createFont();
        font.setColor(HSSFFont.COLOR_RED);
        row1.createCell(0).setCellValue("UID");
        row1.createCell(1).setCellValue("生产日期");
        row1.createCell(2).setCellValue("使用日期");
        row1.createCell(3).setCellValue("灯杆");
        row1.createCell(4).setCellValue("灯头");
        row1.createCell(5).setCellValue("资产编号");
        row1.createCell(6).setCellValue("光衰");
        row1.createCell(7).setCellValue("最大使用时长");
        row1.createCell(8).setCellValue("备注");

        //生成数据
        int rowIndex = 1;
        for (Long id : lightIdList) {
            Lighting lighting = lightingMapper.selectByPrimaryKey(id);
            HSSFRow row = sheet.createRow(rowIndex++);
            //创建单元格并设置单元格内容
            row.createCell(0).setCellValue(lighting.getUid());
            if (lighting.getManufacture() != null) {
                row.createCell(1).setCellValue(lighting.getManufacture()+"");
            } else {
                row.createCell(1).setCellValue("");
            }
            if (lighting.getUseDate() != null) {
                row.createCell(2).setCellValue(lighting.getUseDate()+"");
            } else {
                row.createCell(2).setCellValue("");
            }
            row.createCell(3).setCellValue(lighting.getLamppost());
            row.createCell(4).setCellValue(lighting.getLamphead());
            row.createCell(5).setCellValue(lighting.getPropertySerialNumber());
            row.createCell(6).setCellValue(lighting.getDecay().toString());
            row.createCell(7).setCellValue(String.valueOf(lighting.getMaxUseTime()));
            row.createCell(8).setCellValue(lighting.getMem());
        }

        return wb;
    }

    @Override
    public Tuple.TwoTuple<List<LightingView>, Integer> listLightingView(LightConditionRequest request) {
        return lightDao.listLightingView(request);
    }

    @Override
    public List<LightingView> listSelectLighting(LightConditionRequest request) {
        Tuple.TwoTuple<List<LightingView>, Integer> tuple = listLightingView(new LightConditionRequest());
        List<LightingView> lightingViewList = tuple.getFirst();
        List<LightingView> resultLightingViewList = new ArrayList<>(8);

        //构造坐标比较矩形
        GisPointUtil.Rectangular rectangular = new GisPointUtil.Rectangular(request.getStartLongitude(), request.getStartLatitude(),
                request.getEndLongitude(), request.getEndLatitude());
        for (LightingView lightingView : lightingViewList) {
            GisPointUtil.Point point = new GisPointUtil.Point(lightingView.getLongitude(), lightingView.getLatitude());
            if (GisPointUtil.checkGisPoint(point, rectangular)) {
                resultLightingViewList.add(lightingView);
            }
        }

        return resultLightingViewList;
    }

    @Override
    public int unbindLightBeElebox(List<Long> lightIds) {
        return lightDao.clearLightBeEleboxBeLoop(lightIds);
    }

    @Override
    public Tuple.TwoTuple<List<LightingView>, Integer> listLoopLighting(LightConditionRequest request) {
        return lightDao.listLoopLightingView(request);
    }

    @Override
    public int updateLightPriority(LightConditionRequest request) {
        Lighting lighting = new Lighting();
        lighting.setId(request.getId());
        lighting.setLoopPriority(request.getPriority().byteValue());

        return lightingMapper.updateByPrimaryKeySelective(lighting);
    }

    @Override
    public int updatePairLighting(Lighting lighting) {
        //查询是否存在uuid对应的灯具信息记录
        LightingExample lightingExample = new LightingExample();
        lightingExample.createCriteria().andUidEqualTo(lighting.getUid());
        List<Lighting> lightings = this.lightingMapper.selectByExample(lightingExample);
        int count = lightings.size();

        if (count > 0) {    //存在,更新
            Lighting updateLighting = new Lighting();
            updateLighting.setGmtUpdated(new Date());
            updateLighting.setRealtimeUid(lighting.getRealtimeUid());
            updateLighting.setId(lightings.get(0).getId());

            this.lightingMapper.updateByPrimaryKeySelective(updateLighting);
        } else {    //不存在，新增一个uuid确定的灯具
            Lighting createLighting = new Lighting();
            createLighting.setGmtCreated(new Date());
            createLighting.setGmtUpdated(new Date());
            createLighting.setUid(lighting.getUid());
            createLighting.setRealtimeUid(lighting.getRealtimeUid());

            this.lightingMapper.insertSelective(createLighting);
        }
        return 1;
    }
}
