package com.epam.ball.repository.comparators;

import com.epam.ball.entity.Ball;

import java.util.Comparator;

public class BallRadiusComparator implements Comparator<Ball> {

    @Override
    public int compare(Ball first, Ball second) {
        double firstBallRadius = first.getRadius();
        double secondBallRadius = second.getRadius();
        return Double.compare(firstBallRadius, secondBallRadius);
    }
}