package com.epam.ball.repository;

import com.epam.ball.BallIdentifiable;
import com.epam.ball.entity.Ball;

import java.util.Comparator;
import java.util.List;

public interface BallRepository {

    void add(BallIdentifiable ball);
    void delete(BallIdentifiable ball);
    void update(BallIdentifiable ball);

    List<BallIdentifiable> query(Specification specification);
    List<BallIdentifiable> sort(Comparator<BallIdentifiable> ball);
}
