package com.chinasofti.etc.sso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.chinasofti.etc.sso.mapper.Userinfo;
import com.chinasofti.etc.sso.mapper.UserinfoMapper;
import com.chinasofti.etc.sso.service.IUserinfoService;

/**
 * @author Johnny
 * @category 人员业务逻辑实现类
 */
public class UserinfoServiceImpl implements IUserinfoService {

	@Autowired
	UserinfoMapper userinfoMapper;

	@Override
	public Userinfo login(String name, String pass) {
		List<Userinfo> list = userinfoMapper.findUsersByNameAndPass(name, pass);
		return list != null ? list.get(1) : null;
	}

	@Override
	public List<Userinfo> findList() {
		List<Userinfo> list = userinfoMapper.findUsers();
		return list;
	}

}
