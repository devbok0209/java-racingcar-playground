package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private final int ZERO = 0;
    private final String DEFAULT_REGEX = "[,|:]";
    private final String CUSTOM_REGEX = "//(.)" + "\\\\n" + "(.*)";

    public int splitToAddNumber(String input) {
        if (validInput(input)) return ZERO;
        return inputNumbersSum(createNumbers(input));
    }
    public int inputNumbersSum(List<Integer> numbers) {
        isIncludeNegativeThrowException(numbers);
        return numbers.stream().mapToInt(number -> number).sum();
    }

    private void isIncludeNegativeThrowException(List<Integer> numbers) {
        if (!isAllPositive(numbers)) {
            throw new IllegalArgumentException("반드시 양수를 입력해주세요.");
        }
    }

    private boolean isAllPositive(List<Integer> numbers) {
        return numbers.stream().allMatch(word -> word > 0);
    }

    private List<Integer> createNumbers(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_REGEX).matcher(input);
        if (matcher.find()) {
            return extractNumbersUsingCutsomRegex(matcher);
        }
        return extractNumbers(input, DEFAULT_REGEX);
    }

    private List<Integer> extractNumbersUsingCutsomRegex(Matcher matcher) {
        String customRegex = getCustomRegex(matcher);
        String customInput = matcher.group(2);
        return extractNumbers(customInput, customRegex);
    }

    private List<Integer> extractNumbers(String customInput, String customRegex) {
        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(customInput.split(customRegex))
                .forEach(word -> numbers.add(Integer.parseInt(word)));
        return numbers;
    }

    private String getCustomRegex(Matcher matcher) {
        String customRegex = matcher.group(1);
        List<String> metaCharacters = Arrays.asList("?", "*", "+", "^", "$");

        if (metaCharacters.contains(customRegex)) {
            customRegex = "\\" + customRegex;
        }
        return customRegex;
    }

    private boolean validInput(String input) {
        return input == null || input.isEmpty();
    }
}
