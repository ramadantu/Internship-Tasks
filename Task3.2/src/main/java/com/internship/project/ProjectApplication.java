package com.internship.project;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class ProjectApplication {
    public static void main(String[] args) throws IOException {

        Queue<String> queue = new LinkedList<>();

        readingFile(queue);

        writingFile(queue);

    }

    private static void readingFile(Queue<String> queue) throws IOException{

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

    private static void writingFormat(String output, BufferedWriter writer) throws IOException{
        writer.write(output);
        writer.newLine();
    }

    private static void writingFile(Queue<String> queue) throws IOException{

        File outputFile = new File("Task3.1/src/main/resources/input.txt");
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

}