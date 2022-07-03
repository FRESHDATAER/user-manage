package com.example.usermanage.user.exception;

import lombok.Getter;

/**
 * 普通系统异常类型
 *
 * @author zhiyaoma
 */

@Getter
public enum SystemErrorType implements ErrorType {

    USER_EXITS("10001", "用户名已存在"),
    EMAIL_EXITS("10002", "用户邮箱已存在"),
    SYSTEM_ERROR("10003", "系统异常"),
    PW_NOT_EQUAL("10004", "密码不一致"),
    USER_NOT_EXITS("10005", "用户不存在"),
    PARAM_ERROR("10006", "参数错误"),
    ERROR_REQUEST_PARAM("10004", "错误的请求参数");

    /**
     * 错误类型码
     */
    private String code;
    /**
     * 错误类型描述信息
     */
    private String mesg;

    SystemErrorType(String code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }
}
