package meat;

public class MeatBall extends Meat{

    public MeatBall() {
        super("meatball");
    }

    @Override
    public double getPrice() {
        return 1;
    }

    @Override
    public int getCookingTime() {
        return 2;
    }
}
