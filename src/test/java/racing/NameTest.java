package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {


    @ParameterizedTest
    @DisplayName("자동차 이름 길이가 5 이상이면 Exception을 밷는 테스트")
    @CsvSource(value = "{baba11:nonono:kiki111}", delimiter = ':')
    void shouldThrowExceptionWhenOverFiveLengthCarName(String carName) {
        assertThatThrownBy(() -> new Name(carName)).isInstanceOf(IllegalArgumentException.class);
    }
}