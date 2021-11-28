package com.epam.ball.entity;

public class Ball {
    private final Point3D center;
    private final double radius;

    public Ball(Point3D center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ball)) {
            return false;
        }

        Ball ball = (Ball) o;

        return Double.compare(radius, ball.radius) == 0 && center.equals(ball.center);
    }

    @Override
    public int hashCode() {
        int hash = 5;

        int centerHash = center.hashCode();
        int radiusHash = (int) radius;

        hash = 17 * hash + centerHash;
        hash = 17 * hash + radiusHash;

        return hash;
    }



    public Point3D getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
