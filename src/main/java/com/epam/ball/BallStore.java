package com.epam.ball;

import com.epam.ball.logic.Calculator;

import java.util.HashMap;
import java.util.Map;

public class BallStore implements Observer<BallIdentifiable> {

    private static BallStore instance;

    private final Map<Integer, Parameters> parameters = new HashMap<>();

    private final Calculator calculator = new Calculator();

    private BallStore() { }

    public void update(BallIdentifiable ball) {
        double volume = calculator.calculateVolume(ball);
        double surfaceArea = calculator.calculateSurfaceArea(ball);
        parameters.put(ball.getId(), new Parameters(volume, surfaceArea));
    }

    public static BallStore getInstance() {
        if (instance == null) {
            //System.out.println("I'm null");
            instance = new BallStore();
        }
        return instance;
    }
}
