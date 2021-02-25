package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperationTest {

    String input = "( 2/ + * -1 ? 3 4";
    private Operation operation;

    @BeforeEach
    void setUp() {
        operation = null;
    }

    @Test
    void validateFirstIndex() {
        String wrongInput = "( 2 + 1";

        assertThatThrownBy(() -> operation = new Operation(wrongInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("숫자로 시작해야 합니다.");
    }

    @Test
    void validateOperation() {
    }

    @Test
    void validateOtherSymbols() {
    }

    @Test
    void validateDuplicate() {
        String wrongInput = "2 * / 1 + 3";

        assertThatThrownBy(() -> operation = new Operation(wrongInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("기호나 숫자가 두 번 연속");
    }

    @Test
    void splitOperation() {
    }
}