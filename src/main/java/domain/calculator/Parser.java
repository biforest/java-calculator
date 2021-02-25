package domain.calculator;

import domain.calculator.exception.InvalidInputException;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {

    private final Queue<String> tokenQueue;

    public Parser(String expression) {
        tokenQueue = new LinkedList<>();

        List<String> tokenList = splitExpressionToList(expression);
        validateTokenList(tokenList);
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

    private void validateTokenList(List<String> tokenList) {
        long invalidTokenCount = tokenList.stream()
                .filter(token -> !isNumber(token) && !isOperator(token))
                .count();

        if (invalidTokenCount > 0) {
            throw new InvalidInputException("올바르지 않은 입력입니다.");
        }
    }

    private boolean isNumber(String token) {
        return Pattern.matches("^[0-9]+$", token);
    }
    private boolean isOperator(String token) {
        return Pattern.matches("\\+|-|\\*|/", token);
    }

    public String nextToken() {
        return tokenQueue.poll();
    }
    public boolean hasNext() {
        return !tokenQueue.isEmpty();
    }
}
