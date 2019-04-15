package com.nnlightctl.server.impl;

import com.nnlightctl.dao.LightingGISMapper;
import com.nnlightctl.po.LightingGIS;
import com.nnlightctl.request.UploadDataRequest;
import com.nnlightctl.server.UploadDataServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class UploadDataServerImpl implements UploadDataServer {

    @Autowired
    private LightingGISMapper lightingGISMapper;

    @Override
    public int UploadGISAndEMEI(UploadDataRequest request) {
        if (request.getId()==null){
            LightingGIS lightingGIS=new LightingGIS();
            lightingGIS.setGmtCreated(new Date());
            lightingGIS.setGmtUpdated(new Date());

            lightingGIS.setLatitude(request.getLatitude());
            lightingGIS.setLongitude(request.getLongitude());
            lightingGIS.setEMEI(request.getEMEI());
            lightingGIS.setMem(request.getMem());

            this.lightingGISMapper.insertUploadData(lightingGIS);
        }
        return 1;
    }
}
