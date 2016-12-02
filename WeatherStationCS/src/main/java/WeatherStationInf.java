import java.rmi.Remote;
import java.rmi.RemoteException;

public interface WeatherStationInf extends Remote {
    int mostra_luminusidade() throws RemoteException;
}