package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.request.PhotoperiodConditionRequest;
import com.nnlightctl.request.PhotoperiodRequest;
import com.nnlightctl.vo.PhotoperiodView;

import java.util.List;


public interface PhotoperiodServer {
    int addOrUpdatePhotoperiod(PhotoperiodRequest request);
    int deletePhotoperiod(PhotoperiodConditionRequest request);
    Tuple.TwoTuple<List<PhotoperiodView>,Integer> listPhotoperiod(PhotoperiodConditionRequest request);


}
