package com.example.usermanage.user.exception;

import lombok.Builder;
import lombok.Data;

/**
 * 校验失败错误类型
 *
 * @author zhiyaoma
 */
@Data
@Builder
public class ValidateErrorType implements ErrorType {

    private String code;

    private String mesg;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMesg() {
        return mesg;
    }
}
