package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.chinasofti.etc.sso.SsoServerJohnnyApplication;
import com.chinasofti.etc.sso.mapper.Userinfo;
import com.chinasofti.etc.sso.mapper.UserinfoMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SsoServerJohnnyApplication.class)
public class SsoServerJohnnyApplicationTests {
	
	@Autowired
	UserinfoMapper userinfoMapper;

	@Test
	public void contextLoads() {
		List<Userinfo> list = userinfoMapper.findUsers();
		System.out.println(list.size());
		System.out.println("=================================");
		for (Userinfo info : list) {
			System.out.println(info.getUsername());
		}
	}

}
