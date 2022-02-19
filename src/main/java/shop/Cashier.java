package shop;

public class Cashier extends Thread{

    private Shop shop;

    public Cashier(Shop shop){
        this.shop = shop;
    }

    @Override
    public void run() {
        while(true){
            this.shop.takeOrder();
        }
    }
}
