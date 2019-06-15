package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Elebox;
import com.nnlightctl.po.EleboxModel;
import com.nnlightctl.po.EleboxModelLoop;
import com.nnlightctl.request.*;
import com.nnlightctl.vo.EleboxView;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface EleboxServer {
    int insertElebox(EleboxAddModelRequest request);
    int getCountModelByUid(String uid);
    int getCountModelLoopByLoopCode(ModelLoopByLoopCodeRequest request);
    Elebox getEleboxById(Long id);
    int updateElebox(EleboxRequest request);
    int getCountEleboxByUid(String uid);
    int getCountEleboxByCodeNumber(String codeNumber);
    int updateEleboxDevice(EleboxConditionRequest request);
    int updateModelLoopSplite(EleboxConditionRequest request);
    int deleteElebox(EleboxConditionRequest request);
    Tuple.TwoTuple<List<EleboxView>, Integer> listElebox(EleboxConditionRequest request);
    Tuple.TwoTuple<List<EleboxModel>, Integer> listEleboxModel(EleboxConditionRequest request);
    Tuple.TwoTuple<List<EleboxModelLoop>, Integer> listModelLoop(Long modelId);
    int importElebox(InputStream in, String fileName) throws IOException;
    void uploadImageElebox(MultipartFile eleboxGisIcon , String imagePath);
    HSSFWorkbook exportElebox(List<Long> eleboxIds);
    int batchSetLightingArea(BatchSetEleboxAreaRequest batchSetEleboxAreaRequest);
    int batchSetLightingArea(BatchSetLightingAreaRequest batchSetLightingAreaRequest);
    int batchConfigLightsBeElebox(BatchConfigLightsBeEleboxRequest batchConfigLightsBeEleboxRequest);


    int addOrUpdateElebox(EleboxRequest Request);

    int deleteEleboxPrimaryKey(EleboxConditionRequest request);

    Tuple.TwoTuple<List<Elebox>,Integer> listEleboxMessage(EleboxConditionRequest request);

    Elebox selectEleboxById(EleboxConditionRequest request);

    /**
     * 查询所有的设备编号
     */
    List<String> selectEquipment();

    /**
     * 展示
     */
}
