import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Created by rjaf on 30/11/2016.
 */


public class Server {

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

        WeatherStation ws = new WeatherStation();
        XDK xdk1 = new XDK(ws,1);
        xdk1.start(xdk1_reading_1);
        xdk1.start(xdk1_reading_2);

        Naming.rebind("rmi://localhost:"+port+"/weather",ws);
    }
}
