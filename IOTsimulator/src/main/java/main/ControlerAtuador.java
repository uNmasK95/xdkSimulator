package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjaf on 31/10/2016.
 */
public class ControlerAtuador implements Observer,Controler {

    private List<CondicaoAtuador> listCondAtuador;

    public ControlerAtuador() {
        this.listCondAtuador = new ArrayList<>();
    }

    @Override
    public void update(Subject s) {
        executeComand(s);
    }

    @Override
    public void registerAtenuador(CondicaoAtuador ca) {
        listCondAtuador.add(ca);
    }

    @Override
    public void removeAtenuar(CondicaoAtuador ca) {
        listCondAtuador.add(ca);
    }

    @Override
    public void executeComand(Subject s) {
        XDK xdk = (XDK) s;
        for ( CondicaoAtuador c : listCondAtuador ) {
            if(c.validarCondicao(xdk.getType() , xdk.getState() )){
                c.getAtuador().execute();
            }
        }

    }
}
