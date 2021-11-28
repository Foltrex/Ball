package com.epam.ball.logic;

import com.epam.ball.data.DataReader;
import com.epam.ball.entity.Ball;
import com.epam.ball.exceptions.DataException;
import org.apache.log4j.Logger;


import java.util.ArrayList;
import java.util.List;

public class Director {
    private static final Logger logger = Logger.getLogger(Director.class.getName());

    private final DataReader reader;
    private final BallValidator ballValidator;
    private final BallCreator creator;

    public Director(DataReader reader, BallValidator ballValidator, BallCreator ballCreator) {
        this.reader = reader;
        this.ballValidator = ballValidator;
        this.creator = ballCreator;
    }

    public List<Ball> read(String path) throws DataException {
        logger.debug("Argument path: " + path);

        List<String> lines = reader.read(path);
        List<Ball> balls = new ArrayList<>();
        for (String line: lines) {
            if (ballValidator.isValidLine(line)) {
                logger.info("Valid number string: " + line);
                Ball ball = creator.create(line);
                balls.add(ball);
            }
        }

        logger.info("List of created balls:\n" + balls);
        return balls;
    }
}
