package com.epam.ball.logic;

import com.epam.ball.entity.Ball;
import com.epam.ball.entity.Point3D;
import com.epam.ball.exceptions.BallNotCrossPlaneException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Calculator {
    private static final Logger logger = Logger.getLogger(Calculator.class.getName());

    public double calculateSurfaceArea(Ball ball) {
        logger.debug("Argument ball: " + ball);
        final double radius = ball.getRadius();
        return 4 * radius * radius * Math.PI;
    }

    public double calculateVolume(Ball ball) {
        logger.debug("Argument ball: " + ball);
        final double radius = ball.getRadius();
        return 4 * radius * radius * radius * Math.PI / 3;
    }

    public double calculateSphericalSegmentVolume(Ball ball, double h) {
        logger.debug("Argument ball: " + ball + '\n' +
                     "Argument height: " + h);
        final double radius = ball.getRadius();
        return h * h * (3 * radius - h) / 3 * Math.PI;
    }

    /**
     * we must specify the plane specifically,
     * because the ball can intersect several axes at once
     */
    public double calculateVolumeRatio(Ball ball, Plane plane) throws BallNotCrossPlaneException {
        logger.debug("Argument ball: " + ball + '\n' +
                     "Argument plane: " + plane);

        if (!isCrossingPlane(ball, plane)) {
            logger.log(Level.WARN, "The ball doesn't intersect with the plane");
            throw new BallNotCrossPlaneException("The ball doesn't intersect with the plane", ball, plane.name());
        }

        final double radius = ball.getRadius();
        final Point3D ballCenter = ball.getCenter();

        final double h = Math.abs(radius - plane.getDistance(ballCenter));

        double firstSphericalSegmentVolume = calculateSphericalSegmentVolume(ball, h);
        double secondSphericalSegmentVolume = calculateVolume(ball) - firstSphericalSegmentVolume;

        double volumeRatio = firstSphericalSegmentVolume / secondSphericalSegmentVolume;

        logger.info(String.format("Volume ratio: %.3f", volumeRatio));
        return volumeRatio;
    }


    public boolean isTouchingPlane(Ball ball) {
        logger.debug("Argument ball: " + ball);

        final Point3D ballCenter = ball.getCenter();
        final double radius = ball.getRadius();

        boolean isTouchingOXY = isEqual(Math.abs(ballCenter.getZ()), radius);
        boolean isTouchingOXZ = isEqual(Math.abs(ballCenter.getY()), radius);
        boolean isTouchingOYZ = isEqual(Math.abs(ballCenter.getX()), radius);

        return isTouchingOXY || isTouchingOXZ || isTouchingOYZ;
    }

    public boolean isCrossingPlane(Ball ball, Plane plane) {
        logger.debug("Argument ball: " + ball + '\n' +
                     "Argument plane: " + plane);

        final Point3D ballCenter = ball.getCenter();
        final double radius = ball.getRadius();

        return plane.getDistance(ballCenter) <= radius;
    }

    private boolean isEqual(double x, double y) {
        return (x - y) < 0.000001;
    }
}
