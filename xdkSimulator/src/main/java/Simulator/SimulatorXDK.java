package Simulator;


import Component.Client;
import Component.Xdksim;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by rjaf on 29/09/16.
 */
public class SimulatorXDK implements xdk{

    private ThreadSensor accelerometer;
    private ThreadSensor gyroscope;
    private ThreadSensor magnetometer;
    private ThreadSensor humidity;
    private ThreadSensor pressure;
    private ThreadSensor temperature;
    private ThreadSensor acoustic;
    private ThreadSensor light;



    public SimulatorXDK() throws IOException, InterruptedException {
        accelerometer = new ThreadSensor("accelerometer",1000);
        gyroscope = new ThreadSensor("gyroscope",1000);
        magnetometer = new ThreadSensor("magnetometer",1000);
        humidity = new ThreadSensor("humidity",1000);
        pressure = new ThreadSensor("pressure",1000);
        temperature = new ThreadSensor("temperature",5000);
        acoustic = new ThreadSensor("acoustic",1000);
        light = new ThreadSensor("light",1000);

        this.accelerometer.start();
        this.gyroscope.start();
        this.magnetometer.start();
        this.humidity.start();
        this.pressure.start();
        this.temperature.start();
        this.acoustic.start();
        this.light.start();
    }

    public void addCLiente( ClientDisplay c , String sensor){
        switch (sensor){
            case xdk.accelerometer : {
                accelerometer.addClient( c );
                break;
            }
            case xdk.gyroscope : {
                gyroscope.addClient( c );
                break;
            }
            case xdk.magnetometer : {
                magnetometer.addClient( c );
                break;
            }
            case xdk.humidity : {
                humidity.addClient( c );
                break;
            }
            case xdk.pressure : {
                pressure.addClient( c );
                break;
            }
            case xdk.temperature : {
                temperature.addClient( c );
                break;
            }
            case xdk.acoustic : {
                acoustic.addClient( c );
                break;
            }
            case xdk.light : {
                light.addClient( c );
                break;
            }
            default:{
                System.out.println("Sensor não existe");
            }
        }
    }

    @Override
    public void removeCliente(ClientDisplay c) {
        this.accelerometer.removeClient( c );
        this.gyroscope.removeClient(c);
        this.magnetometer.removeClient(c);
        this.humidity.removeClient(c);
        this.pressure.removeClient(c);
        this.temperature.removeClient(c);
        this.acoustic.removeClient(c);
        this.light.removeClient(c);
    }


    class ThreadSensor extends Thread{

        private String tipo;
        private List<ClientDisplay> listClients;
        private int timeStamp;

        public ThreadSensor(String tipo , int time) {
            this.tipo = tipo;
            this.listClients = new ArrayList<>();
            this.timeStamp = time;
        }


        public void addClient(ClientDisplay cd){

            this.listClients.add( cd );
        }

        public void removeClient(ClientDisplay cd){
            this.listClients.remove( cd );
        }

        @Override
        public void run() {

            while(true){
                try {
                    Thread.sleep(timeStamp);
                    String valor = null;
                    switch (tipo){
                        case xdk.accelerometer : {
                            valor = Xdksim.getAcelerometro();
                            break;
                        }
                        case xdk.gyroscope : {
                            valor = Xdksim.getGiroscopio();
                            break;
                        }
                        case xdk.magnetometer : {
                            valor = Xdksim.getMagnetometro();
                            break;
                        }
                        case xdk.humidity : {
                            valor = Xdksim.getHumidade();
                            break;
                        }
                        case xdk.pressure : {
                            valor = Xdksim.getPresao();
                            break;
                        }
                        case xdk.temperature : {
                            valor = Xdksim.getTemperatura();
                            break;
                        }
                        case xdk.acoustic : {
                            valor = Xdksim.getAcustica();
                            break;
                        }
                        case xdk.light : {
                            valor = Xdksim.getLuz();
                            break;
                        }

                    }

                    for( ClientDisplay clientDisplay : listClients ) {
                        clientDisplay.displayValor( valor );
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }



}
