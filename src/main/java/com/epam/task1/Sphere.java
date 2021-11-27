package com.epam.task1;

public class Sphere {
    private Point3D center;
    double radius;

    public Sphere(Point3D center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public void setCenter(Point3D center) {
        this.center = center;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    public Point3D getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }
}
