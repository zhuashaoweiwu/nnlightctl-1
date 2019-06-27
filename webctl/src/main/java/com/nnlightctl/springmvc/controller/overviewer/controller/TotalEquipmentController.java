package com.nnlightctl.springmvc.controller.overviewer.controller;

import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.overviewer.service.TotalEquipmentServer;
import com.nnlightctl.springmvc.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("api/overviewer")
@RestController
public class TotalEquipmentController extends BaseController {

    @Autowired
    private TotalEquipmentServer totalEquipmentServer;

    @RequestMapping("totalequipment")
    public String totalEquipment(){


        Map totalEquipment = totalEquipmentServer.totalEquipment();

        List totalList=new ArrayList();

        totalList.add(totalEquipment);

        JsonResult jsonResult = JsonResult.getSUCCESS();

        jsonResult.setData(totalList);

        return toJson(jsonResult);

    }


}
