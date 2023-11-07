package com.kr.ark.application.manage.code.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kr.ark.application.manage.code.vo.CodeGrpVO;
import com.kr.ark.application.manage.code.vo.CodeVO;

@Mapper
public interface CodeMapper {
	public List<CodeGrpVO> selectCodeGrpList(CodeGrpVO input);
	public List<CodeVO> selectCodeList(CodeVO input);
}
