package com.nnlightctl.server.impl;

import com.nnlightctl.dao.EleboxMapper;
import com.nnlightctl.po.Elebox;
import com.nnlightctl.request.EleboxAddModelRequest;
import com.nnlightctl.request.EleboxModelRequest;
import com.nnlightctl.server.EleboxModelServer;
import com.nnlightctl.server.EleboxServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EleboxServerImpl implements EleboxServer {

    @Autowired
    private EleboxMapper eleboxMapper;

    @Autowired
    private EleboxModelServer eleboxModelServer;

    @Override
    public int insertElebox(EleboxAddModelRequest request) {
        int ret = -1;
        int count = request.getCount() > 0 ? request.getCount() : 1;
        for (int i = 0; i < count; ++i) {
            Elebox elebox = new Elebox();
            elebox.setGmtCreated(new Date());
            elebox.setGmtUpdated(new Date());

            ret = eleboxMapper.insertSelective(elebox);

            List<EleboxModelRequest> eleboxModelRequestList = request.getDeviceList();
            for (EleboxModelRequest eleboxModelRequest : eleboxModelRequestList) {
                eleboxModelRequest.setNnlightctlEleboxId(elebox.getId());
                ret = eleboxModelServer.addEleboxModel(eleboxModelRequest);
            }
        }
        return ret;
    }
}
