package com.robot.scoket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.robot.service.CarRunService;
/**
 * 
 *@author panlunyou
 *@date 2016年9月19日下午4:39:40
 *@version 1.0
 */
@ServerEndpoint("/websocket")
@Component
public class WebSocket {

	    private static int onlineCount = 0;
	    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();
	    private Session session;
	    static com.robot.service.CarRunService carRunService=null; 

	    @OnOpen
	    public void onOpen (Session session){
	        this.session = session;
	        webSocketSet.add(this);
	        addOnlineCount();
	        System.out.println("有新链接加入!当前在线人数为" + getOnlineCount());
	    }

	    @OnClose
	    public void onClose (){
	        webSocketSet.remove(this);
	        subOnlineCount();
	        
	    }

	    @OnMessage
	    public void onMessage (String message, Session session) throws IOException {
	        System.out.println("来自客户端的消息:" + message);
	        
	      // 群发消息
	    /*    for ( WebSocket item : webSocketSet ){
	                item.sendMessage(message);
	        }*/
	        
	        
	        switch (message) {
case "a":
	System.out.println("-------a----------");
	getCarRunService().left();
	break;
case "d":
	getCarRunService().right();;
case "w":
	getCarRunService().forward();
	break;
case "s":
	getCarRunService().backward();
	break;
	
case "p":
	getCarRunService().stop();
	break;

default:
	break;
}
	        
	        
	        
	    }

	    public void sendMessage (String message) throws IOException {
	        this.session.getBasicRemote().sendText(message);
	    }

	    public static synchronized  int getOnlineCount (){
	        return WebSocket.onlineCount;
	    }

	    public static synchronized void addOnlineCount (){
	    	WebSocket.onlineCount++;
	    }

	    public static synchronized void subOnlineCount (){
	    	WebSocket.onlineCount--;
	    }
	    
	  
	    public static CarRunService getCarRunService(){
	    	
	    	if(carRunService!=null){
	    		return carRunService;
	    			}else{
	    				
	    				 carRunService=	new com.robot.service.CarRunService(11,12,13,14);
	    			}
	    	
	    	return carRunService;
	    }
	    

	}
	
