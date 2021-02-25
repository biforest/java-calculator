package domain.expression.operator.exception;

public class DivideByZeroException extends RuntimeException {

    private String message;

    public DivideByZeroException(String message) {
        this.message = message;
    }
}
