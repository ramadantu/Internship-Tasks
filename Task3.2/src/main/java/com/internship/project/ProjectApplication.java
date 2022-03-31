package com.internship.project;

import com.internship.project.reading.ReadingFile;
import com.internship.project.writing.WritingFile;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class ProjectApplication {
    public static void main(String[] args) throws IOException {

        Queue<String> queue = new LinkedList<>();

        new ReadingFile().readingFile(queue);

        new WritingFile().writingFile(queue);

    }
}