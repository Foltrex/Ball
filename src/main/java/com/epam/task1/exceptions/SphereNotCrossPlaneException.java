package com.epam.task1.exceptions;

import com.epam.task1.Sphere;

public class SphereNotCrossPlaneException extends Exception {
    private Sphere sphere;
    private String plane;

    public SphereNotCrossPlaneException(String message, Sphere sphere, String plane) {
        super(message);
        this.sphere = sphere;
        this.plane = plane;
    }

    public Sphere getSphere() {
        return sphere;
    }

    public String getPlane() {
        return plane;
    }
}
