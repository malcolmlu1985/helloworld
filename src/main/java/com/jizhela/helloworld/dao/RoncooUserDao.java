/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.jizhela.helloworld.dao;

import com.jizhela.helloworld.bean.RoncooUser;
import com.jizhela.helloworld.util.base.Page;

/**
 * @author wujing
 */
public interface RoncooUserDao {

	/**
	 * 插入
	 * 
	 * @param roncooUser
	 * @return
	 */
	int insert(RoncooUser roncooUser);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(int id);

	/**
	 * 更新
	 * 
	 * @param roncooUser
	 * @return
	 */
	int updateById(RoncooUser roncooUser);

	/**
	 * 查找
	 * 
	 * @param id
	 * @return
	 */
	RoncooUser selectById(int id);

	/**
	 * @return
	 */
	Page<RoncooUser> queryForPage(int pageCurrent, int pageSize, String name);

}
