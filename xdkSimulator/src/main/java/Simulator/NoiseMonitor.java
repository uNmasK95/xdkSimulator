package Simulator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by rjaf on 18/10/2016.
 */
public class NoiseMonitor implements Observer{

    private List<Float> lastValues;

    public NoiseMonitor() {
        this.lastValues = new ArrayList<>();

    }

    @Override
    public void update(Subject s) {
        NoiseXDK n = (NoiseXDK) s;
        lastValues.add(n.getState());

        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        int min = rightNow.get(Calendar.MINUTE);

        System.out.print(n.getName() + ": (" + hour + ":" + min +") " );
        for(int i = lastValues.size()-1 ;i>0; i--){
            System.out.print(lastValues.get(i) + "dB,");
        }
        System.out.print(lastValues.get(0) + "dB\n");
    }
}
