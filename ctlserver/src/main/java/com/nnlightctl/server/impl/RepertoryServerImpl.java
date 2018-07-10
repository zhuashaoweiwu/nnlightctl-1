package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.*;
import com.nnlightctl.jdbcdao.RepertoryDao;
import com.nnlightctl.jdbcdao.RepertoryInApplyDao;
import com.nnlightctl.po.*;
import com.nnlightctl.request.*;
import com.nnlightctl.server.RepertoryServer;
import com.nnlightctl.vo.ListRepertoryUserView;
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
    public int transferProperty(TransferPropertyRequest request){

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

        int ret = repertoryDao.transferProperty(request);

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
    public Tuple.TwoTuple<List<RepertoryInApply>, Integer> listApplyInRepertory(BaseRequest request){
        Tuple.TwoTuple<List<RepertoryInApply>, Integer> tuple = new Tuple.TwoTuple<>();

        RepertoryInApplyExample repertoryInApplyExample = new RepertoryInApplyExample();
        repertoryInApplyExample.setOrderByClause("id DESC");

        int total =repertoryInApplyMapper.countByExample(repertoryInApplyExample);
        tuple.setSecond(total);
        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<RepertoryInApply> repertoryInApplyList = repertoryInApplyMapper.selectByExample(repertoryInApplyExample);
        tuple.setFirst(repertoryInApplyList);

        return tuple;
    }

    @Override
    public Tuple.TwoTuple<List<RepertoryOutApply>, Integer> listApplyOutRepertory(BaseRequest request){
        Tuple.TwoTuple<List<RepertoryOutApply>, Integer> tuple = new Tuple.TwoTuple<>();

        RepertoryOutApplyExample repertoryOutApplyExample = new RepertoryOutApplyExample();
        repertoryOutApplyExample.setOrderByClause("id DESC");

        int total =repertoryOutApplyMapper.countByExample(repertoryOutApplyExample);
        tuple.setSecond(total);
        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<RepertoryOutApply> repertoryOutApplyList = repertoryOutApplyMapper.selectByExample(repertoryOutApplyExample);
        tuple.setFirst(repertoryOutApplyList);

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
    public int approveApplyInRepertory(ApproveApplyInRepertoryRequest request){
        return repertoryInApplyDao.approveApplyInRepertory(request);
    }
    @Override
    public int approveApplyOutRepertory(ApproveApplyOutRepertoryRequest request){
        return  repertoryInApplyDao.approveApplyOutRepertory(request);
    }
}
