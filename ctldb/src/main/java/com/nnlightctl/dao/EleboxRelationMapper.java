package com.nnlightctl.dao;

import com.nnlightctl.po.EleboxRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EleboxRelationMapper {
    int deleteByPrimaryKey(Long id);

    int deleteByEleboxId(@Param("eleboxId")Long eleboxId);

    int insert(EleboxRelation record);

    int insertSelective(EleboxRelation record);

    List<EleboxRelation> selectByEleboxId(@Param("eleboxId") Long eleboxId);

    EleboxRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EleboxRelation record);

    int updateByPrimaryKey(EleboxRelation record);

}