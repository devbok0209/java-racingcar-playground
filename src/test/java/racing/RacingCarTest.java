package racing;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @ParameterizedTest
    @DisplayName("자동차 이름, 쉼표로 구분해서 3가지 자동차가 나오는 테스트")
    @ValueSource(strings = {"baba,gogo,coco","soso,nono,koko", "nono,anan,kiki"})
    void  shouldSplitByComma(String input) {
        Car car = new Car(input);
        assertTrue(car.isTreeCarForRacing());
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 5자 넘지 않으면 true 테스트")
    @ValueSource(strings = {"baba,gogo,coco","soso,nono,koko", "nono,anan,kiki"})
    void carNameSmallerThenFiveTest(String input) {
        Car car = new Car(input);
        assertTrue(car.isNameOverFiveLength());
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 5자 넘으면 False 테스트")
    @ValueSource(strings = {"baba11,gogo,coco","soso,nono11,koko", "nono,anan,kiki111",
            "chocho1,shshsh23, nono", "nanaan1, shsho, bmbobi123",
    "chcon:shshsh123:hfififh12", "gagaagag12,gororcn1212, adfasdf3434"})
    void carNameBiggerThenFiveTest(String input) {
        assertThatThrownBy(() -> new Car(input)).isInstanceOf(IllegalArgumentException.class).hasMessage("정확한 정보를 입력해주세요");
    }

    @ParameterizedTest
    @DisplayName("3개의 자동차의 위치정보와 이름을 갖는 자동차 리스트를 반환하는 테스트")
    @ValueSource(strings = {"baba,gogo,coco","soso1,non11,koko", "nono,anan,kiki"})
    void getCarsTest(String input) {
        Cars cars = new Cars(input);
        assertTrue(cars.isReadyCarState());
    }

    @ParameterizedTest
    @DisplayName("랜덤 값이 4 이상일때 전진하는 테스트")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void shouldAdvanceTest(int random) {
        Car car = new Car("bobo", 0);
        if (car.isAdvance(random)) {
            car.advanceCar();
        }
        assertEquals(1, car.nowPlace());
    }

    @ParameterizedTest
    @DisplayName("랜덤 값이 4 이상일때 전진하는 테스트")
    @ValueSource(ints = {0, 1, 2, 3})
    void shouldNotAdvanceTest(int random) {
        Car car = new Car("bobo", 0);
        assertFalse(car.isAdvance(random));
        assertEquals(0, car.nowPlace());
    }

    @ParameterizedTest
    @DisplayName("N번 시도 후 우승자는 1명 이상이어야하는 테스트")
    @ValueSource(ints = {5, 6, 7, 8})
    void shouldHaveWinnerMoreThenOneExist(int times) {
        Cars cars = new Cars("baba,gogo,coco");
        cars.startRacing(times);
        assertTrue(cars.winnerExist());
    }
}
