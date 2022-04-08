package com.internship.project;

import com.internship.project.notations.ReversePolishNotation;
import com.internship.project.reading.ReadingFile;
import com.internship.project.writing.WritingFile;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


public class ProjectApplication {
    public static void main(String[] args) throws IOException {

        Queue<String> inputQueue = new LinkedList<>();
        new ReadingFile().readingFile(inputQueue);

        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
        Queue<String> outputQueue = reversePolishNotation.apply(inputQueue);

        new WritingFile().writingFile(outputQueue);

    }
}