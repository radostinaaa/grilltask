package shop;

import bread.Bread;
import breadBasket.BreadBasket;
import breadBasket.WhiteBreadBasket;
import breadBasket.WholeBreadBasket;
import client.Client;
import creatingFiles.CreatingFiles;
import meat.Meat;
import meatPot.MeatBallPot;
import meatPot.MeatPot;
import meatPot.PleaskavicaPot;
import meatPot.SteakPot;
import saladBow.*;
import salads.Salad;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;

public class Shop {

    private CopyOnWriteArrayList <MeatPot> meatPots;
    private CopyOnWriteArrayList <BreadBasket> breadBaskets;
    private CopyOnWriteArrayList <SaladBow> saladBows;
    private double fund;
    private Queue<Client> clients;


    public Shop() {
        this.meatPots = new CopyOnWriteArrayList<>();
        meatPots.add(new MeatBallPot());
        meatPots.add(new PleaskavicaPot());
        meatPots.add(new SteakPot());
        this.breadBaskets= new CopyOnWriteArrayList<>();
        breadBaskets.add(new WhiteBreadBasket());
        breadBaskets.add(new WholeBreadBasket());
        this.saladBows = new CopyOnWriteArrayList<>();
        saladBows.add(new CabbageAndCarrotsBow());
        saladBows.add(new LyutenitsaBow());
        saladBows.add(new RussianBow());
        saladBows.add(new SnejankaBow());
        saladBows.add(new TomatoesAndCucumberBow());
        this.clients = new LinkedList<>();
    }

    public void cookMeat(Meat m){
        synchronized (meatPots){
            for (MeatPot meatPot:
                 meatPots) {
                if ( meatPot.getStoredMeatType().equals(m.getType())){
                    meatPot.addMeat(m);
                }

            }
            meatPots.notifyAll();
        }
    }
    public void bakeBread(Bread b){
        synchronized (breadBaskets){
            for (BreadBasket breadBasket:
                   breadBaskets) {
                if ( breadBasket.getStoredBreadType().equals(b.getType())){
                    breadBasket.addBread(b);
                }

            }
            breadBaskets.notifyAll();
        }
    }
    public void makeSalad(Salad s){
        synchronized (saladBows){
            for (SaladBow saladBow:
                   saladBows) {
                if ( saladBow.getStoredSaladType().equals(s.getType())){
                    saladBow.addSalad(s);
                }

            }
            saladBows.notifyAll();
        }
    }
    public synchronized void takeOrder(){
        while (this.clients.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Client client = this.clients.poll();
        Bread bread = client.getBread();
        Meat meat = client.getMeat();
        Salad salad= client.getSalad();
        synchronized (breadBaskets) {
            while (breadIsNotReady(bread)){
                try {
                    breadBaskets.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.sellBread(bread);
            breadBaskets.notifyAll();
        }
        synchronized (meatPots) {
            while (meatIsNotReady(meat)){
                try {
                    meatPots.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.sellMeat(meat);
            meatPots.notifyAll();
        }
        synchronized (saladBows) {
            while (saladIsNotReady(salad)){
                try {
                    saladBows.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.sellSalad(salad);
            saladBows.notifyAll();
        }
        this.fund+=bread.getPrice();
        this.fund+=salad.getPrice();
        this.fund+=meat.getPrice();
        double price = bread.getPrice() + salad.getPrice()  + meat.getPrice();
        System.out.println(client.getClientName()+" got "+bread.getType()+"bread, "+meat.getType()+" and "+salad.getType());
        String order = bread.getType()+", "+meat.getType()+", "+salad.getType();
        CreatingFiles.addOrderFile(order,price, LocalDateTime.now());
        notifyAll();
    }


    public boolean isSaladTypeFull(Salad salad){
        boolean result = false;
        for (SaladBow garnishBow : saladBows) {
            if(garnishBow.getStoredSaladType().equals(salad.getType())) {
                if (garnishBow.isFull()) {
                    result = true;
                }
            }
        }
        return  result;
    }

    public boolean isMeatTypeFull(Meat meat){
        boolean result = false;
        for (MeatPot meatPot : meatPots) {
            if(meatPot.getStoredMeatType().equals(meat.getType())){
                if (meatPot.isFull()){
                    result = true;
                }
            }
        }

        return result;
    }

    public boolean isBreadTypeFull(Bread bread){
        boolean result = false;
        for (BreadBasket breadBasket : breadBaskets) {
            if (breadBasket.getStoredBreadType().equals(bread.getType())){
                if (breadBasket.isFull()){
                    result = true;
                }
            }
        }
        return result;
    }


    public boolean breadIsNotReady(Bread bread){
        boolean result = false;
        for (BreadBasket breadBasket : breadBaskets) {
            if(breadBasket.getStoredBreadType().equals(bread.getType())){
                if(breadBasket.isEmpty()){
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean meatIsNotReady(Meat meat){
        boolean result = false;
        for (MeatPot meatPot : meatPots) {
            if(meatPot.getStoredMeatType().equals(meat.getType())){
                if (meatPot.isEmpty()){
                    return true;
                }
            }
        }
        return result;
    }

    private boolean saladIsNotReady(Salad salad){
        boolean result = false;
        for (SaladBow saladBow : saladBows) {
            if (saladBow.getStoredSaladType().equals(salad.getType())){
                if (saladBow.isEmpty()){
                    return true;
                }
            }
        }
        return result;
    }

    private void sellBread(Bread bread){
        for (BreadBasket breadBasket : breadBaskets) {
            if(breadBasket.getStoredBreadType().equals(bread.getType())){
                if(!breadBasket.isEmpty()){
                    breadBasket.removeBread(bread);
                }
            }
        }
    }

    private void sellMeat(Meat meat){
        for (MeatPot meatPot : meatPots) {
            if(meatPot.getStoredMeatType().equals(meat.getType())){
                if(!meatPot.isEmpty()){
                    meatPot.removeMeat(meat);
                }
            }
        }
    }

    public void sellSalad(Salad salad){
        for (SaladBow saladBow : saladBows) {
            if(saladBow.getStoredSaladType().equals(salad.getType())){
                if(saladBow.isEmpty()){
                    saladBow.removeSalad(salad);
                }
            }
        }
    }
    public synchronized void goToShop(Client c){
        this.clients.offer(c);
        System.out.println(c.getClientName()+" went to the grill shop");
        System.out.println(c.getClientName()+" ordered "+ c.getBread().getType()+
                "bread, "+ c.getMeat().getType()
                +", "+ c.getSalad().getType());
        notifyAll();
    }

    public double getFund() {
        return fund;
    }


}
