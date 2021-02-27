package domain.calculator;

import java.util.*;
import java.util.stream.Collectors;

public class Parser {

    private final Queue<String> tokenQueue;

    public Parser(String expression) {
        tokenQueue = new LinkedList<>();
        ExpressionValidator validator = new ExpressionValidator();

        List<String> tokenList = splitExpressionToList(expression);
        validator.validateTokenList(tokenList);
        validator.validateTokenSequence(tokenList);
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