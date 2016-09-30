package Simulator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;

/**
 * Created by rjaf on 29/09/16.
 */
public class ClientDisplay {

    private Socket socket;
    private BufferedReader br;

    public ClientDisplay(String ip, int port) throws IOException {
        this.socket = new Socket(ip ,port);
        this.br = new BufferedReader( new InputStreamReader( socket.getInputStream() ));

    }

    public void statusXDK(){
        String line;
        while (socket.isConnected()){
            try {
                line = br.readLine();
                System.out.println((new Date()).getTime() + " ::: "  + line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args){
        try {
            ClientDisplay c1 = new ClientDisplay(args[0], Integer.parseInt(args[1]));
            c1.statusXDK();
        } catch (IOException e) {
            System.out.println("Não foi possivel fazer ligação ao xdk");
        }
    }
}
