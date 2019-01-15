package com.nnlightctl.cuconnect.util;

import com.iotplatform.client.NorthApiClient;
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.*;
import com.iotplatform.client.invokeapi.SignalDelivery;
import com.nnlight.common.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class SignalDeliveryUtil {

    private static final Logger log = LoggerFactory.getLogger(SignalDeliveryUtil.class);

    private static PostDeviceCommandOutDTO2 postCommand(SignalDelivery signalDelivery, String deviceId, String accessToken, CommandDTOV4 commandDTOV4) {
        PostDeviceCommandInDTO2 pdcInDTO = new PostDeviceCommandInDTO2();
        pdcInDTO.setDeviceId(deviceId);
        pdcInDTO.setCommand(commandDTOV4);

        try {
            return signalDelivery.postDeviceCommand(pdcInDTO, null, accessToken);
        } catch (NorthApiException e) {
            log.error(e.getError_code() + ":" + e.getError_desc());
        }
        return null;
    }

    public static void signalDelivery(NorthApiClient northApiClient, String accessToken, String deviceId, CommandDTOV4 commandDTOV4)
        throws Exception {

        if (northApiClient == null || StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(deviceId)) {
            return;
        }

        SignalDelivery signalDelivery = new SignalDelivery(northApiClient);

        /**---------------------post an NB-IoT device command------------------------*/
        //this is a test NB-IoT device
        System.out.println("======post an NB-IoT device command======");
        PostDeviceCommandOutDTO2 pdcOutDTO = postCommand(signalDelivery, deviceId, accessToken, commandDTOV4);
        if (pdcOutDTO != null) {
            System.out.println(pdcOutDTO.toString());
            String commandId = pdcOutDTO.getCommandId();

            /**---------------------update device command------------------------*/
            System.out.println("\n======update device command======");
            UpdateDeviceCommandInDTO udcInDTO = new UpdateDeviceCommandInDTO();
            udcInDTO.setStatus("CANCELED");
            UpdateDeviceCommandOutDTO udcOutDTO = signalDelivery.updateDeviceCommand(udcInDTO, commandId, null, accessToken);
            System.out.println(udcOutDTO.toString());
        }
    }

    public static void main(String[] args) {
        Tuple.TwoTuple<NorthApiClient, String> tuple = AuthenticationUtil.authentication("config/application.properties");

        CommandDTOV4 cmd = new CommandDTOV4();
        cmd.setServiceId("DeviceInfo");
        cmd.setMethod("PUT"); //"PUT" is the command name defined in the profile
        Map<String, Object> cmdParam = new HashMap<>();
        cmdParam.put("brightness", 50);//"brightness" is the command parameter name defined in the profile
//        cmd.setParas(cmdParam);

        try {
            signalDelivery(tuple.getFirst(), tuple.getSecond(), "6255f65f-230f-404b-89d8-917705267638", cmd);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
