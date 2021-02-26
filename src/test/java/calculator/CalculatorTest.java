package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    void setUp() {
        Calculator calculator = new Calculator();
    }

    @Test
    void calculation() {
    }

    @Test
    void operatorSetting() {
    }

    @Test
    void addChooseOperatorAndCalculate(){
        Calculator calculator = new Calculator();
        int firstNumber = 2;
        String operator = "+";
        int secondNumber = 3;
        int result = 0;
        result = calculator.chooseOperatorAndCalculate(firstNumber, operator, secondNumber);
        assertEquals(5, result);
    }

    @Test
    void subChooseOperatorAndCalculate(){
        Calculator calculator = new Calculator();
        int firstNumber = 2;
        String operator = "-";
        int secondNumber = 3;
        int result = 0;
        result = calculator.chooseOperatorAndCalculate(firstNumber, operator, secondNumber);
        assertEquals(-1, result);
    }

    @Test
    void multiplyChooseOperatorAndCalculate(){
        Calculator calculator = new Calculator();
        int firstNumber = 2;
        String operator = "*";
        int secondNumber = 3;
        int result = 0;
        result = calculator.chooseOperatorAndCalculate(firstNumber, operator, secondNumber);
        assertEquals(6, result);
    }

    @Test
    void divideChooseOperatorAndCalculate(){
        Calculator calculator = new Calculator();
        int firstNumber = 9;
        String operator = "/";
        int secondNumber = 3;
        int result = 0;
        result = calculator.chooseOperatorAndCalculate(firstNumber, operator, secondNumber);
        assertEquals(3, result);
    }

    @Test
    void invalidCalculation(){
        // todo refactoring
        assertThrows(NumberFormatException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Calculator calculator = new Calculator();

                String[] equation_list = {"+", "1", "+"};
                ArithmeticExpressionStack arithmeticExpressionStack = new ArithmeticExpressionStack(equation_list, equation_list.length);

                calculator.OperatorSetting(arithmeticExpressionStack);
            }
        });
    }
}