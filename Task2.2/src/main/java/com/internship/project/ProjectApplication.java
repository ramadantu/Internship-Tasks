package com.internship.project;

import java.io.*;

public class ProjectApplication {
    public static void main(String[] args) throws IOException{

        InputStream input = ProjectApplication.class.getResourceAsStream("/input.txt");

        File outputFile = new File("Task2.2/src/main/resources/output.txt");
        FileWriter fileWriter = new FileWriter(outputFile);

        assert input != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        BufferedWriter writer = new BufferedWriter(fileWriter);

        String[] arrayOfElementsPerLine;
        int firstNumber;
        int secondNumber;
        String operation;

        try {

            while (true) {

                String currentLine = reader.readLine();

                if (currentLine == null)
                    break;

                arrayOfElementsPerLine = currentLine.split(" ");

                firstNumber = Integer.parseInt(arrayOfElementsPerLine[0]);
                secondNumber = Integer.parseInt(arrayOfElementsPerLine[1]);
                operation = arrayOfElementsPerLine[2];

                switch (operation) {
                    case "+" -> writing(String.format("%d %s %d = %d", firstNumber, "+", secondNumber, firstNumber + secondNumber), writer);
                    case "-" -> writing(String.format("%d %s %d = %d", firstNumber, "-", secondNumber, firstNumber - secondNumber), writer);
                    case "*" -> writing(String.format("%d %s %d = %d", firstNumber, "*", secondNumber, firstNumber * secondNumber), writer);
                    case "/" -> writing(String.format("%d %s %d = %f", firstNumber, "/", secondNumber, ((double)firstNumber / (double)secondNumber)), writer);
                    default -> writing("Choose a valid operation for this line!", writer);
                }

            }

        } catch (NumberFormatException exception) {
            writing("Enter a valid number on this line!", writer);
        } finally {
            reader.close();
            writer.close();
            input.close();
            fileWriter.close();
        }

    }

    private static void writing(String output, BufferedWriter writer) throws IOException{
        writer.write(output);
        writer.newLine();
    }
}