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

    public Client(int port) {
        try {
            Registry registry = LocateRegistry.getRegistry(port);
            this.ws = (WeatherStationInf) registry.lookup(WeatherStationInf.NAME);
        } catch (NotBoundException | RemoteException e) {
            e.printStackTrace();
        }
    }

    public void print_mostra_temperatura() throws RemoteException {
        System.out.println("Tempertura Actual: " + this.ws.mostra_temperatura());
    }

    public void print_mostra_humidade() throws RemoteException {
        System.out.println("Humidade Actual: " + this.ws.mostra_humidade());
    }

    public void print_mostra_presao_atm() throws RemoteException {
        System.out.println("pressao atmosférica actual: " + this.ws.mostra_presao_atm());
    }

    public void print_mostra_audio() throws RemoteException {
        System.out.println("Audio actual: " + this.ws.mostra_audio());
    }

    public void print_mostra_luminusidade() throws RemoteException {
        System.out.println( "Luminosidade actual: " + this.ws.mostra_luminusidade());
    }

    public void print_mostra_media(LocalDate data, int sensor) throws RemoteException {
        if(this.ws.mostra_media(data,sensor)!=null) {
            System.out.println(this.ws.mostra_media(data, sensor));
        }
    }

    public void print_mostra_max_minimo(LocalDate data, int sensor) throws RemoteException {
        if(this.ws.mostra_max_minimo(data,sensor) != null) {
            System.out.println(this.ws.mostra_max_minimo(data, sensor));
        }
    }

    public void print_mostra_ultimos_dias(int sensor, int dias) throws RemoteException {
        System.out.println("Valores máximos e mínimos: "+this.ws.mostra_ultimos_dias(sensor,dias).toString());
    }


    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Client c1 = new Client(12345);

        c1.print_mostra_temperatura();


    }


}
