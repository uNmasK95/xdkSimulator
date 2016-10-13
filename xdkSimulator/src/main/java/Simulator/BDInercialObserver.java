package Simulator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjaf on 06/10/2016.
 */
public class BDInercialObserver implements Observer{

    private List<String> bd;

    public BDInercialObserver() {
        this.bd = new ArrayList<>();
    }

    @Override
    public void update(String valor) {
        bd.add(valor);
    }
}
