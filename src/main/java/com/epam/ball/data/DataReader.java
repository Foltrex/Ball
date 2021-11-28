package com.epam.ball.data;

import com.epam.ball.exceptions.DataException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class DataReader {
    private static final Logger logger = Logger.getLogger(DataReader.class.getName());

    public List<String> read(String path) throws DataException {
        logger.debug("Argument path: " + path);

        List<String> lines = new LinkedList<>();

        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {


            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                lines.add(line);
            }
        } catch (FileNotFoundException ex) {
            logger.log(Level.WARN, "File wasn't found", ex);
            throw new DataException("The file in the specified path wasn't found", ex, path);
        } catch (IOException ex) {
            logger.log(Level.WARN, "Some problems with reading file", ex);
            throw new DataException("Problems reading the file at the specified path",ex, path);
        }

        logger.info("List of read lines: " + lines);
        return lines;
    }
}
