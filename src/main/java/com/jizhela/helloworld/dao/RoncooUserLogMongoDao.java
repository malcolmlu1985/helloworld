package com.jizhela.helloworld.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.jizhela.helloworld.bean.RoncooUserLog;



//这里extends了MongoRepository，所以用的是mongodb
//只要在application.properties里配了mongodb和redis的配置，就可以通过mongoTemplate和stringRedisTemplate来对数据库进行操作，这个和jdbctemplate是一样的
//by looking at source code MongoRepository consume mongoTemplate and provide a set of common DAO API
//so in other words, use MongoRepository is preferred way.
public interface RoncooUserLogMongoDao extends MongoRepository<RoncooUserLog, Integer>{

	RoncooUserLog findByUserName(String string);
	
	RoncooUserLog findByUserNameAndUserIp(String string, String ip);

	Page<RoncooUserLog> findByUserName(String string, Pageable pageable);
}
