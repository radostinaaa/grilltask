package salads;

public class Snejanka extends Salad{
    public Snejanka() {
        super("snejanka");
    }

    @Override
    public double getPrice() {
        return 1.2;
    }

    @Override
    public int getCookingTime() {
        return 4;
    }
}
