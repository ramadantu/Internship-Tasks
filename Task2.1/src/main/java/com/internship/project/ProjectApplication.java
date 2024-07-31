package com.internship.project;

import java.io.*;

public class ProjectApplication {
    public static void main(String[] args) throws IOException{

        InputStream input = ProjectApplication.class.getResourceAsStream("/input.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

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
                        System.out.println(firstNumber + " + " + secondNumber + " = " + (firstNumber + secondNumber));
                        break;
                    case "-":
                        System.out.println(firstNumber + " - " + secondNumber + " = " + (firstNumber - secondNumber));
                        break;
                    case "*":
                        System.out.println(firstNumber + " * " + secondNumber + " = " + (firstNumber * secondNumber));
                        break;
                    case "/":
                        System.out.printf("%d / %d = %.2f%n", firstNumber, secondNumber, ((double) firstNumber / (double) secondNumber));
                        break;
                    default:
                        System.out.println("Choose a valid operation for this line!");
                        break;
                }

            }

        } catch (NumberFormatException exception) {
            System.out.println("Enter a valid number on this line!");
        }

    }
}
