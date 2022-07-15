package com.epam.ball.repository.comparators;

import com.epam.ball.BallIdentifiable;

import java.util.Comparator;

public class BallIdComparator implements Comparator<BallIdentifiable> {

    @Override
    public int compare(BallIdentifiable firstBall, BallIdentifiable secondBall) {
        Integer firstBallId = firstBall.getId();
        return firstBallId.compareTo(secondBall.getId());
    }
}
