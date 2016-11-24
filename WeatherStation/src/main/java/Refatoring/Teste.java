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

        WeatherStation iot = new WeatherStation();
        XDK xdk1 = new XDK(iot,1);

        xdk1.start(xdk1_reading_1);
        xdk1.start(xdk1_reading_2);

        // Views
        WeatherView view  = new WeatherView(iot);

        view.print_mostra_temperatura();
        view.print_mostra_max_minimo(LocalDate.now(), WeatherStation.idTemperatura);
        view.print_mostra_max_minimo(LocalDate.now(), WeatherStation.idHumidade);
        view.print_mostra_max_minimo(LocalDate.now(), WeatherStation.idPressao_atm);
        view.print_mostra_max_minimo(LocalDate.now(), WeatherStation.idAudio);
        view.print_mostra_max_minimo(LocalDate.now(), WeatherStation.idLuminosidade);
        view.print_mostra_presao_atm();
        view.print_mostra_humidade();
        view.print_mostra_media(LocalDate.now(),WeatherStation.idTemperatura);
        view.print_mostra_ultimos_dias(WeatherStation.idTemperatura,2);

    }
}
