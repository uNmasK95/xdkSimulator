package Simulator;

/**
 * Created by rjaf on 06/10/2016.
 */
public class Mostrador implements ClientDisplay{

    private String name;

    public Mostrador( String name ) {
        this.name = name;
    }

    @Override
    public void displayValor(String valor) {
        System.out.println(name + " :: " + valor);
    }
}
