import java.time.LocalDate;

/**
 * Created by pedro on 17-11-2016.
 */
public class WeatherView {


    private WeatherStation station;

    public WeatherView(WeatherStation w){
        this.station = w;
    }

    public void print_mostra_temperatura() {
        System.out.println("Tempertura Actual: " + station.mostra_temperatura());
    }

    public void print_mostra_humidade() {
        System.out.println("Humidade Actual: " + station.mostra_humidade());
    }

    public void print_mostra_presao_atm() {
        System.out.println("pressao atmosférica actual: " + station.mostra_presao_atm());
    }

    public void print_mostra_audio() {
        System.out.println("Audio actual: " + station.mostra_audio());
    }

    public void print_mostra_luminusidade() {
        //System.out.println( "Luminosidade actual: " + station.mostra_luminusidade());
    }

    public void print_mostra_media(LocalDate data, int sensor) {
        if(station.mostra_media(data,sensor)!=null) {
            System.out.println(station.mostra_media(data, sensor));
        }
    }

    public void print_mostra_max_minimo(LocalDate data, int sensor) {
        if(station.mostra_max_minimo(data,sensor) != null) {
            System.out.println(station.mostra_max_minimo(data, sensor));
        }
    }

    public void print_mostra_ultimos_dias(int sensor, int dias){
        System.out.println("Valores máximos e mínimos: "+station.mostra_ultimos_dias(sensor,dias).toString());
    }
}
