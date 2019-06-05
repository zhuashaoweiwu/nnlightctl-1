package com.Controller;

import com.weatherserver.SendCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/command")
public class CommandSendController {

    @Resource
    private SendCommand sendCommand;

    @RequestMapping("/send")
    public String sendCommandData(){

        sendCommand.ACommand((byte)0x01);
        return "发送消息成功";
    }




}
