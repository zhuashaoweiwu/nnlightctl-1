package com.nnlightctl.dao;

import com.nnlightctl.po.EleboxModelLoop;
import com.nnlightctl.po.EleboxModelLoopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EleboxModelLoopMapper {
    int countByExample(EleboxModelLoopExample example);

    int deleteByExample(EleboxModelLoopExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EleboxModelLoop record);

    int insertSelective(EleboxModelLoop record);

    List<EleboxModelLoop> selectByExample(EleboxModelLoopExample example);

    EleboxModelLoop selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EleboxModelLoop record, @Param("example") EleboxModelLoopExample example);

    int updateByExample(@Param("record") EleboxModelLoop record, @Param("example") EleboxModelLoopExample example);

    int updateByPrimaryKeySelective(EleboxModelLoop record);

    int updateByPrimaryKey(EleboxModelLoop record);

    void deleteByEleboxModelIds(@Param("ids")List<Long> ids);
}