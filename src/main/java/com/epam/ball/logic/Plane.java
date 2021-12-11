package com.epam.ball.logic;

import com.epam.ball.entity.Point3D;

public enum Plane {
    OXY {
        public double getDistanceTo(Point3D ballCenter) {
            return Math.abs(ballCenter.getZ());
        }
    },
    OXZ {
        public double getDistanceTo(Point3D ballCenter) {
            return Math.abs(ballCenter.getY());
        }
    },
    OYZ {
        public double getDistanceTo(Point3D ballCenter) {
            return Math.abs(ballCenter.getX());
        }
    };
    public abstract double getDistanceTo(Point3D ballCenter);
}
