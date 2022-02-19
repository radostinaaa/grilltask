package salads;

public class CabbageAndCarrots extends Salad{
    public CabbageAndCarrots() {
        super("Cabbage and Carrots");
    }

    @Override
    public double getPrice() {
        return 0.8;
    }

    @Override
    public int getCookingTime() {
        return 2;
    }
}
