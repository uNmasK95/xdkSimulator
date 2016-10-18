package Simulator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjaf on 06/10/2016.
 */
public class BDInercialObserver implements Observer{

    //temperatura
    private List<Float> bd;

    public BDInercialObserver() {

        this.bd = new ArrayList<>();
    }

    @Override
    public void update( Subject s ) {
        bd.add( ((TemperatureXDK) s).getState() );
    }
}
