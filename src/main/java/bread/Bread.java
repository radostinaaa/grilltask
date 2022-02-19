package bread;

public abstract class Bread {

    private String type;

    public Bread(String type){
        this.type = type;
    }

    public abstract double getPrice();
    public abstract int getCookingTime();

    public String getType() {
        return type;
    }
}
