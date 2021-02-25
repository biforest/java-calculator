package domain.calculator;

public class Calculator {

    public int calculate(String strExpression) {
        String[] tokens = strExpression.split(" ");

        int left = Integer.parseInt(tokens[0]);
        String operator = tokens[1];
        int right = Integer.parseInt(tokens[2]);

        Expression expression = Expression.of(left, right, operator);
        return expression.evaluate();
    }
}
