package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7})
    @DisplayName("랜덤 값이 4 이상일때만 전진하는 테스트")
    void shouldAdvanceTest(int input) {
        Car car = new Car("nanan", 0);
        car.advance(input);
        assertEquals(new Position(1), car.getPosition());
    }

    @Test
    @DisplayName("랜덤 값이 4 미만일때 전진 안하는 테스트")
    void shouldNotAdvanceTest() {
        Car car = new Car("nanan", 0);
        car.advance(3);
        assertEquals(new Position(0), car.getPosition());
    }

}