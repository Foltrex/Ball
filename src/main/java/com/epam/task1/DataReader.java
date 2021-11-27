package com.epam.task1;

import com.epam.task1.exceptions.DataException;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class DataReader {

    public List<String> read(String path) throws IOException {
        File file = new File(path);

        if (!file.exists()) {
            throw new DataException("File not found", path);
        }

        if (file.length() == 0) {
            throw new DataException("File is empty", path);
        }

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<String> lines = new LinkedList<>();
        for (String line = null; (line = bufferedReader.readLine()) != null;) {
            lines.add(line);
        }

        bufferedReader.close();
        return lines;
    }
}
