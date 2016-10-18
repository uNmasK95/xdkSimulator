package Simulator;

/**
 * Created by rjaf on 06/10/2016.
 */
public class MostradorObserver implements Observer{

    public MostradorObserver( ) { }

    @Override
    public void update(Subject s) {
        if(s.getClass().getSimpleName().equals("AccelerometerXDK")){
            AccelerometerXDK a = (AccelerometerXDK) s;
            float[] ac = a.getState();
            System.out.println( a.getName() + ":: x=" + ac[0] + " y=" + ac[1] + " z=" + ac[2] );
        }else if(s.getClass().getSimpleName().equals("TemperatureXDK")){
            TemperatureXDK t = (TemperatureXDK) s;
            System.out.println( t.getName() + ":: " + t.getState() );
        }
    }

}
