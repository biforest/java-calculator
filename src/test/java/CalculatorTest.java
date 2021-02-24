import domain.calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void 더하기_테스트() {
        int test1Result = calculator.calculate("1+1");
        assertThat(test1Result).isEqualTo(2);

        int test2Result = calculator.calculate("3+7");
        assertThat(test2Result).isEqualTo(10);

        int test3Result = calculator.calculate("10+234");
        assertThat(test3Result).isEqualTo(244);
    }

    @Test
    void 빼기_테스트() {
        int test1Result = calculator.calculate("1-1");
        assertThat(test1Result).isEqualTo(0);

        int test2Result = calculator.calculate("998-234");
        assertThat(test2Result).isEqualTo(764);

        int test3Result = calculator.calculate("10003-234");
        assertThat(test3Result).isEqualTo(9769);
    }
}
