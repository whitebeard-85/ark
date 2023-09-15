package com.kr.ark.common.model;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {

	private int statusCode;
	private Object data;
	private String resultMessage;
	private String detailMessage;

	public static ResponseMessage of(Object data, int statusCode, String resultMessage,
		String detailMessage, String apiVersion) {
		return ResponseMessage.builder().data(data).statusCode(statusCode).resultMessage(resultMessage)
				.detailMessage(detailMessage).build();
	}

	public static ResponseMessage of(Object data, HttpStatus status, String detailMessage,
		String apiVersion) {
		return of(data, status.value(), status.getReasonPhrase(), detailMessage, apiVersion);
	}

	public static ResponseMessage of(Object data, HttpStatus status, String detailMessage) {
		return of(data, status, detailMessage, null);
	}

	public static ResponseMessage of(Object data, HttpStatus status) {
		return of(data, status, null);
	}

	public static ResponseMessage ok(Object data, String detailMessage) {
		return of(data, HttpStatus.OK, detailMessage);
	}

	public static ResponseMessage of(HttpStatus status) {
		return of(null, status);
	}

	public static ResponseMessage ok() {
		return of(HttpStatus.OK);
	}

	public static ResponseMessage ok(Object data) {
		return of(data, HttpStatus.OK);
	}

	public <T> T getConvertFromMapToData(Class<T> clazz) {
		ObjectMapper mapper = new ObjectMapper();
		return clazz.cast(mapper.convertValue(this.data, clazz));
	}
}
