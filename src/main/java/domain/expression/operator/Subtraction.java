package domain.expression.operator;

public class Subtraction extends Operator {

    public int operate(int left, int right) {
        return left - right;
    }
}