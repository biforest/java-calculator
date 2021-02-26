package calculator;

public class DivideOperation implements OperationInterface {
    @Override
    public int operationPriority() {
        return 1;
    }

    @Override
    public String operationName() {
        return "/";
    }

    @Override
    public int calculation(int beforeNumber, int afterNumber) {
        Message message = new Message();
        try{
            int Result = beforeNumber / afterNumber;
            return Result;
        }
        catch (ArithmeticException e){
            message.exceptionResult("INVALID_DIVIDE");
        }
        return 0;
    }
}
