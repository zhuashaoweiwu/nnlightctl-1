package com.nnlightctl.jdbcdao;

import com.nnlightctl.request.BatchSetEleboxAreaRequest;
import com.nnlightctl.request.BatchSetLightingAreaRequest;

public interface EleboxDao {
    int batchSetEleboxArea(BatchSetEleboxAreaRequest batchSetEleboxAreaRequest);
    int batchSetLightingArea(BatchSetLightingAreaRequest batchSetLightingAreaRequest);
}
