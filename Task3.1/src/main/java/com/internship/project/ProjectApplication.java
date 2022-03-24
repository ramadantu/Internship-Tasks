package com.internship.project;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class ProjectApplication {
    public static void main(String[] args) throws IOException {

        String[] arrayOfElementsPerLine;
        Queue<String> stack = new LinkedList<>();

        InputStream input = ProjectApplication.class.getResourceAsStream("/input.txt");
        assert input != null;
        InputStreamReader inputStreamReader = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        try {
            while (true) {
                String currentLine = reader.readLine();

                if (currentLine == null)
                    break;

                arrayOfElementsPerLine = currentLine.split(" ");

                stack.add(arrayOfElementsPerLine[1]);
                stack.add(arrayOfElementsPerLine[0]);
                stack.add(arrayOfElementsPerLine[2]);
            }

        } catch (Exception exception) {
            System.out.println("Problem in reading! Check your input format!");
        } finally {
            reader.close();
            inputStreamReader.close();
            input.close();
        }

        File outputFile = new File("Task3.1/src/main/resources/input.txt");
        FileWriter fileWriter = new FileWriter(outputFile);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        try {
            while (stack.peek() != null) {

                String operation = stack.remove();
                int firstOperand = Integer.parseInt(stack.remove());
                int secondOperand = Integer.parseInt(stack.remove());

                switch (operation) {
                    case "+" -> writing(String.format("%d %s %d = %d", firstOperand, "+", secondOperand, firstOperand + secondOperand), writer);
                    case "-" -> writing(String.format("%d %s %d = %d", firstOperand, "-", secondOperand, firstOperand - secondOperand), writer);
                    case "*" -> writing(String.format("%d %s %d = %d", firstOperand, "*", secondOperand, firstOperand * secondOperand), writer);
                    case "/" -> writing(String.format("%d %s %d = %f", firstOperand, "/", secondOperand, ((double) firstOperand / (double) secondOperand)), writer);
                    default -> writing("Choose a valid operation for this line!", writer);
                }
            }
        } catch (NumberFormatException exception) {
            writing("Choose a valid operand in this line!", writer);
        } finally {
            writer.close();
            fileWriter.close();
        }

    }

    private static void writing(String output, BufferedWriter writer) throws IOException{
        writer.write(output);
        writer.newLine();
    }

}