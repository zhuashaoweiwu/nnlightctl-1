package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.request.LamppostConditionRequest;
import com.nnlightctl.request.LamppostRequest;
import com.nnlightctl.vo.LamppostView;

import java.util.List;

public interface LamppostServer {

    /**
     * 增加或者修改灯杆信息
     */
    int addOrUpdateLamppost(LamppostRequest Request);

    /**
     * 删除灯杆信息
     */
    int deleteLamppost(LamppostConditionRequest request);

    /**
     * 展示灯杆信息
     */
    Tuple.TwoTuple<List<LamppostView>,Integer> listLamppost(LamppostConditionRequest request);
}
