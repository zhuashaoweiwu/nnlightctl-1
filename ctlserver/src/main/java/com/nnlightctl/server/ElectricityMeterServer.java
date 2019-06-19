package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.ElectricityMeter;
import com.nnlightctl.request.ElectricityMeterConditionRequest;
import com.nnlightctl.request.ElectricityMeterRequest;
import com.nnlightctl.request.deployRequest.DeployElectricityMeter;
import com.nnlightctl.request.deployRequest.DeployPhotoperiodRequest;
import com.nnlightctl.vo.ElectricityMeterView;

import java.util.List;

public interface ElectricityMeterServer {

    int addOrUpdateElectricityMeter(ElectricityMeterRequest request);

    int deleteElectricityMeter(ElectricityMeterConditionRequest request);

    Tuple.TwoTuple<List<ElectricityMeterView>,Integer>  listElectricityMeter(ElectricityMeterConditionRequest request);

    ElectricityMeter selectByPrimarykey(ElectricityMeterConditionRequest request);

    List<ElectricityMeter> selectByParams(ElectricityMeterConditionRequest request);

    Boolean deployElectricityMeter(DeployElectricityMeter request);


    Boolean deleteDeployEletricityMeterAndPhotoriod(Long eleboxId,byte EleboxModelType);


}
