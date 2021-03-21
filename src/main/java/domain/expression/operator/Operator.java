package domain.expression.operator;

import java.util.Map;

public abstract class Operator {

    private static final Map<String, Operator> lookup =
            Map.of("+", new Addition(), "-", new Subtraction(),
                    "*", new Multiplication(), "/", new Division());

    public static Operator from(String operator) {
        if (lookup.containsKey(operator)) {
            return lookup.get(operator);
        }

        throw new UnsupportedOperationException("지원하지 않는 연산자입니다.");
    }

    public abstract int operate(int left, int right);
}
