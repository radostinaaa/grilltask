package meat;

public abstract class Meat {

    private String type;

    public Meat (String type){
        this.type = type;
    }

    public abstract double getPrice();
    public abstract int getCookingTime();

    public String getType() {
        return type;
    }
}
