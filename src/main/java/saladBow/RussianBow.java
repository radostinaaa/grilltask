package saladBow;



import salads.Salad;

import java.util.concurrent.ConcurrentHashMap;

public class RussianBow extends SaladBow{
    private ConcurrentHashMap<String,Integer> salads;

    public RussianBow() {
        this.salads = new ConcurrentHashMap<>();
        if(!salads.containsKey("russian")){
            salads.put("russian",0);
        }
    }

    @Override
    public String getStoredSaladType() {
        return "russian";
    }

    @Override
    public void addSalad(Salad salad) {
        if (salad.getType().equals("russian")){
            salads.put("russian",salads.get("russian")+1);
        }
    }

    @Override
    public String getBowName() {
        return "russian bow";
    }

    @Override
    public void removeSalad(Salad salad) {
        this.salads.put("russian",salads.get(salad.getType())-1);

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
        if(salads.get("russian") == 0){
            result = true;
        }
        return  result;
    }
}
