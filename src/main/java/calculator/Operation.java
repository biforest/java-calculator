package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operation {
    private final String[] operation;
    private final Stream<String> stream;
    private List<Integer> operands;
    private List<Character> operators;

    public Operation(String operation) {
        this.operation = operation.split(" ");
        stream = Arrays.stream(this.operation);
        validateOperation();
        // splitOperation();
    }

    public void validateOperation() {
        validateFirstIndex();
        // validateMixedSymbols();
        // validateOtherSymbols();
        validateDuplicate();
    }

    public void validateFirstIndex() {
        if (!(operation[0].matches("^[0-9]*$") || operation[0].matches("^\\-[1-9]\\d*$"))) {
            throw new IllegalArgumentException("숫자로 시작해야 합니다.");
        }
    }

    // 숫자와 문자가 섞였을 경우
    // 숫자가 음수일 경우에는 또 빼주기
    public void validateMixedSymbols() {
        stream
            .filter(operation -> operation.matches("~~~~~"))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(""));
    }

    // 숫자와 연산자 이외의 문자
    public void validateOtherSymbols() {
        //
    }

    public void validateDuplicate() {
        for (int i = 0; i < operation.length - 1; i++) {
            if ((operation[i].matches("^[0-9]*$") && operation[i + 1].matches("^[0-9]*$"))
                || (operation[i].matches("[+*/-]") && operation[i + 1].matches("[+*/-]"))) {
                throw new IllegalArgumentException("기호나 숫자가 두 번 연속 입력되면 안 됩니다.");
            }
        }
    }

    public void splitOperation() {
        operands = stream
            .filter(operand -> operand.matches("^[0-9]*$"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        operators = stream
            .filter(operator -> operator.matches("[+*/-]"))
            .map(operator -> operator.charAt(0))
            .collect(Collectors.toList());
    }

    public List<Integer> getOperands() {
        return operands;
    }

    public List<Character> getOperators() {
        return operators;
    }
}
