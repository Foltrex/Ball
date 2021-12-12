package com.epam.ball.tests;

import com.epam.ball.entity.Ball;
import com.epam.ball.entity.Point3D;
import com.epam.ball.exceptions.BallNotCrossPlaneException;
import com.epam.ball.logic.Calculator;
import com.epam.ball.logic.Plane;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    // given
    private final Calculator calculator = new Calculator();

    private static final double ACCURACY = 1e-6;


    @Test
    public void testCalculateSurfaceAreaShouldCalculateSurfaceAreaWhenBallValid() {
        // given
        Ball ball = new Ball(new Point3D(0, 0, 0), 2);

        // when
        double surfaceArea = calculator.calculateSurfaceArea(ball);

        // then
        Assert.assertEquals(50.265482, surfaceArea, ACCURACY);
    }

    @Test
    public void testCalculateVolumeShouldCalculateVolumeWhenBallValid() {
        // given
        Ball ball = new Ball(new Point3D(0, 0, 0), 2);

        // when
        double volume = calculator.calculateVolume(ball);

        // then
        Assert.assertEquals(33.510321, volume, ACCURACY);
    }

    @Test
    public void  testCalculateSphericalSegmentVolumeShouldCalculateSphericalSegmentVolumeWhenBallValid() {
        // given
        Ball ball = new Ball(new Point3D(0, 0, 0), 6);
        double hight = 3;

        // when
        double sphericalSegmentVolume = calculator.calculateSphericalSegmentVolume(ball, hight);

        // then
        Assert.assertEquals(141.371669, sphericalSegmentVolume, ACCURACY);
    }

    @Test
    public void testCalculateVolumeRatioShouldCalculateVolumeRatioWhenBallValid() throws BallNotCrossPlaneException {
        // given
        Calculator calculator = new Calculator();
        Ball ball = new Ball(new Point3D(0, 0, 1), 2);

        // when
        double volumeRatio = calculator.calculateVolumeRatio(ball, Plane.OXY);

        // then
        Assert.assertEquals(0.185185, volumeRatio, ACCURACY);
    }

    @Test(expected = BallNotCrossPlaneException.class)
    public void testCalculateVolumeRatioShouldThrowEcxeptionWhenBallNotCrossPlane() throws BallNotCrossPlaneException {
        // when
        Ball ball = new Ball(new Point3D(3, 3, 3), 1);

        // then
        calculator.calculateVolumeRatio(ball, Plane.OXY);
    }

    @Test
    public void testIsTouchingPlaneShouldCheckTouchingPlane() {
        // given
        Ball ball = new Ball(new Point3D(2, 200, 200), 2);

        // when
        boolean isTouching = calculator.isTouchingPlane(ball);

        // then
        Assert.assertTrue(isTouching);
    }

    @Test
    public void testIsCrossingPlaneShouldCheckCrossingPlane() {
        // given
        Ball ball = new Ball(new Point3D(0, 0, 0), 1);

        // when
        boolean isCrossing = calculator.isCrossingPlane(ball, Plane.OXY);

        // then
        Assert.assertTrue(isCrossing);
    }
}
