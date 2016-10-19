package Simulator;

import java.util.*;

/**
 * Created by rjaf on 18/10/2016.
 */
public class NoiseMonitor implements Observer{

    private Map<String,List<Float>> lastValues;

    public NoiseMonitor() {
        this.lastValues = new HashMap<>();
    }

    @Override
    public void update(Subject s) {
        NoiseXDK n = (NoiseXDK) s;
        if(!lastValues.containsKey(n.getName())){
            lastValues.put(n.getName(),new ArrayList<Float>());
        }
        lastValues.get(n.getName()).add(n.getState());

        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        int min = rightNow.get(Calendar.MINUTE);

        System.out.print(n.getName() + ": (" + hour + ":" + min +") " );
        for(int i = lastValues.get(n.getName()).size()-1 ;i>0; i--){
            System.out.print(lastValues.get(n.getName()).get(i) + "dB,");
        }
        System.out.print(lastValues.get(n.getName()).get(0) + "dB\n");
    }
}
