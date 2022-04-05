package com.internship.project.writing;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class WritingFile {
    public void writingFile(Queue<String> queue) throws IOException {

        File outputFile = new File("Task4/src/main/resources/input.txt");
        FileWriter fileWriter = new FileWriter(outputFile);

        try (fileWriter; BufferedWriter writer = new BufferedWriter(fileWriter)) {
            Queue<Integer> operands = new LinkedList<>();
            Queue<String> operators = new LinkedList<>();
            String[] fileFormat = queue.toArray(new String[0]);

            int firstOperand;
            int secondOperand;
            int value;

            while (queue.peek() != null) {

                String token = queue.remove();
                if (!token.equals("?") && !token.equals("=")) {
                    switch (token) {
                        case "*" -> {
                            firstOperand = operands.remove();
                            secondOperand = Integer.parseInt(queue.remove());
                            value = firstOperand * secondOperand;
                            operands.add(value);
                        }
                        case "/" -> {
                            firstOperand = operands.remove();
                            secondOperand = Integer.parseInt(queue.remove());
                            value = firstOperand / secondOperand;
                            operands.add(value);
                        }
                        case "+", "-" -> operators.add(token);
                        default -> operands.add(Integer.parseInt(token));
                    }
                } else if (token.equals("=")) {
                    while (operators.peek() != null) {
                        switch (operators.remove()) {
                            case "+" -> {
                                firstOperand = operands.remove();
                                secondOperand = operands.remove();
                                value = firstOperand + secondOperand;
                                operands.add(value);
                            }
                            case "-" -> {
                                firstOperand = operands.remove();
                                secondOperand = operands.remove();
                                value = firstOperand - secondOperand;
                                operands.add(value);
                            }
                            default -> throw new IllegalStateException("Unexpected value: " + operators.remove());
                        }
                    }
                } else {
                    for (int i = 0; i < fileFormat.length; i++) {
                        if (fileFormat[i].equals("?")) {
                            fileFormat[i] = operands.remove().toString();
                            break;
                        }
                    }
                }
            }

            for (int i = 1; i < fileFormat.length + 1; i++) {
                if (i % 7 == 0) {
                    writer.write(fileFormat[i - 1] + "\n");
                } else {
                    writer.write(fileFormat[i - 1] + " ");
                }
            }

        }

    }
}