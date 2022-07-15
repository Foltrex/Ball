package com.epam.ball.logic;

import com.epam.ball.entity.Point3D;

public enum Plane {
    OXY {
        public double calculateDistanceTo(Point3D ballCenter) {
            return Math.abs(ballCenter.getZ());
        }
    },
    OXZ {
        public double calculateDistanceTo(Point3D ballCenter) {
            return Math.abs(ballCenter.getY());
        }
    },
    OYZ {
        public double calculateDistanceTo(Point3D ballCenter) {
            return Math.abs(ballCenter.getX());
        }
    };

    /**
     * Сalculates the distance from this plane to a given point.
     *
     * @param ballCenter the point to which the distance is calculated
     * @return distance from this plane to ballCenter
     * */
    public abstract double calculateDistanceTo(Point3D ballCenter);
}
