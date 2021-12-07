package com.epam.ball.repository;

import com.epam.ball.BallIdentifiable;
import com.epam.ball.entity.Ball;

import java.util.*;

public class BallRepositoryImpl implements BallRepository {

    private Map<Integer, BallIdentifiable> store = new HashMap<>();

    @Override
    public void add(BallIdentifiable ball) {

    }

    @Override
    public void delete(BallIdentifiable ball) {
        
    }

    @Override
    public void update(BallIdentifiable ball) {

    }

    @Override
    public List<BallIdentifiable> query(Specification specification) {
        List<BallIdentifiable> balls = new ArrayList<>();
        for (BallIdentifiable ball: store.values()) {
            if (specification.specified(ball)) {
                balls.add(ball);
            }
        }
        return balls;
    }

    @Override
    public List<BallIdentifiable> sort(Comparator<BallIdentifiable> ball) {
        return null;
    }
}
