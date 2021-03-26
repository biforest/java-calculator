package calculator;

import java.util.Scanner;


public class Calculator {
    private Message message = new Message();

    /**
     * calculation method
     * 1. getEquation - Receives numeric expression in string format entered by user
     * 2. Put numeric expressions on the stack
     * 3. Passing the stack to the operatorSetting method
     *
     * return type : void
     */
    public void calculation(){
        String[] equation_list = getEquation();
        ArithmeticExpressionStack arithmeticExpressionStack = new ArithmeticExpressionStack(equation_list, equation_list.length);
        OperatorSetting(arithmeticExpressionStack);

    }

    /**
     * OperatorSetting method
     * 1. Pop each operator and number onto the stack.
     * 2. Perform error exception check and calculate
     * 3. After the calculation process is complete, call init() to determine whether to return the calculator
     *
     * return type : void
     */
    public void OperatorSetting(ArithmeticExpressionStack arithmeticExpressionStack) {
        ErrorException exceptionCheck = new ErrorException();
        String firstString = arithmeticExpressionStack.pop();
        // Error checking when converting string to int
        int cumulativeResult = exceptionCheck.NumericalError(firstString);

        for(int i = 0; i<(arithmeticExpressionStack.getStackSize())/2;i++){
            String operator = arithmeticExpressionStack.pop();
            String secondString = arithmeticExpressionStack.pop();
            int secondNumber = exceptionCheck.NumericalError(secondString);

            // calculated value are continuously accumulated
            cumulativeResult = chooseOperatorAndCalculate(cumulativeResult, operator, secondNumber);
        }

        if(cumulativeResult != 0){
            message.calculationResult(cumulativeResult);
        }

        // Whether to re-execute after calculation
        init();
    }

    /**
     * chooseOperatorAndCalculate method
     * 1. Pop each operator and number onto the stack.
     * 2. Perform error exception check and calculate
     * 3. After the calculation process is complete, call init() to determine whether to return the calculator
     *
     * return type : int
     */
    public int chooseOperatorAndCalculate(int firstNumber, String operator, int SecondNumber){
        AddOperation addOperation = new AddOperation();
        SubOperation subOperation = new SubOperation();
        MultiplyOperation multiplyOperation = new MultiplyOperation();
        DivideOperation divideOperation = new DivideOperation();
        int result = 0;

        // When the operator is equal to "+"
        if (operator.equals(addOperation.operationName())){
            result = addOperation.calculation(firstNumber, SecondNumber);
        }

        // When the operator is equal to "-"
        else if (operator.equals(subOperation.operationName())){
            result = subOperation.calculation(firstNumber, SecondNumber);
        }

        // When the operator is equal to "*"
        else if (operator.equals(multiplyOperation.operationName())){
            result = multiplyOperation.calculation(firstNumber, SecondNumber);
        }

        // When the operator is equal to "/"
        else if (operator.equals(divideOperation.operationName())){
            result = divideOperation.calculation(firstNumber, SecondNumber);
        }

        // Raise error when a symbol that does not correspond to the arithmetic operations(+, -, *, /) comes
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                e.getMessage();
                message.exceptionResult("NOT_OPERATOR");
            }
        }

        return result;
    }

    /**
     * init method
     * - Input "1" to redo calculator.
     * - Input another key to exit
     *
     * return type : void
     */
    public void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("계산을 계속 진행하시려면 1, 멈추시려면 임의의 다른키를 눌러주세요");
        String value = scanner.nextLine();

        if(value.equals("1")){
            calculation();
        }
        else{
            System.exit(0);
        }
    }

    /**
     * getEquation method
     * - Method to receive user input data
     *
     * return type : void
     */
    String[] getEquation() {
        String value = inputValues();
        String[] values = value.split(" ");
        return values;
    }

    private String inputValues() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("수식을 입력해주세요 : ");
        String value = scanner.nextLine();
        return value;
    }


}
