package cook;

import meat.Meat;
import meat.MeatBall;
import meat.Pleaskavica;
import meat.Steak;
import shop.Shop;

import java.util.Random;

public class MeatCook extends Thread {

    private Shop shop;

    public MeatCook(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        while (true){
            Meat meat = this.getRandomMeat();
            while (this.shop.isMeatTypeFull(meat)){
                meat = this.getRandomMeat();
            }
            this.shop.cookMeat(meat);
            try {
                sleep(meat.getCookingTime()*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Meat getRandomMeat(){
        Meat meat = null;
        int number = new Random().nextInt(4)+1;

        switch (number){
            case  1:
                meat = new Steak();
                break;
            case  2:
                meat = new Pleaskavica();
                break;
            case  3:
                meat = new MeatBall();
                break;
        }
        return meat;
    }
}
