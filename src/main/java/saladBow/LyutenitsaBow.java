package saladBow;

import salads.Lyutenitsa;
import salads.Salad;

import java.util.concurrent.ConcurrentHashMap;

public class LyutenitsaBow extends SaladBow{
    private ConcurrentHashMap<String,Integer> salads;

    public LyutenitsaBow() {
        this.salads = new ConcurrentHashMap<>();
        if(!salads.containsKey("lyutenitsa")){
            salads.put("lyutenitsa",0);
        }
    }

    @Override
    public String getStoredSaladType() {
        return "lyutenitsa";
    }

    @Override
    public void addSalad(Salad salad) {
        if (salad.getType().equals("lyutenitsa")){
            salads.put("lyutenitsa",salads.get("lyutenitsa")+1);
        }
    }

    @Override
    public String getBowName() {
        return "lyutenitsa bow";
    }

    @Override
    public void removeSalad(Salad salad) {
        this.salads.put("lyutenitsa",salads.get(salad.getType())-1);

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
        if(salads.get("lyutenitsa") == 0){
            result = true;
        }
        return  result;
    }
}
