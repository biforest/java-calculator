package domain.expression.operator;

import java.util.Map;
import java.util.function.BinaryOperator;

public enum OperatorEnum {
    ADDITION("+", (x, y) -> x + y),
    SUBTRACTION("-", (x, y) -> x - y),
    MULTIPLICATION("*", (x, y) -> x * y),
    DIVISION("/", (x, y) -> x / y);

    private static final Map<String, OperatorEnum> lookup
            = Map.of(ADDITION.operator, ADDITION, SUBTRACTION.operator, SUBTRACTION,
            MULTIPLICATION.operator, MULTIPLICATION, DIVISION.operator, DIVISION);

    private final String operator;
    private final BinaryOperator<Integer> calculate;

    OperatorEnum(String operator, BinaryOperator<Integer> calculate) {
        this.operator = operator;
        this.calculate = calculate;
    }

    public int operate(int x, int y) {
        return calculate.apply(x, y);
    }
}
