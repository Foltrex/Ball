package com.epam.ball.exceptions;

import com.epam.ball.entity.Ball;

public class BallNotCrossPlaneException extends Exception {
    private Ball ball;
    private String plane;

    public BallNotCrossPlaneException(String message, Ball ball, String plane) {
        super(message);
        this.ball = ball;
        this.plane = plane;
    }

    public Ball getBall() {
        return ball;
    }

    public String getPlane() {
        return plane;
    }
}
