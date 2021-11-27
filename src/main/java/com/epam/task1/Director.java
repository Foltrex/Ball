package com.epam.task1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Director {
    private DataReader reader;
    private SphereValidator sphereValidator = new SphereValidator();
    private SphereCreator creator = new SphereCreator();

    public Director(DataReader reader) {
        this.reader = reader;
    }
    public Director() {}

    public List<Sphere> read(String path) throws IOException {
        List<String> lines = reader.read(path);
        List<Sphere> spheres = new ArrayList<>();
        for (String line: lines) {
            if (sphereValidator.isSphere(line)) {
                Sphere sphere = creator.create(line);
                spheres.add(sphere);
            }
        }
        return spheres;
    }
}
