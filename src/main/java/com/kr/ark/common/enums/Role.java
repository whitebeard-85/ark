package com.kr.ark.common.enums;

import lombok.Getter;

@Getter
public enum Role {
	
	ADMIN("관리자"), MANAGER("매니저"), MEMBER("일반사용자");
	
	private String description;

    Role(String description) {
        this.description = description;
    }
}
