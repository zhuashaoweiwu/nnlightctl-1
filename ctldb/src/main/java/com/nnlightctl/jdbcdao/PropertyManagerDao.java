package com.nnlightctl.jdbcdao;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.RepairRecord;
import com.nnlightctl.request.ListDeviceDamageCountByMonthRequest;
import com.nnlightctl.request.ListDeviceRepairStatisticRequest;
import com.nnlightctl.request.ListRepairRecordRequest;
import com.nnlightctl.vo.ListDeviceDamageCountByMonthView;
import com.nnlightctl.vo.ListDeviceRepairStatisticView;

import java.util.List;

public interface PropertyManagerDao {

    List<ListDeviceRepairStatisticView> listDeviceRepaireStatistic(ListDeviceRepairStatisticRequest listDeviceRepairStatisticRequest);
    List<ListDeviceDamageCountByMonthView> listDeviceDamageCountByMonth(ListDeviceDamageCountByMonthRequest listDeviceDamageCountByMonthRequest);
    Tuple.TwoTuple<List<RepairRecord>, Integer> listRepairRecord(ListRepairRecordRequest request);
    int commitRepairRecord(List<Long> repairRecordIds);
}
