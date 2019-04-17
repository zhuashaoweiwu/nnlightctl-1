package com.nnlightctl.dao;

import com.nnlightctl.po.Elebox;
import com.nnlightctl.po.EleboxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EleboxMapper {
    int countByExample(EleboxExample example);

    int deleteByExample(EleboxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Elebox record);

    int insertSelective(Elebox record);

    List<Elebox> selectByExample(EleboxExample example);

    Elebox selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Elebox record, @Param("example") EleboxExample example);

    int updateByExample(@Param("record") Elebox record, @Param("example") EleboxExample example);

    int updateByPrimaryKeySelective(Elebox record);

    int updateByPrimaryKey(Elebox record);
}