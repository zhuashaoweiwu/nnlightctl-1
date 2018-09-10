package com.nnlightctl.springmvc.controller;

import com.nnlightctl.po.Alarm;
import com.nnlight.common.Tuple;
import com.nnlightctl.po.AlarmHistory;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.util.DownloadUtil;
import com.nnlightctl.vo.AlarmAndAlarmConfigView;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import com.nnlightctl.request.*;
import org.slf4j.LoggerFactory;
import com.nnlightctl.server.ALarmServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/alarm")
public class AlarmController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(AlarmController.class);
    @Autowired
    private ALarmServer aLarmServer;

    @RequestMapping("listAlarm")
    public String listAlarm(BaseRequest request){
        logger.info("[POST] /api/alarm/listAlarm");

        JsonResult jsonResult = JsonResult.getSUCCESS();

        Tuple.TwoTuple<List<Alarm>, Integer> tuple = aLarmServer.listAlarm(request);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }

    @RequestMapping("getAlarm")
    public String getAlarm(Long id){
        logger.info("[POST] /api/alarm/getAlarm");
        JsonResult jsonResult = JsonResult.getSUCCESS();

        List<AlarmAndAlarmConfigView> list = aLarmServer.getAlarm(id);
        jsonResult.setData(list);

        return toJson(jsonResult);
    }

    @RequestMapping("exportAlarm")
    public void exportAlarm(AlarmRequest alarmRequest,HttpServletResponse response){
        logger.info("[POST] /api/alarm/exportAlarm");

        HSSFWorkbook workbook = aLarmServer.exportElebox(alarmRequest.getAlarmIds());
        String excelName = "报警信息";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String downloadFileName = excelName + "-" + sdf.format(new Date());

        DownloadUtil.downloadExcel(response, downloadFileName, workbook);
    }

    @RequestMapping("clearAlarm")
    public String clearAlarm(AlarmRequest alarmRequest){

        logger.info("[POST] /api/alarm/clearAlarm");
        JsonResult jsonResult = null;
        int ret = aLarmServer.clearAlarm(alarmRequest.getAlarmIds());
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    @RequestMapping("listAlarmHistory")
    public String listAlarmHistory(BaseRequest request){
        logger.info("[POST] /api/alarm/listAlarmHistory");

        JsonResult jsonResult = JsonResult.getSUCCESS();
        Tuple.TwoTuple<List<AlarmHistory>, Integer> tuple = aLarmServer.listAlarmHistory(request);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());
        return toJson(jsonResult);
    }
    @RequestMapping("clearAlarmHistory")
    public String clearAlarmHistory(AlarmHistoryRequest request){
        logger.info("[POST] /api/alarm/clearAlarmHistory");

        JsonResult jsonResult = null;
        int ret = aLarmServer.clearAlarmHistory(request.getAlarmHistoryIds());
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }

    @RequestMapping("exportAlarmHistory")
    public void exportAlarmHistory(AlarmHistoryRequest alarmHistoryRequest,HttpServletResponse response){
        logger.info("[POST] /api/alarm/exportAlarmHistory");

        HSSFWorkbook workbook = aLarmServer.exportAlarmHistory(alarmHistoryRequest.getAlarmHistoryIds());
        String excelName = "报警历史记录";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String downloadFileName = excelName + "-" + sdf.format(new Date());

        DownloadUtil.downloadExcel(response, downloadFileName, workbook);
    }

    @RequestMapping("configAlarm")
    public String configAlarm(AlarmConfigRequest request){
        logger.info("[POST] /api/alarm/configAlarm");

        JsonResult jsonResult = null;
        int ret = aLarmServer.configAlarm(request);

        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
    *  是否启用报警信息
    * */
    @RequestMapping("configIsUseAlarm")
    public String configIsUseAlarm(List<AlarmRequest> alarmRequestList){

        JsonResult jsonResult = null;
        int ret = aLarmServer.configIsUseAlarm(alarmRequestList);
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
}
