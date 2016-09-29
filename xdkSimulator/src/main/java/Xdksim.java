import java.util.Random;

/**
 * Created by rjaf on 29/09/16.
 */
public class Xdksim {

    public static float acelerometro;
    public static float giroscopio;
    public static float humidade;
    public static float magnetometro;
    public static float pressao;
    public static float temperatura;
    public static float acustica;
    public static float luz;
    public static long lasttimeconsult;

    public static void getacelerometro(){
        Random r;
        r = new Random ();
        float p = r.nextFloat();
    }

    public static void gettemperatura(){
        Random r;
        r = new Random();
        temperatura = r.nextInt(30);
    }

    public static void getacustica(){
        Random r;
        r = new Random();

    }

}
