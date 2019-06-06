package com.nnlightctl.dao;

import com.nnlightctl.po.PhotoPeriod;

import java.util.List;


public interface PhotoperiodMapper {

    int insert(PhotoPeriod photoPeriod);

    int updateByPrimaryKey(PhotoPeriod photoPeriod);

    int deleteByPrimaryKey(Long id);

    int selectByCount();

    List<PhotoPeriod> selectAll();

    PhotoPeriod selectById(Long id);

}
