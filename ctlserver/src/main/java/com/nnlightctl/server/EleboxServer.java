package com.nnlightctl.server;

import com.nnlightctl.request.EleboxAddModelRequest;

public interface EleboxServer {
    int insertElebox(EleboxAddModelRequest request);
}
