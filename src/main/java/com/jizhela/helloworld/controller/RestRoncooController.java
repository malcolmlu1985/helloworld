package com.jizhela.helloworld.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.jizhela.helloworld.bean.RoncooUserLog;
import com.jizhela.helloworld.cache.RoncooUserLogCache;

/**
 * @author wujing
 */
@RestController
@RequestMapping(value = "/rest", method = RequestMethod.POST)
public class RestRoncooController { //这个rest的API的测试会在helloworld8081里面用，在8081的测试类里调用这个RestRoncooController

	@Autowired
	private RoncooUserLogCache RoncooUserLogCache;

	@RequestMapping(value = "/update")
	public RoncooUserLog update(@RequestBody JsonNode jsonNode) { //@RequestBody可以接收restful风格的请求的参数，并封装成一个json对象
		System.out.println("jsonNode=" + jsonNode);
		RoncooUserLog bean = RoncooUserLogCache.selectById(jsonNode.get("id").asInt(1)); //把参数里面的id参数转化成int，默认值是1
		if(bean == null){
			bean = new RoncooUserLog();
		}
		bean.setUserName("测试");
		bean.setCreateTime(new Date());
		bean.setUserIp("192.168.1.1");
		RoncooUserLogCache.updateById(bean);
		return bean;
	}
	//上面这个是读取json对象，从json对象中获取参数，下面这个是直接从url中获取参数

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public RoncooUserLog update2(@PathVariable(value = "id") Integer id) {
		RoncooUserLog bean = RoncooUserLogCache.selectById(id);
		if(bean == null){
			bean = new RoncooUserLog();
		}
		bean.setUserName("测试");
		bean.setCreateTime(new Date());
		bean.setUserIp("192.168.1.1");
		RoncooUserLogCache.updateById(bean);
		return bean;
	}

}
