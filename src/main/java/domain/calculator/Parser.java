package domain.calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Parser {

    private final Queue<String> tokenQueue;

    public Parser(String expression) {
        tokenQueue = new LinkedList<>();

        List<String> tokenList = splitExpressionToList(expression);
        tokenQueue.addAll(tokenList);
    }

    private List<String> splitExpressionToList(String expression) {
        String[] tokens = expression.split(" +");
        return filterMeaningfulToken(tokens);
    }

    private List<String> filterMeaningfulToken(String[] tokens) {
        return Arrays.stream(tokens)
                .filter(token -> !token.equals(""))
                .collect(Collectors.toList());
    }

    public String nextToken() {
        return tokenQueue.poll();
    }
    public boolean hasNext() {
        return !tokenQueue.isEmpty();
    }
}
