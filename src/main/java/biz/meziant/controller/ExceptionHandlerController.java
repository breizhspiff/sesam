package biz.meziant.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by ronan on 17/12/16.
 */
@RestControllerAdvice
public class ExceptionHandlerController {


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    @ResponseBody
    public String manageUnexpectedException(Exception ex) {
        return ExceptionUtils.getStackTrace(ex);
    }
}
