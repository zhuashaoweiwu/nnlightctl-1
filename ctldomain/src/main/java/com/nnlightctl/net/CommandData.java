package com.nnlightctl.net;

import com.nnlightctl.request.CommandRequest;
import com.nnlightctl.util.ByteConvert;
import com.nnlightctl.util.BytesHexStrTranslate;
import com.nnlightctl.vo.SceneView;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class CommandData implements Serializable {
    public byte getStart0() {
        return start0;
    }

    public void setStart0(byte start0) {
        this.start0 = start0;
    }

    public byte[] getAddr() {
        return addr;
    }

    public void setAddr(byte[] addr) {
        this.addr = addr;
    }

    public byte getStart1() {
        return start1;
    }

    public void setStart1(byte start1) {
        this.start1 = start1;
    }

    public byte getControl() {
        return control;
    }

    public void setControl(byte control) {
        this.control = control;
    }

    public byte getDataLength() {
        return dataLength;
    }

    public void setDataLength(byte dataLength) {
        this.dataLength = dataLength;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte getCheck() {
        return check;
    }

    public void setCheck(byte check) {
        this.check = check;
    }

    public byte getEnd0() {
        return end0;
    }

    public void setEnd0(byte end0) {
        this.end0 = end0;
    }

    public byte[] getEnd1() {
        return end1;
    }

    public void setEnd1(byte[] end1) {
        this.end1 = end1;
    }

    private byte createCheck() {
        long sum = 0L;

        sum += this.start0;

        for (int i = 0; i < addr.length; ++i) {
            sum += addr[i];
        }

        sum += this.start1;
        sum += this.control;
        sum += this.dataLength;

        int tmpDataLength = ByteConvert.byteToUbyte(this.dataLength);

        for (int i = 0; i < tmpDataLength; ++i) {
            sum += this.data[i];
        }

        return (byte)sum;
    }

    public CommandData() {}

    public CommandData(int percent) {
        this.control = (byte)0xe2;
        this.dataLength = 1;
        this.data = new byte[1];
        this.data[0] = (byte)percent;
        this.check = createCheck();
    }

    public static CommandData getTerminalResetCommand() {
        CommandData commandData = new CommandData();
        commandData.setControl((byte)0xe4);
        commandData.setCheck(commandData.createCheck());

        return commandData;
    }

    public static CommandData getConfigTerminalSendMsgPeriod(int period) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xe5);
        commandData.setDataLength((byte)2);
        commandData.setData(ByteConvert.shortToBytes((short)period));
        commandData.setCheck(commandData.createCheck());

        return commandData;
    }

    public static CommandData getCommandTerminalEleboxOn(Boolean eleboxOn) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xe6);
        commandData.setDataLength((byte)1);
        byte[] data = new byte[1];
        data[0] = eleboxOn ? (byte)0x01 : (byte)0x00;
        commandData.setData(data);
        commandData.setCheck(commandData.createCheck());

        return commandData;
    }

    public static CommandData getConfigTerminalSwitchPolicy(CommandData c7Command) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xe7);

        commandData.setDataLength((byte)(c7Command.getDataLength() - 4));

        byte[] data = new byte[ByteConvert.byteToUbyte(commandData.getDataLength())];
        System.arraycopy(c7Command.getData(), 4, data, 0, data.length);
        commandData.setData(data);

        commandData.setCheck(commandData.createCheck());

        return commandData;
    }

    public static CommandData getCommandReadTerminalInfo() {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xe8);
        commandData.setCheck(commandData.createCheck());

        return commandData;
    }

    public static CommandData getCommandConfigTerminalModel(byte model) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xe9);
        commandData.setDataLength((byte)1);
        commandData.setData(new byte[] {model});

        commandData.setCheck(commandData.createCheck());

        return commandData;
    }

    public static CommandData getReturnTerminalUUID(String uuid) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xf0);
        commandData.setDataLength((byte)uuid.getBytes().length);
        commandData.setData(uuid.getBytes());
        commandData.setCheck(commandData.createCheck());

        return commandData;
    }

    public static CommandData getCheckTimeCommand(byte[] timeBytes) {
        CommandData commandData = new CommandData();
        commandData.setControl((byte)0xf1);
        commandData.setDataLength((byte)6);
        commandData.setData(timeBytes);
        commandData.setCheck(commandData.createCheck());
        return commandData;
    }

    public static CommandData getACKCommandData(byte control, Boolean success) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0x80);
        commandData.setDataLength((byte)2);
        byte[] data = new byte[2];
        data[0] = control;
        if (success) {
            data[1] = 0x00;
        } else {
            data[1] = 0x01;
        }
        commandData.setData(data);
        commandData.setCheck(commandData.createCheck());

        return commandData;
    }

    public static CommandData getChangePowerTypeCommandData(byte powerType) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xf2);
        commandData.setDataLength((byte)1);

        byte[] data = new byte[1];
        data[0] = powerType;

        commandData.setData(data);
        commandData.resetCheck();

        return commandData;
    }

    public static CommandData commandGetModelStateByGateway(String modelUUID) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xd0);
        commandData.setDataLength((byte)36);

        byte[] data = modelUUID.getBytes();
        commandData.setData(data);

        commandData.resetCheck();

        return commandData;
    }

    public static CommandData commandConfigModelStateByGateway(String modelUUID, short modelLoop, short modelLoopState) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xd1);
        commandData.setDataLength((byte)40);

        byte[] data = new byte[40];

        int k = 0;

        byte[] modelUUIDBytes = modelUUID.getBytes();
        System.arraycopy(modelUUIDBytes, 0, data, k, modelUUIDBytes.length);
        k += modelUUIDBytes.length;

        byte[] modelLoopBytes = ByteConvert.shortToBytes(modelLoop);
        System.arraycopy(modelLoopBytes, 0, data, k, modelLoopBytes.length);
        k += 2;

        byte[] modelLoopStateBytes = ByteConvert.shortToBytes(modelLoopState);
        System.arraycopy(modelLoopStateBytes, 0, data, k, modelLoopStateBytes.length);
        k += 2;

        commandData.setData(data);
        commandData.resetCheck();

        return commandData;
    }

    public static CommandData getConfigSetTimeCommand(byte[] time) {
        CommandData commandData = new CommandData();
        commandData.setControl((byte)0xd5);

        commandData.setDataLength((byte)6);
        commandData.setData(time);
        commandData.resetCheck();

        return commandData;
    }

    public static CommandData getUpdateFirewareCommand(short version, short packageNumber, byte lastPackageSize) {
        CommandData commandData = new CommandData();
        commandData.setControl((byte)0xe3);
        commandData.setDataLength((byte)5);

        byte[] data = new byte[5];

        int k = 0;

        System.arraycopy(ByteConvert.shortToBytes(version), 0, data, k, 2);
        k += 2;

        System.arraycopy(ByteConvert.shortToBytes(packageNumber), 0, data, k, 2);
        k += 2;

        data[k++] = lastPackageSize;

        commandData.setData(data);
        commandData.resetCheck();

        return commandData;
    }

    public static CommandData getInvokeModbusEMDirectiveCommandData(byte[] directiveBytes) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0x11);
        commandData.setDataLength((byte)directiveBytes.length);
        commandData.setData(directiveBytes);
        commandData.resetCheck();

        return commandData;
    }

    /**
     * 生成命令的16进制字符串形式
     * @return
     */
    public String toHexString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(BytesHexStrTranslate.bytesToHexFun(this.start0));
        stringBuilder.append(" ");
        stringBuilder.append(BytesHexStrTranslate.bytesToHexFun(this.addr));
        stringBuilder.append(" ");
        stringBuilder.append(BytesHexStrTranslate.bytesToHexFun(this.start1));
        stringBuilder.append(" ");
        stringBuilder.append(BytesHexStrTranslate.bytesToHexFun(this.control));
        stringBuilder.append(" ");
        stringBuilder.append(BytesHexStrTranslate.bytesToHexFun(this.dataLength));
        stringBuilder.append(" ");
        stringBuilder.append(BytesHexStrTranslate.bytesToHexFun(this.data));
        stringBuilder.append(" ");
        stringBuilder.append(BytesHexStrTranslate.bytesToHexFun(this.check));
        stringBuilder.append(" ");
        stringBuilder.append(BytesHexStrTranslate.bytesToHexFun(this.end0));
        stringBuilder.append(" ");
        stringBuilder.append(BytesHexStrTranslate.bytesToHexFun(this.end1));

        return stringBuilder.toString();
    }

    /**
     * 获取CommandData的UUID
     * @return
     */
    public String getUUID() {
        byte[] uuidBytes = new byte[36];
        System.arraycopy(this.data, 0, uuidBytes, 0, 36);
        String uuid = new String(uuidBytes);
        return uuid;
    }

    /**
     * 从数据域0位置获取网上字符串数据
     * @return
     */
    public String getNetworkAddr() {
        byte[] networkAddr = new byte[6];
        System.arraycopy(this.data, 0, networkAddr, 0, 6);
        String networkAddrStr = BytesHexStrTranslate.bytesToHexFun(networkAddr);
        return networkAddrStr;
    }

    /**
     * 获取CommandData的RealtimeUUID
     * @return
     */
    public String getRealtimeUUID() {
        byte[] bytes = new byte[4];
        System.arraycopy(this.getAddr(), 0, bytes, 0, 4);
        return BytesHexStrTranslate.bytesToHexFun(bytes);
    }

    /**
     * 获取CommandData的RealtimeUUID，从数据域中
     * @return
     */
    public String getRealtimeUUIDFromData() {
        byte[] bytes = new byte[4];
        System.arraycopy(this.getData(), 0, bytes, 0, 4);
        return BytesHexStrTranslate.bytesToHexFun(bytes);
    }

    /**
     * 校验
     * @return
     */
    public boolean check() {
        byte check = createCheck();

        return this.check == check;
    }

    /**
     * 变更CommandData对象任意数据，切记重置校验码
     */
    public void resetCheck() {
        this.check = createCheck();
    }

    /***************************************************命令客户端指令********************************************/

    /**
     * 命令层C1字符型命令
     * @param command
     */
    public CommandData(String command) {
        this.control = (byte)0xc1;
        byte[] strBytes = command.getBytes();
        byte tmpDataLength = (byte)0;
        if (strBytes.length > 255) {
            tmpDataLength = (byte)0xff;
        } else {
            tmpDataLength = (byte)strBytes.length;
        }

        this.dataLength = tmpDataLength;
        this.data = new byte[ByteConvert.byteToUbyte(tmpDataLength)];
        System.arraycopy(strBytes, 0, this.data, 0, data.length);
        this.check = createCheck();
    }

    /**
     * 命令层C2灯光调节命令
     * @param percent
     * @param control
     */
    public CommandData(int percent, byte control) {
        this("", percent, control);
    }

    /**
     * 单灯C2灯光调节命令
     * @param realtime_uid
     * @param percent
     * @param control
     */
    public CommandData(String realtime_uid, int percent, byte control) {
        byte[] realtime_uid_bytes = BytesHexStrTranslate.toBytes(realtime_uid);
        this.control = control;
        this.dataLength = (byte) (1 + realtime_uid_bytes.length);
        int uByteDataLength = ByteConvert.byteToUbyte(dataLength);
        this.data = new byte[uByteDataLength];
        this.data[0] = (byte)percent;
        System.arraycopy(realtime_uid_bytes, 0, this.data, 1, realtime_uid_bytes.length);
        this.check = createCheck();
    }

    /**
    *继电器模块与服务器通讯协议A
    *@param realtime_uid
    * @param control
    */
    public CommandData(String realtime_uid ,byte control){
        byte[] realtime_uid_bytes = BytesHexStrTranslate.toBytes(realtime_uid);
        this.control = control;
        this.dataLength = (byte) ( realtime_uid_bytes.length);
        int uByteDataLength = ByteConvert.byteToUbyte(dataLength);
        this.data = new byte[uByteDataLength];
        System.arraycopy(realtime_uid_bytes, 0, this.data, 0, realtime_uid_bytes.length);
        this.check = createCheck();
    }
    /**
     * 命令层C4重启复位命令
     * @return
     */
    public static CommandData getC4CommandData() {
        CommandData commandData = new CommandData();
        commandData.setControl((byte)0xc4);
        commandData.setCheck(commandData.createCheck());
        return commandData;
    }

    /**
     * 命令层C5设置终端定时发送参数命令
     * @return
     */
    public static CommandData getC5CommandData(int period) {
        CommandData commandData = new CommandData();
        commandData.setControl((byte)0xc5);
        commandData.setDataLength((byte) 2);
        commandData.setData(ByteConvert.shortToBytes((short)period));
        commandData.setCheck(commandData.createCheck());

        return commandData;
    }

    /**
     * 命令层C6命令控制柜通断电
     * @param eleboxOn
     * @return
     */
    public static CommandData getC6CommandData(Boolean eleboxOn) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xc6);
        commandData.setDataLength((byte)1);
        byte[] data = new byte[1];
        data[0] = eleboxOn ? (byte)0x01 : (byte)0x00;
        commandData.setData(data);
        commandData.setCheck(commandData.createCheck());

        return commandData;
    }

    /**
     * 命令层C7设置终端开关灯策略
     * @param switchTaskList
     * @return
     */
    public static CommandData getC7CommandData(List<SceneView.SwitchTask> switchTaskList) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xc7);

        int dataLength = 14 * switchTaskList.size();
        if (dataLength > 255) {
            throw new RuntimeException("设置开关任务策略大于15条错误");
        }

        commandData.setDataLength((byte)dataLength);

        byte[] data = new byte[dataLength];
        int k = 0;

        for (SceneView.SwitchTask switchTask : switchTaskList) {
            //任务开始
            data[k++] = switchTask.getPeriod();
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd-HH-mm");
            String[] startDateStrArray = dateFormat.format(switchTask.getStartTime()).split("-");
            data[k++] = Byte.parseByte(startDateStrArray[0]);
            data[k++] = Byte.parseByte(startDateStrArray[1]);
            data[k++] = Byte.parseByte(startDateStrArray[2]);
            data[k++] = Byte.parseByte(startDateStrArray[3]);
            data[k++] = Byte.parseByte(startDateStrArray[4]);
            data[k++] = switchTask.getLightPercent();

            //任务结束
            data[k++] = switchTask.getPeriod();
            String[] endDateStrArray = dateFormat.format(switchTask.getEndTime()).split("-");
            data[k++] = Byte.parseByte(endDateStrArray[0]);
            data[k++] = Byte.parseByte(endDateStrArray[1]);
            data[k++] = Byte.parseByte(endDateStrArray[2]);
            data[k++] = Byte.parseByte(endDateStrArray[3]);
            data[k++] = Byte.parseByte(endDateStrArray[4]);
            data[k++] = (byte)0;
        }

        commandData.setData(data);
        commandData.setCheck(commandData.createCheck());

        return commandData;
    }

    /**
     * 命令层C7设置终端开关灯策略,特定RealtimeUUID
     * @param switchTaskList
     * @param realtimeUUID
     * @return
     */
    public static CommandData getC7CommandData(List<SceneView.SwitchTask> switchTaskList, String realtimeUUID) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xc7);

        int dataLength = 14 * switchTaskList.size() + 4;
        if (dataLength > 255) {
            throw new RuntimeException("设置开关任务策略大于15条错误");
        }

        commandData.setDataLength((byte)dataLength);

        byte[] data = new byte[dataLength];
        int k = 0;

        //realtimeUUID
        byte[] realtimeUUIDBytes = BytesHexStrTranslate.toBytes(realtimeUUID);
        System.arraycopy(realtimeUUIDBytes, 0, data, k, 4);
        k += 4;

        for (SceneView.SwitchTask switchTask : switchTaskList) {
            //任务开始
            data[k++] = switchTask.getPeriod();
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd-HH-mm");
            String[] startDateStrArray = dateFormat.format(switchTask.getStartTime()).split("-");
            data[k++] = Byte.parseByte(startDateStrArray[0]);
            data[k++] = Byte.parseByte(startDateStrArray[1]);
            data[k++] = Byte.parseByte(startDateStrArray[2]);
            data[k++] = Byte.parseByte(startDateStrArray[3]);
            data[k++] = Byte.parseByte(startDateStrArray[4]);
            data[k++] = switchTask.getLightPercent();

            //任务结束
            data[k++] = switchTask.getPeriod();
            String[] endDateStrArray = dateFormat.format(switchTask.getEndTime()).split("-");
            data[k++] = Byte.parseByte(endDateStrArray[0]);
            data[k++] = Byte.parseByte(endDateStrArray[1]);
            data[k++] = Byte.parseByte(endDateStrArray[2]);
            data[k++] = Byte.parseByte(endDateStrArray[3]);
            data[k++] = Byte.parseByte(endDateStrArray[4]);
            data[k++] = (byte)0;
        }

        commandData.setData(data);
        commandData.setCheck(commandData.createCheck());

        return commandData;
    }

    /**
     * 命令层C8命令获取终端信息
     * @return
     */
    public static CommandData getC8CommandData() {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xc8);
        commandData.setCheck(commandData.createCheck());

        return commandData;
    }

    /**
     * 命令层C9设置终端的工作模式（自动-0或者手动-1）
     * @return
     */
    public static CommandData getC9CommandData(int model) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xc9);
        commandData.setDataLength((byte)1);
        commandData.setData(new byte[] {(byte)model});
        commandData.setCheck(commandData.createCheck());

        return commandData;
    }

    /**
     * 命令层C9设置终端的工作模式（自动-0或者手动-1）,特定realtimeUUID
     * @param model
     * @param realtimeUUID
     * @return
     */
    public static CommandData getC9CommandData(int model, String realtimeUUID) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xc9);
        commandData.setDataLength((byte)5);

        byte[] data = new byte[5];

        //realtimeUUID
        byte[] realtimeUUIDBytes = BytesHexStrTranslate.toBytes(realtimeUUID);
        System.arraycopy(realtimeUUIDBytes, 0, data, 0, 4);
        data[4] = (byte)model;

        commandData.setData(data);
        commandData.setCheck(commandData.createCheck());

        return commandData;
    }

    public static CommandData getF2CommandData(int powerType, String realtimeUUID) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xb2);
        commandData.setDataLength((byte)5);

        byte[] data = new byte[5];
        byte[] realtimeUUIDBytes = BytesHexStrTranslate.toBytes(realtimeUUID);
        System.arraycopy(realtimeUUIDBytes, 0, data, 0, 4);
        data[4] = (byte)powerType;

        commandData.setData(data);
        commandData.setCheck(commandData.createCheck());

        return commandData;
    }

    public static CommandData getC3CommandData(String realtimeUUID, String version, int packageNumber, int lastPackageSize) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xc3);

        byte[] realtimeUUIDBytes = BytesHexStrTranslate.toBytes(realtimeUUID);

        String[] versionArray = version.split("\\.");
        StringBuilder stringBuilder = new StringBuilder();
        for (String v : versionArray) {
            stringBuilder.append(v);
        }

        byte[] versionBytes = ByteConvert.shortToBytes(Short.parseShort(stringBuilder.toString()));

        byte[] packageNumberBytes = ByteConvert.shortToBytes((short)packageNumber);
        byte[] lastPackageSizeBytes = new byte[] {(byte)lastPackageSize};

        int dataLength = realtimeUUIDBytes.length + versionBytes.length + packageNumberBytes.length + lastPackageSizeBytes.length;

        commandData.setDataLength((byte)dataLength);

        byte[] data = new byte[dataLength];

        int k = 0;

        System.arraycopy(realtimeUUIDBytes, 0, data, k, realtimeUUIDBytes.length);
        k += realtimeUUIDBytes.length;

        System.arraycopy(versionBytes, 0, data, k, versionBytes.length);
        k += versionBytes.length;

        System.arraycopy(packageNumberBytes, 0, data, k, packageNumberBytes.length);
        k += packageNumberBytes.length;

        System.arraycopy(lastPackageSizeBytes, 0, data, k, lastPackageSizeBytes.length);
        k += lastPackageSizeBytes.length;

        commandData.setData(data);
        commandData.resetCheck();

        return commandData;
    }

    /**
     * 命令层B80应答指令
     * @return
     */
    public static CommandData getB80ReplyCommandData(byte control, Boolean success) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xb8);
        commandData.setDataLength((byte)2);
        byte[] data = new byte[2];
        data[0] = control;
        data[1] = success ? (byte)0x00 : (byte)0x01;
        commandData.setData(data);
        commandData.setCheck(commandData.createCheck());

        return commandData;
    }

    public static CommandData getB80ReplyCommandDataRealtimeUUID(byte control, Boolean success, String realtimeUUID) {
        byte[] realtimeUUIDBytes = BytesHexStrTranslate.toBytes(realtimeUUID);

        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xb8);
        commandData.setDataLength((byte)6);
        byte[] data = new byte[6];
        data[0] = control;
        data[1] = success ? (byte)0x00 : (byte)0x01;
        System.arraycopy(realtimeUUIDBytes, 0, data, 2, 4);
        commandData.setData(data);
        commandData.setCheck(commandData.createCheck());

        return commandData;
    }

    public static CommandData getA0CommandData(String gatewayRealtimeUUID, String modelUUID) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xa0);
        commandData.setDataLength((byte)40);

        byte[] data = new byte[40];

        int k = 0;

        byte[] realtimeUUIDBytes = BytesHexStrTranslate.toBytes(gatewayRealtimeUUID);
        System.arraycopy(realtimeUUIDBytes, 0, data, k, realtimeUUIDBytes.length);

        k += realtimeUUIDBytes.length;

        byte[] modelUUIDBytes = modelUUID.getBytes();
        System.arraycopy(modelUUIDBytes, 0, data, k, modelUUIDBytes.length);

        commandData.setData(data);
        commandData.resetCheck();

        return commandData;
    }


    /*
    *命令层设置0xA0应答指令
    *@return
    * */
    public static CommandData getA0CommandData(String realtime_id) {
        CommandData commandData = new CommandData();
        commandData.setControl((byte)0xa0);
        commandData.setCheck(commandData.createCheck());
        return commandData;
    }

    /*
     *命令层设置0xA1应答指令
     *@return
     * */
    public static CommandData getA1CommandData(String realtime_id) {
        CommandData commandData = new CommandData();
        commandData.setControl((byte)0xa1);
        commandData.setCheck(commandData.createCheck());
        return commandData;
    }

    /**
     * 命令层-A1指令，对应D1指令
     * @param gatewayRealtimeUUID
     * @param modelUUID
     * @param modelLoop
     * @param modelLoopState
     * @return
     */
    public static CommandData getA1CommandData(String gatewayRealtimeUUID, String modelUUID, short modelLoop, short modelLoopState) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xa1);
        commandData.setDataLength((byte)44);

        byte[] data = new byte[44];

        int k = 0;

        byte[] realtimeUUIDBytes = BytesHexStrTranslate.toBytes(gatewayRealtimeUUID);
        System.arraycopy(realtimeUUIDBytes, 0, data, k, realtimeUUIDBytes.length);
        k += realtimeUUIDBytes.length;

        byte[] modelUUIDBytes = modelUUID.getBytes();
        System.arraycopy(modelUUIDBytes, 0, data, k, modelUUIDBytes.length);
        k += modelUUIDBytes.length;

        byte[] modelLoopBytes = ByteConvert.shortToBytes(modelLoop);
        System.arraycopy(modelLoopBytes, 0, data, k, modelLoopBytes.length);
        k += modelLoopBytes.length;

        byte[] modelLoopStateBytes = ByteConvert.shortToBytes(modelLoopState);
        System.arraycopy(modelLoopStateBytes, 0, data, k, modelLoopStateBytes.length);
        k += modelLoopStateBytes.length;

        commandData.setData(data);
        commandData.resetCheck();

        return commandData;
    }

    /*
     *命令层设置0xA2应答指令
     *@return
     * */
    public static CommandData getA2CommandData(String realtime_id) {
        CommandData commandData = new CommandData();
        commandData.setControl((byte)0xa2);
        commandData.setCheck(commandData.createCheck());
        return commandData;
    }
    /*
     *命令层设置0xA3应答指令
     *@return
     * */
    public static CommandData getA3CommandData(String realtime_id) {
        CommandData commandData = new CommandData();
        commandData.setControl((byte)0xa3);
        commandData.setCheck(commandData.createCheck());
        return commandData;
    }
    /*
     *命令层设置0xA4应答指令
     *@return
     * */
    public static CommandData getA4CommandData(String realtime_id) {
        CommandData commandData = new CommandData();
        commandData.setControl((byte)0xa4);
        commandData.setCheck(commandData.createCheck());
        return commandData;
    }
    /*
     *命令层设置0xA5应答指令
     *@return
     * */
    public static CommandData getA5CommandData(String realtime_id) {
        CommandData commandData = new CommandData();
        commandData.setControl((byte)0xa5);
        commandData.setCheck(commandData.createCheck());
        return commandData;
    }

    /**
     * 命令层广播对时指令A5-对应终端D5指令
     * @return
     */
    public static CommandData getA5CommandData() {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0xa5);
        commandData.resetCheck();

        return commandData;
    }

    /*
     *命令层设置0xA6应答指令
     *@return
     * */
    public static CommandData getA6CommandData(String realtime_id) {
        CommandData commandData = new CommandData();
        commandData.setControl((byte)0xa6);
        commandData.setCheck(commandData.createCheck());
        return commandData;
    }
    /*
     *命令层设置0xA7应答指令
     *@return
     * */
    public static CommandData getA7CommandData(String realtime_id) {
        CommandData commandData = new CommandData();
        commandData.setControl((byte)0xa7);
        commandData.setCheck(commandData.createCheck());
        return commandData;
    }

    public static CommandData getC11CommandData(String realtimeUUId, byte[] modbusDirectiveBytes) {
        CommandData commandData = new CommandData();

        commandData.setControl((byte)0x11);

        byte[] realtimeUUIDBytes = BytesHexStrTranslate.toBytes(realtimeUUId);
        int dataLength = realtimeUUIDBytes.length + modbusDirectiveBytes.length;
        commandData.setDataLength((byte)dataLength);

        byte[] data = new byte[dataLength];

        int k = 0;
        System.arraycopy(realtimeUUIDBytes, 0, data, k, realtimeUUIDBytes.length);
        k += realtimeUUIDBytes.length;

        System.arraycopy(modbusDirectiveBytes, 0, data, k, modbusDirectiveBytes.length);
        k += modbusDirectiveBytes.length;

        commandData.setData(data);

        commandData.resetCheck();

        return commandData;
    }
    /***************************************************命令客户端指令********************************************/

    private byte start0 = 0x68;
    private byte[] addr = new byte[6];
    private byte start1 = 0x68;
    private byte control;
    private byte dataLength = (byte)0;
    private byte[] data = new byte[0];
    private byte check;
    private byte end0 = 0x16;
    private byte[] end1 = new byte[] {(byte)0xFE, (byte)0xFD, (byte)0xFC, (byte)0xFB, (byte)0xFA, (byte)0xF9};
    private static final long serialVersionUID = 1L;
}
