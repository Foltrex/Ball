package com.epam.ball.logic;

import com.epam.ball.entity.Point3D;
import org.apache.log4j.Logger;

public class BallValidator {
    private static final Logger logger = Logger.getLogger(BallValidator.class.getName());

    public boolean isBall(Point3D center, double radius) {
        logger.debug("Argument ball center: " + center + '\n' +
                "Argument radius: " + radius);
        return radius > 0;
    }
}
