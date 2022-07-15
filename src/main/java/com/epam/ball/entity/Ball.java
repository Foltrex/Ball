package com.epam.ball.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Ball {
    private Point3D center;
    private double radius;

    public Ball(Point3D center, double radius) {
        this.center = center;
        this.radius = radius;
    }
}
