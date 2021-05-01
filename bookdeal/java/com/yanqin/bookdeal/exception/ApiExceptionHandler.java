package com.yanqin.bookdeal.exception;

import com.baomidou.mybatisplus.extension.api.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public R<String> handleException(MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        List<FieldError> invalidArguments = e.getBindingResult().getFieldErrors();
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < invalidArguments.size(); i++) {
            FieldError fieldError = invalidArguments.get(i);
            String defaultMessage = fieldError.getDefaultMessage();
            String field = fieldError.getField();
            msg.append(defaultMessage);
        }
        return R.failed(msg.toString());
    }

    @ExceptionHandler({MissingServletRequestParameterException.class,javax.validation.ConstraintViolationException.class})
    @ResponseBody
    public R<String> handleException(Exception e) {
        log.error(e.getMessage());
        return R.failed(e.getMessage());
    }

    @ExceptionHandler(UndeclaredThrowableException.class)
    @ResponseBody
    public R<String> handleException(UndeclaredThrowableException e){
        Throwable cause = e.getCause();
        String errmsg = e.getMessage();
        if(cause!=null){
            errmsg = cause.getMessage();
        }
        log.error(e.getMessage()+";causeMessage:"+errmsg,e);
        return R.failed(errmsg);
    }


    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public R<String> handleException(Throwable e) {
        log.error(getStackTrace(e));
        return R.failed(e.getMessage());
    }

    /**
     * 获取堆栈信息
     * @param throwable
     * @return
     */
    private String getStackTrace(Throwable throwable)
    {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            throwable.printStackTrace(pw);
            return "\n"+sw.toString();
        } finally {
            pw.close();
        }
    }
}
