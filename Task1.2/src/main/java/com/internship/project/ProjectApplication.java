package com.internship.project;

import java.io.Console;

public class ProjectApplication {
    public static void main(String[] args) {

        Console console = System.console();

        System.out.println("Enter number A:");
        String inputFirstNumber = console.readLine();
        int firstNumber = Integer.parseInt(inputFirstNumber);

        System.out.println("Enter number B:");
        String inputSecondNumber = console.readLine();
        int secondNumber = Integer.parseInt(inputSecondNumber);

        System.out.println("Choose one of the following operation: +, -, *, /");
        String operation = console.readLine();

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
                System.out.println("Choose a valid operation!");
                break;
        }

    }
}