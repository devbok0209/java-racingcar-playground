package racing;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public Position move() {
        return new Position(this.position + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position1 = (Position) o;

        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return position;
    }

    public String show() {
        String progress = "";
        for (int i = 0; i < this.position ; i++) {
            progress += "-";
        }
        return progress;
    }
}
