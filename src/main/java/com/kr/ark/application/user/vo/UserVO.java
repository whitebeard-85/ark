package com.kr.ark.application.user.vo;

import lombok.Data;

@Data
public class UserVO {
	private String usrSn;		// 사용자일련번호
	private String usrId;		// 사용자아이디
	private String pwd;			// 비밀번호
	private String actvNm;		// 활동명
	private String roleCd;		// 권한코드
	private String rsPwdYn;		// 비밀번호초기화여부
	private String tmpPwd;		// 임시비밀번호(비밀번호초기화시 발급)
	private String regDate;		// 등록일시
	private String regr;		// 등록자
	private String modDate;		// 수정일시
	private String modr;		// 수정자
    private String lookupType;	// 조회구분
}
