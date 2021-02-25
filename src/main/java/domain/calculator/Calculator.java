package domain.calculator;

public class Calculator {

    public int calculate(String expression) {
        String[] splitedExpression = expression.split("\\+|-|\\*|/");
        int left = Integer.parseInt(splitedExpression[0]);
        int right = Integer.parseInt(splitedExpression[1]);

        if (expression.contains("-")) {
            return left - right;
        } else if (expression.contains("*")) {
            return left * right;
        }

        return left + right;
    }
}
