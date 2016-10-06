package Simulator;

import java.io.IOException;

/**
 * Created by rjaf on 06/10/2016.
 */
public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {
        SimulatorXDK xdk = new SimulatorXDK();
        xdk.addCLiente( new ClientDisplay("pedro") , "accelemeter");
        xdk.addCLiente( new ClientDisplay("rui") , "accelemeter");
        xdk.addCLiente( new ClientDisplay("cecilia") , "temperatura");
        xdk.addCLiente( new ClientDisplay("beatriz") , "temperatura");
    }
}
