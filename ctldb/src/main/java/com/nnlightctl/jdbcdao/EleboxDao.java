package com.nnlightctl.jdbcdao;

import com.nnlightctl.request.BatchConfigLightsBeEleboxRequest;
import com.nnlightctl.request.BatchSetEleboxAreaRequest;
import com.nnlightctl.request.BatchSetLightingAreaRequest;

public interface EleboxDao {
    int batchSetEleboxArea(BatchSetEleboxAreaRequest batchSetEleboxAreaRequest);
    int batchSetLightingArea(BatchSetLightingAreaRequest batchSetLightingAreaRequest);
    int batchConfigLightsBeElebox(BatchConfigLightsBeEleboxRequest batchConfigLightsBeEleboxRequest);
}
