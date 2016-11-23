package Refatoring;

import java.util.Vector;

/**
 * Created by pedro on 17-11-2016.
 */
public class XDK {

    private WeatherObserver weatherObserver;

    public XDK (WeatherObserver c, Vector<Integer> v, int id) {
        this.weatherObserver = c;
        start(id,v);
    }

    public void start (Integer id, Vector<Integer> v){
        this.weatherObserver.update(1, v);
    }
}
