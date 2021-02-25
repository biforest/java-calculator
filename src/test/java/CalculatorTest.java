import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class CalculatorTest {
    double num1 = 3;
    double num2 = 2;

    Calculator calculator = new Calculator();

    @Test
    void addTest() {
        String operator = "+";
        double result;
        result = calculator.calculate(num1, operator, num2);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void subtractTest() {
        String operator = "-";
        double result;
        result = Calculator.calculate(num1, operator, num2);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void multiplyTest() {
        String operator = "*";
        double result;
        result = calculator.calculate(num1, operator, num2);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void divideTest() {
        String operator = "/";
        double result;
        result = calculator.calculate(num1, operator, num2);
        assertThat(result).isEqualTo(1.5);
    }
}
