package com.epam.ball.exceptions;

import java.io.IOException;

public class DataException extends IOException {
    private String filePath;

    public DataException(String message, Throwable exception, String filePath) {
        super(message, exception);
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
