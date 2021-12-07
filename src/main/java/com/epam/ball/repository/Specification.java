package com.epam.ball.repository;

import com.epam.ball.BallIdentifiable;
import com.epam.ball.entity.Ball;

public interface Specification {

    boolean specified(BallIdentifiable ball);
}
