package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjaf on 18/10/2016.
 */
public class TemperatureXDK implements Subject,XDK{

    private int timeStamp;
    private List<Observer> listObservers;
    private float lastValue;

    public TemperatureXDK(int time) {
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
                        float value = Xdksim.getTemperatura();
                        if( lastValue != value ) {
                            lastValue = value;
                            System.out.println("Enviar valor temperatura:: " + lastValue);
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

    public float getState(){
        return lastValue;
    }
    public XDKtype getType(){ return XDKtype.Temperatura; }

}

