import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public interface WeatherStationInf extends Remote {

    static String NAME = "WeatherStationInf";

    String mostra_temperatura() throws RemoteException;
    String mostra_humidade() throws RemoteException;
    String mostra_presao_atm() throws RemoteException;
    String mostra_audio() throws RemoteException;
    String mostra_luminusidade() throws RemoteException;
    String mostra_media(LocalDate data, int sensor) throws RemoteException;
    String  mostra_max_minimo(LocalDate data, int sensor) throws RemoteException;
    String mostra_ultimos_dias(int sensor, int dias) throws RemoteException;
}