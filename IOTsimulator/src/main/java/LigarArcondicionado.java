/**
 * Created by rjaf on 27/10/2016.
 */
public class LigarArcondicionado implements Atuador {

    private Arcondicionado ar;


    public LigarArcondicionado(Arcondicionado ar) {
        this.ar = ar;
    }

    public void execute() {
        ar.turnOn();
    }
}
