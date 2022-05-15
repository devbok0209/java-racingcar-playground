package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("쉼표로 자동차 3개를 만드 개수 확인 테스트")
    void shouldMakeCarByComma() {
        Cars cars = new Cars("bobo,nono,coco");
        assertEquals(3, cars.getCars().size());
    }

}