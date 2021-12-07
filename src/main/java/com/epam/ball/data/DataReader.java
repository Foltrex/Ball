package com.epam.ball.data;

import com.epam.ball.exceptions.DataException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class DataReader {
    private static final Logger LOGGER = Logger.getLogger(DataReader.class);

    public List<String> read(String path) throws DataException {
        LOGGER.debug("Argument path: " + path);

        List<String> lines = new LinkedList<>();

        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {


            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                lines.add(line);
            }
        } catch (IOException ex) {
            throw new DataException(ex.getMessage(), ex);
        }

        LOGGER.info("List of read lines: " + lines);
        return lines;
    }
}
