package domain.calculator;

import domain.expression.Expression;

public class Calculator {

    public int calculate(String strExpression) {
        Parser parser = new Parser(strExpression);

        int left = Integer.parseInt(parser.nextToken());
        Expression expression = Expression.from(left);

        while (parser.hasNext()) {
            String operator = parser.nextToken();
            int right = Integer.parseInt(parser.nextToken());
            expression = Expression.of(expression, right, operator);
        }

        return expression.evaluate();
    }
}
