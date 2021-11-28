package com.epam.ball;

import com.epam.ball.tests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BallCreatorTest.class,
        BallValidatorTest.class,
        CalculatorTest.class,
        DataReaderTest.class,
        DirectorTest.class

})
public class BallTestSuite {

}
