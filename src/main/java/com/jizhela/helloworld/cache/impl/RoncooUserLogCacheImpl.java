package com.jizhela.helloworld.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.jizhela.helloworld.bean.RoncooUserLog;
import com.jizhela.helloworld.cache.RoncooUserLogCache;
import com.jizhela.helloworld.dao.RoncooUserLogDao;

/**
 * @author wujing
 */
//@CacheConfig缓存配置，根据cacheNames对应到ehcache.xml里面的而配置
@CacheConfig(cacheNames = "roncooCache")
@Repository
public class RoncooUserLogCacheImpl implements RoncooUserLogCache {

	@Autowired
	private RoncooUserLogDao roncooUserLogDao;

	//@Cacheable：应用到读取数据的方法上，即可缓存的方法，如查找方法：先从缓存中读取，如果没有再调用方法获取数据，然后把数据添加到缓存中。特别适用于查找。
	//即当重复使用相同参数调用方法的时候，方法本身不会被调用执行，即方法本身被略过了，取而代之的是方法的结果直接从缓存中找到并返回了。
	@Cacheable(key = "#p0")
	@Override
	public RoncooUserLog selectById(Integer id) {
		System.out.println("查询功能，缓存找不到，直接读库, id=" + id);
		return roncooUserLogDao.findOne(id);
	}

	//@CachePut：主要针对方法配置，能够根据的请求参数其结果进行缓存，和@Cacheable不同的是，它每次都会触发真实方法的调用 。适用于更新
	//@CachePut：这个注释可以确保方法被执行，同时方法的返回值也被记录到缓存中。
	@CachePut(key = "#p0")
	@Override
	public RoncooUserLog updateById(RoncooUserLog roncooUserLog) {
		System.out.println("更新功能，更新缓存，直接写库, id=" + roncooUserLog);
		return roncooUserLogDao.save(roncooUserLog);
	}

	//@CachEvict：主要针对方法配置，能够根据一定的条件缓存进行清空 主要针对方法配置，能够根据一定的条件缓存进行清空 。适用于删除
	@CacheEvict(key = "#p0")
	@Override
	public String deleteById(Integer id) {
		System.out.println("删除功能，删除缓存，直接写库, id=" + id);
		return "清空缓存成功";
	}

}
