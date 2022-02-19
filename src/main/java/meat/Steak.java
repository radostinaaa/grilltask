package meat;

public class Steak extends Meat{
    public Steak() {
        super("steak");
    }

    @Override
    public double getPrice() {
        return 3;
    }

    @Override
    public int getCookingTime() {
        return 4;
    }
}
