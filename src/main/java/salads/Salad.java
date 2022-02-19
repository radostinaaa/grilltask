package salads;

public abstract class Salad {
    private String type;

    public Salad(String type) {
        this.type = type;
    }

    public abstract double getPrice();
    public abstract int getCookingTime();

    public String getType() {
        return type;
    }
}
