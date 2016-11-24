package Refatoring;

import java.time.LocalDate;

/**
 * Created by pedro on 17-11-2016.
 */
public class WeatherView {


    private WeatherStation station;

    public WeatherView(WeatherStation w){
        this.station = w;
    }

    public void mostra_temperatura() {
        System.out.println("Tempertura Actual: " + station.mostra_temperatura());
    }

    public void mostra_humidade() {
        System.out.println("Humidade Actual: " + station.mostra_humidade());
    }

    public void mostra_presao_atm() {
        System.out.println("pressao atmosférica actual: " + station.mostra_presao_atm());
    }

    public void mostra_audio() {
        System.out.println("Audio actual: " + station.mostra_audio());
    }

    public void mostra_luminusidade() {
        System.out.println( "Luminosidade actual: " + station.mostra_luminusidade());
    }

    public void mostra_media(LocalDate data, int sensor) {
        if(station.mostra_media(data,sensor)!=null) {
            System.out.println(station.mostra_media(data, sensor));
        }
    }

    public void mostra_max_minimo(LocalDate data, int sensor) {
        if(station.mostra_max_minimo(data,sensor) != null) {
            System.out.println(station.mostra_max_minimo(data, sensor));
        }
    }

    public void mostra_ultimos_dias(int sensor, int dias){
        System.out.println("Valores máximos e mínimos: "+station.mostra_ultimos_dias(sensor,dias).toString());
    }
}
