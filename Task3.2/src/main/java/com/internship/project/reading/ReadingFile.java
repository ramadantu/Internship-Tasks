package com.internship.project.reading;

import com.internship.project.ProjectApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Queue;

public class ReadingFile {
    public static void readingFile(Queue<String> queue) throws IOException {

        InputStream input = ProjectApplication.class.getResourceAsStream("/input.txt");
        assert input != null;
        InputStreamReader inputStreamReader = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        try {
            while (true) {
                String currentLine = reader.readLine();

                if (currentLine == null)
                    break;

                String[] arrayOfElementsPerLine;

                arrayOfElementsPerLine = currentLine.split(" ");

                queue.add(arrayOfElementsPerLine[1]);
                queue.add(arrayOfElementsPerLine[0]);
                queue.add(arrayOfElementsPerLine[2]);
            }

        } catch (Exception exception) {
            System.out.println("Problem in reading! Check your input format!");
        } finally {
            reader.close();
            inputStreamReader.close();
            input.close();
        }
    }
}
