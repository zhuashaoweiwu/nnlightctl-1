package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.request.LightConditionRequest;
import com.nnlightctl.request.LightRequest;
import com.nnlightctl.vo.LightingView;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface LightServer {
    int addOrUpdateLight(LightRequest request);
    int getCountLightingByUId(String uid);
    int getCountLightingByLamppost(String lamppost);
    int getCountLightingByLampHead(String lamphead);
    int batchAddLight(LightRequest.BatchLightRequest request);
    int deleteLight(LightConditionRequest request);
    Tuple.TwoTuple<List<LightingView>, Integer> listLighting(LightConditionRequest request);
    int updateLightBeElebox(LightConditionRequest request);
    Lighting getLighting(Long id);
    Lighting getLightingByUUID(String uuid);
    List<LightingView> getLightByLoopId(Long id);
    int updateLightBeEleboxBeLoop(LightConditionRequest request);
    int updateLightBeEleboxBeLoop2(LightConditionRequest request);
    int importLighting(InputStream is, String fileName) throws IOException;
    HSSFWorkbook exportLighting(List<Long> lightIdList);
    Tuple.TwoTuple<List<LightingView>, Integer> listLightingView(LightConditionRequest request);
    List<LightingView> listSelectLighting(LightConditionRequest request);
    int unbindLightBeElebox(List<Long> lightIds);
    Tuple.TwoTuple<List<LightingView>, Integer> listLoopLighting(LightConditionRequest request);
    int updateLightPriority(LightConditionRequest request);
    int updatePairLighting(Lighting lighting);
}
