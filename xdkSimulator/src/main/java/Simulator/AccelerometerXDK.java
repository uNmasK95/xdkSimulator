package Simulator;

import Component.Xdksim;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjaf on 18/10/2016.
 */
public class AccelerometerXDK implements Subject {

    private static int ID = 0;

    private int id;
    private int timeStamp;
    private List<Observer> listObservers;
    private float[] lastValue;

    public AccelerometerXDK(int time) {
        this.id = ID; ID++;
        this.timeStamp = time;
        listObservers = new ArrayList<>();
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

    public void start(){


        Thread c = new Thread( new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(timeStamp);
                        float[] value = Xdksim.getAcelerometro();
                        if( lastValue == null){
                            lastValue = value;
                            notifyObservers();
                        }

                        if( lastValue[0] != value[0] || lastValue[1]!=value[1] || lastValue[2]!=value[2] ) {
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

    public float[] getState(){
        return lastValue;
    }

    public String getName(){
        return "AccelerometerXDK " + this.id;
    }
}
