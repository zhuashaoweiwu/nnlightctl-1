package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.request.LightConditionRequest;
import com.nnlightctl.request.LightRequest;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface LightServer {
    int addOrUpdateLight(LightRequest request);
    int batchAddLight(LightRequest.BatchLightRequest request);
    int deleteLight(LightConditionRequest request);
    Tuple.TwoTuple<List<Lighting>, Integer> listLighting(LightConditionRequest request);
    int updateLightBeElebox(LightConditionRequest request);
    Lighting getLighting(Long id);
    List<Lighting> getLightByLoopId(Long id);
    int updateLightBeEleboxBeLoop(LightConditionRequest request);
    int importLighting(InputStream is, String fileName) throws IOException;
    HSSFWorkbook exportLighting(List<Long> lightIdList);
}
