package breadBasket;

import bread.Bread;

public abstract class BreadBasket {

    protected static final int QUANTITY_GAP = 30;

    public abstract String getStoredBreadType();
    public abstract void addBread(Bread bread);
    public abstract String getBasketName();
    public abstract void removeBread(Bread bread);
    public abstract boolean isFull();
    public abstract boolean isEmpty();


}
