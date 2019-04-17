package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Alarm;
import com.nnlightctl.po.EleboxVolEleRecord;
import com.nnlightctl.po.LightSignalLog;
import com.nnlightctl.po.LightingVolEleRecord;
import com.nnlightctl.request.*;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.EnergyStatisticServer;
import com.nnlightctl.vo.CommonEnergyStatisticView;
import com.nnlightctl.vo.GetEleboxEnergyStatisticView;
import com.nnlightctl.vo.ListEleboxEnergyStatisticView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/energyStatistic")
public class EnergyStatisticController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(EnergyStatisticController.class);

    @Autowired
    private EnergyStatisticServer energyStatisticServer;

    /*
     *一、获取常规能耗统计数据
     * */
    @RequestMapping("getCommonEnergyStatistic")
    public String getCommonEnergyStatistic(){
        logger.info("[POST] /api/energyStatistic/getCommonEnergyStatistic");
        List<CommonEnergyStatisticView> commonEnergyStatisticViewList = energyStatisticServer.getCommonEnergyStatistic();
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(commonEnergyStatisticViewList);

        return toJson(jsonResult);
    }
    /*
     *二、按月份获取每天的能耗
     * */
    @RequestMapping("listEnergyStatisticByDay")
    public String listEnergyStatisticByDay(int month  ){
        logger.info("[POST] /api/energyStatistic/listEnergyStatisticByDay");
        List<CommonEnergyStatisticView> commonEnergyStatisticViewList = energyStatisticServer.listEnergyStatisticByDay(month);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(commonEnergyStatisticViewList);

        return toJson(jsonResult);
    }
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
     *六、通过时间段分页获取全部控制柜的能耗统计信息（每个控制柜都包括“亮灯率”、“消耗电能（kW*h）”、“节约电能”、“节能率”、“满载功率（kW）”）
     * 现阶段只能获取到能耗，其余没有数据。
     * */
    @RequestMapping("listEleboxEnergyStatistic")
    public String listEleboxEnergyStatistic(listEleboxEnergyStatisticRequest request){
        logger.info("[POST] /api/energyStatistic/listEleboxEnergyStatistic");
        List<ListEleboxEnergyStatisticView> listEleboxEnergyStatisticViewList = energyStatisticServer.listEleboxEnergyStatistic(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(listEleboxEnergyStatisticViewList);

        return toJson(jsonResult);
    }
    /*
     *七、通过控制柜id获取单个控制柜的统计信息（每个控制柜都包括“亮灯率”、“消耗电能（kW*h）”、“节约电能”、“节能率”、“满载功率（kW）”）
     * ，当时间范围多于一天时，同时返回控制柜每天的能耗，便于前端在选择一个控制柜后生成图表
     * 现阶段只能获取到能耗，其余没有数据。
     * */
    @RequestMapping("getEleboxEnergyStatistic")
    public String getEleboxEnergyStatistic(listEleboxEnergyStatisticRequest request){
        logger.info("[POST] /api/energyStatistic/getEleboxEnergyStatistic");
        List<GetEleboxEnergyStatisticView> listEleboxEnergyStatisticViewList = energyStatisticServer.getEleboxEnergyStatistic(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(listEleboxEnergyStatisticViewList);

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

    /*
    *十一、根据灯具唯一编码统计单个灯具的电压、能耗信息
    * */
    @RequestMapping("statisticLightEnergy")
    public String statisticLightEnergy(StatisticLightEnergyRequest request){

        logger.info("[POST] /api/energyStatistic/statisticLightEnergy");
        List<LightingVolEleRecord> lightingVolEleRecordList = energyStatisticServer.listStatisticLightEnergy(request);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(lightingVolEleRecordList);
        return toJson(jsonResult);
    }
    /*
     *十二、通过uuid和时间搜索终端信息日志
     * */
    @RequestMapping("listLightSignalLog")
    public String listLightSignalLog(SignalLogRequest request){
        logger.info("[POST] /api/energyStatistic/listLightSignalLog");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        Tuple.TwoTuple<List<LightSignalLog>, Integer> tuple = energyStatisticServer.listLightSignalLog(request);
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
}
