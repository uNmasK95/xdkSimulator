package Refatoring;

import java.util.Vector;

/**
 * Created by pedro on 17-11-2016.
 */
public class XDK {

    private WeatherObserver weatherObserver;
    private int id;

    public XDK (WeatherObserver c, int id) {
        this.weatherObserver = c;
        this.id = id;
    }

    public void start (Vector<Integer> v){
        this.weatherObserver.update(this.id, v);
    }
}