package com.epam.ball.exceptions;

import com.epam.ball.entity.Ball;
import com.epam.ball.logic.Plane;

public class BallNotCrossPlaneException extends Exception {

    public BallNotCrossPlaneException(String message) {
        super(message);
    }
}
