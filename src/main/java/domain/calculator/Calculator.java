package domain.calculator;

public class Calculator {

    public int calculate(String expression) {
        String[] splitedExpression = expression.split("\\+");
        int left = Integer.parseInt(splitedExpression[0]);
        int right = Integer.parseInt(splitedExpression[1]);

        return left + right;
    }
}
