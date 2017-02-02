package com.jizhela.helloworld.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jizhela.helloworld.component.RoncooJavaMailComponent;


/**
 * @author wujing
 */
@RestController
@RequestMapping("/api")
public class ApiController {
 
	
	@Autowired
	private RoncooJavaMailComponent component;
	
	//http://localhost:8080/api/get?name=t
  @RequestMapping(value = "/get")
  public HashMap<String, Object> get(@RequestParam String name) {
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("title", "hello world");
    map.put("name", "参数name 经过8080处理后的" + name);
    return map;
  }
  
	//访问http://localhost:8080/index/hello/22/lupeng
	@RequestMapping(value = "/mail")
	public String mail(String email) {
		component.sendMail(email);
		return "success";
	}
  
}