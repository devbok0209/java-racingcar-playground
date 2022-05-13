package calculator;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
       StringAddCalculator stringAddCalculator = new StringAddCalculator();
       Scanner scanner = new Scanner(System.in);
       System.out.print("구분자를 가진 문자열을 입력해주세요 : ");
       System.out.println(stringAddCalculator.splitToAddNumber(scanner.nextLine()));
    }
}
