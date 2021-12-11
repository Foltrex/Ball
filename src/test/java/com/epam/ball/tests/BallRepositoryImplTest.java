package com.epam.ball.tests;

import com.epam.ball.BallIdentifiable;
import com.epam.ball.entity.Point3D;
import com.epam.ball.repository.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BallRepositoryImplTest {

    private final BallIdentifiable ballFirst = new BallIdentifiable(1, new Point3D(1, 2, 3), 2);
    private final BallIdentifiable ballSecond = new BallIdentifiable(2, new Point3D(4, 5, 6), 3);

    @Test
    public void testQueryShouldReturnBallsWhenSurfaceInGivenRange() {
        // given
        BallRepository repository = new BallRepositoryImpl();
        repository.add(ballFirst);
        repository.add(ballSecond);
        BallIdentifiable ball = Mockito.mock(BallIdentifiable.class);
        SurfaceAreaRangeSpecification specification = Mockito.mock(SurfaceAreaRangeSpecification.class);
        Mockito.when(specification.specified(ballFirst)).thenReturn(false);
        Mockito.when(specification.specified(ballSecond)).thenReturn(true);
        List<BallIdentifiable> expectedQuery = Arrays.asList(ballSecond);

        // when
        List<BallIdentifiable> actualQuery = repository.query(specification);

        // then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testQueryShouldReturnBallsWhenIdMathes() {
        // given
        BallRepository repository = new BallRepositoryImpl();
        repository.add(ballFirst);
        repository.add(ballSecond);
        IdSpecification specification = Mockito.mock(IdSpecification.class);
        Mockito.when(specification.specified(ballFirst)).thenReturn(false);
        Mockito.when(specification.specified(ballSecond)).thenReturn(true);
        List<BallIdentifiable> expectedQuery = Arrays.asList(ballSecond);

        // when
        List<BallIdentifiable> actualQuery = repository.query(specification);

        // then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testQueryShouldReturnBallsWhenInFirstQuadrant() {
        // given
        BallRepository repository = new BallRepositoryImpl();
        repository.add(ballFirst);
        repository.add(ballSecond);
        FirstQuadrantSpecification specification = Mockito.mock(FirstQuadrantSpecification.class);
        Mockito.when(specification.specified(ballFirst)).thenReturn(true);
        Mockito.when(specification.specified(ballSecond)).thenReturn(true);
        List<BallIdentifiable> expectedQuery = Arrays.asList(ballFirst, ballSecond);

        // when
        List<BallIdentifiable> actualQuery = repository.query(specification);

        // then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testSortShouldSortDataByIdWhenDataIsValid() {
        // given
        BallRepository repository = new BallRepositoryImpl();
        repository.add(ballSecond);
        repository.add(ballFirst);
        Comparator<BallIdentifiable> comparatorById = Mockito.mock(Comparator.class);
        Mockito.when(comparatorById.compare(ballFirst, ballSecond)).thenReturn(-1);
        List<BallIdentifiable> expectedQuery = Arrays.asList(ballFirst, ballSecond);

        // when
        List<BallIdentifiable> actualQuery = repository.sort(comparatorById);

        // then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testSortShouldSortDataByRadiusWhenDataIsValid() {
        // given
        BallRepository repository = new BallRepositoryImpl();
        repository.add(ballSecond);
        repository.add(ballFirst);
        Comparator<BallIdentifiable> comparatorByRadius = Mockito.mock(Comparator.class);
        Mockito.when(comparatorByRadius.compare(ballFirst, ballSecond)).thenReturn(-1);
        List<BallIdentifiable> expectedQuery = Arrays.asList(ballFirst, ballSecond);

        // when
        List<BallIdentifiable> actualQuery = repository.sort(comparatorByRadius);

        // then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testShouldSortDataByXCoordinateWhenDataIsValid() {
        // given
        BallRepository repository = new BallRepositoryImpl();
        repository.add(ballSecond);
        repository.add(ballFirst);
        Comparator<BallIdentifiable> comparatorByXCoordinate = Mockito.mock(Comparator.class);
        Mockito.when(comparatorByXCoordinate.compare(ballFirst, ballSecond)).thenReturn(-1);
        List<BallIdentifiable> expectedQuery = Arrays.asList(ballFirst, ballSecond);

        // when
        List<BallIdentifiable> actualQuery = repository.sort(comparatorByXCoordinate);

        // then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testShouldSortDataByYCoordinateWhenDataIsValid() {
        // given
        BallRepository repository = new BallRepositoryImpl();
        repository.add(ballSecond);
        repository.add(ballFirst);
        Comparator<BallIdentifiable> comparatorByYCoordinate = Mockito.mock(Comparator.class);
        Mockito.when(comparatorByYCoordinate.compare(ballFirst, ballSecond)).thenReturn(-1);
        List<BallIdentifiable> expectedQuery = Arrays.asList(ballFirst, ballSecond);

        // when
        List<BallIdentifiable> actualQuery = repository.sort(comparatorByYCoordinate);

        // then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testShouldSortDataByZCoordinateWhenDataIsValid() {
        // given
        BallRepository repository = new BallRepositoryImpl();
        repository.add(ballSecond);
        repository.add(ballFirst);
        Comparator<BallIdentifiable> comparatorByZCoordinate = Mockito.mock(Comparator.class);
        Mockito.when(comparatorByZCoordinate.compare(ballFirst, ballSecond)).thenReturn(-1);
        List<BallIdentifiable> expectedQuery = Arrays.asList(ballFirst, ballSecond);

        // when
        List<BallIdentifiable> actualQuery = repository.sort(comparatorByZCoordinate);

        // then
        Assert.assertEquals(expectedQuery, actualQuery);
    }
}
