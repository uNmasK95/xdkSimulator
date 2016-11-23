package Refatoring;

import java.time.LocalDate;

/**
 * Created by pedro on 17-11-2016.
 */
public class VisualizeView {


    private WeatherStation station;

    public VisualizeView (WeatherStation w){
        this.station = w;
    }

    public void mostra_temperatura() {
        System.out.println(station.mostra_temperatura());
    }

    public void mostra_humidade() {
        System.out.println(station.mostra_humidade());
    }

    public void mostra_presao_atm() {
        System.out.println(station.mostra_presao_atm());
    }

    public void mostra_audio() {

        System.out.println(station.mostra_audio());
    }

    public void mostra_luminusidade() {
        System.out.println(station.mostra_humidade());
    }

    public void mostra_media(LocalDate data, int sensor) {
        System.out.println(station.mostra_media(data,sensor));
    }

    public void mostra_max_minimo(LocalDate data, int sensor) {
        System.out.println(station.mostra_max_minimo(data,sensor));
    }
}
