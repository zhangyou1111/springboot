package com.chinasofti.etc.sso.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chinasofti.etc.sso.service.ISSOTokenService;
import com.chinasofti.etc.sso.service.OnlineUserInfo;

@Component("tokenService")
public class SSOTokenServiceImpl implements ISSOTokenService {

	@Override
	public OnlineUserInfo getUserByToken(String token) {
		return SSOOnlineUserList.getUserByToken(token);
	}

	@Override
	public void addUserToken(String token, OnlineUserInfo user) {
		SSOOnlineUserList.putUserToken(token, user);
	}

	@Override
	public boolean isUserOnline(String username) {
		return SSOOnlineUserList.isUserOnline(username);
	}

	@Override
	public List<OnlineUserInfo> getOnlineUserListByRole(int role) {
		
		return SSOOnlineUserList.getOnlineUserListByRole(role);
	}

	@Override
	public List<OnlineUserInfo> getAllOnlineUser() {
		return SSOOnlineUserList.getAllOnlineUser();
	}

	@Override
	public int getOnlineUserNum() {
		return SSOOnlineUserList.getOnlineUserNum();
	}

}
