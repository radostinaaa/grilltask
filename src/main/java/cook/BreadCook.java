package cook;

import bread.Bread;
import bread.White;
import bread.Whole;
import shop.Shop;

import java.util.Random;

public class BreadCook extends Thread{
    private Shop shop;

    public BreadCook(Shop shop){
        this.shop = shop;
    }

    @Override
    public void run() {
        while(true){
            try{
                Bread b = this.getRandomBread();
                while (this.shop.isBreadTypeFull(b)){
                    b = this.getRandomBread();
                } this.shop.bakeBread(b);
                sleep(b.getCookingTime()*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public Bread getRandomBread(){
        Bread bread = null;
        if(new Random().nextBoolean()){
            bread = new White();
        }else{
            bread = new Whole();
        }
        return bread;
    }
}
