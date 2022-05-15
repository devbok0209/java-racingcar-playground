package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("현재 전진 길이를 보여주는 테스트")
    void show() {
        Position position = new Position(3);
        assertEquals("---", position.show());
    }

}