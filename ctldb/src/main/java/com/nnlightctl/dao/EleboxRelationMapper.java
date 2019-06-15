package com.nnlightctl.mapper;

import com.nnlightctl.po.EleboxRelation;

public interface EleboxRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EleboxRelation record);

    int insertSelective(EleboxRelation record);

    EleboxRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EleboxRelation record);

    int updateByPrimaryKey(EleboxRelation record);

}