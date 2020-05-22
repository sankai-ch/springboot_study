package com.example.demo.common.core.biz;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SanKai
 * @since 2019-11-06
 */
public enum ErrorCode {
    SUCCESS("000000", "success"),


    //无效参数
    INVALID_PARAM("100001", "invalid param"),


    //系统异常
    SYSTEM_EXCEPTION("999999", "system error"),
    //缺少参数
    MISS_PARAM("100002", "miss param:"),

    APP_KEY_EXCEPTION("100003", "appKey不匹配"),

    APP_SECRET_EXCEPTION("100004", "签名不对"),
    APP_NEED_LOGIN("100005", "需要登录"),

    USER_NOT_EXIST("100006", "用户不存在"),

    USER_EXIST("100006", "用户已存在"),


    ;

    private String code;

    private String description;

    ErrorCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static ErrorCode findByCode(String code) {

        for (ErrorCode type : ErrorCode.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (ErrorCode code : values()) {
            map.put(code.getCode(), code.getDescription());
        }
        System.out.println(JSON.toJSONString(map));
    }
}
