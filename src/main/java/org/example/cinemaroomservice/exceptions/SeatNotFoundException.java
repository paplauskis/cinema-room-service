package org.example.cinemaroomservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class SeatNotFoundException extends RuntimeException {

    public SeatNotFoundException(String message) {
        super(message);
    }
}
