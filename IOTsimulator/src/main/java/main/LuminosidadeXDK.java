package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjaf on 18/10/2016.
 */
public class LuminosidadeXDK implements Subject,XDK{

    private int timeStamp;
    private List<Observer> listObservers;
    private float lastValue;

    public LuminosidadeXDK(int time) {
        this.timeStamp = time;
        listObservers = new ArrayList<>();
        this.lastValue = 0;

        start();
    }

    @Override
    public void registerObserver(Observer c ) {
        listObservers.add( c );
    }

    @Override
    public void removeObserver(Observer c) {
        listObservers.remove( c );
    }

    @Override
    public void notifyObservers() {
        for( Observer clientDisplay : listObservers ) {
            clientDisplay.update( this );
        }
    }

    private void start(){

        Thread c = new Thread( new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(timeStamp);
                        float value = Xdksim.getLuz();
                        if( lastValue != value ) {
                            lastValue = value;
                            System.out.println("Enviar valor luz:: " + lastValue);
                            notifyObservers();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        c.start();

    }
    @Override
    public float getState(){
        return lastValue;
    }
    @Override
    public XDKtype getType() {
        return XDKtype.Luminosidade;
    }

}

