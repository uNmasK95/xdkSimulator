package main.Object.Comandos;

import main.Object.*;

/**
 * Created by rjaf on 27/10/2016.
 */

public class AbrirEstore implements Atuador {

    private Estore estore;

    public AbrirEstore(Estore estore) {
        this.estore = estore;
    }

    @Override
    public void execute() {
        estore.open();
    }
}
