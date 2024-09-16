package org.example.cinemaroomservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class WrongAdminPasswordException extends RuntimeException {

    public WrongAdminPasswordException(String message) {
        super(message);
    }
}
