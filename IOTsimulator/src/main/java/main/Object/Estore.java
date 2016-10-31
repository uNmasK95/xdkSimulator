package main.Object;

/**
 * Created by rjaf on 27/10/2016.
 */
public class Estore {

    private static int ID=0;

    private boolean ativo;
    private int id;

    public Estore() {
        this.id = ID++;
        this.ativo = false;
    }

    public void open(){
        if(this.ativo==false){
            this.ativo=true;
            System.out.println(id + " - Abrir estore");
        }else {
            System.out.println(id + " - O estore já se encontra aberto");
        }
    }

    public void close(){
        if(this.ativo==false){
            this.ativo=false;
            System.out.println(id + " - Fechar estore");
        }else {
            System.out.println(id + " - O estore já se encontra fechado");
        }
    }

}
