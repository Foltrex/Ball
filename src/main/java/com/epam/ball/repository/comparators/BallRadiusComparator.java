package com.epam.ball.repository.comparators;

import com.epam.ball.BallIdentifiable;
import com.epam.ball.entity.Ball;

import java.util.Comparator;

public class BallRadiusComparator implements Comparator<BallIdentifiable> {

    @Override
    public int compare(BallIdentifiable first, BallIdentifiable second) {
        return Double.compare(first.getRadius(), second.getRadius());
    }
}