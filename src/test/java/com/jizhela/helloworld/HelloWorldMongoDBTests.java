package com.jizhela.helloworld;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.jizhela.helloworld.bean.RoncooUserLog;
import com.jizhela.helloworld.dao.RoncooUserLogMongoDao;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldMongoDBTests {

	/*@Autowired
	private RoncooMongodbComponent roncooMongodbComponent;

	@Test
	public void set() {
		RoncooUser roncooUser = new RoncooUser();
		roncooUser.setId(1);
		roncooUser.setName("无境1");
		roncooUser.setCreateTime(new Date());
		roncooMongodbComponent.insert(roncooUser);
	}

	@Test
	public void select() {
		System.out.println(roncooMongodbComponent.selectById(1));
	}
	
	@Test
	public void update() {
		RoncooUser roncooUser = new RoncooUser();
		roncooUser.setId(1);
		roncooUser.setName("测试修改");
		roncooUser.setCreateTime(new Date());
		roncooMongodbComponent.updateById(roncooUser);
		System.out.println(roncooMongodbComponent.selectById(1));
	}
	
	@Test
	public void delete() {
		roncooMongodbComponent.deleteById(1);
	}*/
	
	//上面的增删查改用的是RoncooMongodbComponent，它里面是用mongotemplate来实现功能
	//以下用的是RoncooUserLogMongoDao，它继承了MongoRepository
	@Autowired
	private RoncooUserLogMongoDao roncooUserLogMongoDao;

	@Test
	public void insert() {
		RoncooUserLog entity = new RoncooUserLog();
		entity.setId(1);
		entity.setUserName("无境");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		roncooUserLogMongoDao.save(entity);
		System.out.println(roncooUserLogMongoDao.findOne(1));
	}

	@Test
	public void delete() {
		roncooUserLogMongoDao.delete(1);
	}

	@Test
	public void update() {
		RoncooUserLog entity = new RoncooUserLog();
		entity.setId(2);
		entity.setUserName("无境2");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		roncooUserLogMongoDao.save(entity);
	}

	@Test
	public void select() {
		RoncooUserLog result = roncooUserLogMongoDao.findOne(1);
		System.out.println(result);
	}

	@Test
	public void select2() {
		RoncooUserLog result = roncooUserLogMongoDao.findByUserName("无境2");
		System.out.println(result);
	}

	// 分页
	@Test
	public void queryForPage() {
		Pageable pageable = new PageRequest(0, 20, new Sort(new Order(Direction.DESC, "id")));
		// Page<RoncooUserLog> result = roncooUserLogDao.findByUserName("无境2", pageable);
		Page<RoncooUserLog> result = roncooUserLogMongoDao.findAll(pageable);
		System.out.println(result.getContent());
	}

}