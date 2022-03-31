package com.internship.project.writing;

import java.io.BufferedWriter;
import java.io.IOException;

public class Calculator {

    public enum Operation {
        ADDITION {
            @Override
            public String calculate(int firstOperand, int secondOperand) {
                return firstOperand + " + " + secondOperand + " = " + (firstOperand + secondOperand) + "\n";
            }
        },
        SUBTRACTION {
            @Override
            public String calculate(int firstOperand, int secondOperand) {
                return firstOperand + " - " + secondOperand + " = " + (firstOperand - secondOperand) + "\n";
            }
        },
        MULTIPLICATION {
            @Override
            public String calculate(int firstOperand, int secondOperand) {
                return firstOperand + " * " + secondOperand + " = " + (firstOperand * secondOperand) + "\n";
            }
        },
        DIVISION {
            @Override
            public String calculate(int firstOperand, int secondOperand) {
                return firstOperand + " / " + secondOperand + " = " + ((double) firstOperand / (double) secondOperand) + "\n";
            }
        };

        public String calculate(int firstOperand, int secondOperand) {
            return "";
        }
    }

    public void writing(int firstOperand, int secondOperand, String operator, BufferedWriter writer) throws IOException {

        switch (operator) {
            case "+" -> writer.write(Operation.ADDITION.calculate(firstOperand, secondOperand));
            case "-" -> writer.write(Operation.SUBTRACTION.calculate(firstOperand, secondOperand));
            case "*" -> writer.write(Operation.MULTIPLICATION.calculate(firstOperand, secondOperand));
            case "/" -> writer.write(Operation.DIVISION.calculate(firstOperand, secondOperand));
            default -> writer.write("Choose a valid operator! \n");
        }

    }
}
