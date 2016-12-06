import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public interface WeatherStationInf extends Remote {

    static String NAME = "WeatherStationInf";

    int mostra_temperatura() throws RemoteException;
    int mostra_humidade() throws RemoteException;
    int mostra_presao_atm() throws RemoteException;
    int mostra_audio() throws RemoteException;
    int mostra_luminusidade() throws RemoteException;
    String mostra_media(LocalDate data, int sensor) throws RemoteException;
    String  mostra_max_minimo(LocalDate data, int sensor) throws RemoteException;
    Map<LocalDate, Vector<Integer>> mostra_ultimos_dias(int sensor, int dias) throws RemoteException;
}