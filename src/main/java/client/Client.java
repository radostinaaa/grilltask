package client;

import bread.Bread;
import bread.White;
import bread.Whole;
import meat.Meat;
import meat.MeatBall;
import meat.Pleaskavica;
import meat.Steak;
import salads.*;
import shop.Shop;

import java.util.Random;

public class Client extends Thread{

    private String name;
    private static int id = 1;
    private Shop shop;
    private Meat meat;
    private Bread bread;
    private Salad salad;


    public Client (Shop shop){
        this.name = "Client" + id++;
        this.shop = shop;
        this.meat = getRandomMeat();
        this.bread = getRandomBread();
        this.salad = getRandomSalad();
    }


    @Override
    public void run() {
        this.shop.goToShop(this);
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

    public Bread getRandomBread(){
        Bread bread = null;
        if(new Random().nextBoolean()){
            bread = new White();
        }else{
            bread = new Whole();
        }
        return bread;
    }

    public Meat getMeat() {
        return meat;
    }

    public Bread getBread() {
        return bread;
    }

    public Salad getSalad() {
        return salad;
    }

    public String getClientName() {
        return this.name;
    }
}

