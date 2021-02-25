import domain.calculator.Calculator;
import domain.calculator.exception.InvalidInputException;
import domain.expression.operator.exception.DivideByZeroException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void 더하기_테스트() {
        int test1Result = calculator.calculate("1 + 1");
        assertThat(test1Result).isEqualTo(2);

        int test2Result = calculator.calculate("3 + 7");
        assertThat(test2Result).isEqualTo(10);

        int test3Result = calculator.calculate("10 + 234");
        assertThat(test3Result).isEqualTo(244);
    }

    @Test
    void 빼기_테스트() {
        int test1Result = calculator.calculate("1 - 1");
        assertThat(test1Result).isEqualTo(0);

        int test2Result = calculator.calculate("998 - 234");
        assertThat(test2Result).isEqualTo(764);

        int test3Result = calculator.calculate("10003 - 234");
        assertThat(test3Result).isEqualTo(9769);
    }

    @Test
    void 곱하기_테스트() {
        int test1Result = calculator.calculate("2 * 34");
        assertThat(test1Result).isEqualTo(68);

        int test2Result = calculator.calculate("60 * 61");
        assertThat(test2Result).isEqualTo(3660);

        int test3Result = calculator.calculate("430 * 289");
        assertThat(test3Result).isEqualTo(124270);
    }

    @Test
    void 나누기_테스트() {
        int test1Result = calculator.calculate("42 / 2");
        assertThat(test1Result).isEqualTo(21);

        int test2Result = calculator.calculate("60 / 5");
        assertThat(test2Result).isEqualTo(12);

        int test3Result = calculator.calculate("22 / 6");
        assertThat(test3Result).isEqualTo(3);
    }

    @Test
    void 나누기는_0으로_나눌때_DivideByZeroException_발생() {
        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(() -> calculator.calculate("2 / 0"))
                .as("0으로 나눌 수 없습니다.");
    }

    @Test
    void 두개의_연산자가_존재하는_식을_계산할_수_있다() {
        int test1Result = calculator.calculate("44 + 23 - 3");
        assertThat(test1Result).isEqualTo(64);

        int test2Result = calculator.calculate("4 / 2 - 10");
        assertThat(test2Result).isEqualTo(-8);

        int test3Result = calculator.calculate("54 * 20 / 3");
        assertThat(test3Result).isEqualTo(360);
    }

    @Test
    void 두개_이상의_연산자가_존재하는_식을_계산할_수_있다() {
        int test1Result = calculator.calculate("44 + 23 - 3 * 5");
        assertThat(test1Result).isEqualTo(320);

        int test2Result = calculator.calculate("4 / 2 - 10 * 10 / 4");
        assertThat(test2Result).isEqualTo(-20);

        int test3Result = calculator.calculate("54 * 20 / 3 / 120 + 2 - 5");
        assertThat(test3Result).isEqualTo(0);
    }

    @Test
    void 정상적이지_않은_공백_입력에_대해서도_올바른_답을_낼_수_있다() {
        int test1Result = calculator.calculate(" 21 + 2  ");
        assertThat(test1Result).isEqualTo(23);

        int test2Result = calculator.calculate("23                - 2 /   3");
        assertThat(test2Result).isEqualTo(7);
    }

    @Test
    void 정상적이지_않은_입력에_대해_InvalidInputException을_던진다() {
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> calculator.calculate("2 + // 3"));

        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> calculator.calculate("abc efij 2 + 3"));

        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> calculator.calculate("3 + 3 - 3 ###"));

        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> calculator.calculate("3 + 3 3 2 - 2"));
    }
}
