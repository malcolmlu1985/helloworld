/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.jizhela.helloworld.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jizhela.helloworld.bean.RoncooUserLog;


/**
 * @author wujing
 */
//这里extends了JpaRepository，所以用的是Jpa
//jdbctemplate 和jpa用的都是application.properties里面配置的datasource，用来找到数据库，JpaRepository也是
//但如果extends了MongoRepository或者用mongotemplate，则会用application.properties里面配置的mongodb参数来找数据库
//StringRedisTemplate会用application.properties里面配置的redis参数来找数据库
//interface没有方法实现
public interface RoncooUserLogDao extends JpaRepository<RoncooUserLog, Integer> {

	/**
	 * @param string
	 * @return
	 */
	@Query(value = "select u from RoncooUserLog u where u.userName=?1")
	List<RoncooUserLog> findByUserName(String userName);

	/**
	 * @param string
	 * @param string2
	 * @return
	 */
	List<RoncooUserLog> findByUserNameAndUserIp(String string, String string2);

	/**
	 * @param exampl
	 * @param pageable
	 * @return
	 */
	Page<RoncooUserLog> findByUserName(String userName, Pageable pageable);

}
