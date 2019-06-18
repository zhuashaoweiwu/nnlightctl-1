package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.SystemConfig;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.EleboxRelationMapper;
import com.nnlightctl.dao.PhotoperiodMapper;
import com.nnlightctl.po.EleboxRelation;
import com.nnlightctl.po.PhotoPeriod;
import com.nnlightctl.request.PhotoperiodConditionRequest;
import com.nnlightctl.request.PhotoperiodRequest;
import com.nnlightctl.request.deployRequest.DeployPhotoperiodRequest;
import com.nnlightctl.server.PhotoperiodServer;
import com.nnlightctl.vo.PhotoperiodView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class PhotoperiodServiceImpl implements PhotoperiodServer {

    private Logger logger= LoggerFactory.getLogger(PhotoperiodServiceImpl.class);

    @Autowired
    private PhotoperiodMapper photoperiodMapper;

    @Autowired
    private EleboxRelationMapper eleboxRelationMapper;

    private int flag=-1;


    @Override
    public int addOrUpdatePhotoperiod(PhotoperiodRequest request) {

        PhotoPeriod photoPeriod=new PhotoPeriod();

        ReflectCopyUtil.beanSameFieldCopy(request,photoPeriod);


        if (request.getId()==null){
            //新增光照计

            photoPeriod.setState(0);
            flag= photoperiodMapper.insert(photoPeriod);
        }else {
            //修改光照计

            flag=photoperiodMapper.updateByPrimaryKey(photoPeriod);
        }

        return flag;
    }

    @Override
    public int deletePhotoperiod(PhotoperiodConditionRequest request) {
        List<Long> ids = request.getPhotoperiodIds();
        int ret=-1;
        for (Long id : ids) {
            ret = photoperiodMapper.deleteByPrimaryKey(id);
        }

        return ret;
    }

    @Override
    public PhotoPeriod PhotoperiodById(PhotoperiodConditionRequest request) {

        //获取id
        Long id = request.getId();
        //通过id到数据库查询数据
        PhotoPeriod photoPeriod = photoperiodMapper.selectById(id);

        return photoPeriod;
    }

    @Override
    public Tuple.TwoTuple<List<PhotoperiodView>, Integer> listPhotoperiod(PhotoperiodConditionRequest request) {
        Tuple.TwoTuple<List<PhotoperiodView>,Integer> listPhotoperiod=new Tuple.TwoTuple<>();

        int total = photoperiodMapper.selectByCount();

        listPhotoperiod.setSecond(total);

        PageHelper.startPage(request.getPageNumber(),request.getPageSize());

        List<PhotoperiodView> photoperiodViews=new ArrayList<>();

        String equipmentNumber = request.getEquipmentNumber();

        PhotoPeriod photoPeriodNew=new PhotoPeriod();

        photoPeriodNew.setEquipmentNumber(equipmentNumber);

        photoPeriodNew.setPhotoperiodName(request.getPhotoperiodName());

        photoPeriodNew.setPhotoperiodModel(request.getPhotoperiodModel());

        List<PhotoPeriod> photoPeriods = photoperiodMapper.selectAll(photoPeriodNew);

        for (PhotoPeriod photoPeriod : photoPeriods) {

            PhotoperiodView photoperiodView=new PhotoperiodView();
            ReflectCopyUtil.beanSameFieldCopy(photoPeriod,photoperiodView);
            photoperiodViews.add(photoperiodView);
        }
        listPhotoperiod.setFirst(photoperiodViews);
        return listPhotoperiod;
    }

    @Override
    public Boolean deployPhotoperiod(DeployPhotoperiodRequest request) {


        try {
            for (PhotoperiodRequest photoperiodRequest : request.getPhotoperiodRequestList()) {

                PhotoPeriod photoPeriod=new PhotoPeriod();

                photoPeriod.setState(1);

                photoPeriod.setPhotoperiodModel(photoperiodRequest.getPhotoperiodModel());

                photoPeriod.setPhotoperiodName(photoperiodRequest.getPhotoperiodName());

                photoPeriod.setId(photoperiodRequest.getId());

                photoperiodMapper.updateByPrimaryKey(photoPeriod);
                /**
                 * 修改关联表
                 */

                EleboxRelation eleboxRelation=new EleboxRelation();

                eleboxRelation.setGmtUpdated(new Date());

                eleboxRelation.setEleboxId(request.getEleboxId());

                eleboxRelation.setEleboxModelId(photoperiodRequest.getId());

                eleboxRelation.setEleboxModelType(SystemConfig.getInfo.getConstant.Illumination);

                eleboxRelationMapper.insertSelective(eleboxRelation);

                return Boolean.TRUE;

            }
        } catch (Exception e) {
            logger.info("部署失败");
            e.printStackTrace();
        }


        return Boolean.FALSE;
    }


}
