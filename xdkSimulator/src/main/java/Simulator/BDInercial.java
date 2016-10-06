package Simulator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjaf on 06/10/2016.
 */
public class BDInercial implements ClientDisplay{

    private List<String> bd;

    public BDInercial() {
        this.bd = new ArrayList<>();
    }

    @Override
    public void displayValor(String valor) {
        bd.add(valor);
    }
}
