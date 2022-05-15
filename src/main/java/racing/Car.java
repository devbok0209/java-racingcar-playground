package racing;

import java.util.Arrays;
import java.util.List;

public class Car {

    public static final int MAX = 5;
    public static final int SIGNAL_TO_ADVANCE = 4;
    private String carNames;
    private String carName;
    private int place;

    public Car(String carNames) {
        this.carNames = carNames;
        if (!isValidateInput()) {
            throw new IllegalArgumentException("정확한 정보를 입력해주세요");
        }
    }

    public Car(String carName, int place) {
        this.carName = carName;
        this.place = place;
    }

    public String getCarName() {
        return carName;
    }

    public boolean isValidateInput() {
        return isTreeCarForRacing() && isNameOverFiveLength();
    }

    public boolean isTreeCarForRacing() {
        return carNames.split(",").length == 3;
    }

    public boolean isNameOverFiveLength() {
        return Arrays.stream(carNames.split(","))
                .allMatch(this::isNotOverFiveLength);
    }

    private boolean isNotOverFiveLength(String carName) {
        return carName.length() <= MAX;
    }

    public boolean isReadyForRace(List<Car> racingCars) {
        return this.carName != null && this.place == 0 && racingCars.size() == 3;
    }

    public boolean isAdvance(int random) {
        if (random >= SIGNAL_TO_ADVANCE) {
            return true;
        }
        return false;
    }

    public void advanceCar() {
        place += 1;
    }


    public int nowPlace() {
        return place;
    }

    public String makeProcess() {
        String progress = "";
        for (int i = 0; i < nowPlace() ; i++) {
            progress += "-";
        }
        return progress;
    }
}
