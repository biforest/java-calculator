package calculator;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;
    int firstNumber;
    int secondNumber;
    String operator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        firstNumber = 2;
        secondNumber = 3;
    }

    @Test
    void addChooseOperatorAndCalculate(){
        operator = "+";
        int result = 0;
        result = calculator.chooseOperatorAndCalculate(firstNumber, operator, secondNumber);
        assertEquals(5, result);
        assertThat(5).isEqualTo(result);
    }

    @Test
    void subChooseOperatorAndCalculate(){
        operator = "-";
        int result = 0;
        result = calculator.chooseOperatorAndCalculate(firstNumber, operator, secondNumber);
        assertThat(-1).isEqualTo(result);
    }

    @Test
    void multiplyChooseOperatorAndCalculate(){
        operator = "*";
        int result = 0;
        result = calculator.chooseOperatorAndCalculate(firstNumber, operator, secondNumber);
        assertThat(6).isEqualTo(result);
    }

    @Test
    void divideChooseOperatorAndCalculate(){
        operator = "/";
        int result = 0;
        result = calculator.chooseOperatorAndCalculate(firstNumber, operator, secondNumber);
        assertThat(0).isEqualTo(result);
    }
}