package com.jizhela.helloworld.controller;



import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


//restcontroller是返回实体，controller是视图路径

@Controller
@RequestMapping ( "/testSession" ) 
public class TestSessionController {
	

	
	private static final Logger logger = LoggerFactory.getLogger(TestSessionController.class);
	
	//使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
	//如：Logger logger = LoggerFactory.getLogger(Actions.class);
	//    logger.debug("日志信息");
	//将会打印出: Actions  : 日志信息
	
	
	@RequestMapping ( "/testSession" )
	   public String hello( ModelMap model,HttpSession httpSession){
		
		  logger.info("这里是TestSessionController");
		  model.put("title",  "第一个应用：sessionID=" + httpSession.getId());
	       return "session";
	    }

}
