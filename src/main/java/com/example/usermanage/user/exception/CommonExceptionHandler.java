package com.example.usermanage.user.exception;

import com.example.usermanage.user.vo.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ValidationException;

/**
 * 异常处理类
 *
 * @author zhiyaoma
 */
@ControllerAdvice
public class CommonExceptionHandler {


    /**
     * 参数校验异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Object validateExp(MethodArgumentNotValidException e) {
        e.getStackTrace();
        return Result.fail(SystemErrorType.PARAM_ERROR.getCode(), e.getMessage());
    }

    /**
     * 运行时异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Object runtimeExp(Exception e) {
        e.getStackTrace();
        return Result.fail(SystemErrorType.SYSTEM_ERROR);
    }
}
