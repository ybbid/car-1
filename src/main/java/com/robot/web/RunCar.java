package com.robot.web;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robot.service.CarRunService;

/**
 *  汽车运行接口
 *@author panlunyou
 *@date 2016年9月9日下午4:02:58
 *@version 1.0
 */
@RestController
@RequestMapping("/run")
public class RunCar {
	
static com.robot.service.CarRunService carRunService=null;  //new com.robot.service.CarRunService(11,12,13,14);
	
	 @RequestMapping("/forword")
	    public String forword() {
		
		 getCarRunService().forward();
	        return "OK";
	    }
	 
	 @RequestMapping("/backward")
	    public String backward() {
	      
		 getCarRunService().backward();
	        return "OK";
	    }
	 
	 @RequestMapping("/stop")
	    public String stop() {
		 getCarRunService().stop();
	        return "OK";
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
