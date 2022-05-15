package racing;

public class Name {
    private static final int MAX = 5;
    private String name;

    public Name(String name) {
        if (name.length() > MAX) {
            throw new IllegalArgumentException("자동차 이름은 5름 초과할 수 없습니다.");
        }
        this.name = name;
    }
}
