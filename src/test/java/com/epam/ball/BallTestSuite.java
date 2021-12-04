package com.epam.ball;

import com.epam.ball.logic.BallValidator;
import com.epam.ball.tests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BallCreatorTest.class,
        BallLineValidatorTest.class,
        BallValidatorTest.class,
        CalculatorTest.class,
        DataReaderTest.class,
        DirectorTest.class,
        BallStoreTest.class,
        BallIdentifiableTest.class

})
public class BallTestSuite {

}
