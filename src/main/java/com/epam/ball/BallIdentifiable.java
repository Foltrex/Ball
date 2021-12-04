package com.epam.ball;

import com.epam.ball.entity.Ball;
import com.epam.ball.entity.Point3D;

import java.util.ArrayList;
import java.util.List;

public class BallIdentifiable extends Ball implements Observable<BallIdentifiable> {

    private final Integer id;
    private final List<Observer<BallIdentifiable>> observers = new ArrayList<>();

    public BallIdentifiable(Integer id, Point3D center, double radius) {
        super(center, radius);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setCenter(Point3D center) {
        super.setCenter(center);
    }

    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
        notifyObservers();
    }

    @Override
    public void attach(Observer<BallIdentifiable> observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer<BallIdentifiable> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }
}
