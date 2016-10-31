package main.Object.Comandos;

import main.Object.*;
/**
 * Created by rjaf on 27/10/2016.
 */
public class FecharEstore implements Atuador{

    private Estore estore;

    public FecharEstore(Estore estore) {
        this.estore = estore;
    }

    @Override
    public void execute() {
        this.estore.close();
    }
}
