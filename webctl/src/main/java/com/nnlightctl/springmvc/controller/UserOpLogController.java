package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.request.UserOpLogConditionRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.UserOpLogServer;
import com.nnlightctl.util.DownloadUtil;
import com.nnlightctl.vo.UserOpLogView;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserOpLogController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(UserOpLogController.class);

    @Autowired
    private UserOpLogServer userOpLogServer;

    @RequestMapping("listUserOpLog")
    public String listUserOpLog(UserOpLogConditionRequest request) {
        logger.info("[POST] /api/user/listUserOpLog");

        Tuple.TwoTuple<List<UserOpLogView>, Integer> tuple = userOpLogServer.listUserOpLog(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }

    /*
    * 一、根据用户id导出用户操作日志
    * */
    @RequestMapping("exportUserOpLog")
    public void exportUserOpLog(Long id , HttpServletResponse response){
        logger.info("[POST] /api/user/exportUserOpLog");

        HSSFWorkbook workbook = userOpLogServer.exportElebox(id);
        String excelName = "操作日志";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String downloadFileName = excelName + "-" + sdf.format(new Date());

        DownloadUtil.downloadExcel(response, downloadFileName, workbook);
    }

    /*
    *二、导入用户操作日志
    * */
    @RequestMapping("importUserOpLog")
    public String importUserOpLog(MultipartFile userOpLogFile){
        logger.info("[POST] /api/user/importUserOpLog");
        int ret = -1;
        try{
            userOpLogServer.importUserOpLog(userOpLogFile.getInputStream(),userOpLogFile.getOriginalFilename());
        }catch (IOException e){
            logger.error(e.getMessage());
        }
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }
}
