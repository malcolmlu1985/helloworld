package com.jizhela.helloworld;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.jizhela.helloworld.bean.RoncooUser;
import com.jizhela.helloworld.controller.IndexController;
import com.jizhela.helloworld.dao.RoncooUserDao;
import com.jizhela.helloworld.util.base.Page;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloworldApplicationTests {

	private MockMvc mvc;
	@Test
	public void contextLoads() throws Exception {
		
		RequestBuilder req = get("/index");
		mvc.perform(req).andExpect(status().isOk()).andExpect(content().string("hello world~"));
	}
	
	@Before
	public void before() {
		
		this.mvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
	}
	
	@Autowired
	private RoncooUserDao roncooUserDao;  //直接调用接口的类，通过Autowired, spring会注入实现类RoncooUserDaoImpl，所谓IOC
	//如果一个接口有多个实现，在想要使用的那个实现类前面加上@Primary或者@Qualifier,则IOC时就会返回这个实现类
	
	@Test
	public void insert() {
		RoncooUser roncooUser = new RoncooUser();
		roncooUser.setName("测试");
		roncooUser.setCreateTime(new Date());
		int result = roncooUserDao.insert(roncooUser);
		System.out.println(result);
	}

	@Test
	public void delete() {
		int result = roncooUserDao.deleteById(1);
		System.out.println(result);
	}

	@Test
	public void update() {
		RoncooUser roncooUser = new RoncooUser();
		roncooUser.setId(2);
		roncooUser.setName("测试2");
		roncooUser.setCreateTime(new Date());
		int result = roncooUserDao.updateById(roncooUser);
		System.out.println(result);
	}

	@Test
	public void select() {
		RoncooUser result = roncooUserDao.selectById(2);
		System.out.println(result);
	}
	

	@Test
	public void select2() {
		RoncooUser result = roncooUserDao.selectById(7);
		System.out.println(result);
	}
	
	// 分页测试
	@Test
	public void queryForPage(){
		Page<RoncooUser> result = roncooUserDao.queryForPage(1, 20, "测试");
		System.out.println(result.getList());
	}

}


