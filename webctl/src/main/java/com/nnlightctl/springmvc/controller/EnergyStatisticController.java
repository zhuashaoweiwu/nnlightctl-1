package com.nnlightctl.springmvc.controller;

import com.nnlightctl.po.EleboxVolEleRecord;
import com.nnlightctl.po.LightingVolEleRecord;
import com.nnlightctl.request.EleboxPowerRequest;
import com.nnlightctl.request.LightingVolEleRecordRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.EnergyStatisticServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/energyStatistic")
public class EnergyStatisticController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(EnergyStatisticController.class);

    @Autowired
    private EnergyStatisticServer energyStatisticServer;

    /*
    *三、通过控制柜id获取某段时间范围内的功率 （包括有功功率及无功功率）
    * */
    @RequestMapping("listEleboxPower")
    public String listEleboxPower(EleboxPowerRequest eleboxPowerRequest){

        logger.info("[POST] /api/energyStatistic/listEleboxPower");
        List<EleboxVolEleRecord> eleboxVolEleRecordList = energyStatisticServer.listEleboxPower(eleboxPowerRequest);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(eleboxVolEleRecordList);

        return toJson(jsonResult);
    }

    /*
    *四 通过控制柜id获取某段时间范围内的电流
    * */
    @RequestMapping("listEleboxElectric")
    public String listEleboxElectric(EleboxPowerRequest eleboxPowerRequest){

        logger.info("[POST] /api/energyStatistic/listEleboxElectric");

        List<EleboxVolEleRecord> eleboxVolEleRecordList = energyStatisticServer.listEleboxPower(eleboxPowerRequest);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(eleboxVolEleRecordList);

        return toJson(jsonResult);
    }

    /*
    * 五、通过控制柜id获取某段时间范围内的电压
    * */
    @RequestMapping("listEleboxVoltage")
    public String listEleboxVoltage(EleboxPowerRequest eleboxPowerRequest){
        logger.info("[POST] /api/energyStatistic/listEleboxVoltage");

        List<EleboxVolEleRecord> eleboxVolEleRecordList = energyStatisticServer.listEleboxPower(eleboxPowerRequest);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(eleboxVolEleRecordList);

        return toJson(jsonResult);
    }
    /*
    *八、获取一段时间范围内的一组灯具（至少选择一盏灯具）的平均电压值的集合
    * */
    @RequestMapping("listLightAvgVoltage")
    public String listLightAvgVoltage(LightingVolEleRecordRequest lightingVolEleRecordRequest){

        logger.info("[POST] /api/energyStatistic/listLightAvgVoltage");

        List<LightingVolEleRecord> lightingVolEleRecordList = energyStatisticServer.listLightingVolEleRecord(lightingVolEleRecordRequest);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(lightingVolEleRecordList);

        return toJson(jsonResult);
    }
    /*
    *九、获取一段时间范围内的一组灯具（至少选择一盏灯具）的平均电流值的集合
    * */
    @RequestMapping("listLightAvgElectric")
    public String listLightAvgElectric(LightingVolEleRecordRequest lightingVolEleRecordRequest){
        logger.info("[POST] /api/energyStatistic/listLightAvgElectric");

        List<LightingVolEleRecord> lightingVolEleRecordList = energyStatisticServer.listLightingVolEleRecord(lightingVolEleRecordRequest);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(lightingVolEleRecordList);

        return toJson(jsonResult);
    }
    /*
    *十、获取一段时间范围内的一组灯具（至少选择一盏灯具）的平均功率值的集合
    * */
    @RequestMapping("listLightAvgPower")
    public String listLightAvgPower(LightingVolEleRecordRequest lightingVolEleRecordRequest){
        logger.info("[POST] /api/energyStatistic/listLightAvgPower");

        List<LightingVolEleRecord> lightingVolEleRecordList = energyStatisticServer.listLightingVolEleRecord(lightingVolEleRecordRequest);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(lightingVolEleRecordList);

        return toJson(jsonResult);
    }
}
