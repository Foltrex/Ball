package com.epam.ball.tests;

import com.epam.ball.data.DataReader;
import com.epam.ball.exceptions.DataException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    // given
    private final DataReader dataReader = new DataReader();

    private static final String VALID_PATH = "src/test/resources/input.txt";
    private static final String INVALID_PATH = "invalid_path";

    @Test
    public void testReadShouldReadDataWhenPathValid() throws DataException {
        // when
        List<String> readLines = dataReader.read(VALID_PATH);

        // then
        List<String> expectedLines = Arrays.asList("1.9 234.32 4.5 1.2", "flj", "sod");
        Assert.assertEquals(expectedLines, readLines);
    }

    @Test (expected = DataException.class)
    public void testReadShouldThrowExpeptionWhenPathInvalid() throws DataException {
        // when
        List<String> readLines = dataReader.read(INVALID_PATH);
    }
}
