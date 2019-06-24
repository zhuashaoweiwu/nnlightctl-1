package com.nnlightctl.dao;


import com.nnlightctl.parameter.ModularParameter;
import com.nnlightctl.po.Modular;
import com.nnlightctl.po.ModularExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModularMapper {
    Long countByExample(ModularExample example);

    int deleteByExample(ModularExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Modular record);

    int insertSelective(Modular record);

    List<Modular> selectByExample(ModularExample example);

    Modular selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Modular record, @Param("example") ModularExample example);

    int updateByExample(@Param("record") Modular record, @Param("example") ModularExample example);

    int updateByPrimaryKeySelective(Modular record);

    int updateByPrimaryKey(Modular record);

    List<Modular> selectByParams(@Param("params") ModularParameter modularParameter);

    List<Modular> selectModularAll();

    List<String> listEquipmentNumber();


}