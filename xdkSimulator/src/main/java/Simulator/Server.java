package Simulator;

import java.io.IOException;

/**
 * Created by rjaf on 06/10/2016.
 */
public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {
        SimulatorXDK xdk = new SimulatorXDK();
        xdk.addCLiente( new Mostrador("pedro") , "accelerometer");
        xdk.addCLiente( new Mostrador("rui") , "gyroscope");
        xdk.addCLiente( new BDInercial() , "magnetometer");
        xdk.addCLiente( new BDInercial() , "humidity");
        xdk.addCLiente( new Mostrador("madalena") , "pressure");
        xdk.addCLiente( new Mostrador("leandro") , "temperature");
        xdk.addCLiente( new BDInercial() , "acoustic");
        xdk.addCLiente( new BDInercial() , "light");
    }
}
