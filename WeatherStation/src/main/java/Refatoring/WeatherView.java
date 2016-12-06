package Refatoring;

import java.time.LocalDate;

/**
 * Created by pedro on 17-11-2016.
 */
public class WeatherView {


    public void print_mostra_temperatura(int temperatura) {
        System.out.println("Tempertura Actual: " + temperatura);
    }

    public void print_mostra_humidade(int humidade) {
        System.out.println("Humidade Actual: " + humidade);
    }

    public void print_mostra_presao_atm(int presao_atm) {
        System.out.println("pressao atmosférica actual: " + presao_atm);
    }

    public void print_mostra_audio(int audio) {
        System.out.println("Audio actual: " + audio);
    }

    public void print_mostra_luminusidade(int luminosidade) {
        System.out.println( "Luminosidade actual: " + luminosidade);
    }

    public void print_mostra_media(String media) {
        System.out.println(media);
    }

    public void print_mostra_max_minimo(String max_minimo) {
        System.out.println(max_minimo);
    }

    public void print_mostra_ultimos_dias(String ultimos_dias){
        System.out.println("Valores máximos e mínimos: "+ ultimos_dias);
    }
}
