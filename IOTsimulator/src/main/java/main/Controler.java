package main;

import main.Object.Atuador;

/**
 * Created by rjaf on 31/10/2016.
 */
public interface Controler {

    public void registerAtuador(CondicaoAtuador ca );
    public void removeAtuador(CondicaoAtuador ca );
    public void executeComand(Subject s);

}
