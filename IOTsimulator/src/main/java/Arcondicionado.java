/**
 * Created by rjaf on 27/10/2016.
 */
public class Arcondicionado {

    private boolean ativo;

    public Arcondicionado() {
        this.ativo = false;
    }

    public void turnOn(){
        if(this.ativo==false){
            this.ativo=true;
            System.out.println("Ligar arcondicionado");
        }else {
            System.out.println("Já se encontra ligado");
        }
    }

    public void turnOff(){
        if(this.ativo==true){
            this.ativo=false;
            System.out.println("Desligar arcondicionado");
        }else{
            System.out.println("Já se encontra desligado");
        }
    }
}
