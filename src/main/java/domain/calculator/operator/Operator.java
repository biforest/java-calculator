package domain.calculator.operator;

public abstract class Operator {

    public static Operator from(String operator) {
        if (operator.equals("+")) {
            return new Addition();
        } else if (operator.equals("-")) {
            return new Subtraction();
        }
        return new Multiplication();
    }

    public abstract int operate(int left, int right);
}
