package Simulator;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by rjaf on 29/09/16.
 */
public class SimulatorXDK {

    private ServerSocket sSocket;
    private ThreadAccelerometer accelerometer;


    public SimulatorXDK(int port) throws IOException {
        sSocket = new ServerSocket(port);
        accelerometer = new ThreadAccelerometer(1000);

        this.accelerometer.start();

        // posteriormente vamos ter de criar mais class thread para cada sensor e inicialos.
        // ou optamos por criar um serversocket em cada sensor e depois o cliente liga-se a porta especifica do sendor que quer ter os dados
        // ou então o cliente quando se ligar manda uma string predefenida em que diz qual é o sensor que quer receber os dados

    }



    public void start(){
        while(true){
            Socket socket = null;
            try {
                socket = sSocket.accept();
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader( socket.getInputStream()));
                    String line = br.readLine();
                    switch (line){
                        case "accelerometer" : {
                            this.accelerometer.addClient(new BufferedWriter(new OutputStreamWriter( socket.getOutputStream())));
                        }
                        case "temperatura" : {

                        }

                    }
                } catch (IOException e) {
                    System.out.println("Não foi possivel iniciar a comunicação com o cliente");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args){

        try {
            SimulatorXDK xdk = new SimulatorXDK(Integer.parseInt(args[0]));
            xdk.start();
        } catch (IOException e) {
            System.out.println("Não foi possivel iniciar a simulçaõ do xdk");
        }
    }


    class ThreadAccelerometer extends Thread{

        private List<BufferedWriter> listSocketClients;
        private int timeStamp;

        public ThreadAccelerometer(int time) {

            this.listSocketClients = new ArrayList<>();
            this.timeStamp = time;
        }


        public void addClient(BufferedWriter bw){

            this.listSocketClients.add( bw );
        }

        @Override
        public void run() {

            while(true){
                try {
                    Thread.sleep(timeStamp);

                    for( BufferedWriter bwClient : listSocketClients ){
                        try {
                            bwClient.write("Teste1"); //aqui temos de ver se podemos utilizar o componente para gerar os valores ou como vamos fazer
                            bwClient.newLine();
                            bwClient.flush();
                        } catch (IOException e) {
                            listSocketClients.remove(bwClient);
                            System.out.println("Não foi possivel enviar a informação para um cliente");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
