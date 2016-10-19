package Component;

/**
 * Created by pedro on 30-09-2016.
 */
public class Teste {
    private static int time = 2000;

    public static void main(String[] args) throws InterruptedException {

        Client c1 = new Client();

        Client c2 = new Client();

        while(true){
            Thread.sleep(time);

            float[] teste = Xdksim.getAcelerometro();

            c1.displayValue(teste);

            c2.displayValue(teste);

        }
    }
}
