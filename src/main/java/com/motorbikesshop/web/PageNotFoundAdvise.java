package com.motorbikesshop.web;

import com.motorbikesshop.model.exeption.PageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class PageNotFoundAdvise {

    @ExceptionHandler({PageNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public ModelAndView onPageNotFound(PageNotFoundException pnfe) {
        return new ModelAndView("404");
    }

}
