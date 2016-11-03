package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by rjaf on 31/10/2016.
 */
public class ControlerAtuador implements Observer,Controler {

    private List<CondicaoAtuador> listCondAtuador;
    private Relogio relogio;

    public ControlerAtuador() {
        this.listCondAtuador = new ArrayList<>();
        this.relogio = new Relogio( Thread.currentThread() );
        new Thread(this.relogio).start();
    }

    @Override
    public void update(Subject s) {
        executeComand(s);
    }

    @Override
    public void registerAtuador(CondicaoAtuador ca) {
        listCondAtuador.add(ca);
    }

    @Override
    public void removeAtuador(CondicaoAtuador ca) {
        listCondAtuador.add(ca);
    }

    @Override
    public void executeComand(Subject s) {
        XDK xdk = (XDK) s;
        for ( CondicaoAtuador c : listCondAtuador ) {
            if(c.validarCondicao(xdk.getType() , xdk.getState() , this.relogio.getTime() )){
                c.getAtuador().execute();
            }
        }

    }

    public class Relogio implements Runnable {

        private Thread main;
        private int hora;
        private int minuto;


        public Relogio(Thread father) {
            this.main = father;
            this.hora = 0;
            this.minuto = 0;
        }

        public synchronized Calendar getTime(){
            Calendar c = Calendar.getInstance();
            c.set(Calendar.HOUR, hora);
            c.set(Calendar.MINUTE, minuto);
            return c;
        }

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1000);
                    this.minuto = this.minuto + 5;
                    if(this.minuto >= 60){
                        this.hora++;
                        this.minuto = 0;
                    }
                    System.out.println(this.hora + ":" + this.minuto);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
