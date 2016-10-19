package Component;

/**
 * Created by pedro on 30-09-2016.
 */
public class Client {
    public Client() {
    }

    public void displayValue(float[] value){
        System.out.println( "x=" + value[0] + " y=" + value[1] + " z=" + value[2] );
    }

    public void displayValue(float value){
        System.out.println( value );
    }

}
