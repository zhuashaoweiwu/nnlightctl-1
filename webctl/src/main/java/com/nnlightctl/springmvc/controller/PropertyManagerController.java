package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.AlarmHistory;
import com.nnlightctl.po.Masker;
import com.nnlightctl.po.ProjectCountry;
import com.nnlightctl.po.RepairRecord;
import com.nnlightctl.request.*;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.MaskerServer;
import com.nnlightctl.server.PropertyManagerServer;
import com.nnlightctl.util.DownloadUtil;
import com.nnlightctl.vo.ListDeviceDamageCountByMonthView;
import com.nnlightctl.vo.ListDeviceRepairStatisticView;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/propertyManager")
public class PropertyManagerController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(PropertyManagerController.class);

    @Autowired
    private PropertyManagerServer propertyManagerServer;
    @Autowired
    private MaskerServer maskerServer;

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
     *二、通过时间范围搜索基于月的设备损坏总数统计
     * */
    @RequestMapping("exportDeviceOperation")
    public void exportDeviceOperation(ExportDeviceOperationRequest request,HttpServletResponse response){

        logger.info("[POST] /api/propertyManager/exportDeviceOperation");
        HSSFWorkbook workbook = propertyManagerServer.exportDeviceOperation(request);

        // 设置excel的文件名称
        String excelName = "设备运维概况";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String downloadFileName = excelName + "-" + sdf.format(new Date());

        DownloadUtil.downloadExcel(response, downloadFileName, workbook);

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

    /*
     * 前端接口-资产管理系统-联系人管理
     * 一、新增/修改联系人
     * */
    @RequestMapping("addOrUpdateMasker")
    public String addOrUpdateMasker(MaskerRequest request){
        logger.info("[POST] /api/propertyManager/addOrUpdateMasker");

        int ret =maskerServer.addOrUpdateMasker(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    /*
     * 前端接口-资产管理系统-联系人管理
     * 二、删除联系人
     * */
    @RequestMapping("deleteMasker")
    public String deleteMasker(DeleteMaskerRequest request){
        logger.info("[POST] /api/propertyManager/deleteMasker");

        JsonResult jsonResult = null;
        int ret = maskerServer.deleteMasker(request);

        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     * 前端接口-资产管理系统-联系人管理
     * 三、分页获取工单执行联系人
     * */
    @RequestMapping("listMasker")
    public String listMasker(BaseRequest request){
        logger.info("[POST] /api/propertyManager/listMasker");

        JsonResult jsonResult = JsonResult.getSUCCESS();
        Tuple.TwoTuple<List<Masker>, Integer> tuple = maskerServer.listMasker(request);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     * 前端接口-资产管理系统-联系人管理
     * 四、通过id获取单个执行联系人信息
     * */
    @RequestMapping("getMasker")
    public String getMasker(Long id){

        logger.info("[POST] /api/propertyManager/getMasker");

        JsonResult jsonResult = JsonResult.getSUCCESS();
        Masker masker = maskerServer.getMasker(id);
        List<Masker> maskerList = new ArrayList<>();
        maskerList.add(masker);
        jsonResult.setData(maskerList);

        return toJson(jsonResult);
    }
}

