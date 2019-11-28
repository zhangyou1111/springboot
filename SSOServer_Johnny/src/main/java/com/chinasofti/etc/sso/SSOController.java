package com.chinasofti.etc.sso;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinasofti.etc.sso.biz.LoginService;
import com.chinasofti.etc.sso.biz.UserInfoServie;
import com.chinasofti.etc.sso.mapper.Userinfo;
import com.chinasofti.etc.sso.util.SSOFileUpload;

@Controller
public class SSOController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	UserInfoServie userinfoService;
	
	@Autowired
	SSOFileUpload sSOFileUpload;
	
	@RequestMapping(value = "/ssologin", method = RequestMethod.GET)
	public String ssologin(@RequestParam("from") String from, HttpServletRequest request) {
		System.out.println("coming....");
		HttpSession session = request.getSession(true);
		session.setAttribute("from", from);
		return "login";
	}

	@RequestMapping(value = "/ssologin", method = RequestMethod.POST)
	public String ssologin(@RequestParam("userAccount") String username, @RequestParam("userPass") String password,
			HttpServletRequest request) {
		Userinfo info = new Userinfo();
		info.setUsername(username);
		info.setUserpass(password);
		int number = loginService.login(info);
		System.out.println("登录状态为："+number);
		// 执行登录判定
		switch (number) {
		// 如果用户名错误
		case LoginService.WRONG_USERNAME:
			// 在作用域中保存用户名不存在的错误提示
			request.setAttribute("ERROR_MSG", "用户名不存在！");
			// 在作用域中保存用户填写的信息
			request.setAttribute("USER_INFO", info);
			// 跳转回登录界面
			return "login";

		// 如果密码错误
		case LoginService.WRONG_PASSWORD:
			// 在作用域中保存密码错误的错误提示
			request.setAttribute("ERROR_MSG", "用户密码不匹配！");
			// 在作用域中保存用户填写的信息
			request.setAttribute("USER_INFO", info);
			// 跳转回登录界面
			return "login";

		// 如果登陆成功
		case LoginService.LOGIN_OK:
			// 在会话信息中保存用户的详细信息
			System.out.println("登录成功");
			return "redirect:userlist";

		// 如果用户已经被锁定
		case LoginService.WRONG_LOCKED:
			// 在作用域中保存用户被锁定的错误提示
			request.setAttribute("ERROR_MSG", "该用户已经被锁定！");
			// 在作用域中保存用户填写的信息
			request.setAttribute("USER_INFO", loginService.getLoginUser());
			// 跳转回登录界面
			return "login";

		// 如果用户已经在线
		case LoginService.USER_ALREADY_ONLINE:
			// 在作用域中保存用户已经在线的错误提示
			request.setAttribute("ERROR_MSG", "该用户已经在线，不能重复登录！");
			// 在作用域中保存用户填写的信息
			request.setAttribute("USER_INFO", info);
			// 跳转回登录界面
			return "login";

		}

		return "";
	}

	@RequestMapping(value = "/ssoregist", method = RequestMethod.GET)
	public String ssoregist(HttpServletRequest request) {
		System.out.println("coming....regist");
		return "regist";
	}
	
	@RequestMapping(value = "/ssoregist", method = RequestMethod.POST)
	public String ssoregist(@RequestParam("userAccount") String username, @RequestParam("userPass") String password,
			HttpServletRequest request) {
		//头像上传
		String headimage = null;
		try {
			headimage = sSOFileUpload.upload(request);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Userinfo user = new Userinfo(username, password,headimage);
		userinfoService.addUser(user);
		return "registok";
	}
	
	@RequestMapping(value="/userlist")
	public String userlist(HttpServletRequest request){
		List<Userinfo> list = userinfoService.findList();
		//将集合存入作用域中
		request.setAttribute("list", list);
		return "userlist";
	}
	
	@RequestMapping("/ok")
	public String ok() {
		return "loginok";
	}
}
