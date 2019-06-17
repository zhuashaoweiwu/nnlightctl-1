package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.PhotoPeriod;
import com.nnlightctl.request.PhotoperiodConditionRequest;
import com.nnlightctl.request.PhotoperiodRequest;
import com.nnlightctl.request.deployRequest.DeployPhotoperiodRequest;
import com.nnlightctl.vo.PhotoperiodView;

import java.util.List;


public interface PhotoperiodServer {
    int addOrUpdatePhotoperiod(PhotoperiodRequest request);

    int deletePhotoperiod(PhotoperiodConditionRequest request);

    PhotoPeriod PhotoperiodById(PhotoperiodConditionRequest request);

    Tuple.TwoTuple<List<PhotoperiodView>,Integer> listPhotoperiod(PhotoperiodConditionRequest request);

    Boolean deployPhotoperiod(DeployPhotoperiodRequest request);


}
