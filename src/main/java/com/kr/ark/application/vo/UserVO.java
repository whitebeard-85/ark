package com.kr.ark.application.vo;

import lombok.Data;

@Data
public class UserVO {
	
	private String serial;
    private String id;
    private String password;
    private String nickName;
    private String email;
    private String memberStatus;
    private String registerDate;
    private String register;
    private String updateDate;
    private String updateUser;
    private String deleted;
    private String lookupType;
}
