package com.epam.ball.repository;

import com.epam.ball.BallIdentifiable;
import com.epam.ball.logic.Calculator;

public class SurfaceAreaRangeSpecification implements Specification {
    private final Double surfaceAreaMin;
    private final Double surfaceAreaMax;
    private final Calculator calculator;

    public SurfaceAreaRangeSpecification(Double surfaceAreaMin, Double surfaceAreaMax, Calculator calculator) {
        this.surfaceAreaMin = surfaceAreaMin;
        this.surfaceAreaMax = surfaceAreaMax;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(BallIdentifiable ball) {

        Double surfaceArea = calculator.calculateSurfaceArea(ball);
        return Double.compare(surfaceArea, surfaceAreaMin) > 0 && Double.compare(surfaceArea, surfaceAreaMax)  < 0;
    }
}
