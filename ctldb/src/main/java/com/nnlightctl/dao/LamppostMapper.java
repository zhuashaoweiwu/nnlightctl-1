package com.nnlightctl.dao;

import com.nnlightctl.po.Lamppost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LamppostMapper {

    int insertLamppost(Lamppost lamppost);

    int updateByPrimaryKeyLamppost(Lamppost lamppost);

    int deleteByPrimaryKeyLamppost(Long id);

    int selectByCountLamppost();

    List<Lamppost> selectAllLamppost(@Param("lamppost") Lamppost lamppost);

    Lamppost selectLampById(@Param("id") Long id);

    List<String> getAllEquipmentNumber();


}
