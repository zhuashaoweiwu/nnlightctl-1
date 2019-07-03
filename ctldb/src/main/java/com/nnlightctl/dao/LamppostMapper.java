package com.nnlightctl.dao;

import com.nnlightctl.po.Lamppost;
import com.nnlightctl.vo.LamppostEquipment;
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


    List<String> selectAllLamppostType();

    List<LamppostEquipment> selectByLamppostType(@Param("param") String lamppostType);


}
