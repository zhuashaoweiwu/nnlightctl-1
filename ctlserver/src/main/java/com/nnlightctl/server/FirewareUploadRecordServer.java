package com.nnlightctl.server;

import com.nnlightctl.po.FirewareUploadRecord;

import java.util.List;

public interface FirewareUploadRecordServer {
    int addOrUpdateFirewareUploadRecord(FirewareUploadRecord record);
    List<FirewareUploadRecord> listFirewareUploadRecord();
}
