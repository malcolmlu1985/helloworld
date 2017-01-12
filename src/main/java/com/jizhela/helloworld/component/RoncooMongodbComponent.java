/**
 * Copyright 2015-2016 广州市领课网络科技有限公司
 */
package com.jizhela.helloworld.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.jizhela.helloworld.bean.RoncooUser;

/**
 * @author wujing
 */
@Component
public class RoncooMongodbComponent {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void insert(RoncooUser roncooUser) {
		mongoTemplate.insert(roncooUser);
	}

	public void deleteById(int id) {
		Criteria criteria = Criteria.where("id").in(id);
		Query query = new Query(criteria);
		mongoTemplate.remove(query, RoncooUser.class);
	}
	
	public void updateById(RoncooUser roncooUser) {
		Criteria criteria = Criteria.where("id").in(roncooUser.getId());
		Query query = new Query(criteria);
		Update update = new Update();
		update.set("name", roncooUser.getName());
		update.set("createTime", roncooUser.getCreateTime());
		mongoTemplate.updateMulti(query, update, RoncooUser.class);
	}
	
	public RoncooUser selectById(int id) {
		Criteria criteria = Criteria.where("id").in(id);
		Query query = new Query(criteria);
		return mongoTemplate.findOne(query, RoncooUser.class);
	}
}
