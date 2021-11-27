package com.epam.task1;

import java.util.StringTokenizer;

public class SphereCreator {

    public Sphere create(String line) {
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
        Sphere sphere = new Sphere(center, radius);

        return sphere;
    }
}
