package com.chinasofti.etc.sso.mapper;

public class Userinfo {
	private int userid;
	private String username;
	private String userpass;
	private String userheadimage;
	private int userrole;

	public Userinfo() {
		super();
	}

	public Userinfo(String username, String userpass) {
		super();
		this.username = username;
		this.userpass = userpass;
	}

	public Userinfo(String username, String userpass, String userheadimage) {
		super();
		this.username = username;
		this.userpass = userpass;
		this.userheadimage = userheadimage;
	}

	public Userinfo(int userid, String username, String userpass, int userrole) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpass = userpass;
		this.userrole = userrole;
	}

	public Userinfo(int userid, String username, String userpass, String userheadimage, int userrole) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpass = userpass;
		this.userheadimage = userheadimage;
		this.userrole = userrole;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUserheadimage() {
		return userheadimage;
	}

	public void setUserheadimage(String userheadimage) {
		this.userheadimage = userheadimage;
	}

	public int getUserrole() {
		return userrole;
	}

	public void setUserrole(int userrole) {
		this.userrole = userrole;
	}

}
