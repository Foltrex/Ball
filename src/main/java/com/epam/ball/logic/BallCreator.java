package com.epam.ball.logic;

import com.epam.ball.entity.Ball;
import com.epam.ball.entity.Point3D;
import org.apache.log4j.Logger;

import java.util.Optional;
import java.util.StringTokenizer;

public class BallCreator {
    private static final Logger logger = Logger.getLogger(BallCreator.class.getName());

    public Optional<Ball> create(String line) {
        logger.debug("Argument line: " + line);

        StringTokenizer stringTokenizer = new StringTokenizer(line);

        final String X = stringTokenizer.nextToken();
        final double x = Double.parseDouble(X);

        final String Y = stringTokenizer.nextToken();
        final double y = Double.parseDouble(Y);

        final String Z = stringTokenizer.nextToken();
        final double z = Double.parseDouble(Z);

        final String RADIUS  = stringTokenizer.nextToken();
        final double radius = Double.parseDouble(RADIUS);

        final Point3D center = new Point3D(x, y, z);

        if (radius > 0) {
            Ball ball = new Ball(center, radius);
            logger.info("Created ball: " + ball);
            return Optional.of(ball);
        } else {
            logger.warn("Negative radius: " + radius);
            return Optional.empty();
        }
    }
}
