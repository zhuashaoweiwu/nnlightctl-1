package com.nnlightctl.springmvc.controller;

import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.IndexServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class Index extends BaseController {

    @Autowired
    private IndexServer indexServer;

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return indexServer.indexServer();
    }

    @RequestMapping("/")
    public String indexPage() {
        return "redirect:/html/index.html";
    }

    @RequestMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(MultipartFile file) {
        if (file != null) {
            String filePath = "d:/";
            filePath += file.getOriginalFilename();
            try {
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }

            return toJson(JsonResult.getSUCCESS());
        }

        return toJson(JsonResult.getFAILURE());
    }
}
