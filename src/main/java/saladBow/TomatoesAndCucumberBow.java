package saladBow;

import salads.Salad;

import java.util.concurrent.ConcurrentHashMap;

public class TomatoesAndCucumberBow extends SaladBow{
    private ConcurrentHashMap<String,Integer> salads;

    public TomatoesAndCucumberBow() {
        this.salads = new ConcurrentHashMap<>();
        if(!salads.containsKey("tomatoes and cucumber")){
            salads.put("tomatoes and cucumber",0);
        }
    }

    @Override
    public String getStoredSaladType() {
        return "tomatoes and cucumber";
    }

    @Override
    public void addSalad(Salad salad) {
        if (salad.getType().equals("tomatoes and cucumber")){
            salads.put("tomatoes and cucumber",salads.get("tomatoes and cucumber")+1);
        }
    }

    @Override
    public String getBowName() {
        return "tomatoes and cucumber bow";
    }

    @Override
    public void removeSalad(Salad salad) {
        this.salads.put("tomatoes and cucumber",salads.get(salad.getType())-1);

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
        if(salads.get("tomatoes and cucumber") == 0){
            result = true;
        }
        return  result;
    }
}
