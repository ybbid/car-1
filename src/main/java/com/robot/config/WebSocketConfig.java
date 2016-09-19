package com.robot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
/**
 * Socket 配置
 *@author panlunyou
 *@date 2016年9月19日下午4:39:40
 *@version 1.0
 */
@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter (){
    	
    
        return new ServerEndpointExporter();
    }
}
