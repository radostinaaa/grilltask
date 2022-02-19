package salads;

public class Russian extends Salad{
    public Russian() {
        super("russian");
    }

    @Override
    public double getPrice() {
        return 1.5;
    }

    @Override
    public int getCookingTime() {
        return 10;
    }
}
