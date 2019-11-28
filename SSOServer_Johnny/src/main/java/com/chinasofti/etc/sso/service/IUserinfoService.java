package com.chinasofti.etc.sso.service;

import java.util.List;

import com.chinasofti.etc.sso.mapper.Userinfo;

/**
 * @author Johnny
 * @category 人员接口
 */
public interface IUserinfoService {

	/**
	 * 人员登录
	 * @param name 用户名
	 * @param pass 密码
	 * @return 人员对象
	 */
	public Userinfo login(String name,String pass);
	
	/**
	 * 查找用户列表
	 * @return 返回所有的用户列表
	 */
	public List<Userinfo> findList();
}
