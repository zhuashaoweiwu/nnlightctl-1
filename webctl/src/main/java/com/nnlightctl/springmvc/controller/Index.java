package com.nnlightctl.springmvc.controller;

import com.nnlightctl.server.IndexServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
