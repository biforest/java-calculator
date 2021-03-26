package calculator;

public class MultiplyOperation implements OperationInterface {
    @Override
    public String operationName() {
        return "*";
    }

    @Override
    public int calculation(int beforeNumber, int afterNumber) {
        int Result = beforeNumber * afterNumber;
        return Result;
    }
}
