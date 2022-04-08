package com.internship.project;

import com.internship.project.calculating.Calculator;
import com.internship.project.reading.ReadingFile;
import com.internship.project.writing.WritingFile;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class ProjectApplication {
    public static void main(String[] args) throws IOException {

        Queue<String> queue = new LinkedList<>();
        new ReadingFile().readingFile(queue);

        WritingFile writing = new WritingFile();
        Calculator calculator = new Calculator();

        while (queue.peek() != null) {

            String operator = queue.remove();
            int firstOperand = Integer.parseInt(queue.remove());
            int secondOperand = Integer.parseInt(queue.remove());
            String result = calculator.apply(firstOperand, secondOperand, operator);

            writing.writingFile(firstOperand + " " + operator + " " + secondOperand + " = " + result + "\n");

        }

    }
}