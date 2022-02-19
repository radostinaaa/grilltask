package saladBow;

import salads.CabbageAndCarrots;
import salads.Salad;

import java.util.concurrent.ConcurrentHashMap;

public class CabbageAndCarrotsBow extends SaladBow {
    private ConcurrentHashMap<String,Integer> salads;

    public CabbageAndCarrotsBow() {
        this.salads = new ConcurrentHashMap<>();
        if(!salads.containsKey("Cabbage and Carrots")){
            salads.put("Cabbage and Carrots",0);
        }
    }

    @Override
    public String getStoredSaladType() {
        return "Cabbage and Carrots";
    }

    @Override
    public void addSalad(Salad salad) {
        if (salad.getType().equals("Cabbage and Carrots")){
            salads.put("Cabbage and Carrots",salads.get("Cabbage and Carrots")+1);
        }
    }

    @Override
    public String getBowName() {
        return "Cabbage and Carrots";
    }

    @Override
    public void removeSalad(Salad salad) {
        this.salads.put("Cabbage and Carrots",salads.get(salad.getType())-1);

    }

    @Override
    public boolean isFull() {
        boolean result = false;
        if(this.salads.size() == QUANTITY_GAP){
            result = true;
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        boolean result = false;
        if(salads.get("Cabbage and Carrots") == 0){
            result = true;
        }
        return  result;
    }
}
