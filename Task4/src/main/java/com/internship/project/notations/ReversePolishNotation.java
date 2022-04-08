package com.internship.project.notations;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReversePolishNotation {
    public Queue<String> apply(Queue<String> inputQueue) {
        Queue<String> reversePolishNotationQueue = change(inputQueue);
        return calculate(reversePolishNotationQueue);
    }

    private Queue<String> change(Queue<String> inputQueue) {
        Queue<String> reversePolishNotationQueue = new LinkedList<>();
        Stack<String> operators = new Stack<>();

        while (inputQueue.peek() != null) {
            String token = inputQueue.remove();
            if ("*/+-".contains(token)) {
                if ("*/".contains(operators.peek()) && "+-".contains(token)) {
                    while (operators.peek() != null) {
                        reversePolishNotationQueue.add(operators.pop());
                    }
                    operators.push(token);
                } else {
                    operators.push(token);
                }
            } else if (token.equals("=")) {
                reversePolishNotationQueue.add(operators.pop());
                reversePolishNotationQueue.add(token);
            } else {
                reversePolishNotationQueue.add(token);
            }
        }

        return reversePolishNotationQueue;
    }

    private Queue<String> calculate(Queue<String> reversePolishNotationQueue) {
        Queue<String> outputQueue = new LinkedList<>();
        //to do
        return outputQueue;
    }
}
