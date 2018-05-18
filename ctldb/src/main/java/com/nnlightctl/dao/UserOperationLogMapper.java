package com.nnlightctl.dao;

import com.nnlightctl.po.UserOperationLog;
import com.nnlightctl.po.UserOperationLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserOperationLogMapper {
    int countByExample(UserOperationLogExample example);

    int deleteByExample(UserOperationLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserOperationLog record);

    int insertSelective(UserOperationLog record);

    List<UserOperationLog> selectByExample(UserOperationLogExample example);

    UserOperationLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserOperationLog record, @Param("example") UserOperationLogExample example);

    int updateByExample(@Param("record") UserOperationLog record, @Param("example") UserOperationLogExample example);

    int updateByPrimaryKeySelective(UserOperationLog record);

    int updateByPrimaryKey(UserOperationLog record);
}