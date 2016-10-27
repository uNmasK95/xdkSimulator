/**
 * Created by rjaf on 27/10/2016.
 */
public class DesligarArcondicionado implements Atuador {

    private Arcondicionado ar;

    public DesligarArcondicionado(Arcondicionado ar) {
        this.ar = ar;
    }

    public void execute() {
        ar.turnOff();
    }
}
