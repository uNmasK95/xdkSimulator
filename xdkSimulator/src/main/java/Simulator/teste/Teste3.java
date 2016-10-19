package Simulator.teste;

import Simulator.*;

import java.io.IOException;

/**
 * Created by rjaf on 06/10/2016.
 */
public class Teste3 {

    public static void main(String[] args) throws IOException, InterruptedException {


        AccelerometerXDK acc = new AccelerometerXDK(1000);

        MostradorObserver mo1 = new MostradorObserver();

        acc.registerObserver( mo1 );

        TemperatureXDK temp = new TemperatureXDK(5000);

        BDInercialObserver bdio = new BDInercialObserver();

        temp.registerObserver(bdio);
        temp.registerObserver(mo1);

    }
}
