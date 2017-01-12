package com.jizhela.helloworld.util.configuration;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

//ehcache通过ehcache.xml来配置缓存，在TestEhcaheController.java可看到是如何应用的
//但Redis只能通过下面这个类来配置，没有xml文档来配置
/**
 * redis 自定义缓存管理器
 * 
 * @author wujing
 */
@Configuration
public class RedisCacheConfiguration extends CachingConfigurerSupport {

	/**
	 * 自定义缓存管理器.
	 * 
	 * @param redisTemplate
	 * @return
	 */
	@Bean
	public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
		// 设置默认的过期时间，这个是对于整个redis来设置的
		cacheManager.setDefaultExpiration(20);
		Map<String, Long> expires = new HashMap<String, Long>();
		// 单独设置
		expires.put("roncooCache", 200L);
		cacheManager.setExpires(expires);
		return cacheManager;
	}
	
	/**
	 * 自定义key. 此方法将会根据类名+方法名+所有参数的值生成唯一的一个key,即使@Cacheable中的value属性一样，key也会不一样。
	 */
	@Override
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object o, Method method, Object... objects) {
				StringBuilder sb = new StringBuilder();
				sb.append(o.getClass().getName());
				sb.append(method.getName());
				for (Object obj : objects) {
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}



}