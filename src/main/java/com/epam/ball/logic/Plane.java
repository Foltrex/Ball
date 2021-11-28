package com.epam.ball.logic;

import com.epam.ball.entity.Point3D;

public enum Plane {
    OXY {
        public double getDistance(Point3D ballCenter) {
            return Math.abs(ballCenter.getZ());
        }
    },
    OXZ {
        public double getDistance(Point3D ballCenter) {
            return Math.abs(ballCenter.getY());
        }
    },
    OYZ {
        public double getDistance(Point3D ballCenter) {
            return Math.abs(ballCenter.getX());
        }
    };
    public abstract double getDistance(Point3D ballCenter);
}
