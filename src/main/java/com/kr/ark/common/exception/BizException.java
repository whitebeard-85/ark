package com.kr.ark.common.exception;

public class BizException extends RuntimeException{
	private static final long serialVersionUID = 4181246915665486144L;

	public BizException() {
    }
	
	public BizException(String message) {
        super(message); // RuntimeException 클래스의 생성자를 호출합니다.
    }
}
