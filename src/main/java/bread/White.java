package bread;

public class White extends Bread{
    public White() {
        super("white");
    }


    @Override
    public double getPrice() {
        return 0.9;
    }

    @Override
    public int getCookingTime() {
        return 2;
    }
}
