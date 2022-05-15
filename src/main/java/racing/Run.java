package racing;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println("시도할 회수는 몇회인가요?");
        int times = scanner.nextInt();

        System.out.println("실행 결과");
        Cars cars = new Cars(input);
        cars.startRacing(times);
        cars.showWinners();
    }
}
