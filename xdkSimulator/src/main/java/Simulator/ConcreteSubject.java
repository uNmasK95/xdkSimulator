package Simulator;

import Component.Xdksim;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjaf on 13/10/2016.
 */
public class ConcreteSubject implements Subject{

    private int timeStamp;
    private String tipo;
    private List<Observer> listObservers;

    public ConcreteSubject(String tipo , int time) {
        this.timeStamp = time;
        this.tipo = tipo;
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
    public void notifyObservers( String valor ) {
        for( Observer clientDisplay : listObservers ) {
            clientDisplay.update( valor );
        }
    }

    public void start(){
        while(true){
            try {
                Thread.sleep(timeStamp);
                String valor = null;
                switch (tipo){
                    case "accelerometer" : {
                        valor = Xdksim.getAcelerometro();
                        break;
                    }
                    case "gyroscope" : {
                        valor = Xdksim.getGiroscopio();
                        break;
                    }
                    case "magnetometer" : {
                        valor = Xdksim.getMagnetometro();
                        break;
                    }
                    case "humidity" : {
                        valor = Xdksim.getHumidade();
                        break;
                    }
                    case "pressure" : {
                        valor = Xdksim.getPresao();
                        break;
                    }
                    case "temperature" : {
                        valor = Xdksim.getTemperatura();
                        break;
                    }
                    case "acoustic" : {
                        valor = Xdksim.getAcustica();
                        break;
                    }
                    case "light" : {
                        valor = Xdksim.getLuz();
                        break;
                    }

                }

                notifyObservers( valor );

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
