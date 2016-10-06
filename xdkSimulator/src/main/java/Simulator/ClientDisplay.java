package Simulator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rjaf on 29/09/16.
 */
public class ClientDisplay{

    private String name;

    public ClientDisplay(String name) {
        this.name = name;
    }

    public void displayValor(String valor){
        System.out.println(this.name +" :: "+valor);
    }
}
