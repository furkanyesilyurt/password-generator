package com.fyesilyurt.passwordgenerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotFoundChoice extends RuntimeException {

    private static final long serialVersionUID = -3213961165289610754L;

    public NotFoundChoice(String message) {
        super(message);
    }
}
