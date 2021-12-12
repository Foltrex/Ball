package com.epam.ball.tests;

import com.epam.ball.entity.Point3D;
import com.epam.ball.logic.BallValidator;
import org.junit.Assert;
import org.junit.Test;

public class BallValidatorTest {

    private final BallValidator ballValidator = new BallValidator();

    @Test
    public void testIsBallShouldReturnTrueWhenBallValid() {
        // given
        Point3D ballCenter = new Point3D(0, 0, 0);
        double radius = 12;

        // when
        boolean isBall = ballValidator.isBall(ballCenter, radius);

        // then
        Assert.assertTrue(isBall);
    }

    @Test
    public void testIsBallShouldReturnFalseWhenBallInvalid() {
        // given
        Point3D ballCenter = new Point3D(0, 0, 0);
        double radius = -12;

        // when
        boolean isBall = ballValidator.isBall(ballCenter, radius);

        // then
        Assert.assertFalse(isBall);
    }
}
