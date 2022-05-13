import calculator.StringAddCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator;

    public static Stream<Arguments> customStringInputAndNumbers() {
        return Stream.of(
                Arguments.of("//;" + "\\n" + "1;2;3", Arrays.asList(1, 2, 3), 6),
                Arguments.of("//?" + "\\n" + "1?2?3", Arrays.asList(1, 2, 3), 6),
                Arguments.of("//!" + "\\n" + "1!2!3", Arrays.asList(1, 2, 3), 6),
                Arguments.of("//@" + "\\n" + "1@2@3", Arrays.asList(1, 2, 3), 6)
        );
    }

    public static Stream<Arguments> stringInputAndNumbersOutput() {
        return Stream.of(
                Arguments.of("1,2", Arrays.asList(1, 2), 3),
                Arguments.of("1,2,3", Arrays.asList(1, 2, 3), 6),
                Arguments.of("1:3", Arrays.asList(1, 3), 4),
                Arguments.of("1:2:4", Arrays.asList(1, 2, 4), 7)
        );
    }

    public static Stream<Arguments> InputNumbersForSum() {
        return Stream.of(
                Arguments.of(Arrays.asList(-1, 3, 4)),
                Arguments.of(Arrays.asList(2, -4, 5)),
                Arguments.of(Arrays.asList(2, 4, -5)),
                Arguments.of(Arrays.asList(-2, -4, 5)),
                Arguments.of(Arrays.asList(-2, 4, -5)),
                Arguments.of(Arrays.asList(2, -4, -5)),
                Arguments.of(Arrays.asList(-2, -4, -5))
        );
    }

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
    }

    @ParameterizedTest
    @MethodSource("stringInputAndNumbersOutput")
    @DisplayName("쉼표 또는 콜론이 있으면 숫자 배열로 쪼갠후 합을 구한다.")
    void stringSplitToNumbers(String input, List<Integer> numbers, int expectedValue) {
        int addedValue = stringAddCalculator.splitToAddNumber(input);
        assertEquals(expectedValue, addedValue);
    }

    @Test
    @DisplayName("null 또는 빈 문자가 오면 0을 반환한다.")
    void nullAndEmptyReturnZero() {
        assertEquals(0, stringAddCalculator.splitToAddNumber(null));
        assertEquals(0, stringAddCalculator.splitToAddNumber(""));
    }

    @ParameterizedTest
    @DisplayName("//{}\n 사이에 있는 특정 값은 커스텀 구분자로 사용된다.")
    @MethodSource("customStringInputAndNumbers")
    void customDividerTest(String input, List<Integer> numbers, int expectedValue) {
        assertEquals(expectedValue, stringAddCalculator.splitToAddNumber(input));
    }

    @Test
    @DisplayName("Matcher find() 테스트")
    void matcherFindTest() {
        String text = "//;\n1;2;3";
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        assertTrue(matcher.find());
    }

    @Test
    @DisplayName("Matcher group() 테스트")
    void matcherGroupTest() {
        String text = "//;\n1;2;3";
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (matcher.find()) {
            assertEquals(";", matcher.group(1));
            assertEquals("1;2;3", matcher.group(2));
        }
    }

    @ParameterizedTest
    @DisplayName("음수를 전달할 경우 IllegalArgumentException 발생")
    @MethodSource("InputNumbersForSum")
    void negativeShouldThrowException(List<Integer> input) {
        assertThrows(IllegalArgumentException.class, () -> stringAddCalculator.inputNumbersSum(input));
    }

}