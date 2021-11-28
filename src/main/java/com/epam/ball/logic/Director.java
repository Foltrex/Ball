package com.epam.ball.logic;

import com.epam.ball.data.DataReader;
import com.epam.ball.entity.Ball;
import com.epam.ball.exceptions.DataException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Director {
    private final DataReader reader;
    private final BallValidator ballValidator;
    private final BallCreator creator;

    public Director(DataReader reader, BallValidator ballValidator, BallCreator ballCreator) {
        this.reader = reader;
        this.ballValidator = ballValidator;
        this.creator = ballCreator;
    }

    public List<Ball> read(String path) throws DataException {
        List<String> lines = reader.read(path);
        List<Ball> balls = new ArrayList<>();
        for (String line: lines) {
            if (ballValidator.isValidLine(line)) {
                Ball ball = creator.create(line);
                balls.add(ball);
            }
        }
        return balls;
    }
}
