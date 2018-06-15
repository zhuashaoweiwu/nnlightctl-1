package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Institution;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.InstitutionConditionRequest;
import com.nnlightctl.request.InstitutionRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.InstitutionServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/institution")
public class InstitutionController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(InstitutionController.class);

    @Autowired
    private InstitutionServer institutionServer;

    @RequestMapping("addOrUpdateInstitution")
    public String addOrUpdateInstitution(InstitutionRequest request) {
        logger.info("[POST] /api/institution/addOrUpdateInstitution");

        int ret = institutionServer.addOrUpdateInstitution(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("listInsitution")
    public String listInstitution(BaseRequest request) {
        logger.info("[POST] /api/institution/listInsitution");

        Tuple.TwoTuple<List<Institution>, Integer> tuple = institutionServer.listInstitution(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }

    @RequestMapping("getInstitution")
    public String getInstitution(Long id) {
        logger.info("[POST] /api/institution/getInstitution");

        Institution institution = institutionServer.getInstitutionById(id);

        JsonResult jsonResult = JsonResult.getSUCCESS();

        List<Institution> institutionList = new ArrayList<>(1);
        institutionList.add(institution);

        jsonResult.setData(institutionList);

        return toJson(jsonResult);
    }

    @RequestMapping("deleteInstitution")
    public String deleteInstitution(InstitutionConditionRequest request) {
        logger.info("[POST] /api/institution/deleteInstitution");

        int ret = institutionServer.deleteInstitution(request.getInstitutionIds());

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }
}
