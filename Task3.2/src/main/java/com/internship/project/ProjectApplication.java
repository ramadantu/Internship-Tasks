package com.internship.project;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

import static com.internship.project.reading.ReadingFile.readingFile;
import static com.internship.project.writing.WritingFile.writingFile;

public class ProjectApplication {
    public static void main(String[] args) throws IOException {

        Queue<String> queue = new LinkedList<>();

        readingFile(queue);

        writingFile(queue);

    }
}