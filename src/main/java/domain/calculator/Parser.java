package domain.calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Parser {

    private final Queue<String> tokenQueue;

    public Parser(String expression) {
        tokenQueue = new LinkedList<>();

        String[] tokens = expression.split(" ");
        tokenQueue.addAll(Arrays.asList(tokens));
    }

    public String nextToken() {
        return tokenQueue.poll();
    }
    public boolean hasNext() {
        return !tokenQueue.isEmpty();
    }
}
