package com.nnlightctl.dao;

import com.nnlightctl.po.PhotoPeriod;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PhotoperiodMapper {

    int insert(PhotoPeriod photoPeriod);

    int updateByPrimaryKey(PhotoPeriod photoPeriod);

    int deleteByPrimaryKey(Long id);

    int selectByCount();

    List<PhotoPeriod> selectAll(@Param("params") PhotoPeriod photoPeriod);


    PhotoPeriod selectById(Long id);

}
