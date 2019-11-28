package com.chinasofti.etc.sso.service;

import java.util.List;

public interface ISSOTokenService {
	
	public OnlineUserInfo getUserByToken(String token);
	public void addUserToken(String token,OnlineUserInfo user);
	public boolean isUserOnline(String username);
	
	public List<OnlineUserInfo> getOnlineUserListByRole(int role);
	public List<OnlineUserInfo> getAllOnlineUser();
	public int getOnlineUserNum();

}
