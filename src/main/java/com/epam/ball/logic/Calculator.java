package com.epam.ball.logic;

import com.epam.ball.entity.Ball;
import com.epam.ball.entity.Point3D;
import com.epam.ball.exceptions.BallNotCrossPlaneException;
import org.apache.log4j.Logger;

public class Calculator {
    private static final Logger LOGGER = Logger.getLogger(Calculator.class);

    public double calculateSurfaceArea(Ball ball) {
        LOGGER.debug("Argument ball: " + ball);
        final double radius = ball.getRadius();
        return 4 * radius * radius * Math.PI;
    }

    public double calculateVolume(Ball ball) {
        LOGGER.debug("Argument ball: " + ball);
        final double radius = ball.getRadius();
        return 4 * radius * radius * radius * Math.PI / 3;
    }

    public double calculateSphericalSegmentVolume(Ball ball, double hight) {
        LOGGER.debug("Argument ball: " + ball + '\n' +
                     "Argument height: " + hight);
        final double radius = ball.getRadius();
        return hight * hight * (3 * radius - hight) / 3 * Math.PI;
    }

    /**
     * we must specify the plane specifically,
     * because the ball can intersect several axes at once
     */
    public double calculateVolumeRatio(Ball ball, Plane plane) throws BallNotCrossPlaneException {
        LOGGER.debug("Argument ball: " + ball + '\n' +
                     "Argument plane: " + plane);

        if (!isCrossingPlane(ball, plane)) {
            throw new BallNotCrossPlaneException("The ball doesn't intersect with the plane");
        }

        final double radius = ball.getRadius();
        final Point3D ballCenter = ball.getCenter();

        final double hight = Math.abs(radius - plane.getDistanceTo(ballCenter));

        double firstSphericalSegmentVolume = calculateSphericalSegmentVolume(ball, hight);
        double secondSphericalSegmentVolume = calculateVolume(ball) - firstSphericalSegmentVolume;

        double volumeRatio = firstSphericalSegmentVolume / secondSphericalSegmentVolume;

        LOGGER.info(String.format("Volume ratio: %.3f", volumeRatio));
        return volumeRatio;
    }


    public boolean isTouchingPlane(Ball ball) {
        LOGGER.debug("Argument ball: " + ball);

        final Point3D ballCenter = ball.getCenter();
        final double radius = ball.getRadius();

        boolean isTouchingOXY = isEqual(Math.abs(ballCenter.getZ()), radius);
        boolean isTouchingOXZ = isEqual(Math.abs(ballCenter.getY()), radius);
        boolean isTouchingOYZ = isEqual(Math.abs(ballCenter.getX()), radius);

        return isTouchingOXY || isTouchingOXZ || isTouchingOYZ;
    }

    public boolean isCrossingPlane(Ball ball, Plane plane) {
        LOGGER.debug("Argument ball: " + ball + '\n' +
                     "Argument plane: " + plane);

        final Point3D ballCenter = ball.getCenter();
        final double radius = ball.getRadius();

        return Double.compare(plane.getDistanceTo(ballCenter), radius) <= 0;
    }

    private final double EPSILON = 1e-6;
    private boolean isEqual(double x, double y) {
        return (x - y) < EPSILON;
    }
}
