package com.robot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试 web 页面架构  前端使用 velocity 
 *@author panlunyou
 *@date 2016年9月9日下午4:03:26
 *@version 1.0
 */

@Controller
@RequestMapping("test")
public class RunWebCar {
	
	 @RequestMapping("/index")
	    public String index(ModelMap map) {
	        return "index";
	    }
	
}
