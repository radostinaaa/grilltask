package cook;

import salads.*;
import shop.Shop;

import java.util.Random;

public class SaladCook extends Thread{
    private Shop shop;

    public SaladCook(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        while (true){
            try {
                Salad salad = this.getRandomSalad();
                while (this.shop.isSaladTypeFull(salad)){
                    salad = this.getRandomSalad();
                }
                this.shop.makeSalad(salad);
                sleep(salad.getCookingTime()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Salad getRandomSalad(){
        Salad salad = null;
        int number = new Random().nextInt(6)+1;
        switch (number){
            case 1:
                salad = new CabbageAndCarrots();
                break;
            case 2:
                salad = new Lyutenitsa();
                break;
            case 3:
                salad = new Russian();
                break;
            case 4:
                salad = new Snejanka();
                break;
            case 5:
                salad = new TomatoesAndCucumber();
                break;
        }
        return salad;
    }
}

