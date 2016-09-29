/**
 * Created by rjaf on 29/09/16.
 */


public class Teste {

    private static int time = 50000;

    public static void main(String[] args) throws InterruptedException {

        Client c1 = new Client();

        Client c2 = new Client();

        while(true){
            Thread.sleep(time);

            float teste = Xdksim.getacelerometro();

            c1.displayValue(teste);

            c2.displayValue(teste);

        }
    }
}
