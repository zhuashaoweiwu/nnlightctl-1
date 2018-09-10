package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlightctl.dao.AlarmConfigMapper;
import com.nnlightctl.dao.AlarmHistoryMapper;
import com.nnlightctl.dao.AlarmMapper;
import com.nnlight.common.Tuple;
import com.nnlightctl.po.*;
import com.nnlightctl.request.AlarmConfigRequest;
import com.nnlightctl.request.AlarmRequest;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.server.ALarmServer;
import com.nnlightctl.vo.AlarmAndAlarmConfigView;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nnlightctl.jdbcdao.AlarmAndAlarmConfigDao;

import java.util.Date;
import java.util.List;
@Service
public class AlarmServerImpl implements ALarmServer{

    @Autowired
    private AlarmMapper alarmMapper;

    @Autowired
    private AlarmAndAlarmConfigDao alarmAndAlarmConfigDao;

    @Autowired
    private AlarmHistoryMapper alarmHistoryMapper;
    @Autowired
    private AlarmConfigMapper alarmConfigMapper;

    @Override
    public Tuple.TwoTuple<List<Alarm>, Integer> listAlarm(BaseRequest request) {
        Tuple.TwoTuple<List<Alarm>, Integer> tuple = new Tuple.TwoTuple<>();

        AlarmExample alarmExample = new AlarmExample();
        alarmExample.setOrderByClause("id DESC");

        int total =alarmMapper.countByExample(alarmExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<Alarm> alarmList = alarmMapper.selectByExample(alarmExample);
        tuple.setFirst(alarmList);

        return tuple;
    }
    public List<AlarmAndAlarmConfigView> getAlarm(Long id){

        return alarmAndAlarmConfigDao.getAlarm(id);

    }

    @Override
    public HSSFWorkbook exportElebox(List<Long> alarmIds) {
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("报警信息");

        //创建表头
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("ID");
        row1.createCell(1).setCellValue("创建日期");
        row1.createCell(2).setCellValue("修改日期");
        row1.createCell(3).setCellValue("报警编码");
        row1.createCell(4).setCellValue("来源");
        row1.createCell(5).setCellValue("等级");
        row1.createCell(6).setCellValue("状态");
        row1.createCell(7).setCellValue("类型");
        row1.createCell(8).setCellValue("报警时间");
        row1.createCell(9).setCellValue("解除时间");
        row1.createCell(10).setCellValue("消息");
        row1.createCell(11).setCellValue("次数");
        row1.createCell(12).setCellValue("报警配置");

        int rowIndex = 1;
        for (Long id : alarmIds) {
            Alarm alarm = alarmMapper.selectByPrimaryKey(id);
            HSSFRow row = sheet.createRow(rowIndex++);
            //创建单元格并设置单元格内容
            row.createCell(0).setCellValue(alarm.getId());
            if (alarm.getGmtCreated() != null) {
                row.createCell(1).setCellValue(alarm.getGmtCreated());
            } else {
                row.createCell(1).setCellValue("");
            }
            if (alarm.getGmtUpdated() != null) {
                row.createCell(2).setCellValue(alarm.getGmtUpdated());
            } else {
                row.createCell(2).setCellValue("");
            }
            row.createCell(3).setCellValue(alarm.getCodeNumber());
            row.createCell(4).setCellValue(alarm.getAlarmSource());
            row.createCell(5).setCellValue(alarm.getAlarmLevel());
            row.createCell(6).setCellValue(alarm.getState());
            row.createCell(7).setCellValue(alarm.getCtype());
            if (alarm.getAlarmTime() != null) {
                row.createCell(8).setCellValue(alarm.getAlarmTime());
            } else {
                row.createCell(8).setCellValue("");
            }
            if (alarm.getRemoveAlarmTime() != null) {
                row.createCell(9).setCellValue(alarm.getRemoveAlarmTime());
            } else {
                row.createCell(9).setCellValue("");
            }

            row.createCell(10).setCellValue(alarm.getMsg());
            row.createCell(11).setCellValue(alarm.getAlarmCount());
            row.createCell(12).setCellValue(alarm.getNnlightctlAlarmConfigId().toString());

        }
        return wb;
    }

    public int clearAlarm(List<Long> alarmIds){
        Alarm alarm = new Alarm();
        AlarmHistory alarmHistory = new AlarmHistory();
        Byte state = 3;
        alarm.setState(state);
        alarm.setGmtUpdated(new Date());
        for (Long id : alarmIds) {
            alarm.setId(id);
            alarmMapper.updateByPrimaryKeySelective(alarm);

            alarmHistory.setGmtCreated(new Date());
            alarmHistory.setGmtUpdated(new Date());
            alarmHistory.setNnlightctlAlarmId(id);
            alarmHistory.setMem("因为电压过高导致系统报警。");
            alarmHistoryMapper.insert(alarmHistory);
        }
        return 1;
    }
    @Override
    public Tuple.TwoTuple<List<AlarmHistory>, Integer> listAlarmHistory(BaseRequest request) {
        Tuple.TwoTuple<List<AlarmHistory>, Integer> tuple = new Tuple.TwoTuple<>();

        AlarmHistoryExample alarmHistoryExample = new AlarmHistoryExample();
        alarmHistoryExample.setOrderByClause("id DESC");

        int total =alarmHistoryMapper.countByExample(alarmHistoryExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<AlarmHistory> alarmHistoriesList = alarmHistoryMapper.selectByExample(alarmHistoryExample);
        tuple.setFirst(alarmHistoriesList);

        return tuple;
    }

    @Override
    public int clearAlarmHistory(List<Long> alarmHistoryIds) {
        for (Long id : alarmHistoryIds) {
            alarmHistoryMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }

    @Override
    public HSSFWorkbook exportAlarmHistory(List<Long> alarmHistoryIds) {
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("报警历史信息");

        //创建表头
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("ID");
        row1.createCell(1).setCellValue("创建日期");
        row1.createCell(2).setCellValue("修改日期");
        row1.createCell(3).setCellValue("报警信息Id");
        row1.createCell(4).setCellValue("终端");
        row1.createCell(5).setCellValue("地址");
        row1.createCell(6).setCellValue("通道");
        row1.createCell(7).setCellValue("备注");
        int rowIndex = 1;
        for (Long id : alarmHistoryIds) {
            AlarmHistory alarmHistory = alarmHistoryMapper.selectByPrimaryKey(id);
            HSSFRow row = sheet.createRow(rowIndex++);
            //创建单元格并设置单元格内容
            row.createCell(0).setCellValue(alarmHistory.getId());
            if (alarmHistory.getGmtCreated() != null) {
                row.createCell(1).setCellValue(alarmHistory.getGmtCreated());
            } else {
                row.createCell(1).setCellValue("");
            }
            if (alarmHistory.getGmtUpdated() != null) {
                row.createCell(2).setCellValue(alarmHistory.getGmtUpdated());
            } else {
                row.createCell(2).setCellValue("");
            }
            row.createCell(3).setCellValue(alarmHistory.getNnlightctlAlarmId());
            row.createCell(4).setCellValue(alarmHistory.getTerminal());
            row.createCell(5).setCellValue(alarmHistory.getAddress());
            row.createCell(6).setCellValue(alarmHistory.getAlarmHistoryChannel());
            row.createCell(7).setCellValue(alarmHistory.getMem());
        }
        return wb;
    }
    @Override
    public int configAlarm(AlarmConfigRequest larmConfigRequest){
        AlarmConfig alarmConfig = new AlarmConfig();
        alarmConfig.setGmtUpdated(new Date());
        alarmConfig.setGmtCreated(new Date());
        alarmConfig.setAlarmConfigLevel(larmConfigRequest.getAlarmConfigLevel());
        alarmConfig.setIsNoticeEmail(larmConfigRequest.getIsNoticeEmail());
        alarmConfig.setIsNoticeMap(larmConfigRequest.getIsNoticeMap());
        alarmConfig.setIsNoticeSms(larmConfigRequest.getIsNoticeSms());
        alarmConfig.setIsNoticeWeixin(larmConfigRequest.getIsNoticeWeixin());
        int tep =  alarmConfigMapper.insert(alarmConfig);
        return tep;
    }
    @Override
    public int updateIsUseAlarm(List<AlarmRequest> request){
        AlarmExample alarmExample = new AlarmExample();
        alarmExample.setOrderByClause("id DESC");
        for (AlarmRequest alarmRequest :request) {
            alarmExample.createCriteria().andAlarmSourceEqualTo(alarmRequest.getAlarmSource());
            alarmExample.createCriteria().andCtypeEqualTo(alarmRequest.getCtype());
            List<Alarm> alarmList = alarmMapper.selectByExample(alarmExample);
            for (Alarm alarm : alarmList) {
                alarm.setIsUse(alarmRequest.getIsUse());
                alarmMapper.updateByPrimaryKeySelective(alarm);
            }
        }
        return 1;
    }

}
