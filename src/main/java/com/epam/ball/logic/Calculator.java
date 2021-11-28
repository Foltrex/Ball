package com.epam.ball.logic;

import com.epam.ball.entity.Ball;
import com.epam.ball.entity.Point3D;
import com.epam.ball.exceptions.BallNotCrossPlaneException;

public class Calculator {
    public boolean isBall(Point3D center, double radius) {
        return radius > 0;
    }

    public double calculateSurfaceArea(Ball ball) {
        double radius = ball.getRadius();
        return 4 * radius * radius * Math.PI;
    }

    public double calculateVolume(Ball ball) {
        double radius = ball.getRadius();
        return 4 * radius * radius * radius * Math.PI / 3;
    }

    public double calculateSphericalSegmentVolume(Ball ball, double h) {
        double radius = ball.getRadius();
        return h * h * (3 * radius - h) / 3 * Math.PI;
    }

    /**
     * we must specify the plane specifically,
     * because the ball can intersect several axes at once
     */
    public double calculateVolumeRatio(Ball ball, Plane plane) throws BallNotCrossPlaneException {
        if (!isCrossingPlane(ball, plane)) {
            throw new BallNotCrossPlaneException("The ball doesn't intersect with the plane", ball, plane.name());
        }

        double radius = ball.getRadius();
        Point3D ballCenter = ball.getCenter();

        double h = Math.abs(radius - plane.getDistance(ballCenter));

        double firstSphericalSegmentVolume = calculateSphericalSegmentVolume(ball, h);
        double secondSphericalSegmentVolume = calculateVolume(ball) - firstSphericalSegmentVolume;

        return firstSphericalSegmentVolume / secondSphericalSegmentVolume;
    }


    public boolean isTouchingPlane(Ball ball) {
        Point3D ballCenter = ball.getCenter();
        double radius = ball.getRadius();

        boolean isTouchingOXY = isEqual(Math.abs(ballCenter.getZ()), radius);
        boolean isTouchingOXZ = isEqual(Math.abs(ballCenter.getY()), radius);
        boolean isTouchingOYZ = isEqual(Math.abs(ballCenter.getX()), radius);

        return isTouchingOXY || isTouchingOXZ || isTouchingOYZ;
    }

    public boolean isCrossingPlane(Ball ball, Plane plane) {
        Point3D ballCenter = ball.getCenter();
        double radius = ball.getRadius();

        return plane.getDistance(ballCenter) <= radius;
    }

    private boolean isEqual(double x, double y) {
        return (x - y) < 0.000001;
    }
}
