package Simulator.teste;


import Simulator.NoiseMonitor;
import Simulator.NoiseXDK;

import java.io.IOException;

/**
 * Created by rjaf on 19/10/2016.
 */
public class Teste4 {

    public static void main(String[] args) throws IOException, InterruptedException {


        NoiseXDK n1 = new NoiseXDK(15000);
        NoiseXDK n2 = new NoiseXDK(10000);
        NoiseXDK n3 = new NoiseXDK(5000);

        NoiseMonitor nm = new NoiseMonitor();

        n1.registerObserver( nm );
        n2.registerObserver( nm );
        n3.registerObserver( nm );




    }
}
