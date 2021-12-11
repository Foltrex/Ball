package com.epam.ball.repository.comparators;

import com.epam.ball.BallIdentifiable;

import java.util.Comparator;

public class BallIdComparator implements Comparator<BallIdentifiable> {

    @Override
    public int compare(BallIdentifiable firstBall, BallIdentifiable secondBall) {
        Integer firstBallId = firstBall.getId();
        Integer secondBallId = secondBall.getId();
        return firstBallId.compareTo(secondBallId);
    }
}
