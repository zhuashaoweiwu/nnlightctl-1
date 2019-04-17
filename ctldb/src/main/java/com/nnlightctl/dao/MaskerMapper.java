package com.nnlightctl.dao;

import com.nnlightctl.po.Masker;
import com.nnlightctl.po.MaskerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaskerMapper {
    int countByExample(MaskerExample example);

    int deleteByExample(MaskerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Masker record);

    int insertSelective(Masker record);

    List<Masker> selectByExample(MaskerExample example);

    Masker selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Masker record, @Param("example") MaskerExample example);

    int updateByExample(@Param("record") Masker record, @Param("example") MaskerExample example);

    int updateByPrimaryKeySelective(Masker record);

    int updateByPrimaryKey(Masker record);
}