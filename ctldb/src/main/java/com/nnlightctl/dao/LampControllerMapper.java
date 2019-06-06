package com.nnlightctl.dao;

import com.nnlightctl.po.LampController;


import java.util.List;

public interface LampControllerMapper {

    int insert(LampController lampController);

    int updateByPrimaryKey(LampController lampController);

    int deleteByPrimaryKey(Long id);

    int selectByCount();

    List<LampController> selectAll();

    LampController selectById(Long id);


}