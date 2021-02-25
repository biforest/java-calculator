package domain.calculator;

public class Calculator {

    public int calculate(String strExpression) {
        String[] tokens = strExpression.split(" ");

        int left = Integer.parseInt(tokens[0]);
        String operator = tokens[1];
        int right = Integer.parseInt(tokens[2]);
        Expression leftResult = Expression.of(left, right, operator);

        String operator2 = tokens[3];
        int right2 = Integer.parseInt(tokens[4]);
        Expression expression = Expression.of(leftResult, right2, operator2);

        return expression.evaluate();
    }
}
