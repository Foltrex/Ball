package com.epam.ball.repository;

import com.epam.ball.BallIdentifiable;
import com.epam.ball.entity.Point3D;
import com.epam.ball.logic.Plane;

public class FirstQuadrantSpecification implements Specification {
    @Override
    public boolean specified(BallIdentifiable ball) {
        Point3D ballCenter = ball.getCenter();

        return Double.compare(ballCenter.getX(), ball.getRadius()) > 0 &&
                Double.compare(ballCenter.getY(), ball.getRadius()) > 0 &&
                Double.compare(ballCenter.getZ(), ball.getRadius()) > 0;
    }
}
