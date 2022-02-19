package bread;

public class Whole extends Bread{

    public Whole() {
        super("whole");
    }

    @Override
    public double getPrice() {
        return 1.4;
    }

    @Override
    public int getCookingTime() {
        return 5;
    }
}
