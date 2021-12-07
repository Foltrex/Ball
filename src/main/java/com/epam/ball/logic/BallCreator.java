package com.epam.ball.logic;

import com.epam.ball.entity.Ball;
import com.epam.ball.entity.Point3D;
import org.apache.log4j.Logger;

import java.util.Optional;
import java.util.StringTokenizer;

public class BallCreator {
    private static final Logger logger = Logger.getLogger(BallCreator.class);

    public Optional<Ball> create(String line) {
        logger.debug("Argument line: " + line);

        StringTokenizer stringTokenizer = new StringTokenizer(line);

        String xToken = stringTokenizer.nextToken();
        double x = Double.parseDouble(xToken);

        String yToken = stringTokenizer.nextToken();
        double y = Double.parseDouble(yToken);

        String zToken = stringTokenizer.nextToken();
        double z = Double.parseDouble(zToken);

        String radiusToken  = stringTokenizer.nextToken();
        double radius = Double.parseDouble(radiusToken);

        Point3D center = new Point3D(x, y, z);

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
