package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Modular;
import com.nnlightctl.request.ModularConditionRequest;
import com.nnlightctl.request.ModularRequest;
import com.nnlightctl.vo.ModularView;

import java.util.List;

public interface ModularServer {

    /**
     * 添加或者修改开关模块
     * @param request
     * @return
     */
    int addOrUpdateModular(ModularRequest request);

    /**
     * 通过主键查询开关模块
     */
    Modular selectByPrimaryKey(ModularConditionRequest request);

    /**
     *  查询所有的开关模块的信息
     */
    Tuple.TwoTuple<List<ModularView>,Integer> listModular(ModularConditionRequest request);

    /**
     * 通过主键删除开关模块信息
     */
    int deleteModularByPrimaryKey(ModularConditionRequest request);

    /**
     * 必要查询开关模块开关模块
     */
    List<Modular> selectByParams(ModularConditionRequest request);


}
