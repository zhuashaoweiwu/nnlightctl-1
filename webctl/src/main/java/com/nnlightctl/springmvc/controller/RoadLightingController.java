package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.*;
import com.nnlightctl.request.*;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.*;
import com.nnlightctl.vo.GISView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/roadlighting")
public class RoadLightingController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(RoadLightingController.class);

    @Autowired
    private ModelLoopServer modelLoopServer;

    @Autowired
    private EleboxModelServer modelServer;

    @Autowired
    private EleboxServer eleboxServer;

    @Autowired
    private LightServer lightServer;

    @Autowired
    private LightModelServer lightModelServer;

    @Autowired
    private GISServer gisServer;

    @Autowired
    private AreaServer areaServer;

    @RequestMapping("addorupdatemodelloop")
    public String addOrUpdateModelLoop(ModelLoopRequest request) {
        logger.info("[POST] /api/roadlighting/addorupdatemodelloop");

        int ret = modelLoopServer.addOrUpdateModelLoop(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("deletemodelloop")
    public String deleteModeLoop(ModelLoopConditionRequest request) {
        logger.info("[POST] /api/roadlighting/deletemodelloop");

        int ret = modelLoopServer.deleteModelLoop(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("addeleboxmodel")
    public String addEleboxModel(EleboxModelRequest request) {
        logger.info("[POST] /api/roadlighting/addeleboxmodel");

        int ret = modelServer.addEleboxModel(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("updateeleboxmodel")
    public String updateEleboxModel(EleboxModelRequest request) {
        logger.info("[POST] /api/roadlighting/updateeleboxmodel");

        int ret = modelServer.updateEleboxModel(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("deleteeleboxmodel")
    public String deleteEleboxModel(EleboxModelConditionRequest request) {
        logger.info("[POST] /api/roadlighting/deleteeleboxmodel");

        int ret = modelServer.deleteEleboxModel(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("addelebox")
    public String addEleBox(EleboxAddModelRequest request) {
        logger.info("[POST] /api/roadlighting/addelebox");

        int ret = eleboxServer.insertElebox(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("updateelebox")
    public String updateEleBox(EleboxRequest request) {
        logger.info("[POST] /api/roadlighting/updateelebox");

        int ret = eleboxServer.updateElebox(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("updateEleboxDevice")
    public String updateEleboxDevice(EleboxConditionRequest request) {
        logger.info("[POST] /api/roadlighting/updateEleboxDevice");

        int ret = eleboxServer.updateEleboxDevice(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("splitmodelloop")
    public String modelLoopSplite(EleboxConditionRequest request) {
        logger.info("[POST] /api/roadlighting/splitmodelloop");

        int ret = eleboxServer.updateModelLoopSplite(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("deleteelebox")
    public String deleteElebox(EleboxConditionRequest request) {
        logger.info("[POST] /api/roadlighting/deleteelebox");

        int ret = eleboxServer.deleteElebox(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("listelebox")
    public String listElebox(BaseRequest request) {
        logger.info("[POST] /api/roadlighting/listelebox");

        Tuple.TwoTuple<List<Elebox>, Integer> tuple = eleboxServer.listElebox(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }

    @RequestMapping("listmodel")
    public String listEleboxModel(EleboxConditionRequest request) {
        logger.info("[POST] /api/roadlighting/listmodel");

        Tuple.TwoTuple<List<EleboxModel>, Integer> tuple = eleboxServer.listEleboxModel(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }

    @RequestMapping("listmodelloop")
    public String listModelLoop(Long modelId) {
        logger.info("[POST] /api/roadlighting/listmodelloop");

        Tuple.TwoTuple<List<EleboxModelLoop>, Integer> tuple = eleboxServer.listModelLoop(modelId);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }

    @RequestMapping("addOrUpdateLighting")
    public String addOrUpdateLighting(LightRequest request) {
        logger.info("[POST] /api/roadlighting/addOrUpdateLighting");

        int ret = lightServer.addOrUpdateLight(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("deleteLighting")
    public String deleteLighting(LightConditionRequest request) {
        logger.info("[POST] /api/roadlighting/deleteLighting");

        int ret = this.lightServer.deleteLight(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("listLighting")
    public String listLighting(LightConditionRequest request) {
        logger.info("[POST] /api/roadlighting/listLighting");

        Tuple.TwoTuple<List<Lighting>, Integer> tuple = this.lightServer.listLighting(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }

    @RequestMapping("getLighting")
    public String getLighting(Long id) {
        logger.info("[POST] /api/roadlighting/getLighting");

        Lighting lighting = this.lightServer.getLighting(id);

        List<Lighting> data = new ArrayList<>(1);
        data.add(lighting);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(data);

        return toJson(jsonResult);
    }

    @RequestMapping("updateLightBeElebox")
    public String updateLightBeElebox(LightConditionRequest request) {
        logger.info("[POST] /api/roadlighting/updateLightBeElebox");

        int ret = this.lightServer.updateLightBeElebox(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("addOrUpdateLightModel")
    public String addOrUpdateLightModel(LightModelRequest request) {
        logger.info("[POST] /api/roadlighting/addOrUpdateLightModel");

        int ret = this.lightModelServer.addOrUpdateLightModel(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("deleteLightModel")
    public String deleteLightModel(LightModelConditionRequest request) {
        logger.info("[POST] /api/roadlighting/deleteLightModel");

        int ret = this.lightModelServer.deleteLightModel(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("listLightModel")
    public String listLightModel(LightModelConditionRequest request) {
        logger.info("[POST] /api/roadlighting/listLightModel");

        Tuple.TwoTuple<List<LightingModel>, Integer> tuple = this.lightModelServer.listLightModel(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }

    @RequestMapping("addOrUpdateGIS")
    public String addOrUpdateGIS(GISRequest request) {
        logger.info("[POST] /api/roadlighting/addOrUpdateGIS");

        int ret = this.gisServer.addOrUpdateGIS(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("deleteGIS")
    public String deleteGIS(GISConditionRequest request) {
        logger.info("[POST] /api/roadlighting/deleteGIS");

        int ret = this.gisServer.deleteGIS(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("listGIS")
    public String listGIS(GISConditionRequest request) {
        logger.info("[POST] /api/roadlighting/listGIS");

        Tuple.TwoTuple<List<GISView>, Integer> tuple = this.gisServer.listGIS(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }

    @RequestMapping("addOrUpdateArea")
    public String addOrUpdateArea(AreaRequest request) {
        logger.info("[POST] /api/roadlighting/addOrUpdateArea");

        int ret = this.areaServer.addOrUpdateArea(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("deleteArea")
    public String deleteArea(AreaConditionRequest request) {
        logger.info("[POST] /api/roadlighting/deleteArea");

        int ret = this.areaServer.deleteArea(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }

        return toJson(jsonResult);
    }

    @RequestMapping("listArea")
    public String listArea(AreaConditionRequest request) {
        logger.info("[POST] /api/roadlighting/listArea");

        Tuple.TwoTuple<List<Region>, Integer> tuple = this.areaServer.listArea(request);

        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
}