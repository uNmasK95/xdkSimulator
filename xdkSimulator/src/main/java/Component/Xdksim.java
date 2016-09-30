package Component;

import java.util.Random;

/**
 * Created by pedro on 30-09-2016.
 */
public class Xdksim {

    private static float[] acelerometro;
    private static float giroscopio;
    private static float magnetometro;
    private static float temperatura;
    private static float acustica;
    private static float luz;
    private static float pressao;
    private static float humidade;


    public static void iniciarXDK(){
        Random r = new Random();
        acelerometro = new float[3];
        acelerometro[0]= r.nextInt(200)+100;
        acelerometro[1]= r.nextInt(200)+100;
        acelerometro[2]= r.nextInt(50)+50;
        giroscopio = r.nextInt(360);
        magnetometro = r.nextInt(175)+50; //mg
        temperatura = r.nextInt(20)+10; // ºC
        acustica = r.nextInt(40)+10;//db
        luz = r.nextInt(50)+20; // %
        pressao = r.nextInt(70)+70 ; // pa
        humidade = r.nextInt(100); // %
    }

    public static String getAcelerometro(){
        Random r = new Random();
        String a = "Acelarometro x: "+acelerometro[0]+" y: "+ acelerometro[1] + " z: "+acelerometro[2];
        int qual = r.nextInt(2);
        System.out.println("qual "+qual);
        if(qual==1) {
            acelerometro[0] += r.nextInt(10);
            acelerometro[1] += r.nextInt(10);
            acelerometro[2] += r.nextInt(2);
        }
        else {
            acelerometro[0] -= r.nextInt(10);
            acelerometro[1] -= r.nextInt(10);
            acelerometro[2] -= r.nextInt(2);
        }
        return a;
    }

    public static String getGiroscopio(){
        String a = "Giroscopio: "+ giroscopio;
        Random r = new Random();
        int qual = r.nextInt(2);
        if(qual==1) {
            giroscopio += r.nextInt(5);
        }
        else{
            giroscopio -= r.nextInt(5);
        }
        return a;
    }

    public static String getMagnetometro(){
        String a = "Magnetometro: "+ magnetometro+" mg";
        Random r = new Random();
        int qual = r.nextInt(2);
        if(qual==1) {
            magnetometro += r.nextInt(5);
        }
        else{
            magnetometro -= r.nextInt(5);
        }
        return a;
    }

    public static String getTemperatura(){
        String a = "Temperatura: "+ temperatura+" ºC";
        Random r = new Random();
        int qual = r.nextInt(2);
        if(qual==1) {
            temperatura += r.nextInt(5);
        }
        else{
            temperatura -= r.nextInt(5);
        }
        return a;
    }

    public static String getAcustica(){
        String a = "Acustica: "+ acustica+" dB";
        Random r = new Random();
        int qual = r.nextInt(2);
        if(qual==1) {
            acustica += r.nextInt(5);
        }
        else{
            acustica -= r.nextInt(5);
            if(acustica < 0){
                acustica += 5;
            }
        }
        return a;
    }

    public static String getLuz(){
        String a = "Luz: "+ luz+" %";
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
        return a;
    }

    public static String getPresao(){
        String a = "Pressao: "+ pressao+" pa";
        Random r = new Random();
        int qual = r.nextInt(2);
        if(qual==1) {
            pressao += r.nextInt(5);
        }
        else{
            pressao -= r.nextInt(5);
            if(luz <= 0){
                pressao += 5;
            }
        }
        return a;
    }

    public static String getHumidade(){
        String a = "Humidade: "+ humidade+" %";
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
        return a;
    }
}
