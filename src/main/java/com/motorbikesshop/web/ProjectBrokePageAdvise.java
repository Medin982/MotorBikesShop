package com.motorbikesshop.web;

import com.motorbikesshop.model.exeption.ProjectBrokeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ProjectBrokePageAdvise {

    @ExceptionHandler({ProjectBrokeException.class})
    public ModelAndView onProjectBrokeExc() {
        return new ModelAndView("500");
    }
}
