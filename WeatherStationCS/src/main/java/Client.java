import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;

/**
 * Created by rjaf on 30/11/2016.
 */
public class Client {

    private WeatherStationInf ws;

    public Client(int port,String name) {
        try {
            Registry registry = LocateRegistry.getRegistry(port);
            this.ws = (WeatherStationInf) registry.lookup(name);
        } catch (NotBoundException | RemoteException e) {
            e.printStackTrace();
        }
    }

    public void mostra_temperatura() throws RemoteException {
        System.out.println( this.ws.mostra_temperatura());
    }

    public void mostra_humidade() throws RemoteException {
        System.out.println( this.ws.mostra_humidade());
    }

    public void mostra_presao_atm() throws RemoteException {
        System.out.println( this.ws.mostra_presao_atm());
    }

    public void mostra_audio() throws RemoteException  {
        System.out.println( this.ws.mostra_audio());
    }

    public void mostra_luminusidade() throws RemoteException {
        System.out.println( this.ws.mostra_luminusidade());
    }

    public void mostra_media(LocalDate data, int sensor) throws RemoteException {
        System.out.println( this.ws.mostra_media(data, sensor));
    }

    public void mostra_max_minimo(LocalDate data, int sensor) throws RemoteException {
        System.out.println( this.ws.mostra_max_minimo(data, sensor));
    }

    public void mostra_ultimos_dias(int sensor, int dias) throws RemoteException{
        System.out.println( this.ws.mostra_ultimos_dias(sensor,dias).toString());
    }

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Client c1 = new Client(12345,"WeatherStation1");

        c1.mostra_temperatura();


    }


}
