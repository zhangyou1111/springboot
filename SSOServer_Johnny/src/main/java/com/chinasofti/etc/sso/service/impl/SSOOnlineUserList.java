package com.chinasofti.etc.sso.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.chinasofti.etc.sso.service.OnlineUserInfo;

public class SSOOnlineUserList {

	private static Map<String, OnlineUserInfo> onlineUserList = Collections
			.synchronizedMap(new HashMap<String, OnlineUserInfo>());

	public static OnlineUserInfo getUserByToken(String token) {
		return onlineUserList.get(token);
	}

	public static void putUserToken(String token, OnlineUserInfo user) {
		onlineUserList.put(token, user);
	}

	public static Set<String> getTokenSet() {
		return onlineUserList.keySet();
	}

	public static void removeToken(String Token) {
		onlineUserList.remove(Token);
	}

	public static boolean isUserOnline(String username) {
		Set<String> tokenSet = getTokenSet();
		for (String token : tokenSet) {
			OnlineUserInfo info = getUserByToken(token);
			if (username.equals(info.getUsername())) {
				return true;
			}
		}
		return false;

	}

	public static int getOnlineUserNum() {
		return getTokenSet().size();
	}

	public static List<OnlineUserInfo> getAllOnlineUser() {
		Set<String> keys = getTokenSet();
		List<OnlineUserInfo> list = new ArrayList<OnlineUserInfo>();
		for (String token : keys) {
			list.add(getUserByToken(token));
		}
		return list;
	}

	public static List<OnlineUserInfo> getOnlineUserListByRole(int role) {
		Set<String> keys = getTokenSet();
		List<OnlineUserInfo> list = new ArrayList<OnlineUserInfo>();
		for (String token : keys) {
			OnlineUserInfo info = getUserByToken(token);
			if (role == info.getRole()) {
				list.add(info);
			}
		}
		return list;
	}

}
