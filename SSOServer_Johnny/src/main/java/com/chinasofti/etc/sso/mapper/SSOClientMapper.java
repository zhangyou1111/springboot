package com.chinasofti.etc.sso.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SSOClientMapper {

	@Select("select * from clientlist")
	public List<SSOClient> getAllClient();
}
