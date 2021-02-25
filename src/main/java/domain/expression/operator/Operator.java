package domain.expression.operator;

public abstract class Operator {

    public static Operator from(String operator) {
        if (operator.equals("+")) {
            return new Addition();
        } else if (operator.equals("-")) {
            return new Subtraction();
        } else if (operator.equals("*")) {
            return new Multiplication();
        }
        return new Division();
    }

    public abstract int operate(int left, int right);
}
