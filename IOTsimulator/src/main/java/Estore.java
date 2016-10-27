/**
 * Created by rjaf on 27/10/2016.
 */
public class Estore {

    private boolean ativo;

    public Estore() {
        this.ativo = false;
    }

    public void open(){
        if(this.ativo==false){
            this.ativo=true;
            System.out.println("Abrir estore");
        }else {
            System.out.println("Já se encontra aberto");
        }
    }

    public void close(){
        if(this.ativo==false){
            this.ativo=false;
            System.out.println("Fechar estore");
        }else {
            System.out.println("Já se encontra fechado");
        }
    }

}
