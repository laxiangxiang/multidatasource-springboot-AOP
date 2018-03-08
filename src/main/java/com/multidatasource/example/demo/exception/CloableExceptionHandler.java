package com.multidatasource.example.demo.exception;

import com.multidatasource.example.demo.common.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CloableExceptionHandler {

    @ExceptionHandler(ParamException.class)
    @ResponseBody
    public JsonData paramHandler(ParamException e){
        return JsonData.fail(e.getMessage());
    }
}
