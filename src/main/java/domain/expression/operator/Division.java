package domain.expression.operator;

import domain.expression.operator.exception.DivideByZeroException;

public class Division extends Operator {

    public int operate(int left, int right) {
        if (right == 0) {
            throw new DivideByZeroException("0으로 나눌 수 없습니다.");
        }
        return left / right;
    }
}