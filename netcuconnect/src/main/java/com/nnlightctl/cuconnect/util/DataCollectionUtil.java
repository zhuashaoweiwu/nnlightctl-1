package com.nnlightctl.cuconnect.util;

import com.iotplatform.client.NorthApiClient;
import com.iotplatform.client.dto.*;
import com.iotplatform.client.invokeapi.Authentication;
import com.iotplatform.client.invokeapi.DataCollection;
import com.nnlight.common.Tuple;
import org.springframework.util.StringUtils;

public class DataCollectionUtil {
    public static void dataCollection(NorthApiClient northApiClient, String accessToken, String deviceId) throws Exception {
        if (StringUtils.isEmpty(accessToken) || northApiClient == null || StringUtils.isEmpty(deviceId)) {
            return;
        }

        /**---------------------initialize DataCollection------------------------*/
        DataCollection dataCollection = new DataCollection(northApiClient);

        /**---------------------query device info------------------------*/
        System.out.println("======query device info======");
//        String deviceId = "cb15cbb6-04ce-4e2b-bf35-d6a264c74646";
        QuerySingleDeviceInfoOutDTO qsdiOutDTO = dataCollection.querySingleDeviceInfo(deviceId, null, null, accessToken);
        if (qsdiOutDTO != null) {
            System.out.println(qsdiOutDTO.toString());
        }

        /**---------------------query batch device info------------------------*/
        System.out.println("\n======query batch device info======");
        QueryBatchDevicesInfoInDTO qbdiInDTO = new QueryBatchDevicesInfoInDTO();
        qbdiInDTO.setPageNo(0);
        qbdiInDTO.setPageSize(10);
        QueryBatchDevicesInfoOutDTO qbdiOutDTO = dataCollection.queryBatchDevicesInfo(qbdiInDTO, accessToken);
        if (qbdiOutDTO != null) {
            System.out.println(qbdiOutDTO.toString());
        }

        /**---------------------query device data history------------------------*/
        System.out.println("\n======query device data history======");
        QueryDeviceDataHistoryInDTO qddhInDTO = new QueryDeviceDataHistoryInDTO();
        qddhInDTO.setDeviceId(deviceId);
        qddhInDTO.setGatewayId(deviceId);//for directly-connected device, the gatewayId is its own deviceId
        QueryDeviceDataHistoryOutDTO qddhOutDTO = dataCollection.queryDeviceDataHistory(qddhInDTO, accessToken);
        if (qddhOutDTO != null) {
            System.out.println(qddhOutDTO.toString());
        }

        /**---------------------query device desired history------------------------*/
        System.out.println("\n======query device desired history======");
        QueryDeviceDesiredHistoryInDTO qddesiredhInDTO = new QueryDeviceDesiredHistoryInDTO();
        qddesiredhInDTO.setDeviceId(deviceId);
        qddesiredhInDTO.setGatewayId(deviceId);//for directly-connected device, the gatewayId is its own deviceId
        QueryDeviceDesiredHistoryOutDTO qddesiredhOutDTO = dataCollection.queryDeviceDesiredHistory(qddesiredhInDTO, accessToken);
        if (qddesiredhOutDTO != null) {
            System.out.println(qddesiredhOutDTO.toString());
        }

        /**---------------------query device desired capabilities------------------------*/
        System.out.println("\n======query device desired capabilities======");
        QueryDeviceCapabilitiesInDTO qdcInDTO = new QueryDeviceCapabilitiesInDTO();
        qdcInDTO.setDeviceId(deviceId);
        QueryDeviceCapabilitiesOutDTO qdcOutDTO = dataCollection.queryDeviceCapabilities(qdcInDTO, accessToken);
        if (qdcOutDTO != null) {
            System.out.println(qdcOutDTO.toString());
        }
    }

    public static void main(String[] args) {
        Tuple.TwoTuple<NorthApiClient, String> tuple = AuthenticationUtil.authentication("config/application.properties");
        try {
            dataCollection(tuple.getFirst(), tuple.getSecond(), "6255f65f-230f-404b-89d8-917705267638");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
