package saladBow;

import salads.Salad;

import java.util.concurrent.ConcurrentHashMap;

public class SnejankaBow extends SaladBow {
    private ConcurrentHashMap<String,Integer> salads;

    public SnejankaBow() {
        this.salads = new ConcurrentHashMap<>();
        if(!salads.containsKey("snejanka")){
            salads.put("snejanka",0);
        }
    }

    @Override
    public String getStoredSaladType() {
        return "snejanka";
    }

    @Override
    public void addSalad(Salad salad) {
        if (salad.getType().equals("snejanka")){
            salads.put("snejanka",salads.get("snejanka")+1);
        }
    }

    @Override
    public String getBowName() {
        return "snejanka bow";
    }

    @Override
    public void removeSalad(Salad salad) {
        this.salads.put("snejanka",salads.get(salad.getType())-1);

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
        if(salads.get("snejanka") == 0){
            result = true;
        }
        return  result;
    }
}
