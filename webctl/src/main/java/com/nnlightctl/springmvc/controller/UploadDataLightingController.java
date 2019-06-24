package com.nnlightctl.springmvc.controller;


import com.nnlightctl.request.UploadDataRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.UploadDataServer;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 上传GPS和EMEI编号
 *
 * @author keriezhang
 * @date 2019/4/11
 */
@RestController
@RequestMapping("api/uploadDataLighting")
public class UploadDataLightingController extends BaseController{
    private Logger logger=LoggerFactory.getLogger(UploadDataLightingController.class);
    @Autowired
    private UploadDataServer uploadDataServer;

    /**
     * 经度 维度 EMEI
     * @return
     */
    @RequestMapping("xyEMEI")
    public String xyEMEI(String x, String y, String imei){
        logger.info("[post] /api/uploadDataLighting/xyEMEI/");

        UploadDataRequest uploadDataRequest=new UploadDataRequest();
        uploadDataRequest.setLatitude(y);
        uploadDataRequest.setLongitude(x);
        uploadDataRequest.setImei(imei);

        JsonResult jsonResult = null;

        int ret = uploadDataServer.UploadGISAndImei(uploadDataRequest);
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);


    }

    @RequestMapping("countnumber")
    public String countNumber(String mem){

        char[] t1 = null;
        t1 = mem.toCharArray();
        int t0 = t1.length;
        int count = 0;
        for (int i = 0; i < t0; i++) {
            if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
                count ++;

            }
        }

        List<Integer> countnumber=new ArrayList<>();

        countnumber.add(count);

        JsonResult jsonResult=JsonResult.getSUCCESS();

        jsonResult.setData(countnumber);

        jsonResult.setTotal(-1);


        return toJson(jsonResult);
    }


}
