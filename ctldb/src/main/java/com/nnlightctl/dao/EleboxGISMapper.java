package com.nnlightctl.dao;

import com.nnlightctl.po.EleboxGIS;
import com.nnlightctl.po.EleboxGISExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EleboxGISMapper {
    int countByExample(EleboxGISExample example);

    int deleteByExample(EleboxGISExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EleboxGIS record);

    int insertSelective(EleboxGIS record);

    List<EleboxGIS> selectByExample(EleboxGISExample example);

    EleboxGIS selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EleboxGIS record, @Param("example") EleboxGISExample example);

    int updateByExample(@Param("record") EleboxGIS record, @Param("example") EleboxGISExample example);

    int updateByPrimaryKeySelective(EleboxGIS record);

    int updateByPrimaryKey(EleboxGIS record);
}