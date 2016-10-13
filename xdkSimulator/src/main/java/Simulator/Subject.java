package Simulator;

/**
 * Created by rjaf on 13/10/2016.
 */
public interface Subject {

    public void registerObserver( Observer observer );
    public void removeObserver( Observer observer );
    public void notifyObservers( String valor );

}
