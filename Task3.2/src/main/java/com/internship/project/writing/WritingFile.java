package com.internship.project.writing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;

public class WritingFile {
    public static void writingFile(Queue<String> queue) throws IOException {

        File outputFile = new File("Task3.2/src/main/resources/input.txt");
        FileWriter fileWriter = new FileWriter(outputFile);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        try {
            while (queue.peek() != null) {

                String operation = queue.remove();
                int firstOperand = Integer.parseInt(queue.remove());
                int secondOperand = Integer.parseInt(queue.remove());

                switch (operation) {
                    case "+" -> writingFormat(String.format("%d %s %d = %d", firstOperand, "+", secondOperand, firstOperand + secondOperand), writer);
                    case "-" -> writingFormat(String.format("%d %s %d = %d", firstOperand, "-", secondOperand, firstOperand - secondOperand), writer);
                    case "*" -> writingFormat(String.format("%d %s %d = %d", firstOperand, "*", secondOperand, firstOperand * secondOperand), writer);
                    case "/" -> writingFormat(String.format("%d %s %d = %f", firstOperand, "/", secondOperand, ((double) firstOperand / (double) secondOperand)), writer);
                    default -> writingFormat("Choose a valid operation for this line!", writer);
                }
            }
        } catch (NumberFormatException exception) {
            writingFormat("Choose a valid operand in this line!", writer);
        } finally {
            writer.close();
            fileWriter.close();
        }
    }

    private static void writingFormat(String output, BufferedWriter writer) throws IOException{
        writer.write(output);
        writer.newLine();
    }
}