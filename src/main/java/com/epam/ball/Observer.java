package com.epam.ball;

public interface Observer<T> {

    void update(T event);
}
