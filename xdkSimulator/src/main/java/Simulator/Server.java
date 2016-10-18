package Simulator;

import java.io.IOException;

/**
 * Created by rjaf on 06/10/2016.
 */
public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {


        AccelerometerXDK acc = new AccelerometerXDK(1000);

        MostradorObserver mo1 = new MostradorObserver();


        acc.registerObserver( mo1 );





        TemperatureXDK temp = new TemperatureXDK(5000);

        BDInercialObserver bdio = new BDInercialObserver();

        temp.registerObserver(bdio);
        temp.registerObserver(mo1);


        NoiseXDK n = new NoiseXDK(15000);
        NoiseXDK n1 = new NoiseXDK(5000);
        NoiseMonitor nm = new NoiseMonitor();

        n.registerObserver( nm );
        n1.registerObserver( nm );
        n1.start();
        n.start();
        acc.start();
        temp.start();



    }
}
