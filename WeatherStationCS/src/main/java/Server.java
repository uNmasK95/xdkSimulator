
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Vector;

/**
 * Created by rjaf on 30/11/2016.
 */


public class Server {

    public Server(int port, String name, WeatherStationInf ws) {
        try {
            Registry registry = LocateRegistry.getRegistry(port);
            registry.rebind(name,ws);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws MalformedURLException, RemoteException {
        String port = args[0];

        Vector<Integer> xdk1_reading_1= new Vector<>();
        xdk1_reading_1.add(23);
        xdk1_reading_1.add(2);
        xdk1_reading_1.add(3);
        xdk1_reading_1.add(54);
        xdk1_reading_1.add(32);

        Vector<Integer> xdk1_reading_2= new Vector<>();
        xdk1_reading_2.add(22);
        xdk1_reading_2.add(24);
        xdk1_reading_2.add(3);
        xdk1_reading_2.add(4);
        xdk1_reading_2.add(5);

        WeatherModel wModel = new WeatherModel();

        WeatherStation wStation = new WeatherStation(wModel);
        XDK xdk1 = new XDK(wStation,1);
        xdk1.start(xdk1_reading_1);
        xdk1.start(xdk1_reading_2);

        Server s = new Server(12345,"WeatherStation1",wStation);
    }
}
