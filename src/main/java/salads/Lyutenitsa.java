package salads;

public class Lyutenitsa extends Salad{
    public Lyutenitsa() {
        super("lyutenitsa");
    }

    @Override
    public double getPrice() {
        return 1.1;
    }

    @Override
    public int getCookingTime() {
        return 8;
    }
}
