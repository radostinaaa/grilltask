package meat;

public class Pleaskavica extends Meat{
    public Pleaskavica() {
        super("pleskavica");
    }

    @Override
    public double getPrice() {
        return 2;
    }

    @Override
    public int getCookingTime() {
        return 3;
    }
}
