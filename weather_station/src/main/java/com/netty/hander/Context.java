package com.netty.hander;

import com.common.util.ArrayUtil;
import com.netty.dto.ChannelWarp;
import com.netty.dto.CommandData;
import com.weatherserver.SendCommand;
import io.netty.channel.ChannelHandlerContext;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Data
@Component
public class Context {
        @Value("${map.number}")
        private int mapCount;

        @Resource
        private SendCommand sendCommand;

        @Resource
        private ArrayUtil arrayUtil;


        @Resource
        private CommandData commandData;




        public void sendMessage(byte addr){

            //byte[] commandSend=new byte[]{sendCommand.getAddr(),sendCommand.getFunction(),sendCommand.getStartAddr()[0],sendCommand.getStartAddr()[1],sendCommand.getLength()[0],sendCommand.getLength()[1],sendCommand.getCRCCode()[0],sendCommand.getCRCCode()[1]};

            try {
                Map<String, ChannelWarp> channelWarpMap = BindWeatherHander.getBindContext().getChannelWarpMap();
                for (Map.Entry<String, ChannelWarp> entry : channelWarpMap.entrySet()) {
                    ChannelHandlerContext context = entry.getValue().getContext();
                    context.writeAndFlush(new CommandData(addr));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        private ChannelHandlerContext channelHandlerContext;

        private ChannelWarp channelWarp;

        private int number=0;





}
