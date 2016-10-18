package Simulator;

import Component.Xdksim;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjaf on 18/10/2016.
 */
public class NoiseXDK implements Subject{

    private static int ID = 0;

    private int id;
    private int timeStamp;
    private List<Observer> listObservers;
    private float lastValue;

    public NoiseXDK(int time) {
        this.id = ID; ID++;
        this.timeStamp = time;
        listObservers = new ArrayList<>();
        this.lastValue = 0;
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

    public void start() {

        Thread c = new Thread( new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(timeStamp);
                        float value = Xdksim.getAcustica();
                        if (lastValue != value) {
                            lastValue = value;
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

    public String getName(){
        return "NoiseXDK " + this.id;
    }
}
