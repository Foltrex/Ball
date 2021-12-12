package com.epam.ball.repository;

import com.epam.ball.BallIdentifiable;
import com.epam.ball.entity.Ball;

public class IdSpecification implements Specification {

    private final Integer id;

    public IdSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public boolean specified(BallIdentifiable ball) {
        return ball.getId().equals(id);
    }
}
