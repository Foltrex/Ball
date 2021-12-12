package com.epam.ball.logic;

import com.epam.ball.entity.Point3D;
import org.apache.log4j.Logger;

public class BallValidator {
    private static final Logger LOGGER = Logger.getLogger(BallValidator.class);

    public boolean isBall(Point3D center, double radius) {
        LOGGER.debug("Argument ball center: " + center + '\n' +
                     "Argument radius: " + radius);
        return Double.compare(radius, 0) > 0;
    }
}
