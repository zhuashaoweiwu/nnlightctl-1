package com.nnlightctl.server;

import com.nnlightctl.request.ModbusRequest;

public interface ModbusEMServer {
    String getInvokeModbusEMDirective(ModbusRequest request);
}
