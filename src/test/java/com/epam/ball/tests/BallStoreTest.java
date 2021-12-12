package com.epam.ball.tests;

import com.epam.ball.BallIdentifiable;
import com.epam.ball.BallStore;
import com.epam.ball.Parameters;
import com.epam.ball.entity.Point3D;
import com.epam.ball.logic.Calculator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Map;

import static org.mockito.Matchers.isA;

public class BallStoreTest {


    @Before
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = BallStore.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    public void testUpdateShouldUpdateWhenInstanceNull() throws IllegalAccessException, NoSuchFieldException {
        // given
        BallStore instance = BallStore.getInstance();

        Calculator calculator = Mockito.mock(Calculator.class);
        Field calculatorField = BallStore.class.getDeclaredField("calculator");
        calculatorField.setAccessible(true);
        calculatorField.set(instance, calculator);
        Mockito.when(calculator.calculateVolume(isA(BallIdentifiable.class))).thenReturn(33.510);
        Mockito.when(calculator.calculateSurfaceArea(isA(BallIdentifiable.class))).thenReturn(50.265);

        Map<Integer, Parameters> parameters = Mockito.mock(Map.class);
        Field parametersField = BallStore.class.getDeclaredField("parameters");
        parametersField.setAccessible(true);
        parametersField.set(instance, parameters);
        Mockito.when(parameters.put(isA(Integer.class), isA(Parameters.class))).thenReturn(null);


        // when
        instance.update(new BallIdentifiable(1, new Point3D(1, 1, 1), 2));


        // then
        Mockito.verify(calculator).calculateVolume(isA(BallIdentifiable.class));
        Mockito.verify(calculator).calculateSurfaceArea(isA(BallIdentifiable.class));
        Mockito.verify(parameters).put(isA(Integer.class), isA(Parameters.class));
    }
}
