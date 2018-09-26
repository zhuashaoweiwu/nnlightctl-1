package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.*;
import com.nnlightctl.request.*;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.*;
import com.nnlightctl.util.DownloadUtil;
import com.nnlightctl.vo.ListDeviceDamageCountByMonthView;
import com.nnlightctl.vo.ListDeviceRepairStatisticView;
import com.nnlightctl.vo.ListRepertoryUserView;
import com.nnlightctl.vo.RepertoryInApplyView;
import org.apache.kafka.common.protocol.types.Field;
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
    @Autowired
    private RepertoryServer repertoryServer;
    @Autowired
    private SupplierServer supplierServer;
    @Autowired
    private PropertyClassifyCatalogServer propertyClassifyCatalogServer;
    @Autowired
    private RepertoryInReasonServer repertoryInReasonServer;
    @Autowired
    private RepertoryOutReasonServer repertoryOutReasonServer;
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
        int ret = propertyManagerServer.updateCommitRepairRecord(request.getRepairRecordIds());
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
     * 八、通过id获取单个维修记录
     * */
    @RequestMapping("getRepairRecord")
    public String getRepairRecord(Long id){
        logger.info("[POST] /api/propertyManager/getRepairRecord");

        JsonResult jsonResult = JsonResult.getSUCCESS();
        RepairRecord RepairRecord = propertyManagerServer.getRepairRecord(id);
        List<RepairRecord> repairRecordList = new ArrayList<>();
        repairRecordList.add(RepairRecord);
        jsonResult.setData(repairRecordList);
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
    /*
     * 库存管理
     * 一、新增/修改仓库信息
     * */
    @RequestMapping("addOrUpdateRepertory")
    public String addOrUpdateRepertory(RepertoryRequest request){
        logger.info("[POST] /api/propertyManager/addOrUpdateRepertory");
        int ret = repertoryServer.addOrUpdateRepertory(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }
    /*
     * 库存管理
     * 二、删除仓库
     * */
    @RequestMapping("deleteRepertory")
    public String deleteRepertory(DeleteRepertoryRequest request){
        logger.info("[POST] /api/propertyManager/deleteRepertory");

        int ret = repertoryServer.deleteRepairRecord(request.getRepertoryIds());

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     * 库存管理
     * 三、通过搜索条件分页获取仓库集合
     * */
    @RequestMapping("listRepertory")
    public String listRepertory(BaseRequest request){
        logger.info("[POST] /api/propertyManager/listRepertory");

        Tuple.TwoTuple<List<ListRepertoryUserView>, Integer> tuple = repertoryServer.listRepertory(request);

        JsonResult jsonResult = JsonResult.SUCCESS;
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     * 库存管理
     * 四、通过仓库id获取单个仓库信息
     * */
    @RequestMapping("getRepertory")
    public String getRepertory(Long id){
        logger.info("[POST] /api/propertyManager/getRepertory");

        JsonResult jsonResult = JsonResult.getSUCCESS();

        Tuple.TwoTuple<List<ListRepertoryUserView>, Integer> tuple = repertoryServer.getRepertory(id);
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     * 库存管理
     * 五、资产转移操作接口
     * */
    @RequestMapping("transferProperty")
    public String transferProperty(TransferPropertyRequest request){
        logger.info("[POST] /api/propertyManager/transferProperty");

        int ret = repertoryServer.updateTransferProperty(request);
        JsonResult jsonResult = JsonResult.getSUCCESS();;
        return toJson(jsonResult);
    }
    /*
     * 库存管理
     * 六、通过搜索条件分页显示资产转移记录
     * */
    @RequestMapping("listPropertyTransRecord")
    public String listPropertyTransRecord(BaseRequest request){
        logger.info("[POST] /api/propertyManager/listPropertyTransRecord");
        Tuple.TwoTuple<List<RepertoryPropertyTranslateRecord>, Integer> tuple = repertoryServer.listPropertyTransRecord(request);

        JsonResult jsonResult = JsonResult.SUCCESS;
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     * 库存管理-主页相关接口
     * 一、通过搜索条件分页显示入库申请
     * */
    @RequestMapping("listApplyInRepertory")
    public String listApplyInRepertory(BaseRequest request){
        logger.info("[POST] /api/propertyManager/listApplyInRepertory");

        Tuple.TwoTuple<List<RepertoryInApplyView>, Integer> tuple = repertoryServer.listApplyInRepertory(request);

        JsonResult jsonResult = JsonResult.SUCCESS;
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     * 库存管理-主页相关接口
     * 二、通过搜索条件分页显示出库申请
     * */
    @RequestMapping("listApplyOutRepertory")
    public String listApplyOutRepertory(BaseRequest request){
        logger.info("[POST] /api/propertyManager/listApplyOutRepertory");
        Tuple.TwoTuple<List<RepertoryOutApply>, Integer> tuple = repertoryServer.listApplyOutRepertory(request);

        JsonResult jsonResult = JsonResult.SUCCESS;
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     * 库存管理-主页相关接口
     * 三、统计入库申请
     * */
    @RequestMapping("countApplyInRepertory")
    public String countApplyInRepertory(){
        logger.info("[POST] /api/propertyManager/countApplyInRepertory");

        Long total = repertoryServer.countApplyInRepertory();

        List<Long> listTatol = new ArrayList<>();
        listTatol.add(total);

        JsonResult jsonResult = JsonResult.SUCCESS;
        jsonResult.setData(listTatol);

        return toJson(jsonResult);
    }
    /*
     * 库存管理-主页相关接口
     * 四、统计出库申请
     * */
    @RequestMapping("countApplyOutRepertory")
    public String countApplyOutRepertory(){
        logger.info("[POST] /api/propertyManager/countApplyOutRepertory");

        Long total = repertoryServer.countApplyOutRepertory();

        List<Long> listTatol = new ArrayList<>();
        listTatol.add(total);

        JsonResult jsonResult = JsonResult.SUCCESS;
        jsonResult.setData(listTatol);

        return toJson(jsonResult);
    }
    /*
     * 库存管理-资产申请相关接口
     *一、新增/修改入库申请
     * */
    @RequestMapping("addOrUpdateApplyInRepertory")
    public String addOrUpdateApplyInRepertory(RepertoryInApplyRequest request){
        logger.info("[POST] /api/propertyManager/addOrUpdateApplyInRepertory");

        int ret = repertoryServer.addOrUpdateApplyInRepertory(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     * 库存管理-资产申请相关接口
     *二、删除入库申请
     * */
    @RequestMapping("deleteApplyInRepertory")
    public String deleteApplyInRepertory(RepertoryInApplyRequest request){
        logger.info("[POST] /api/propertyManager/deleteApplyInRepertory");

        int ret =repertoryServer.deleteApplyInRepertory(request.getApplyInRepertoryIds());
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     * 库存管理-资产申请相关接口
     *三、通过id获取单个入库申请
     * */
    @RequestMapping("getApplyInRepertoryById")
    public String getApplyInRepertoryById(Long id){
        logger.info("[POST] /api/propertyManager/getApplyInRepertoryById");

        RepertoryInApply repertoryInApply = repertoryServer.getApplyInRepertoryById(id);
        List<RepertoryInApply> repertoryInApplyList =new ArrayList<RepertoryInApply>();
        repertoryInApplyList.add(repertoryInApply);
        JsonResult jsonResult = JsonResult.SUCCESS;
        jsonResult.setData(repertoryInApplyList);

        return toJson(jsonResult);
    }
    /*
     * 库存管理-资产申请相关接口
     *四、新增/修改出库申请
     * */
    @RequestMapping("addOrUpdateApplyOutRepertory")
    public String addOrUpdateApplyOutRepertory(RepertoryOutApplyRequest request){
        logger.info("[POST] /api/propertyManager/addOrUpdateApplyOutRepertory");
        int ret = repertoryServer.addOrUpdateApplyOutRepertory(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     * 库存管理-资产申请相关接口
     *五、删除出库申请
     * */
    @RequestMapping("deleteApplyOutRepertory")
    public String deleteApplyOutRepertory(RepertoryOutApplyRequest request){
        logger.info("[POST]  /api/propertyManager/deleteApplyOutRepertory");
        int ret = repertoryServer.deleteApplyOutRepertory(request.getApplyOutRepertoryIds());
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     * 库存管理-资产申请相关接口
     *六、通过出库申请id获取单个出库申请信息
     * */
    @RequestMapping("getApplyOutRepertoryById")
    public String getApplyOutRepertoryById(Long id){
        logger.info("[POST]  /api/propertyManager/getApplyOutRepertoryById");

        RepertoryOutApply repertoryOutApply = repertoryServer.getApplyOutRepertoryById(id);
        List<RepertoryOutApply> repertoryOutApplyList =new ArrayList<RepertoryOutApply>();
        repertoryOutApplyList.add(repertoryOutApply);
        JsonResult jsonResult = JsonResult.SUCCESS;
        jsonResult.setData(repertoryOutApplyList);

        return toJson(jsonResult);
    }
    /*
     * 资产审批
     *一、分页获取入库申请待审批集合
     * */
    @RequestMapping("listApplyInApprovePending")
    public String listApplyInApprovePending(BaseRequest request){
        logger.info("[POST]  /api/propertyManager/listApplyInApprovePending");
        int ret = 1;
        JsonResult jsonResult = JsonResult.SUCCESS;
        Tuple.TwoTuple<List<RepertoryInApply>, Integer> tuple = repertoryServer.listApplyInApprovePending(request , ret);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     * 资产审批
     *二、分页获取出库申请待审批集合
     * */
    @RequestMapping("listApplyOutApprovePending")
    public String listApplyOutApprovePending(BaseRequest request){
        logger.info("[POST]  /api/propertyManager/listApplyOutApprovePending");
        Integer ret = 1;
        JsonResult jsonResult = JsonResult.SUCCESS;
        Tuple.TwoTuple<List<RepertoryOutApply>, Integer> tuple = repertoryServer.listApplyOutApprovePending(request,ret);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     * 资产审批
     *三、分页显示入库申请已审批历史记录
     * */
    @RequestMapping("listApplyInHistory")
    public String listApplyInHistory(BaseRequest request){
        logger.info("[POST]  /api/propertyManager/listApplyInHistory");
        Integer ret3 = 3;
        Integer ret4 = 4;
        JsonResult jsonResult = JsonResult.SUCCESS;

        List<Integer> applyStates = new ArrayList<Integer>();
        applyStates.add(ret3);
        applyStates.add(ret4);
        Tuple.TwoTuple<List<RepertoryInApply>, Integer> tuple = repertoryServer.listApplyInHistory(request,applyStates);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     * 资产审批
     *四、分页显示出库申请已审批历史记录
     * */
    @RequestMapping("listApplyOutHistory")
    public String listApplyOutHistory(BaseRequest request){
        logger.info("[POST]  /api/propertyManager/listApplyOutHistory");
        Integer ret3 = 3;
        Integer ret4 = 4;
        List<Integer> applyStates = new ArrayList<Integer>();
        applyStates.add(ret3);
        applyStates.add(ret4);
        JsonResult jsonResult = JsonResult.SUCCESS;
        Tuple.TwoTuple<List<RepertoryOutApply>, Integer> tuple = repertoryServer.listApplyOutHistory(request,applyStates);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     * 资产审批
     *五、入库申请审批操作
     * */
    @RequestMapping("approveApplyInRepertory")
    public String approveApplyInRepertory( ApproveApplyInRepertoryRequest request){
        logger.info("[POST]  /api/propertyManager/approveApplyInRepertory");
        int ret = repertoryServer.updateApproveApplyInRepertory(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     * 资产审批
     *六、出库申请审批操作
     * */
    @RequestMapping("approveApplyOutRepertory")
   public String approveApplyOutRepertory(ApproveApplyOutRepertoryRequest request){
        logger.info("[POST]  /api/propertyManager/approveApplyOutRepertory");
        int ret = repertoryServer.updateApproveApplyOutRepertory(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
   }
    /*
     * 基础数据
     *一、供应商的新增和修改
     * */
    @RequestMapping("addOrUpdateSupplier")
   public String addOrUpdateSupplier(SupplierRequest request){
        logger.info("[POST]  /api/propertyManager/addOrUpdateSupplier");

        int ret =supplierServer.addOrUpdateRepertory(request);
        JsonResult jsonResult = null;

        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     * 基础数据
     *二、删除供应商
     * */
    @RequestMapping("deleteSupplier")
    public String deleteSupplier(SupplierRequest request){
        logger.info("[POST]  /api/propertyManager/deleteSupplier");

        int ret = supplierServer.deleteSupplier(request.getSupplierIds());
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     * 基础数据
     *三、按搜索条件分页显示供应商
     * */
    @RequestMapping("listSupplier")
    public String listSupplier(BaseRequest request){
        logger.info("[POST]  /api/propertyManager/listSupplier");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        Tuple.TwoTuple<List<Supplier>, Integer> tuple = supplierServer.listSupplier(request);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     * 基础数据
     *四、通过供应商id获取单个供应商信息
     * */
    @RequestMapping("getSupplier")
    public String getSupplier(Long id){
        logger.info("[POST]  /api/propertyManager/getSupplier");

        JsonResult jsonResult = JsonResult.getSUCCESS();
        Supplier supplier = supplierServer.getSupplier(id);
        List<Supplier> supplierList = new ArrayList<Supplier>();
        supplierList.add(supplier);
        jsonResult.setData(supplierList);

        return toJson(jsonResult);
    }
    /*
     * 基础数据
     *五、新增/修改资产分类目录
     * */
    @RequestMapping("addOrUpdatePropertyClassifyCatalog")
    public String addOrUpdatePropertyClassifyCatalog(PropertyClassifyCatalogRequest request){
        logger.info("[POST]  /api/propertyManager/addOrUpdatePropertyClassifyCatalog");
        int ret = propertyClassifyCatalogServer.addOrUpdatePropertyClassifyCatalog(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     * 基础数据
     *六、删除资产分类目录（同时删除其全部子目录）
     * */
    @RequestMapping("deletePropertyClassifyCatalog")
    public String deletePropertyClassifyCatalog(PropertyClassifyCatalogRequest request){
        logger.info("[POST]  /api/propertyManager/deletePropertyClassifyCatalog");
        int ret = propertyClassifyCatalogServer.deletePropertyClassifyCatalog(request.getPropertyClassifyCatalogIds());
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     * 基础数据
     *七、获取全部一级资产分类目录
     * */
    @RequestMapping("listPropertyClassifyCatalogLevel1")
    public String listPropertyClassifyCatalogLevel1(){
        logger.info("[POST]  /api/propertyManager/listPropertyClassifyCatalogLevel1");
        JsonResult jsonResult = JsonResult.getSUCCESS();

        List<PropertyClassifyCatalog> propertyClassifyCatalogList = propertyClassifyCatalogServer.listPropertyClassifyCatalogLevel1();
        jsonResult.setData(propertyClassifyCatalogList);

        return toJson(jsonResult);
    }
    /*
     * 基础数据
     *八、通过资产分类目录id获取全部子目录（下一层深度）
     * */
    @RequestMapping("listSubPropertyClassifyCatalog")
    public String listSubPropertyClassifyCatalog(Long id){
        logger.info("[POST]  /api/propertyManager/listSubPropertyClassifyCatalog");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        List<PropertyClassifyCatalog> propertyClassifyCatalogList = propertyClassifyCatalogServer.listPropertyClassifyCatalogAll(id);
        jsonResult.setData(propertyClassifyCatalogList);
        return toJson(jsonResult);
    }
    /*
     * 基础数据
     *九、新增/修改入库原因
     * */
    @RequestMapping("addOrUpdateRepertoryInReason")
    public String addOrUpdateRepertoryInReason(RepertoryInReasonRequest request){
        logger.info("[POST]  /api/propertyManager/addOrUpdateRepertoryInReason");
        int ret = repertoryInReasonServer.addOrUpdateRepertoryInReason(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     * 基础数据
     *十、删除入库原因
     * */
    @RequestMapping("deleteRepertoryInReason")
    public String deleteRepertoryInReason(RepertoryInReasonRequest request){
        logger.info("[POST]  /api/propertyManager/deleteRepertoryInReason");
        int ret = repertoryInReasonServer.deleteRepertoryInReason(request.getRepertoryInReasonIds());
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     * 基础数据
     *十一、分页获取全部入库原因
     * */
    @RequestMapping("listRepertoryInReason")
    public String listRepertoryInReason(BaseRequest request){
        logger.info("[POST]  /api/propertyManager/listRepertoryInReason");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        Tuple.TwoTuple<List<RepertoryInReason>, Integer> tuple = repertoryInReasonServer.listRepertoryInReason(request);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     * 基础数据
     *十二、通过id获取单个入库原因
     * */
    @RequestMapping("getRepertoryInReasonById")
    public String getRepertoryInReasonById(Long id){
        logger.info("[POST]  /api/propertyManager/getRepertoryInReasonById");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        RepertoryInReason repertoryInReason = repertoryInReasonServer.getRepertoryInReasonById(id);
        List<RepertoryInReason> repertoryInReasonList = new ArrayList<RepertoryInReason>();
        repertoryInReasonList.add(repertoryInReason);
        jsonResult.setData(repertoryInReasonList);

        return toJson(jsonResult);
    }
    /*
     * 基础数据
     *十三、新增/修改出库原因
     * */
    @RequestMapping("addOrUpdateRepertoryOutReason")
    public String addOrUpdateRepertoryOutReason(RepertoryOutReasonRequest request){
        logger.info("[POST]  /api/propertyManager/addOrUpdateRepertoryOutReason");
        int ret = repertoryOutReasonServer.addOrUpdateRepertoryOutReason(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     * 基础数据
     *十四、删除出库原因
     * */
    @RequestMapping("deleteRepertoryOutReason")
    public String deleteRepertoryOutReason(RepertoryOutReasonRequest request){
        logger.info("[POST]  /api/propertyManager/deleteRepertoryOutReason");
        int ret = repertoryOutReasonServer.deleteRepertoryOutReason(request.getRepertoryOutReasonIds());
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     * 基础数据
     *十五、分页获取全部出库原因
     * */
    @RequestMapping("listRepertoryOutReason")
    public String listRepertoryOutReason(BaseRequest request){
        logger.info("[POST]  /api/propertyManager/listRepertoryOutReason");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        Tuple.TwoTuple<List<RepertoryOutReason>, Integer> tuple = repertoryOutReasonServer.listRepertoryOutReason(request);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     * 基础数据
     *十五、分页获取全部出库原因
     * */
    @RequestMapping("getRepertoryOutReason")
    public String getRepertoryOutReason(Long id){
        logger.info("[POST]  /api/propertyManager/getRepertoryOutReason");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        RepertoryOutReason repertoryOutReason = repertoryOutReasonServer.getRepertoryOutReason(id);
        List<RepertoryOutReason> repertoryOutReasonList = new ArrayList<RepertoryOutReason>();
        repertoryOutReasonList.add(repertoryOutReason);
        jsonResult.setData(repertoryOutReasonList);

        return toJson(jsonResult);
    }

    @RequestMapping("configAutoCommitRepairRecord")
    public String configAutoCommitRepairRecord(RepaireRecordConditionRequest request) {
        logger.info("[POST] /api/propertyManager/configAutoCommitRepairRecord");

        int ret = propertyManagerServer.setDateAutoCommitRepairRecord(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }
    /*
     * 基础数据
     *十七、编辑资产信息
     * */
    @RequestMapping("updateProperty")
    public String updateProperty(PropertyRequest request){
        logger.info("[POST] /api/propertyManager/updateProperty");
        int ret = propertyManagerServer.updateProperty(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }
}