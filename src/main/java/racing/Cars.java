package racing;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Cars {

    public static final int FIRST_PLACE = 0;
    public static final int MAX = 10;
    private final List<Car> racingCars;
    private List<Car> winners;

    public Cars(String input) {
        racingCars = createRacingCars(input);
    }

    private List<Car> createRacingCars(String input) {
        List<Car> cars = new ArrayList<>();
        Arrays.stream(input.split(","))
                .forEach(carName -> cars.add(new Car(carName, FIRST_PLACE)));
        return cars;
    }

    public boolean isReadyCarState() {
        return this.racingCars.stream()
                .allMatch(car -> car.isReadyForRace(racingCars));
    }

    public boolean winnerExist() {
        List<Car> racingWinner = new ArrayList<>();
        int winnerPlace = racingCars.stream().mapToInt(Car::nowPlace).max().orElse(FIRST_PLACE);
        racingCars.forEach(car -> {
            if (car.nowPlace() >= winnerPlace) {
                racingWinner.add(car);
            }
        } );
        this.winners = racingWinner;
        return !winners.isEmpty();
    }

    public void startRacing(int times) {
        for (int i = 0; i < times ; i++) {
            carStartAdvance();
            showProcess();
            System.out.println();
        }
    }

    private void carStartAdvance() {
        racingCars.forEach(car -> {
            Random random = new SecureRandom();
            if (car.isAdvance(random.nextInt(MAX))) {
                car.advanceCar();
            }
        });
    }

    public void showProcess() {
        racingCars.forEach(car -> {
            String process = car.makeProcess();
            System.out.printf("%s : %s%n", car.getCarName(), process);
        });
    }

    public void showWinners() {
        winnerExist();
        String winner = "";
        for (int i = 0; i < winners.size() ; i++) {
            if (i != winners.size() -1) {
                winner += winners.get(i).getCarName() + ", ";
                return;
            }
            winner += winners.get(i).getCarName();
        }
        System.out.println(String.format("%s가 최종 우승했습니다.", winner));
    }
}
