package com.internship.project.writing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WritingFile {
    public void writingFile(String line) throws IOException {

        File outputFile = new File("Task3.2/src/main/resources/input.txt");
        FileWriter fileWriter = new FileWriter(outputFile);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        try {
            writer.write(line);
        } catch (NumberFormatException exception) {
            writer.write("Choose a valid operand in this line!");
        } finally {
            writer.close();
            fileWriter.close();
        }
    }
}