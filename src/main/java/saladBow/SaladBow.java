package saladBow;


import salads.Salad;

public abstract class SaladBow {
    protected static final int QUANTITY_GAP = 10;

    public abstract String getStoredSaladType();
    public abstract void addSalad(Salad salad);
    public abstract String getBowName();
    public abstract void removeSalad(Salad salad);
    public abstract boolean isFull();
    public abstract boolean isEmpty();
}
