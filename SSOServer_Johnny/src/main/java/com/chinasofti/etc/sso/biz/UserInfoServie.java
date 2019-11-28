package com.chinasofti.etc.sso.biz;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.etc.sso.mapper.Userinfo;
import com.chinasofti.etc.sso.mapper.UserinfoMapper;
import com.chinasofti.etc.sso.sec.Passport;

/**
 * @author Johnny
 * @category 用户的业务逻辑类
 */
@Service
public class UserInfoServie {

	@Autowired
	UserinfoMapper mapper;

	@Autowired
	Passport passport;

	/**
	 * 添加用户
	 * 
	 * @param user 用户对象
	 */
	public void addUser(Userinfo user) {
		user.setUserpass(passport.md5(user.getUserpass()));
		mapper.addUser(user);
	}

	public List<Userinfo> findList() {
		return mapper.findUsers();
	}
}
