package com.internship.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProjectApplication {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter number A:");
            String inputFirstNumber = reader.readLine();
            int firstNumber = Integer.parseInt(inputFirstNumber);

            System.out.println("Enter number B:");
            String inputSecondNumber = reader.readLine();
            int secondNumber = Integer.parseInt(inputSecondNumber);

            System.out.println("Choose one of the following operation: +, -, *, /");
            String operation = reader.readLine();

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
                    System.out.println(String.format("%d / %d = %.2f", firstNumber, secondNumber, ((double) firstNumber / (double)secondNumber)));
                    break;
                default:
                    System.out.println("Choose a valid operation!");
                    break;
            }

        } catch (NumberFormatException exception) {
            System.out.println("Enter a valid number");
        }

    }
}