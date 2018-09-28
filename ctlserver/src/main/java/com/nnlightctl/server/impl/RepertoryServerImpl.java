package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.*;
import com.nnlightctl.jdbcdao.RepertoryDao;
import com.nnlightctl.jdbcdao.RepertoryInApplyDao;
import com.nnlightctl.po.*;
import com.nnlightctl.request.*;
import com.nnlightctl.server.PropertyClassifyCatalogServer;
import com.nnlightctl.server.RepertoryServer;
import com.nnlightctl.vo.ListRepertoryUserView;
import com.nnlightctl.vo.RepertoryInApplyView;
import com.nnlightctl.vo.RepertoryOutApplyView;
import com.sun.org.apache.xerces.internal.impl.PropertyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RepertoryServerImpl implements RepertoryServer {
    @Autowired
    private RepertoryMapper repertoryMapper;
    @Autowired
    private RepertoryPropertyTranslateRecordMapper repertoryPropertyTranslateRecordMapper;
    @Autowired
    private RepertoryDao repertoryDao;

    @Autowired
    private PropertyMapper propertyMapper;
    @Autowired
    private RepertoryInApplyMapper repertoryInApplyMapper;
    @Autowired
    private RepertoryOutApplyMapper repertoryOutApplyMapper;
    @Autowired
    private RepertoryInApplyDao repertoryInApplyDao;
    @Autowired
    private RepertoryInReasonMapper repertoryInReasonMapper;

    @Autowired
    private PropertyClassifyCatalogServer propertyClassifyCatalogServer;

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RepertoryOutReasonMapper repertoryOutReasonMapper;

    public int addOrUpdateRepertory(RepertoryRequest request){
        Repertory repertory = new Repertory();
        ReflectCopyUtil.beanSameFieldCopy(request, repertory);
        repertory.setGmtUpdated(new Date());

        int ret = -1;
        if (request.getId() != null) {  //修改
            ret = repertoryMapper.updateByPrimaryKeySelective(repertory);
        } else {
            repertory.setGmtCreated(new Date());
            ret = repertoryMapper.insertSelective(repertory);
        }
        return ret;
    }

    @Override
    public int deleteRepairRecord(List<Long> repertoryIds){
        for (Long id : repertoryIds) {
            repertoryMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }

    @Override
    public Tuple.TwoTuple<List<ListRepertoryUserView>, Integer> listRepertory(BaseRequest request){
        return repertoryDao.listRepertoryUser(request);
    }

    @Override
    public Tuple.TwoTuple<List<ListRepertoryUserView>, Integer> getRepertory(Long id){
        return repertoryDao.getRepertory(id);
    }

    @Override
    public int updateTransferProperty(TransferPropertyRequest request){

        for(int i = 0 ; i < request.getPropertyIds().size() ; i++){
            Property property = propertyMapper.selectByPrimaryKey(request.getPropertyIds().get(i));
            RepertoryPropertyTranslateRecord repertoryPropertyTranslateRecord = new RepertoryPropertyTranslateRecord();
            repertoryPropertyTranslateRecord.setGmtCreated(new Date());
            repertoryPropertyTranslateRecord.setGmtUpdated(new Date());
            repertoryPropertyTranslateRecord.setNnlightctlPropertyId(property.getNnlightctlPropertyId());
            repertoryPropertyTranslateRecord.setTranslateDate(new Date());
            repertoryPropertyTranslateRecord.setSourceRepertyId(property.getNnlightctlRepertoryId());
            repertoryPropertyTranslateRecord.setTargetRepertyId(request.getNewRepertoryId());
            repertoryPropertyTranslateRecord.setNnlightctlUserIdApply(property.getNnlightctlUserApplierId());
            repertoryPropertyTranslateRecord.setNnlightctlUserIdReceive(property.getPropertyManagerId());
            repertoryPropertyTranslateRecordMapper.insert(repertoryPropertyTranslateRecord);
        }

        int ret = repertoryDao.updateTransferProperty(request);

        return 1;
    }
    @Override
    public Tuple.TwoTuple<List<RepertoryPropertyTranslateRecord>, Integer> listPropertyTransRecord(BaseRequest request){
        Tuple.TwoTuple<List<RepertoryPropertyTranslateRecord>, Integer> tuple = new Tuple.TwoTuple<>();

        RepertoryPropertyTranslateRecordExample repertoryPropertyTranslateRecordExample = new RepertoryPropertyTranslateRecordExample();
        repertoryPropertyTranslateRecordExample.setOrderByClause("id DESC");

        int total =repertoryPropertyTranslateRecordMapper.countByExample(repertoryPropertyTranslateRecordExample);
        tuple.setSecond(total);
        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<RepertoryPropertyTranslateRecord> repertoryPropertyTranslateRecordList = repertoryPropertyTranslateRecordMapper.selectByExample(repertoryPropertyTranslateRecordExample);
        tuple.setFirst(repertoryPropertyTranslateRecordList);

        return tuple;
    }

    @Override
    public Tuple.TwoTuple<List<RepertoryInApplyView>, Integer> listApplyInRepertory(BaseRequest request){
        Tuple.TwoTuple<List<RepertoryInApplyView>, Integer> tuple = new Tuple.TwoTuple<>();

        RepertoryInApplyExample repertoryInApplyExample = new RepertoryInApplyExample();
        repertoryInApplyExample.setOrderByClause("id DESC");

        int total =repertoryInApplyMapper.countByExample(repertoryInApplyExample);
        tuple.setSecond(total);
        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<RepertoryInApplyView> repertoryInApplyViews = new ArrayList<>(10);
        List<RepertoryInApply> repertoryInApplyList = repertoryInApplyMapper.selectByExample(repertoryInApplyExample);
        for (RepertoryInApply apply : repertoryInApplyList) {
            RepertoryInApplyView repertoryInApplyView = new RepertoryInApplyView();
            ReflectCopyUtil.beanSameFieldCopy(apply, repertoryInApplyView);

            //获取资产目录描述
            String desc = propertyClassifyCatalogServer.getPropertyClassifyCatalogDesc(apply.getNnlightctlPropertyClassifyCatalogId());
            repertoryInApplyView.setPropertyClassifyCatalogDesc(desc);

            //供应商名称
            String supplierName = supplierMapper.selectByPrimaryKey(apply.getNnlightctlSupplier()).getApplierName();
            repertoryInApplyView.setSupplierDesc(supplierName);

            //入库原因
            String repertoryInReason = repertoryInReasonMapper.selectByPrimaryKey(apply.getNnlightctlRepertoryInReasonId()).getReasonDesc();
            repertoryInApplyView.setRepertoryInReason(repertoryInReason);

            //入库仓库
            String repertoryName = repertoryMapper.selectByPrimaryKey(apply.getNnlightctlRepertoryId()).getRepertoryName();
            repertoryInApplyView.setRepertoryName(repertoryName);

            //入库申请人
            String applierName = userMapper.selectByPrimaryKey(apply.getNnlightctlUserApplyId()).getUserName();
            repertoryInApplyView.setUserApplyName(applierName);

            repertoryInApplyViews.add(repertoryInApplyView);
        }
        tuple.setFirst(repertoryInApplyViews);

        return tuple;
    }

    @Override
    public Tuple.TwoTuple<List<RepertoryOutApplyView>, Integer> listApplyOutRepertory(BaseRequest request){
        Tuple.TwoTuple<List<RepertoryOutApplyView>, Integer> tuple = new Tuple.TwoTuple<>();

        RepertoryOutApplyExample repertoryOutApplyExample = new RepertoryOutApplyExample();
        repertoryOutApplyExample.setOrderByClause("id DESC");

        int total =repertoryOutApplyMapper.countByExample(repertoryOutApplyExample);
        tuple.setSecond(total);
        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<RepertoryOutApplyView> repertoryOutApplyViews = new ArrayList<>(10);
        List<RepertoryOutApply> repertoryOutApplyList = repertoryOutApplyMapper.selectByExample(repertoryOutApplyExample);
        for (RepertoryOutApply apply : repertoryOutApplyList) {
            RepertoryOutApplyView view = new RepertoryOutApplyView();
            ReflectCopyUtil.beanSameFieldCopy(apply, view);

            //资产名称
            view.setPropertyName(this.propertyMapper.selectByPrimaryKey(apply.getNnlightctlPropertyId()).getPropertyClassifyCatalogName());

            //申请人用户名
            view.setApplierName(this.userMapper.selectByPrimaryKey(apply.getNnlightctlUserId()).getUserName());

            //出库仓库名称
            view.setOutRepertoryName(this.repertoryMapper.selectByPrimaryKey(apply.getNnlightctlOutRepertoryId()).getRepertoryName());

            //出库理由描述
            view.setOutRepertoryReasonDesc(this.repertoryOutReasonMapper.selectByPrimaryKey(apply.getNnlightctlRepertoryOutReasonId()).getReason());

        }

        tuple.setFirst(repertoryOutApplyViews);

        return tuple;
    }
    @Override
    public Long countApplyInRepertory(){
        return repertoryDao.countApplyInRepertory();
    }
    @Override
    public Long countApplyOutRepertory(){
        return repertoryDao.countApplyOutRepertory();
    }
    @Override
    public int addOrUpdateApplyInRepertory(RepertoryInApplyRequest request){

        RepertoryInApply repertoryInApply = new RepertoryInApply();
        ReflectCopyUtil.beanSameFieldCopy(request, repertoryInApply);
        repertoryInApply.setGmtUpdated(new Date());

        int ret = -1;
        if (request.getId() != null) {  //修改
            ret = repertoryInApplyMapper.updateByPrimaryKeySelective(repertoryInApply);
        } else {
            repertoryInApply.setGmtCreated(new Date());
            ret = repertoryInApplyMapper.insertSelective(repertoryInApply);
        }
        return ret;
    }
    @Override
    public int deleteApplyInRepertory(List<Long> applyInRepertoryIds ){
        for (Long id : applyInRepertoryIds) {
            repertoryInApplyMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }
    @Override
    public RepertoryInApply getApplyInRepertoryById(Long id){
        return repertoryInApplyMapper.selectByPrimaryKey(id);
    }
    @Override
    public int addOrUpdateApplyOutRepertory(RepertoryOutApplyRequest request){
        RepertoryOutApply repertoryOutApply = new RepertoryOutApply();
        ReflectCopyUtil.beanSameFieldCopy(request, repertoryOutApply);
        repertoryOutApply.setGmtUpdated(new Date());

        int ret = -1;
        if (request.getId() != null) {  //修改
            ret = repertoryOutApplyMapper.updateByPrimaryKeySelective(repertoryOutApply);
        } else {
            repertoryOutApply.setGmtCreated(new Date());
            ret = repertoryOutApplyMapper.insertSelective(repertoryOutApply);
        }
        return ret;
    }
    @Override
    public int deleteApplyOutRepertory(List<Long> applyOutRepertoryIds){
        for (Long id : applyOutRepertoryIds) {
            repertoryOutApplyMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }
    @Override
    public RepertoryOutApply getApplyOutRepertoryById(Long id){
        return repertoryOutApplyMapper.selectByPrimaryKey(id);
    }
    @Override
    public Tuple.TwoTuple<List<RepertoryInApply>, Integer> listApplyInApprovePending(BaseRequest request ,int applyState){
        return repertoryInApplyDao.listApplyInApprovePending(request,applyState);
    }

    @Override
    public Tuple.TwoTuple<List<RepertoryOutApply>, Integer> listApplyOutApprovePending(BaseRequest request ,Integer applyState){
        return repertoryInApplyDao.listApplyOutApprovePending(request,applyState);
    }
    @Override
    public Tuple.TwoTuple<List<RepertoryInApply>, Integer> listApplyInHistory(BaseRequest request ,List<Integer> applyStates){
        return repertoryInApplyDao.listApplyInHistory(request,applyStates);
    }
    @Override
    public Tuple.TwoTuple<List<RepertoryOutApply>, Integer> listApplyOutHistory(BaseRequest request ,List<Integer> applyStates){
        return repertoryInApplyDao.listApplyOutHistory(request,applyStates);
    }
    @Override
    public int updateApproveApplyInRepertory(ApproveApplyInRepertoryRequest request){
        return repertoryInApplyDao.updateApproveApplyInRepertory(request);
    }
    @Override
    public int updateApproveApplyOutRepertory(ApproveApplyOutRepertoryRequest request){
        return  repertoryInApplyDao.updateApproveApplyOutRepertory(request);
    }
}
