package com.internship.project.reading;

import com.internship.project.ProjectApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Queue;

public class ReadingFile {
    public void readingFile(Queue<String> queue) throws IOException {

        try (InputStream input = ProjectApplication.class.getResourceAsStream("/input.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(input)))) {

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {

                String[] arrayOfElementsPerLine;

                arrayOfElementsPerLine = currentLine.split(" ");

                queue.add(arrayOfElementsPerLine[1]);
                queue.add(arrayOfElementsPerLine[0]);
                queue.add(arrayOfElementsPerLine[2]);

            }

        }
    }
}
