package Refatoring;

import java.util.Vector;

/**
 * Created by andreferreira on 03/11/2016.
 */
public interface WeatherObserver {
    void update(int id, Vector<Integer> values);
}
