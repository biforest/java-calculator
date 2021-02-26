package calculator;

public class SubOperation implements OperationInterface {
    @Override
    public int operationPriority() {
        return 1;
    }

    @Override
    public String operationName() {
        return "-";
    }

    @Override
    public int calculation(int beforeNumber, int afterNumber) {
        int Result = beforeNumber - afterNumber;
        return Result;
    }
}