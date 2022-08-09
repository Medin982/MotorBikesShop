package com.motorbikesshop.model.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.thymeleaf.exceptions.TemplateInputException;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ProjectBrokeException extends TemplateInputException {
    public ProjectBrokeException(String message) {
        super(message);
    }
}
