package com.kr.ark.application.user.vo;

import com.kr.ark.application.common.vo.BaseVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserVO extends BaseVO {
	private String usrSn;		// 사용자일련번호
	private String usrId;		// 사용자아이디
	private String pwd;			// 비밀번호
	private String actvNm;		// 활동명
	private String agreeYn;		// 약관동의여부
	private String roleCd;		// 권한코드
	private String rsPwdYn;		// 비밀번호초기화여부
	private String tmpPwd;		// 임시비밀번호(비밀번호초기화시 발급)
    private String lookupType;	// 조회구분
}
