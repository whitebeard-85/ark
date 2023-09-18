package com.kr.ark.application.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kr.ark.application.user.vo.UserVO;

@Mapper
public interface UserMapper {
	public UserVO selectUser(UserVO input);
	public int insertUser(UserVO input);
}
