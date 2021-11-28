package com.epam.ball.tests;

import com.epam.ball.entity.Ball;
import com.epam.ball.entity.Point3D;
import com.epam.ball.logic.BallCreator;
import org.junit.Assert;
import org.junit.Test;

public class BallCreatorTest {

    private static final String VALID_LINE      = "3.0   4.0   5.0   6.0";

    @Test
    public void testCreateShouldCreateBallWhenDataCorrect() {
        // given
        BallCreator ballCreator = new BallCreator();

        // when
        Ball ball = new Ball(new Point3D(3, 4, 5), 6);
        Ball ballCreated = ballCreator.create(VALID_LINE);

        // then
        Assert.assertEquals(ball, ballCreated);
    }
}
