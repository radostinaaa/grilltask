package meatPot;

import meat.Meat;

import java.util.concurrent.ConcurrentHashMap;

public class PleaskavicaPot extends MeatPot{

    private ConcurrentHashMap<String,Integer> meats;

    public PleaskavicaPot() {
        this.meats = new ConcurrentHashMap<>();
        if(!meats.containsKey("pleskavica")){
            meats.put("pleaskavica",0);
        }
    }

    @Override
    public String getStoredMeatType() {
        return "pleskavica";
    }

    @Override
    public void addMeat(Meat meat) {
        if (meat.getType().equals("pleskavica")){
        meats.put("pleskavica",meats.get("pleskavica")+1);
    }
    }

    @Override
    public String getMeatPotName() {
        return "pleskavica pot";
    }

    @Override
    public void removeMeat(Meat meat) {
        this.meats.put("pleskavica",meats.get(meat.getType())-1);

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
        if(meats.get("pleskavica") == 0){
            result = true;
        }
        return  result;
    }
}
