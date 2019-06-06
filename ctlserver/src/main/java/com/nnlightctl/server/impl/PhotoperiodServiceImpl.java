package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.PhotoperiodMapper;
import com.nnlightctl.po.PhotoPeriod;
import com.nnlightctl.request.PhotoperiodConditionRequest;
import com.nnlightctl.request.PhotoperiodRequest;
import com.nnlightctl.server.PhotoperiodServer;
import com.nnlightctl.vo.PhotoperiodView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PhotoperiodServiceImpl implements PhotoperiodServer {

    @Autowired
    private PhotoperiodMapper photoperiodMapper;


    @Override
    public int addOrUpdatePhotoperiod(PhotoperiodRequest request) {

        PhotoPeriod photoPeriod=new PhotoPeriod();

        ReflectCopyUtil.beanSameFieldCopy(request,photoPeriod);

        int ret=-1;

        if (request.getId()==null){
            //新增光照计
            ret= photoperiodMapper.insert(photoPeriod);
        }else {
            //修改光照计
            ret=photoperiodMapper.updateByPrimaryKey(photoPeriod);

        }

        return ret;
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

        List<PhotoPeriod> photoPeriods = photoperiodMapper.selectAll();

        for (PhotoPeriod photoPeriod : photoPeriods) {

            PhotoperiodView photoperiodView=new PhotoperiodView();
            ReflectCopyUtil.beanSameFieldCopy(photoPeriod,photoperiodView);
            photoperiodViews.add(photoperiodView);
        }
        listPhotoperiod.setFirst(photoperiodViews);
        return listPhotoperiod;
    }


}
