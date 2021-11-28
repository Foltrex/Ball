package com.epam.ball.logic;

import com.epam.ball.entity.Ball;
import com.epam.ball.entity.Point3D;

import java.util.StringTokenizer;

public class BallCreator {

    public Ball create(String line) {
        StringTokenizer stringTokenizer = new StringTokenizer(line);

        final String X = stringTokenizer.nextToken();
        double x = Double.parseDouble(X);

        final String Y = stringTokenizer.nextToken();
        double y = Double.parseDouble(Y);

        final String Z = stringTokenizer.nextToken();
        double z = Double.parseDouble(Z);

        final String RADIUS  = stringTokenizer.nextToken();
        double radius = Double.parseDouble(RADIUS);

        Point3D center = new Point3D(x, y, z);
        Ball ball = new Ball(center, radius);

        return ball;
    }
}
