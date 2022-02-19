import client.Client;
import cook.BreadCook;
import cook.MeatCook;
import cook.SaladCook;
import creatingFiles.OperatingFiles;
import shop.Cashier;
import shop.Shop;

public class Demo {
    public static void main(String[] args) {
        Shop shop = new Shop();

        MeatCook meatCook = new MeatCook(shop);
        BreadCook breadCook = new BreadCook(shop);
        SaladCook saladCook = new SaladCook(shop);

        Cashier cashier = new Cashier(shop);
        Client client = new Client(shop);
        Client client2 = new Client(shop);
        Client client3 = new Client(shop);
        Client client4 = new Client(shop);
        Client client5 = new Client(shop);
        Client client6 = new Client(shop);
        Client client7 = new Client(shop);

        meatCook.start();
        breadCook.start();
        saladCook.start();
        cashier.start();
        client.start();
        client2.start();
        client3.start();
        client4.start();
        client5.start();
        client6.start();
        Thread statistics = new Thread(() -> {
            while (true){
                try {
                    Thread.currentThread().sleep(20000);
                    OperatingFiles.readAndInsertToDB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        statistics.setDaemon(true);
        statistics.start();

    }
}
