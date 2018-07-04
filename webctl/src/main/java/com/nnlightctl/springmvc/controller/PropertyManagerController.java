package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.ProjectCountry;
import com.nnlightctl.po.RepairRecord;
import com.nnlightctl.request.*;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.PropertyManagerServer;
import com.nnlightctl.vo.ListDeviceDamageCountByMonthView;
import com.nnlightctl.vo.ListDeviceRepairStatisticView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/propertyManager")
public class PropertyManagerController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(PropertyManagerController.class);

    @Autowired
    private PropertyManagerServer propertyManagerServer;

    /*
    * 前端接口-资产管理系统
    *一、通过时间范围搜索设备的维修统计情况
    * */
    @RequestMapping("listDeviceRepairStatistic")
    public String listDeviceRepaireStatistic(ListDeviceRepairStatisticRequest listDeviceRepairStatisticRequest){
        logger.info("[POST] /api/propertyManager/listDeviceRepairStatistic");

        List<ListDeviceRepairStatisticView> listDeviceRepairStatisticViewList = propertyManagerServer.listDeviceRepaireStatistic(listDeviceRepairStatisticRequest);

        JsonResult jsonResult = JsonResult.SUCCESS;
        jsonResult.setData(listDeviceRepairStatisticViewList);

        return toJson(jsonResult);
    }

    /*
    * 前端接口-资产管理系统
    *二、通过时间范围搜索基于月的设备损坏总数统计
    * */
    @RequestMapping("listDeviceDamageCountByMonth")
    public String listDeviceDamageCountByMonth(ListDeviceDamageCountByMonthRequest listDeviceDamageCountByMonthRequest){
        logger.info("[POST] /api/propertyManager/listDeviceDamageCountByMonth");


        List<ListDeviceDamageCountByMonthView> listDeviceDamageCountByMonthViewList = propertyManagerServer.listDeviceDamageCountByMonth(listDeviceDamageCountByMonthRequest);
        JsonResult jsonResult = JsonResult.SUCCESS;
        jsonResult.setData(listDeviceDamageCountByMonthViewList);

        return toJson(jsonResult);
    }

    /*
    * 前端接口-资产管理系统
    *四、通过搜索条件分页获取维修记录
    * */
    @RequestMapping("listRepairRecord")
    public String listRepairRecord(ListRepairRecordRequest request){

        logger.info("[POST] /api/propertyManager/listRepairRecord");
        JsonResult jsonResult = JsonResult.SUCCESS;

        Tuple.TwoTuple<List<RepairRecord>, Integer>  tuple = propertyManagerServer.listRepairRecord(request);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }

    /*
    * 前端接口-资产管理系统
    * 五、新建/修改维修记录
    * */
    @RequestMapping("addOrUpdateRepairRecord")
    public String addOrUpdateRepairRecord(RepairRecordRequest request){

        logger.info("[POST] /api/propertyManager/addOrUpdateRepairRecord");
        int ret = propertyManagerServer.addOrUpdateRepairRecord(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    /*
     * 前端接口-资产管理系统
     * 六、批量删除维修记录
     * */
    @RequestMapping("deleteRepairRecord")
    public String deleteRepairRecord(DeleteRepairRecordRequest request){

        logger.info("[POST] /api/propertyManager/deleteRepairRecord");

        int ret = propertyManagerServer.deleteRepairRecord(request.getRepairRecordIds());
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }

    /*
    * 前端接口-资产管理系统
    * 七、批量提交维修记录
    * */
    @RequestMapping("commitRepairRecord")
    public String commitRepairRecord(DeleteRepairRecordRequest request){
        logger.info("[POST] /api/propertyManager/commitRepairRecord");
        int ret = propertyManagerServer.commitRepairRecord(request.getRepairRecordIds());
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
}

