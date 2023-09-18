package com.kr.ark.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

public abstract class CommonUtils {

	public static String viewPathResolve(String path) {
		return "/view/" + path;
	}

	public static String makeSerial(String userGroup) {
		String dateTime = new SimpleDateFormat("yyyyMMddHHmmssSSSSS").format(new Date());
		String randomStr = RandomStringUtils.random(20, true, true);
		String serial = userGroup + dateTime + randomStr;
		return serial;
	}

	public static String ToStr(Object str) {
        if (str == null) {
            return "";
        }
        return String.valueOf(str);
    }
}
