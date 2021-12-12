package com.epam.ball.tests;

import com.epam.ball.entity.Ball;
import com.epam.ball.entity.Point3D;
import com.epam.ball.logic.BallCreator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class BallCreatorTest {

    // given
    private final BallCreator ballCreator = new BallCreator();

    private static final String VALID_LINE = "3.0   4.0   5.0   6.0";
    private static final String INVALID_LINE = "3.0   4.0   5.0   -6.0";

    @Test
    public void testCreateShouldCreateBallWhenDataCorrect() {
        // given
        Point3D ballCenter = new Point3D(3, 4, 5);
        double radius = 6;

        // when
        Optional<Ball> ball = Optional.of(new Ball(ballCenter, radius));
        Optional<Ball> ballCreated = ballCreator.create(VALID_LINE);

        // then
        Assert.assertEquals(ball, ballCreated);
    }

    @Test
    public void testCreateShouldntCreateBallWhenIsntBall() {
        // when
        Optional<Ball> notBall = Optional.empty();
        Optional<Ball> ballCreated = ballCreator.create(INVALID_LINE);

        // then
        Assert.assertEquals(notBall, ballCreated);
    }
}
