package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Elebox;
import com.nnlightctl.po.EleboxModel;
import com.nnlightctl.po.EleboxModelLoop;
import com.nnlightctl.request.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface EleboxServer {
    int insertElebox(EleboxAddModelRequest request);
    Elebox getEleboxById(Long id);
    int updateElebox(EleboxRequest request);
    int updateEleboxDevice(EleboxConditionRequest request);
    int updateModelLoopSplite(EleboxConditionRequest request);
    int deleteElebox(EleboxConditionRequest request);
    Tuple.TwoTuple<List<Elebox>, Integer> listElebox(EleboxRequest request);
    Tuple.TwoTuple<List<EleboxModel>, Integer> listEleboxModel(EleboxConditionRequest request);
    Tuple.TwoTuple<List<EleboxModelLoop>, Integer> listModelLoop(Long modelId);
    int importElebox(InputStream in, String fileName) throws IOException;
    void uploadImageElebox(MultipartFile eleboxGisIcon , String imagePath);
    HSSFWorkbook exportElebox(List<Long> eleboxIds);
    int batchSetLightingArea(BatchSetEleboxAreaRequest batchSetEleboxAreaRequest);
    int batchSetLightingArea(BatchSetLightingAreaRequest batchSetLightingAreaRequest);
    int batchConfigLightsBeElebox(BatchConfigLightsBeEleboxRequest batchConfigLightsBeEleboxRequest);
}
