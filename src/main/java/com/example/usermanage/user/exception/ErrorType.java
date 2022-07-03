package com.example.usermanage.user.exception;

/**
 * 错误类型
 *
 * @author zhiyaoma
 */
public interface ErrorType {
    /**
     * 返回code
     *
     * @return
     */
    String getCode();

    /**
     * 返回mesg
     *
     * @return
     */
    String getMesg();
}