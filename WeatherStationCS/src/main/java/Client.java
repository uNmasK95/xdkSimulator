import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by rjaf on 30/11/2016.
 */
public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        String port = args[0];
        WeatherStationInf ws = (WeatherStationInf) Naming.lookup("rmi://localhost:"+port+"/weather");

        System.out.print(ws.mostra_luminusidade());


    }


}
