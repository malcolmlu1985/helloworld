package com.jizhela.helloworld.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jizhela.helloworld.bean.RoncooUserLog;
import com.jizhela.helloworld.cache.RoncooUserLogCache;


@RestController
@RequestMapping("/testehcache")
public class TestEhcaheController {
	
	@Autowired
	private RoncooUserLogCache roncooUserLogCache; //直接调用接口的类，通过Autowired, spring会注入实现类RoncooUserLogCacheImpl, 所谓IOC
	//如果一个接口有多个实现，在想要使用的那个实现类前面加上@Primary或者@Qualifier,则IOC时就会返回这个实现类
	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public RoncooUserLog get(@RequestParam(defaultValue = "1") Integer id) {
		return roncooUserLogCache.selectById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public RoncooUserLog update(@RequestParam(defaultValue = "1") Integer id) {
		RoncooUserLog bean = roncooUserLogCache.selectById(id);
		bean.setUserName("测试");
		bean.setCreateTime(new Date());
		roncooUserLogCache.updateById(bean);
		return bean;
	}

	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String del(@RequestParam(defaultValue = "1") Integer id) {
		return roncooUserLogCache.deleteById(id);
	}

}
