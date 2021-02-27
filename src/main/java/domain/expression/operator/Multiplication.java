package domain.expression.operator;

public class Multiplication extends Operator {

    public int operate(int left, int right) {
        return left * right;
    }
}