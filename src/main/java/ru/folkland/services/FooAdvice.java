package ru.folkland.services;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

//@RestControllerAdvice
public class FooAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public Exception handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) {
        return e;
    }
}
