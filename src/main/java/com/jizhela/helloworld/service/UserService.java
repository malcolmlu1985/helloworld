/**
 * Copyright 2015-2016 广州市领课网络科技有限公司
 */
package com.jizhela.helloworld.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jizhela.helloworld.bean.RoncooUser;
import com.jizhela.helloworld.bean.RoncooUserLog;
import com.jizhela.helloworld.dao.RoncooUserDao;
import com.jizhela.helloworld.dao.RoncooUserLogDao;


/**
 * @author wujing
 */
@Service
public class UserService {

	@Autowired
	private RoncooUserDao roncooUserDao;

	@Autowired
	private RoncooUserLogDao roncooUserLogDao;

	/**
	 * 用户注册
	 * 
	 * @return
	 */
	@Transactional
	public String register(String name, String ip) {
		// 1.添加用户
		RoncooUser roncooUser = new RoncooUser();
		roncooUser.setName(name);
		roncooUser.setCreateTime(new Date());
		roncooUserDao.insert(roncooUser);

		// 测试使用
		boolean flag = true;
		if (flag) {
			throw new RuntimeException();
		}

		// 2.添加注册日志
		RoncooUserLog roncooUserLog = new RoncooUserLog();
		roncooUserLog.setUserName(name);
		roncooUserLog.setUserIp(ip);
		roncooUserLog.setCreateTime(new Date());
		roncooUserLogDao.save(roncooUserLog);

		return "success";
	}

}
