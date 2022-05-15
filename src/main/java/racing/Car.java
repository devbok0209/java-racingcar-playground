package racing;


public class Car {

    public static final int SIGNAL_ADVANCE = 4;
    private Position position;
    private Name name;

    public Car(String carName) {
        this.name = new Name(carName);
    }

    public Position getPosition() {
        return position;
    }

    public Car(String carName, int position) {
        this.name = new Name(carName);
        this.position = new Position(position);
    }

    public void advance(int input) {
        if (input >= SIGNAL_ADVANCE) {
            this.position = position.move();
        }
    }
}
