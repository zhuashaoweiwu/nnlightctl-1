package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.UserMapper;
import com.nnlightctl.dao.UserOperationLogMapper;
import com.nnlightctl.jdbcdao.UserDao;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.po.User;
import com.nnlightctl.po.UserOperationLog;
import com.nnlightctl.po.UserOperationLogExample;
import com.nnlightctl.request.UserOpLogConditionRequest;
import com.nnlightctl.server.UserOpLogServer;
import com.nnlightctl.vo.UserOpLogView;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
public class UserOpLogServerImpl implements UserOpLogServer {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserOperationLogMapper userOperationLogMapper;

    @Autowired
    private UserDao userDao;

    @Override
    public Tuple.TwoTuple<List<UserOpLogView>, Integer> listUserOpLog(UserOpLogConditionRequest request) {
        Tuple.TwoTuple<List<UserOpLogView>, Integer> tuple = new Tuple.TwoTuple<>();

        UserOperationLogExample userOperationLogExample = new UserOperationLogExample();
        userOperationLogExample.setOrderByClause("id DESC");

        UserOperationLogExample.Criteria criteria = userOperationLogExample.createCriteria();
        if (request.getOperationType() != null) {
            criteria.andOperationTypeEqualTo(request.getOperationType().byteValue());
        }

        if (request.getStartDate() != null) {
            criteria.andOperationTimeGreaterThanOrEqualTo(request.getStartDate());
        }

        if (request.getEndDate() != null) {
            criteria.andOperationTimeLessThanOrEqualTo(request.getEndDate());
        }

        if (!StringUtils.isEmpty(request.getContent())) {
            criteria.andOperationDescLike("%" + request.getContent() + "%");
        }

        if(request.getUserId() != null){
            criteria.andNnlightctlUserIdEqualTo(request.getUserId().longValue());
        }

        int total = userOperationLogMapper.countByExample(userOperationLogExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<UserOperationLog> userOperationLogList = userOperationLogMapper.selectByExample(userOperationLogExample);

        List<UserOpLogView> userOpLogViewList = new ArrayList<>(8);

        for (UserOperationLog userOperationLog : userOperationLogList) {
            Long opUserId = userOperationLog.getNnlightctlUserId();
            User user = userMapper.selectByPrimaryKey(opUserId);

            UserOpLogView userOpLogView = new UserOpLogView();
            ReflectCopyUtil.beanSameFieldCopy(user, userOpLogView);

            ReflectCopyUtil.beanSameFieldCopy(userOperationLog, userOpLogView);

            userOpLogViewList.add(userOpLogView);
        }

        tuple.setFirst(userOpLogViewList);

        return tuple;
    }

    @Override
    public HSSFWorkbook exportElebox(Long userId){
    //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("操作日志");

        //创建表头
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("ID");
        row1.createCell(1).setCellValue("创建日期");
        row1.createCell(2).setCellValue("修改日期");
        row1.createCell(3).setCellValue("用户Id");
        row1.createCell(4).setCellValue("操作类型");
        row1.createCell(5).setCellValue("操作时间");
        row1.createCell(6).setCellValue("操作描述");

        int rowIndex = 1;
        List<UserOperationLog> userOperationLogList = userDao.listUserOpLog(userId);
        for (UserOperationLog userOperationLog : userOperationLogList) {
            HSSFRow row = sheet.createRow(rowIndex++);
            //创建单元格并设置单元格内容
            row.createCell(0).setCellValue(userOperationLog.getId());
            if (userOperationLog.getGmtCreated() != null) {
                row.createCell(1).setCellValue(userOperationLog.getGmtCreated());
            } else {
                row.createCell(1).setCellValue("");
            }
            if (userOperationLog.getGmtUpdated() != null) {
                row.createCell(2).setCellValue(userOperationLog.getGmtUpdated());
            } else {
                row.createCell(2).setCellValue("");
            }
            row.createCell(3).setCellValue(userOperationLog.getNnlightctlUserId());
            row.createCell(4).setCellValue(userOperationLog.getOperationType());
            if (userOperationLog.getOperationTime() != null) {
                row.createCell(5).setCellValue(userOperationLog.getOperationTime());
            } else {
                row.createCell(5).setCellValue("");
            }
            row.createCell(6).setCellValue(userOperationLog.getOperationDesc());
        }
        return wb;
    }

    @Override
    public int importUserOpLog(InputStream is, String fileName) throws IOException {
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
                    UserOperationLog userOperationLog = new UserOperationLog();
                    userOperationLog.setGmtCreated(new Date());
                    userOperationLog.setGmtUpdated(new Date());

                    String opType = hssfRow.getCell(4).getStringCellValue();
                    userOperationLog.setOperationType(Byte.valueOf(opType));
                    userOperationLog.setOperationTime(hssfRow.getCell(5).getDateCellValue());
                    userOperationLog.setOperationDesc(hssfRow.getCell(6).getStringCellValue());
                    userOperationLogMapper.insertSelective(userOperationLog);
                }
            }
        }
        is.close();
        return  1;
    }

    @Override
    public int addUserOpLog(UserOperationLog usereOpLog) {
        return userOperationLogMapper.insertSelective(usereOpLog);
    }
}
