package com.internship.project.writing;

import java.io.*;
import java.util.Queue;

public class WritingFile {
    public void writingFile(Queue<String> outputQueue, Queue<String> results) throws IOException {

        File outputFile = new File("Task5.1/src/main/resources/input.txt");
        FileWriter fileWriter = new FileWriter(outputFile);

        try (fileWriter; BufferedWriter writer = new BufferedWriter(fileWriter)) {
            while (outputQueue.peek() != null) {
                if (outputQueue.peek().equals("=")) {
                    writer.write(outputQueue.remove() + " " + results.remove() + "\n");
                } else {
                    writer.write(outputQueue.remove() + " ");
                }
            }
        }

    }
}