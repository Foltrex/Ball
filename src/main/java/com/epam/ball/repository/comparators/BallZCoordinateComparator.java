package com.epam.ball.repository.comparators;

import com.epam.ball.BallIdentifiable;
import com.epam.ball.entity.Ball;
import com.epam.ball.entity.Point3D;

import java.util.Comparator;

public class BallZCoordinateComparator implements Comparator<BallIdentifiable> {

    @Override
    public int compare(BallIdentifiable first, BallIdentifiable second) {
        Point3D firstBallCenter = first.getCenter();
        Point3D secondBallCenter = second.getCenter();

        double firstZCenterCoordinate = firstBallCenter.getZ();
        double secondZCenterCoordinate = secondBallCenter.getZ();
        return Double.compare(firstZCenterCoordinate, secondZCenterCoordinate);
    }
}