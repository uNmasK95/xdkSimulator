package Simulator;

/**
 * Created by rjaf on 06/10/2016.
 */
public class MostradorObserver implements Observer{

    private String name;

    public MostradorObserver(String name ) {
        this.name = name;
    }

    @Override
    public void update(String valor) {

        System.out.println(name + " :: " + valor);
    }

}
