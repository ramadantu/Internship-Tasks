package com.internship.project;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.Objects;

public class ProjectApplication {
    public static void main(String[] args) throws IOException{

        InputStream input = ProjectApplication.class.getResourceAsStream("/input.txt");

        File outputFile = new File("src/main/resources/output.txt");
        FileWriter fileWriter = new FileWriter(outputFile);

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        BufferedWriter writer = new BufferedWriter(fileWriter);

        String[] arrayOfElementsPerLine = new String[3];
        String[][] arrayOfFileElements = new String[100][3];
        int firstNumber;
        int secondNumber;
        String operation;


        try {

            for (int i = 0;;i++) {

                String currentLine = reader.readLine();

                if (currentLine == null)
                    break;

                arrayOfElementsPerLine = currentLine.split(" ");

                arrayOfFileElements[i][0] = arrayOfElementsPerLine[0];
                arrayOfFileElements[i][1] = arrayOfElementsPerLine[1];

                arrayOfFileElements[i][2] = arrayOfElementsPerLine[2];


                firstNumber = Integer.parseInt(arrayOfFileElements[i][0]);
                secondNumber = Integer.parseInt(arrayOfFileElements[i][1]);
                operation = arrayOfFileElements[i][2];


                switch (operation) {
                    case "+":
                        writer.write(firstNumber + " + " + secondNumber + " = " + (firstNumber + secondNumber));
                        writer.newLine();
                        break;
                    case "-":
                        writer.write(firstNumber + " - " + secondNumber + " = " + (firstNumber - secondNumber));
                        writer.newLine();
                        break;
                    case "*":
                        writer.write(firstNumber + " * " + secondNumber + " = " + (firstNumber * secondNumber));
                        writer.newLine();
                        break;
                    case "/":
                        writer.write(String.format("%d / %d = %.2f", firstNumber, secondNumber, ((double) firstNumber / (double) secondNumber)));
                        writer.newLine();
                        break;
                    default:
                        writer.write("Choose a valid operation for this line!");
                        writer.newLine();
                        break;
                }

            }

        } catch (NumberFormatException exception) {
            writer.write("Enter a valid number on this line!");
            writer.newLine();
        }

        writer.close();

    }
}