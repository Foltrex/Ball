package com.epam.ball.repository.comparators;

import com.epam.ball.entity.Ball;
import com.epam.ball.entity.Point3D;

import java.util.Comparator;

public class BallZCoordinateComparator implements Comparator<Ball> {

    @Override
    public int compare(Ball first, Ball second) {
        Point3D firstBallCenter = first.getCenter();
        Point3D secondBallCenter = second.getCenter();

        double firstZCenterCoordinate = firstBallCenter.getX();
        double secondZCenterCoordinate = secondBallCenter.getX();
        return Double.compare(firstZCenterCoordinate, secondZCenterCoordinate);
    }
}