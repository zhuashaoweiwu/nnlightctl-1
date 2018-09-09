package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.UserOperationLog;
import com.nnlightctl.request.UserOpLogConditionRequest;
import com.nnlightctl.vo.UserOpLogView;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface UserOpLogServer {
    Tuple.TwoTuple<List<UserOpLogView>, Integer> listUserOpLog(UserOpLogConditionRequest request);
    HSSFWorkbook exportElebox(Long userId);
    int importUserOpLog(InputStream is, String fileName) throws IOException;
    int addUserOpLog(UserOperationLog usereOpLog);
}
