package racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(String input) {
        this.cars = createCars(input);
    }

    private List<Car> createCars(String input) {
        List<Car> racingCars = new ArrayList<>();
        Arrays.stream(input.split(","))
                .forEach(carName -> racingCars.add(new Car(carName)));
        return racingCars;
    }

    public List<Car> getCars() {
        return cars;
    }


}
