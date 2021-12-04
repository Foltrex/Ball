package com.epam.ball.tests;

import com.epam.ball.BallIdentifiable;
import com.epam.ball.BallStore;
import com.epam.ball.entity.Point3D;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.List;

import static org.mockito.Matchers.any;

public class BallIdentifiableTest {

    @Test
    public void testAttachShouldAttachObserver() throws IllegalAccessException, NoSuchFieldException {
        // given
        BallIdentifiable ball = new BallIdentifiable(1, new Point3D(1, 1, 1), 2);

        List observers = Mockito.mock(List.class);
        Field observersField = BallIdentifiable.class.getDeclaredField("observers");
        observersField.setAccessible(true);
        observersField.set(ball, observers);

        Mockito.when(observers.add(BallStore.getInstance())).thenReturn(true);

        // when
        ball.attach(BallStore.getInstance());

        // then
        Mockito.verify(observers).add(BallStore.getInstance());
    }

    @Test
    public void testDetachShouldDetachObserver() throws IllegalAccessException, NoSuchFieldException {
        // given
        BallIdentifiable ball = new BallIdentifiable(1, new Point3D(1, 1, 1), 2);

        List observers = Mockito.mock(List.class);
        Field observersField = BallIdentifiable.class.getDeclaredField("observers");
        observersField.setAccessible(true);
        observersField.set(ball, observers);

        Mockito.when(observers.remove(BallStore.getInstance())).thenReturn(true);

        // when
        ball.detach(BallStore.getInstance());

        // then
        Mockito.verify(observers).remove(BallStore.getInstance());
    }

    @Test
    public void testNotifyObserversShouldNotifyObservers() throws NoSuchFieldException, IllegalAccessException {
        // given
        BallIdentifiable ball = new BallIdentifiable(1, new Point3D(1, 1, 1), 2);

        List observers = Mockito.mock(List.class);
        Field observersField = BallIdentifiable.class.getDeclaredField("observers");
        observersField.setAccessible(true);
        observersField.set(ball, observers);

        Mockito.doNothing().when(observers).forEach(any());

        // when
        ball.notifyObservers();

        // then
        Mockito.verify(observers).forEach(any());
    }
}
