package com.epam.task1;

import com.epam.task1.exceptions.SphereNotCrossPlaneException;

public class Calculator {
    public boolean isSphere(Point3D center, double radius) {
        return radius > 0;
    }

    public double calculateSurfaceArea(Sphere sphere) {
        double radius = sphere.getRadius();
        return 4 * radius * radius * Math.PI;
    }

    public double calculateVolume(Sphere sphere) {
        double radius = sphere.getRadius();
        return 4 * radius * radius * radius * Math.PI / 3;
    }

    public double calculateSphericalSegmentVolume(Sphere sphere, double h) {
        double radius = sphere.getRadius();
        return h * h * (3 * radius - h) / 3 * Math.PI;
    }

    /**
     * we must specify the plane specifically,
     * because the sphere can intersect several axes at once
     */
    double calculateVolumeRatio(Sphere sphere, Plane plane) throws SphereNotCrossPlaneException {
        if (!isCrossingPlane(sphere, plane))
            throw new SphereNotCrossPlaneException("The sphere doesn't intersect with the plane", sphere, plane.name());

        double radius = sphere.getRadius();
        Point3D sphereCenter = sphere.getCenter();

        double h = Math.abs(radius - plane.getDistance(sphereCenter));

        double firstSphericalSegmentVolume = calculateSphericalSegmentVolume(sphere, h);
        double secondSphericalSegmentVolume = calculateVolume(sphere) - firstSphericalSegmentVolume;

        return firstSphericalSegmentVolume / secondSphericalSegmentVolume;
    }


    public boolean isTouchingPlane(Sphere sphere) {
        Point3D sphereCenter = sphere.getCenter();
        double radius = sphere.getRadius();

        boolean isTouchingOXY = isEqual(Math.abs(sphereCenter.getZ()), radius);
        boolean isTouchingOXZ = isEqual(Math.abs(sphereCenter.getY()), radius);
        boolean isTouchingOYZ = isEqual(Math.abs(sphereCenter.getX()), radius);

        return isTouchingOXY || isTouchingOXZ || isTouchingOYZ;
    }

    public boolean isCrossingPlane(Sphere sphere, Plane plane) {
        Point3D sphereCenter = sphere.getCenter();
        double radius = sphere.getRadius();

        return plane.getDistance(sphereCenter) <= radius;
    }

    private boolean isEqual(double x, double y) {
        return (x - y) < 0.000001;
    }

    private enum Plane {
        OXY {
            public double getDistance(Point3D sphereCenter) {
                return Math.abs(sphereCenter.getZ());
            }
        },
        OXZ {
            public double getDistance(Point3D sphereCenter) {
                return Math.abs(sphereCenter.getY());
            }
        },
        OYZ {
            public double getDistance(Point3D sphereCenter) {
                return Math.abs(sphereCenter.getX());
            }
        };
        public abstract double getDistance(Point3D sphereCenter);
    }
}
