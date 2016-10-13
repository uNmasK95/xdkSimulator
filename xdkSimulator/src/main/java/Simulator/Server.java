package Simulator;

import java.io.IOException;

/**
 * Created by rjaf on 06/10/2016.
 */
public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {

        ConcreteSubject xdkA = new ConcreteSubject("accelerometer",1000);
        ConcreteSubject xdkT = new ConcreteSubject("temperature",5000);

        xdkA.start();
        xdkT.start();

        MostradorObserver mo = new MostradorObserver("pedro");

        xdkA.registerObserver( mo  );
        xdkT.registerObserver( mo );

        BDInercialObserver bd = new BDInercialObserver();

        xdkA.registerObserver( bd );
        xdkT.registerObserver( bd );






    }
}
