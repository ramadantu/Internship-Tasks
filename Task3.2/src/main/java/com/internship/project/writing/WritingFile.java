package com.internship.project.writing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;

public class WritingFile {
    public void writingFile(Queue<String> queue) throws IOException {

        File outputFile = new File("Task3.2/src/main/resources/input.txt");
        FileWriter fileWriter = new FileWriter(outputFile);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        try {
            while (queue.peek() != null) {

                String operator = queue.remove();
                int firstOperand = Integer.parseInt(queue.remove());
                int secondOperand = Integer.parseInt(queue.remove());

                new Calculator().writing(firstOperand, secondOperand, operator, writer);

            }
        } catch (NumberFormatException exception) {
            writer.write("Choose a valid operand in this line!");
        } finally {
            writer.close();
            fileWriter.close();
        }
    }
}