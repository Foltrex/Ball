package com.epam.task1.exceptions;

import java.io.IOException;

public class DataException extends IOException {
    private String fileName;

    public DataException(String message, String fileName) {
        super(message);
        this.fileName = fileName;
    }
}
