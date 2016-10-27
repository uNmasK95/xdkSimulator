import java.util.*;

/**
 * Created by rjaf on 18/10/2016.
 */
public class TemperatureXDK implements Subject{


    private Map<Condicao,List<Atuador>> listComands;

    private int timeStamp;
    private float lastValue;

    public TemperatureXDK(int time) {
        this.listComands = new HashMap<>();
        this.timeStamp = time;
        this.lastValue = 0;
        start();
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
                            System.out.println("TemperatureXDK:: " + lastValue);
                            executeComand();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        c.start();

    }

    @Override
    public void registerAtenuador(Condicao c, Atuador a) {
        if(listComands.containsKey(c)){
            listComands.get(c).add(a);
        }else{
            List<Atuador> list = new ArrayList();
            list.add(a);
            listComands.put(c,list);
        }
    }

    @Override
    public void removeAtenuar(Condicao c, Atuador a) {
        if(listComands.containsKey(c)){
            listComands.get(c).remove(a);
        }
    }

    @Override
    public void executeComand() {
        for ( Condicao c : listComands.keySet()) {
            if( c.validCondicao(lastValue)){
                for ( Atuador a :listComands.get(c) ) {
                    a.execute();
                }
            }
        }
    }
}

