package com.epam.ball.data;

import com.epam.ball.exceptions.DataException;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class DataReader {

    public List<String> read(String path) throws DataException {

        List<String> lines = new LinkedList<>();

        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {


            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                lines.add(line);
            }
        } catch (FileNotFoundException ex) {
            throw new DataException("The file in the specified path was not found", ex, path);
        } catch (IOException ex) {
            throw new DataException("Problems reading the file at the specified path",ex, path);
        }

        return lines;
    }
}
