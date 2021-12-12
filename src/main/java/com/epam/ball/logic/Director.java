package com.epam.ball.logic;

import com.epam.ball.data.DataReader;
import com.epam.ball.entity.Ball;
import com.epam.ball.exceptions.DataException;
import org.apache.log4j.Logger;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Director {
    private static final Logger LOGGER = Logger.getLogger(Director.class);

    private final DataReader reader;
    private final BallLineValidator ballLineValidator;
    private final BallCreator creator;

    public Director(DataReader reader, BallLineValidator ballLineValidator, BallCreator ballCreator) {
        this.reader = reader;
        this.ballLineValidator = ballLineValidator;
        this.creator = ballCreator;
    }

    public List<Ball> read(String path) throws DataException {
        LOGGER.debug("Argument path: " + path);

        List<String> lines = reader.read(path);
        List<Ball> balls = new ArrayList<>();
        for (String line: lines) {
            if (ballLineValidator.isValidLine(line)) {
                LOGGER.info("Valid number string: " + line);
                Optional<Ball> optionalBall = creator.create(line);
                if (optionalBall.isPresent()) {
                    Ball ball = optionalBall.get();
                    balls.add(ball);
                }
            }
        }

        LOGGER.info("List of created balls:\n" + balls);
        return balls;
    }
}
