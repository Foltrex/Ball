package com.epam.ball.repository;

import com.epam.ball.BallIdentifiable;
import com.epam.ball.entity.Point3D;
import com.epam.ball.logic.Plane;

public class FirstQuadrantSpecification implements Specification {
    @Override
    public boolean specified(BallIdentifiable ball) {
        Point3D ballCenter = ball.getCenter();
        return Plane.OXY.getDistanceTo(ballCenter) > ball.getRadius() &&
                Plane.OXZ.getDistanceTo(ballCenter) > ball.getRadius() &&
                Plane.OYZ.getDistanceTo(ballCenter) > ball.getRadius();
    }
}
