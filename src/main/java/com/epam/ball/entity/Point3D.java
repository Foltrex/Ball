package com.epam.ball.entity;

import java.util.Objects;

public class Point3D {
    private final double x;
    private final double y;
    private final double z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ( !(o instanceof Point3D) ) {
            return false;
        }

        Point3D point3D = (Point3D) o;

        return  Double.compare(point3D.getX(), getX()) == 0 &&
                Double.compare(point3D.getY(), getY()) == 0 &&
                Double.compare(point3D.getZ(), getZ()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getZ());
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
