package domain.calculator;

public class Calculator {

    public int calculate(String strExpression) {
        String[] tokens = strExpression.split(" ");

        int left = Integer.parseInt(tokens[0]);
        Expression expression = Expression.from(left);

        for (int i = 1; i < tokens.length; i+=2) {
            String operator = tokens[i];
            int right = Integer.parseInt(tokens[i+1]);
            expression = Expression.of(expression, right, operator);
        }

        return expression.evaluate();
    }
}
