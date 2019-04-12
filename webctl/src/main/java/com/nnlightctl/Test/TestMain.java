package com.nnlightctl.Test;

import com.nnlightctl.springmvc.controller.UploadDataLightingController;

import org.junit.jupiter.api.Test;


public class TestMain {

    UploadDataLightingController uploadDataLightingController=new UploadDataLightingController();

   @Test
    public void testAdd(){
        uploadDataLightingController.xyEMEI("123","345","222");
    }

}
