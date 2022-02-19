package salads;

public class TomatoesAndCucumber extends Salad{
    public TomatoesAndCucumber() {
        super("tomatoes and cucumber");
    }

    @Override
    public double getPrice() {
        return 1.3;
    }

    @Override
    public int getCookingTime() {
        return 3;
    }
}
