package Refatoring;

import java.time.LocalDate;
import java.util.Vector;

/**
 * Created by pedro on 24-11-2016.
 */
public class Teste {
    public static void main(String args[]) {
        // Create a hash map

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

        //Model
        WeatherModel wm = new WeatherModel();

        //Controller
        WeatherStation iot = new WeatherStation(wm);

        // XDK
        XDK xdk1 = new XDK(iot,1);
        xdk1.start(xdk1_reading_1);
        xdk1.start(xdk1_reading_2);

        // Views
        WeatherView wv = new WeatherView(iot);
        wv.mostra_temperatura();
        wv.mostra_max_minimo(LocalDate.now(), WeatherModel.idTemperatura);
        wv.mostra_max_minimo(LocalDate.now(), WeatherModel.idHumidade);
        wv.mostra_max_minimo(LocalDate.now(), WeatherModel.idPressao_atm);
        wv.mostra_max_minimo(LocalDate.now(), WeatherModel.idAudio);
        wv.mostra_max_minimo(LocalDate.now(), WeatherModel.idLuminosidade);
        wv.mostra_presao_atm();
        wv.mostra_humidade();
        wv.mostra_media(LocalDate.now(),WeatherModel.idTemperatura);
        wv.mostra_ultimos_dias(WeatherModel.idTemperatura,2);

    }

}
