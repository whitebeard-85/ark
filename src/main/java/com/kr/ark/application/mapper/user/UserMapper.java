package com.kr.ark.application.mapper.user;

import org.apache.ibatis.annotations.Mapper;

import com.kr.ark.application.vo.UserVO;

@Mapper
public interface UserMapper {
	public UserVO selectUser(UserVO input);
	public int insertUser(UserVO input);
}
