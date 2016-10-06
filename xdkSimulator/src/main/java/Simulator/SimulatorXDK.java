package Simulator;


import Component.Xdksim;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by rjaf on 29/09/16.
 */
public class SimulatorXDK {

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
            case "accelerometer" : {
                accelerometer.addClient( c );
                break;
            }
            case "gyroscope" : {
                gyroscope.addClient( c );
                break;
            }
            case "magnetometer" : {
                magnetometer.addClient( c );
                break;
            }
            case "humidity" : {
                humidity.addClient( c );
                break;
            }
            case "pressure" : {
                pressure.addClient( c );
                break;
            }
            case "temperature" : {
                temperature.addClient( c );
                break;
            }
            case "acoustic" : {
                acoustic.addClient( c );
                break;
            }
            case "light" : {
                light.addClient( c );
                break;
            }
            default:{
                System.out.println("Sensor não existe");
            }
        }
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

        @Override
        public void run() {

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
