package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private final String operation;
    private final String[] values;
    private List<Integer> operands;
    private List<Character> operators;

    public Input(String operation) {
        this.operation = operation;
        values = operation.split(" ");
        verifyOperation();
        splitOperation();
    }

    public void verifyOperation() {
    }

    public void splitOperation() {
        operands = Arrays.stream(values)
            .filter(operand -> operand.matches("^[0-9]*$"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        operators = Arrays.stream(values)
            .filter(operator -> operator.matches("[+*/-]"))
            .map(operator -> operator.charAt(0))
            .collect(Collectors.toList());

        /*System.out.println("operand");
        for (int operand : operands) {
            System.out.println(operand);
        }

        System.out.println("operators");
        for (String operator : operators) {
            System.out.println(operator);
        }*/
    }

    public List<Integer> getOperands() {
        return operands;
    }

    public List<Character> getOperators() {
        return operators;
    }
}
