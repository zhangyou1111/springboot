package com.example.demo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chinasofti.etc.sso.SsoServerJohnnyApplication;
import com.chinasofti.etc.sso.mapper.Userinfo;
import com.chinasofti.etc.sso.mapper.UserinfoMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SsoServerJohnnyApplication.class)
public class Test2 {
	
	@Autowired
	UserinfoMapper userinfoMapper;

	@Test
	public void test() {
		List<Userinfo> list = userinfoMapper.findUsersByName("mm");
		System.out.println(list.size());
		
		
	}

}
