package com.kr.ark.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response Exception(Exception e) {
        e.printStackTrace();
        return new Response("500", "서버 에러");
    }
	
	@ExceptionHandler(BizException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response TestException(Exception e) {
        e.printStackTrace();
        return new Response("501", "테스트 커스텀 예외 입니다.");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response NotFoundException(Exception e) {
        e.printStackTrace();
        return new Response("404", "찾을 수 없습니다.");
    }

    //Response DTO
    @Data
    @AllArgsConstructor
    static class Response {
        private String code;
        private String msg;
    }
}
