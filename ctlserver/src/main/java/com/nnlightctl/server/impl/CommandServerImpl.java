package com.nnlightctl.server.impl;

import cn.hutool.core.io.FileUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.nnlight.common.ArrayUtil;
import com.nnlight.common.CRCUtil;
import com.nnlight.common.Constants;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlightctl.command.Command;
import com.nnlightctl.command.CommandFactory;
import com.nnlightctl.command.client.analyze.CommandAnalyzeFactory;
import com.nnlightctl.command.event.MessageEvent;
import com.nnlightctl.dao.EleboxModelLoopMapper;
import com.nnlightctl.dao.FirewareUploadRecordMapper;
import com.nnlightctl.dao.SwitchTaskInfoMapper;
import com.nnlightctl.mymessage.producer.Produce;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.net.D0Response;
import com.nnlightctl.net.ModBusResponse;
import com.nnlightctl.po.FirewareUploadRecord;
import com.nnlightctl.po.FirewareUploadRecordExample;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.po.SwitchTask;
import com.nnlightctl.po.SwitchTaskInfo;
import com.nnlightctl.request.CommandRequest;
import com.nnlightctl.request.UpdateFirewareCommandRequest;
import com.nnlightctl.server.*;
import com.nnlightctl.util.BytesHexStrTranslate;
import com.nnlightctl.vo.SceneView;
import com.nnlightctl.vo.SwitchTaskInfoView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CommandServerImpl implements CommandServer {

    private static final Logger logger = LoggerFactory.getLogger(CommandServerImpl.class);

    @Autowired
    private LightServer lightServer;

    @Autowired
    private EleboxModelServer eleboxModelServer;

    @Autowired
    private EleboxModelLoopMapper eleboxModelLoopMapper;

    @Autowired
    private SwitchTaskInfoMapper switchTaskInfoMapper;

    @Autowired
    private SceneServer sceneServer;

    @Autowired
    private FirewareUploadRecordMapper firewareUploadRecordMapper;

    @Autowired
    private FirewareUploadRecordServer firewareUploadRecordServer;

    private final Command command;

    private String globalMsg;

    @Autowired
    public CommandServerImpl(Produce produce) {
        command = CommandFactory.getNettyClientCommand(new MessageEvent() {
            @Override
            public void receiveMsg(CommandData msg) {
                globalMsg = CommandAnalyzeFactory.getCommandAnalyzer(msg.getControl()).analyze(msg);
            }
        }, produce);
    }

    @Override
    public void sendCommand(String msg) {
        command.sendMsg(msg);
    }

    @Override
    public void sendLightAdjustCommand(int percent) {
        command.sendLightAdjustCommand(percent);
    }

    @Override
    public void sendLightAdjustCommandBatch(List<Long> lightIds, int percent) {
        if (lightIds == null || lightIds.size() < 1) {
            throw new RuntimeException("批量操作的灯具数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (Long lightId : lightIds) {
            Lighting lighting = lightServer.getLighting(lightId);
            realtime_ids.add(lighting.getRealtimeUid());
        }

        command.batchSendLightAdjustCommand(realtime_ids, percent);
    }

    @Override
    public void sendLightAdjustCommandBatchUUID(List<String> lightUUIDs, int percent) {
        if (lightUUIDs == null || lightUUIDs.size() < 1) {
            throw new RuntimeException("批量操作的灯具UUID数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (String uuid : lightUUIDs) {
            Lighting lighting = lightServer.getLightingByUUID(uuid);
            realtime_ids.add(lighting.getRealtimeUid());
        }

        command.batchSendLightAdjustCommand(realtime_ids, percent);
    }

    @Override
    public String webRequireMsg() {
        String retString = "";
        if (this.globalMsg != null) {
            retString = new String(this.globalMsg);
            this.globalMsg = null;
        }

        return retString;
    }

    @Override
    public void resetCommand() {
        command.resetCommand();
    }

    @Override
    public void configTerminalSendMsgPeriod(int period) {
        command.configTerminalSendMsgPeriod(period);
    }

    @Override
    public void commandTerminalEleboxOn(Boolean terminalEleboxOn) {
        command.commandTerminalEleboxOn(terminalEleboxOn);
    }

    @Override
    public void commandReadTerminalInfo() {
        command.commandReadTerminalInfo();
    }

    @Override
    public void configTerminalSwitchPolicy(List<SwitchTask> switchTasks) {
        List<SceneView.SwitchTask> switchViewList = new ArrayList<>(8);
        for (SwitchTask switchTask : switchTasks) {
            SceneView.SwitchTask switchTaskView = new SceneView.SwitchTask();
            ReflectCopyUtil.beanSameFieldCopy(switchTask, switchTaskView);
            switchViewList.add(switchTaskView);
        }
        command.configTerminalSwitchPolicy(switchViewList);
    }

    @Override
    public void configTerminalSwitchPolicyBatch(List<SwitchTask> switchTasks, List<String> terminalUUIDs) {
        List<SceneView.SwitchTask> switchViewList = new ArrayList<>(8);
        for (SwitchTask switchTask : switchTasks) {
            SceneView.SwitchTask switchTaskView = new SceneView.SwitchTask();
            ReflectCopyUtil.beanSameFieldCopy(switchTask, switchTaskView);
            switchViewList.add(switchTaskView);
        }

        Map<Long, Object> verification = Verification(switchViewList);

        for (String terminalUUID : terminalUUIDs) {
            String terminalRealtimeUUID = lightServer.getLightingByUUID(terminalUUID).getRealtimeUid();
            command.batchConfigTerminalAutoMode(0, terminalRealtimeUUID);
            command.configTerminalSwitchPolicy(switchViewList, terminalRealtimeUUID, verification);
            command.batchConfigTerminalAutoMode(0, terminalRealtimeUUID);
        }
    }


    @Override
    public void configTerminalAutoModel(int model) {
        command.configTerminalAutoMode(model);
    }

    @Override
    public void batchConfigTerminalAutoModel(int model, List<String> uuidList) {
        for (String uuid : uuidList) {
            command.batchConfigTerminalAutoMode(model, lightServer.getLightingByUUID(uuid).getRealtimeUid());
        }
    }

    @Override
    public void commandReadServiceFixedInfo(List<Long> lightIds) {
        if (lightIds == null || lightIds.size() < 1) {
            throw new RuntimeException("批量操作的灯具数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (Long lightId : lightIds) {
            Lighting lighting = lightServer.getLighting(lightId);
            realtime_ids.add(lighting.getRealtimeUid());
        }
        command.commandReadServiceFixedInfo(realtime_ids);
    }

    @Override
    public D0Response getModelState(String modelUUID) {
        if (StringUtils.isEmpty(modelUUID)) {
            throw new RuntimeException("请求模块信息的模块UUID不可为空");
        }

        String gatewayRealtimeUUID = eleboxModelServer.getEleboxRealtimeUUIDByModelUUID(modelUUID);

        return command.getModelState(gatewayRealtimeUUID, modelUUID);
    }

    @Override
    public D0Response getModelState(Long modelId) {
        String gatewayRealtimeUUID = eleboxModelServer.getEleboxRealtimeUUIDByModelId(modelId);
        return command.getModelState(gatewayRealtimeUUID, eleboxModelServer.getEleboxModelById(modelId).getUid());
    }

    @Override
    public void configModelState(String modelUUID, short modelLoop, short modelLoopState) {
        String gatewayRealtimeUUID = eleboxModelServer.getEleboxRealtimeUUIDByModelUUID(modelUUID);

        command.configModelState(gatewayRealtimeUUID, modelUUID, modelLoop, modelLoopState);
    }

    @Override
    public void configModelState(Long loopId, short modelLoop, short modelLoopState) {
        String gatewayRealtimeUUID = eleboxModelServer.getEleboxRealtimeUUIDByLoopId(loopId);

        Long modelId = eleboxModelLoopMapper.selectByPrimaryKey(loopId).getNnlightctlEleboxModelId();

        command.configModelState(gatewayRealtimeUUID, eleboxModelServer.getEleboxModelById(modelId).getUid(), modelLoop, modelLoopState);
    }

    @Override
    public void configServiceOpenClose(List<Long> lightIds) {
        if (lightIds == null || lightIds.size() < 1) {
            throw new RuntimeException("批量操作的灯具数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (Long lightId : lightIds) {
            Lighting lighting = lightServer.getLighting(lightId);
            realtime_ids.add(lighting.getRealtimeUid());
        }
        command.serviceOpenClose(realtime_ids);
    }

    @Override
    public void batchConfigRestart(List<Long> lightIds) {
        if (lightIds == null || lightIds.size() < 1) {
            throw new RuntimeException("批量操作的灯具数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (Long lightId : lightIds) {
            Lighting lighting = lightServer.getLighting(lightId);
            realtime_ids.add(lighting.getRealtimeUid());
        }
        command.batchConfigRestart(realtime_ids);
    }

    @Override
    public void batchCommandReadTimeParameter(List<Long> lightIds) {
        if (lightIds == null || lightIds.size() < 1) {
            throw new RuntimeException("批量操作的灯具数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (Long lightId : lightIds) {
            Lighting lighting = lightServer.getLighting(lightId);
            realtime_ids.add(lighting.getRealtimeUid());
        }
        command.batchCommandReadTimeParameter(realtime_ids);
    }

    @Override
    public void batchCommandReadSending(List<Long> lightIds) {
        if (lightIds == null || lightIds.size() < 1) {
            throw new RuntimeException("批量操作的灯具数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (Long lightId : lightIds) {
            Lighting lighting = lightServer.getLighting(lightId);
            realtime_ids.add(lighting.getRealtimeUid());
        }
        command.batchCommandReadSending(realtime_ids);
    }

    @Override
    public void batchConfigSetTime() {
        command.batchConfigSetTime();
    }

    @Override
    public void batchConfigOpenCloseStrategy(List<Long> lightIds) {
        if (lightIds == null || lightIds.size() < 1) {
            throw new RuntimeException("批量操作的灯具数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (Long lightId : lightIds) {
            Lighting lighting = lightServer.getLighting(lightId);
            realtime_ids.add(lighting.getRealtimeUid());
        }
        command.batchConfigOpenCloseStrategy(realtime_ids);
    }

    @Override
    public void batchConfigWorkModel(List<Long> lightIds) {
        if (lightIds == null || lightIds.size() < 1) {
            throw new RuntimeException("批量操作的灯具数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(1);
        for (Long lightId : lightIds) {
            Lighting lighting = lightServer.getLighting(lightId);
            realtime_ids.add(lighting.getRealtimeUid());
        }
        command.batchConfigWorkModel(realtime_ids);
    }

    @Override
    public void batchConfigTerminalPowerType(List<String> terminalUUIDs, int powerType) {
        if (terminalUUIDs == null || terminalUUIDs.size() < 1) {
            throw new RuntimeException("批量设置终端的电源类型的终端数量为0");
        }

        List<String> realtime_ids = new ArrayList<>(8);
        for (String uuid : terminalUUIDs) {
            realtime_ids.add(lightServer.getLightingByUUID(uuid).getRealtimeUid());
        }

        command.batchConfigTerminalPowerType(powerType, realtime_ids);
    }

    @Override
    public void batchExecScene(List<Long> sceneIds) {
        if (sceneIds == null || sceneIds.size() < 1) {
            throw new RuntimeException("下发场景不可为空！");
        }
        //分别处理每个场景的下发
        for (Long scendId : sceneIds) {
            //获取场景下全部灯具列表
            List<Lighting> lightingList = sceneServer.listLightingsOfScene(scendId);
            //获取场景下全部任务策略列表
            List<SwitchTask> switchTaskList = sceneServer.listSwitchTaskOfScene(scendId);

            //获取灯具uuid
            List<String> lightingUUIDList = new ArrayList<>(8);
            for (Lighting lighting : lightingList) {
                lightingUUIDList.add(lighting.getUid());
            }

            //下发策略
            configTerminalSwitchPolicyBatch(switchTaskList, lightingUUIDList);
        }
    }

    private String getSLCFileName(int n) {
        String numStr = String.valueOf(n);
        int zeroNumber = 4 - numStr.length();
        for (int i = 0; i < zeroNumber; ++i) {
            numStr = "0" + numStr;
        }

        return "SLC" + numStr + ".bin";
    }

    @Override
    public int updateFireware(UpdateFirewareCommandRequest request, HttpServletRequest servletRequest) {
        String userHomePath = System.getProperty("user.home") + File.separator + Constants.USERHOME_FIREWARE
                + File.separator + Constants.USERHOME_FIREWARE_FIREWAREBACKUP;
        File file = new File(userHomePath);
        if (!file.exists()) {
            file.mkdirs();
        }

        String saveFirewareFilePath = userHomePath + File.separator + request.getUpdateFireware().getOriginalFilename();
        File saveFirewareFile = new File(saveFirewareFilePath);

        try {
            request.getUpdateFireware().transferTo(saveFirewareFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //切分固件文件
        String rootAbsolutePath = servletRequest.getSession().getServletContext().getRealPath("/");
        String versionDir = "V" + request.getVersion() + request.getAspect();
        String dir = rootAbsolutePath + File.separator + "hardware" + File.separator + "SLC"
                + File.separator + versionDir + File.separator;
        File mkDirFile = new File(dir);
        if (!mkDirFile.exists()) {
            mkDirFile.mkdirs();
        }
        FileUtil.clean(mkDirFile);

        long fileSize = saveFirewareFile.length();
        long number = fileSize / Constants.BATCH_SIZE;
        long yu = fileSize % Constants.BATCH_SIZE;
        if (yu > 0) {
            ++number;
        }

        int lastPackageSize = 0;

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(saveFirewareFile, "r")) {
            for (int i = 0; i < number; ++i) {
                byte[] buffer = new byte[Constants.BATCH_SIZE];
                randomAccessFile.seek(i * Constants.BATCH_SIZE);
                int n = randomAccessFile.read(buffer);
                logger.info("拆分固件读取字节数：[" + i + "=" + n + "]");
                //小文件CRC16验证2字节
                byte[] crc16CheckBytes = new byte[n];
                System.arraycopy(buffer, 0, crc16CheckBytes, 0, n);
                String crc16Str = CRCUtil.get16CRC(crc16CheckBytes);
                logger.info("拆分固件CRC16验证字符串：[" + i + "=" + crc16Str + "]");
                byte[] crc16bytes = ArrayUtil.reverse(BytesHexStrTranslate.toBytes(crc16Str));
                logger.info("拆分固件CRC16验证字节数：[" + i + "=" + crc16bytes.length + "]");
                byte[] combineBytes = new byte[n + crc16bytes.length];
                System.arraycopy(buffer, 0, combineBytes, 0, n);
                System.arraycopy(crc16bytes, 0, combineBytes, n, crc16bytes.length);

                byte[] writeBuffer = combineBytes;

                if (i == number - 1) {
                    //全部CRC32验证
                    randomAccessFile.seek(0);
                    byte[] totalBuffer = new byte[(int) saveFirewareFile.length()];
                    int k = randomAccessFile.read(totalBuffer);
                    byte[] crc32Bytes = ArrayUtil.reverse(BytesHexStrTranslate.toBytes(CRCUtil.get32CRC(totalBuffer)));
                    //扩展最后一个包
                    byte[] lastCombineBytes = new byte[combineBytes.length + 4];
                    System.arraycopy(combineBytes, 0, lastCombineBytes, 0, combineBytes.length);
                    System.arraycopy(crc32Bytes, 0, lastCombineBytes, combineBytes.length, 4);

                    writeBuffer = lastCombineBytes;
                    lastPackageSize = writeBuffer.length;
                }
                //小文件路径
                String piecePath = dir + File.separator + getSLCFileName(i);
                OutputStream outputStream = new FileOutputStream(piecePath);
                logger.info("拆分固件加验证要写入总字节数：[" + i + "=" + writeBuffer.length + "]");
                outputStream.write(writeBuffer, 0, writeBuffer.length);
                outputStream.close();
            }
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        //插入或者更新一条固件上传记录
        FirewareUploadRecord firewareUploadRecord = new FirewareUploadRecord();
        firewareUploadRecord.setGmtUpdated(new Date());
        firewareUploadRecord.setFirewareVersion(request.getVersion());
        firewareUploadRecord.setPackageNumber((short) number);
        firewareUploadRecord.setLastPackageSize((byte) lastPackageSize);
        firewareUploadRecord.setPersist1(request.getAspect());

        return firewareUploadRecordServer.addOrUpdateFirewareUploadRecord(firewareUploadRecord);
    }

    @Override
    public List<FirewareUploadRecord> listFirewareUploadRecord() {
        return firewareUploadRecordServer.listFirewareUploadRecord();
    }

    @Override
    public void batchInvokeFirewareUpdateUUID(CommandRequest request) {
        List<String> uuidList = request.getLightUUIDs();
        Long uploadFirewareId = request.getUploadFirewareRecordId();

        if (uuidList == null || uuidList.size() < 1 || uploadFirewareId < 1) {
            throw new RuntimeException("参数错误！");
        }

        FirewareUploadRecord firewareUploadRecord = this.firewareUploadRecordMapper.selectByPrimaryKey(uploadFirewareId);
        List<String> realtimeUUIDs = new ArrayList<>(8);
        for (String uuid : uuidList) {
            realtimeUUIDs.add(lightServer.getLightingByUUID(uuid).getRealtimeUid());
        }
        command.batchUpdateFireware(realtimeUUIDs, firewareUploadRecord.getFirewareVersion(), firewareUploadRecord.getPackageNumber(),
                firewareUploadRecord.getLastPackageSize());
    }

    @Override
    public void batchInvokeFirewareUpdateId(CommandRequest request) {
        List<Long> lightIds = request.getLightIds();
        Long uploadFirewareId = request.getUploadFirewareRecordId();

        if (lightIds == null || lightIds.size() < 1 || uploadFirewareId < 1) {
            throw new RuntimeException("参数错误！");
        }

        FirewareUploadRecord firewareUploadRecord = firewareUploadRecordMapper.selectByPrimaryKey(uploadFirewareId);
        List<String> realtimeUUIDs = new ArrayList<>(8);
        for (Long lightId : lightIds) {
            realtimeUUIDs.add(lightServer.getLighting(lightId).getRealtimeUid());
        }

        command.batchUpdateFireware(realtimeUUIDs, firewareUploadRecord.getFirewareVersion(), firewareUploadRecord.getPackageNumber(),
                firewareUploadRecord.getLastPackageSize());
    }

    @Override
    public ModBusResponse invokeModbusDirective(String realtimeUUID, byte[] directiveBytes) {
        return command.invokeModbusEM(realtimeUUID, directiveBytes);
    }


    private Map<Long, Object> Verification(List<SceneView.SwitchTask> switchTaskList) {
        int dataLength = 4;
        Map<Long, Object> resultMap = Maps.newHashMap();
        List<Long> parList = Lists.newArrayList();
        for (SceneView.SwitchTask task : switchTaskList) {
            if (!task.getPeriod().equals((byte)4))
                dataLength += 14;
            else {
                parList.add(task.getId());
                List<SwitchTaskInfoView> switchTaskInfos = switchTaskInfoMapper.selectByTaskId(task.getId());
                dataLength += switchTaskInfos.size() * 7;
                resultMap.put(task.getId(), switchTaskInfos);
            }
            if (dataLength > 255)
                throw new RuntimeException("设置开关任务策略大于15条错误");
        }
        resultMap.put(0L, dataLength);
        return resultMap;
    }
}
