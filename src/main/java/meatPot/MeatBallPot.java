package meatPot;

import meat.Meat;

import java.util.concurrent.ConcurrentHashMap;

public class MeatBallPot extends MeatPot {
    private ConcurrentHashMap<String,Integer> meats;

    public MeatBallPot() {
        this.meats = new ConcurrentHashMap<>();
        if(!meats.containsKey("meatball")){
            meats.put("meatball",0);
        }
    }


    @Override
    public String getStoredMeatType() {
        return "meatball";
    }

    @Override
    public void addMeat(Meat meat) {
        if (meat.getType().equals("meatball")){
            meats.put("meatball",meats.get("meatball")+1);
        }
    }

    @Override
    public String getMeatPotName() {
        return "meatball pot";
    }

    @Override
    public void removeMeat(Meat meat) {
        this.meats.put("meatball",meats.get(meat.getType())-1);
    }

    @Override
    public boolean isFull() {
        boolean result = false;
        if(this.meats.size() == QUANTITY_GAP){
            result = true;
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        boolean result = false;
        if(meats.get("meatball") == 0){
            result = true;
        }
        return  result;
    }
}
