package com.nnlightctl.server;

import com.nnlightctl.request.UploadDataRequest;

public interface UploadDataServer {
    int UploadGISAndImei(UploadDataRequest request);
}