package Simulator.teste;

import Simulator.*;

import java.io.IOException;

/**
 * Created by rjaf on 06/10/2016.
 */
public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {


        AccelerometerXDK acc = new AccelerometerXDK(1000);

        MostradorObserver mo1 = new MostradorObserver();


        //acc.registerObserver( mo1 );





        TemperatureXDK temp = new TemperatureXDK(5000);

        BDInercialObserver bdio = new BDInercialObserver();

        //temp.registerObserver(bdio);
        //temp.registerObserver(mo1);


        NoiseXDK n1 = new NoiseXDK(15000);
        NoiseXDK n2 = new NoiseXDK(10000);
        NoiseXDK n3 = new NoiseXDK(5000);

        NoiseMonitor nm = new NoiseMonitor();

        n1.registerObserver( nm );
        n2.registerObserver( nm );
        n3.registerObserver( nm );



    }
}
