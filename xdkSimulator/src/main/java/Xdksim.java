import java.util.Random;

/**
 * Created by rjaf on 29/09/16.
 */
public class Xdksim {

    public static float getacelerometro(){
        Random r = new Random ();
        return r.nextInt(20);
    }

    public static float gettemperatura(){
        Random r;
        r = new Random();
        temperatura = r.nextInt(30);
    }

    public static void getacustica(){
        Random r;
        r = new Random();
        acustica = r.nextInt(20);
    }

    public static void getluz(){
        Random r;
        r = new Random();
        luz = r.nextInt(20);
    }

    public static void getpressao(){
        Random r;
        r = new Random();
        pressao = r.nextInt(20);
    }

}
