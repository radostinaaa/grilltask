package meatPot;

import meat.Meat;

import java.util.concurrent.ConcurrentHashMap;

public class SteakPot extends MeatPot{
    private ConcurrentHashMap<String,Integer> meats;

    public SteakPot() {
        this.meats = new ConcurrentHashMap<>();
        if(!meats.containsKey("steak")){
            meats.put("steak",0);
        }
    }

    @Override
    public String getStoredMeatType() {
        return "steak";
    }

    @Override
    public void addMeat(Meat meat) {
        if (meat.getType().equals("steak")){
            meats.put("steak",meats.get("steak")+1);
        }
    }

    @Override
    public String getMeatPotName() {
        return "steak pot";
    }

    @Override
    public void removeMeat(Meat meat) {
        this.meats.put("steak",meats.get(meat.getType())-1);

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
        if(meats.get("steak") == 0){
            result = true;
        }
        return  result;
    }
}
