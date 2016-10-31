package main.Object;

/**
 * Created by rjaf on 27/10/2016.
 */
public class Arcondicionado {

    private static int ID = 0;

    private boolean ativo;
    private int id;

    public Arcondicionado() {
        this.id = ID++;
        this.ativo = false;
    }

    public void turnOn(){
        if(this.ativo==false){
            this.ativo=true;
            System.out.println(id + " - Ligar arcondicionado");
        }else {
            System.out.println(id + " - O arcondicionado já se encontra ligado");
        }
    }

    public void turnOff(){
        if(this.ativo==true){
            this.ativo=false;
            System.out.println(id + " - Desligar arcondicionado");
        }else{
            System.out.println(id + " - O arcondicionado já se encontra desligado");
        }
    }
}
