package com.robot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * api 项目入口
 * 
 * @author panlunyou
 * @version 1.0
 * @date 2016-06-15
 * 
 * @update 集成部署 支持war发布形式    @author panlunyou @date 2016-06-22
 */

@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableScheduling
@ServletComponentScan
public class Application/* extends SpringBootServletInitializer*/ {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
	
	
/*	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(this);
	}*/

}
