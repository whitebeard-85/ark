package com.kr.ark.application.manage.code.vo;

import com.kr.ark.application.common.vo.BaseVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CodeGrpVO extends BaseVO {
	private String grpCd;	// 그룹코드
	private String grpCdNm;	// 그룹코드명
	private String desc1;	// 설명1
	private String desc2;	// 설명2
	private String useYn;	// 사용여부
}
