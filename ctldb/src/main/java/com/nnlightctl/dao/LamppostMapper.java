package com.nnlightctl.dao;

import com.nnlightctl.po.Lamppost;

import java.util.List;

public interface LamppostMapper {

    int insertLamppost(Lamppost lamppost);

    int updateByPrimaryKeyLamppost(Lamppost lamppost);

    int deleteByPrimaryKeyLamppost(Long id);

    int selectByCountLamppost();

    List<Lamppost> selectAllLamppost();
}
