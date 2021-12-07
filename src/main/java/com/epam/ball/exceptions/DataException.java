package com.epam.ball.exceptions;

import java.io.IOException;

public class DataException extends IOException {

    public DataException(String message, Throwable exception) {
        super(message, exception);
    }
}
