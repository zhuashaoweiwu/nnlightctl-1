package com.nnlightctl.cuconnect.util;

import com.iotplatform.client.NorthApiClient;
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.AuthOutDTO;
import com.iotplatform.client.dto.AuthRefreshInDTO;
import com.iotplatform.client.dto.AuthRefreshOutDTO;
import com.iotplatform.client.dto.ClientInfo;
import com.iotplatform.client.invokeapi.Authentication;
import com.iotplatform.utils.PropertyUtil;
import com.nnlight.common.PropertiesUtil;
import com.nnlight.common.Tuple;

import java.io.IOException;
import java.util.Properties;

public class AuthenticationUtil {

    public static Tuple.TwoTuple<NorthApiClient, String> authentication(String propertiesPath) {
        /**---------------------initialize northApiClient------------------------*/
        NorthApiClient northApiClient = new NorthApiClient();
        Properties properties = null;
        try {
            properties = PropertiesUtil.load(propertiesPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (properties != null) {
            ClientInfo clientInfo = new ClientInfo();
            clientInfo.setPlatformIp(properties.getProperty("platformIp"));
            clientInfo.setPlatformPort(properties.getProperty("platformPort"));
            clientInfo.setAppId(properties.getProperty("app.id"));
            clientInfo.setSecret(properties.getProperty("app.secret"));

            try {
                northApiClient.setClientInfo(clientInfo);
                northApiClient.initSSLConfig();
            } catch (NorthApiException e) {
                System.out.println(e.toString());
            }
        }

        northApiClient.getVersion();

        /**----------------------get access token-------------------------------*/
        System.out.println("======get access token======");
        Authentication authentication = new Authentication(northApiClient);

        // get access token
        AuthOutDTO authOutDTO = null;
        try {
            authOutDTO = authentication.getAuthToken();
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        System.out.println(authOutDTO.toString());

        /**----------------------refresh token--------------------------------*/
        System.out.println("\n======refresh token======");
        AuthRefreshInDTO authRefreshInDTO = new AuthRefreshInDTO();

        authRefreshInDTO.setAppId(properties.getProperty("app.id"));
        authRefreshInDTO.setSecret(northApiClient.getClientInfo().getSecret());

        //get refreshToken from the output parameter (i.e. authOutDTO) of Authentication
        String refreshToken = authOutDTO.getRefreshToken();
        authRefreshInDTO.setRefreshToken(refreshToken);

        AuthRefreshOutDTO authRefreshOutDTO = null;
        try {
            authRefreshOutDTO = authentication.refreshAuthToken(authRefreshInDTO);
        } catch (NorthApiException e) {
            e.printStackTrace();
        }

        System.out.println(authRefreshOutDTO.toString());

        Tuple.TwoTuple<NorthApiClient, String> tuple = new Tuple.TwoTuple<>();
        tuple.setFirst(northApiClient);
        tuple.setSecond(authOutDTO.getAccessToken());

        return tuple;
    }

    public static void main(String[] args) {
        authentication("config/application.properties");
    }
}
