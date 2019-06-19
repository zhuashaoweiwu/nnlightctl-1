package com.nnlightctl.vo;

import java.util.List;
import java.util.Map;

public class DeployEleboxModifyForView {

    private Long   id;

    private String modelCode;//设备编码

    private String modelName;//设备名称

    private Byte equType;//设备类别

    private String modelType;//设备类型

    private Map<String,Object> exleboxModel;//实体内容




    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Byte getEquType() {
        return equType;
    }

    public void setEquType(Byte equType) {
        this.equType = equType;
    }


    public Map<String, Object> getExleboxModel() {
        return exleboxModel;
    }

    public void setExleboxModel(Map<String, Object> exleboxModel) {
        this.exleboxModel = exleboxModel;
    }

}
