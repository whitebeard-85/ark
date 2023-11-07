package com.kr.ark.application.manage.code.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kr.ark.application.manage.code.mapper.CodeMapper;
import com.kr.ark.application.manage.code.vo.CodeGrpVO;
import com.kr.ark.application.manage.code.vo.CodeVO;
import com.kr.ark.common.model.ResponseMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CodeService {

	private final CodeMapper codeMapper;

	public ResponseMessage selectCodeGrpList(CodeGrpVO input) {
		List<CodeGrpVO> dataList = codeMapper.selectCodeGrpList(input);
		return ResponseMessage.ok(dataList, "조회되었습니다.");
	}

	public ResponseMessage selectCodeList(CodeVO input) {
		List<CodeVO> dataList = codeMapper.selectCodeList(input);
		return ResponseMessage.ok(dataList, "조회되었습니다.");
	}
}
