package com.nnlight.common;

public class Constants {
    public static final String JOB_PARAM_KEY_REPAIRRECORDAUTOCOMMITMAPPER = "repairRecordAutoCommitMapper";
    public static final String JOB_PARAM_KEY_REPAIRRECORDMAPPER = "repairRecordMapper";

    //用户路径-固件升级
    public static final String USERHOME_FIREWARE = "fireware";
    public static final String USERHOME_FIREWARE_FIREWAREBACKUP = "backup";
    public static final int BATCH_SIZE = 128;

    public interface HttpKey {
        static final String BaseURI = "http://192.168.120.155:8565/";

        public static final String Register = BaseURI + "api/RegisterDirectConnectedDevice";

        public static final String RemoveDirect = BaseURI + "api/RemoveDirectConnectedDevice";

        public static final String Dimming = BaseURI + "api/Dimming";

        public static final String CreateTask = BaseURI + "api/CreateBatchTask";
    }
}
