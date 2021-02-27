package domain.expression.operator;

public class Addition extends Operator {

    public int operate(int left, int right) {
        return left + right;
    }
}