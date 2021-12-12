package com.epam.ball.repository.comparators;

import com.epam.ball.BallIdentifiable;
import com.epam.ball.entity.Ball;
import com.epam.ball.entity.Point3D;

import java.util.Comparator;

public class BallXCoordinateComparator implements Comparator<BallIdentifiable> {

    @Override
    public int compare(BallIdentifiable first, BallIdentifiable second) {
        Point3D firstBallCenter = first.getCenter();
        Point3D secondBallCenter = second.getCenter();

        double firstXCenterCoordinate = firstBallCenter.getX();
        double secondXCenterCoordinate = secondBallCenter.getX();
        return Double.compare(firstXCenterCoordinate, secondXCenterCoordinate);
    }
}