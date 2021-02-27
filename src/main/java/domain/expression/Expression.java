
package domain.expression;

import domain.expression.operator.Operator;

public class Expression {

    private int left;
    private int right;
    private Operator operator;

    private Expression(int left, int right, Operator operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public static Expression of(int left, int right, String operator) {
        return new Expression(left, right, Operator.from(operator));
    }
    public static Expression of(Expression left, int right, String operator) {
        int leftResult = left.evaluate();
        return new Expression(leftResult, right, Operator.from(operator));
    }
    public static Expression from(int left) {
        return of(left, 0, "+");
    }

    public int evaluate() {
        return operator.operate(left, right);
    }
}