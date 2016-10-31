package main;

import java.util.Random;

/**
 * Created by pedro on 30-09-2016.
 */
public class Xdksim {

    private static float[] acelerometro;
    private static float magnetometro;
    private static float temperatura;
    private static float acustica;
    private static float luz;
    private static float pressao;
    private static float humidade;
    private static boolean iniciarXDK = false;


    private static void iniciarXDK(){
        Random r = new Random();
        acelerometro = new float[3];
        acelerometro[0]= r.nextInt(200)+100;
        acelerometro[1]= r.nextInt(200)+100;
        acelerometro[2]= r.nextInt(50)+50;
        magnetometro = r.nextInt(175)+50; //mg
        temperatura = r.nextInt(20)+10; // ºC
        acustica = r.nextInt(40)+10;//db
        luz = r.nextInt(50)+20; // %
        pressao = r.nextInt(70)+70 ; // pa
        humidade = r.nextInt(100); // %
    }

    public static float[] getAcelerometro(){
        if(!iniciarXDK) {
            iniciarXDK(); iniciarXDK = true;
        }
        Random r = new Random();
        int qual = r.nextInt(2);
        if(qual==1) {
            acelerometro[0] += r.nextInt(10) + r.nextFloat();
            acelerometro[1] += r.nextInt(10) + r.nextFloat();
            acelerometro[2] += r.nextInt(2) + r.nextFloat();
        }
        else {
            acelerometro[0] -= r.nextInt(10) + r.nextFloat();
            acelerometro[1] -= r.nextInt(10) + r.nextFloat();
            acelerometro[2] -= r.nextInt(2) + r.nextFloat();
        }

        float teste[] = new float[3];
        teste[0] = acelerometro[0];
        teste[1] = acelerometro[1];
        teste[2] = acelerometro[2];
        return teste;
    }

    public static float getGiroscopio(){
        if(!iniciarXDK) {
            iniciarXDK(); iniciarXDK = true;
        }
        Random r = new Random();
        int qual = r.nextInt(2);
        float giroscopio = r.nextInt(360);
        if(qual==1) {
            giroscopio = -1 * giroscopio;
        }
        return giroscopio;
    }

    public static float getMagnetometro(){
        if(!iniciarXDK) {
            iniciarXDK(); iniciarXDK = true;
        }
        Random r = new Random();
        int qual = r.nextInt(2);
        if(qual==1) {
            magnetometro += r.nextInt(5) + r.nextFloat();
        }
        else{
            magnetometro -= r.nextInt(5) + r.nextFloat();
        }
        return magnetometro;
    }

    public static float getTemperatura(){
        if(!iniciarXDK) {
            iniciarXDK(); iniciarXDK = true;
            temperatura = 26;
        }
        Random r = new Random();
        int qual = r.nextInt(2);
        if(qual==1) {
            temperatura += r.nextInt(5) + r.nextFloat();
        }
        else{
            temperatura -= r.nextInt(5) + r.nextFloat();
        }
        return temperatura;
    }

    public static float getAcustica(){
        if(!iniciarXDK) {
            iniciarXDK(); iniciarXDK = true;
        }
        Random r = new Random();
        int qual = r.nextInt(2);
        if(qual==1) {
            acustica += r.nextInt(5);
        }
        else{
            acustica -= r.nextInt(5);
            if(acustica <= 0){
                acustica += 5;
            }
        }
        return acustica;
    }

    public static float getLuz(){
        if(!iniciarXDK) {
            iniciarXDK(); iniciarXDK = true;
            luz = 50;
        }
        Random r = new Random();
        int qual = r.nextInt(2);
        if(qual==1) {
            luz += r.nextInt(5);
            if(luz >100){
                luz -= 5;
            }
        }
        else{
            luz -= r.nextInt(5);
            if(luz <= 0){
                luz += 5;
            }
        }
        return luz;
    }

    public static float getPresao(){
        if(!iniciarXDK) {
            iniciarXDK(); iniciarXDK = true;
        }
        Random r = new Random();
        int qual = r.nextInt(2);
        if(qual==1) {
            pressao += r.nextInt(5) + r.nextFloat();
        }
        else{
            pressao -= r.nextInt(5) + r.nextFloat();
            if(luz <= 0){
                pressao += 5;
            }
        }
        return pressao;
    }

    public static float getHumidade(){
        if(!iniciarXDK) {
            iniciarXDK(); iniciarXDK = true;
        }
        Random r = new Random();
        int qual = r.nextInt(2);
        if(qual==1) {
            humidade += r.nextInt(5);
            if(humidade >=100){
                humidade -= 5;
            }
        }
        else{
            humidade -= r.nextInt(5);
            if(humidade <= 0){
                humidade += 5;
            }
        }
        return humidade;
    }
}
