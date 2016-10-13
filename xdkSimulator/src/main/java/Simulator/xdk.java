package Simulator;

/**
 * Created by rjaf on 13/10/2016.
 */
public interface xdk {

    public final static String accelerometer = "accelerometer";
    public final static String gyroscope = "gyroscope";
    public final static String magnetometer = "magnetometer";
    public final static String humidity = "humidity";
    public final static String pressure = "pressure";
    public final static String temperature = "temperature";
    public final static String acoustic = "acoustic";
    public final static String light = "light";

    public void addCLiente( ClientDisplay c , String sensor);
    public void removeCliente(ClientDisplay c);
    //notify observers
}
