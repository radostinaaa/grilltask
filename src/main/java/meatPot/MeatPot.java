package meatPot;


import meat.Meat;

public abstract class MeatPot {
    protected static final int QUANTITY_GAP = 20;

    public abstract String getStoredMeatType();
    public abstract void addMeat(Meat meat);
    public abstract String getMeatPotName();
    public abstract void removeMeat(Meat meat);
    public abstract boolean isFull();
    public abstract boolean isEmpty();
}
