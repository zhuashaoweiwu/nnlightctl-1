package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.RepairRecord;
import com.nnlightctl.request.*;
import com.nnlightctl.vo.ListDeviceDamageCountByMonthView;
import com.nnlightctl.vo.ListDeviceRepairStatisticView;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

public interface PropertyManagerServer {

    List<ListDeviceRepairStatisticView> listDeviceRepaireStatistic(ListDeviceRepairStatisticRequest listDeviceRepairStatisticRequest);
    List<ListDeviceDamageCountByMonthView> listDeviceDamageCountByMonth(ListDeviceDamageCountByMonthRequest listDeviceDamageCountByMonthRequest);
    Tuple.TwoTuple<List<RepairRecord>, Integer> listRepairRecord(ListRepairRecordRequest request);
    int addOrUpdateRepairRecord(RepairRecordRequest request);
    int deleteRepairRecord(List<Long> repairRecordIds);
    int updateCommitRepairRecord(List<Long> repairRecordIds);
    HSSFWorkbook exportDeviceOperation(ExportDeviceOperationRequest request);
    int setDateAutoCommitRepairRecord(RepaireRecordConditionRequest request);
    int updateProperty(PropertyRequest request);
    RepairRecord getRepairRecord(Long id);

}
