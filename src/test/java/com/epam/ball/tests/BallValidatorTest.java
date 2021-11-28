package com.epam.ball.tests;

import com.epam.ball.entity.Ball;
import com.epam.ball.logic.BallValidator;
import org.junit.Assert;
import org.junit.Test;

public class BallValidatorTest {

    // given
    private final BallValidator ballValidator = new BallValidator();

    private static final String VALID_LINE              = "3.0   4.0   5.0   6.0";
    private static final String INVALID_LENGTH_LINE     = "3.0   4.0   5.0";
    private static final String INVALID_NUMBERS_LINE    = "3e4.5 12d e12 12";


    @Test
    public void testIsValidLineCheckShouldReturnTrueWhenCorrectCountCorrectNumbers() {
        // when
        boolean isValidLine = ballValidator.isValidLine(VALID_LINE);

        // then
        Assert.assertTrue(isValidLine);
    }

    @Test
    public void testIsValidLineCheckShouldReturnTrueWhenUncorrectCountCorrectNumbers() {
        // when
        boolean isValidLine = ballValidator.isValidLine(INVALID_LENGTH_LINE);

        // then
        Assert.assertFalse(isValidLine);
    }


    @Test
    public void testIsValidLineCheckShouldReturnFalseWhenCorrectCountUncorrectNumbers() {
        // when
        boolean isValidLine = ballValidator.isValidLine(INVALID_NUMBERS_LINE);

        // then
        Assert.assertFalse(isValidLine);
    }
}
