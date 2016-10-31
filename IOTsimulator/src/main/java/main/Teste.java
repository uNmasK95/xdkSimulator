package main;


import main.Object.*;
import main.Object.Comandos.*;

/**
 * Created by rjaf on 27/10/2016.
 */
public class Teste {

    public static void main(String[] args){

        TemperatureXDK temp = new TemperatureXDK(5000);
        LuminosidadeXDK luz = new LuminosidadeXDK(5000);

        ControlerAtuador controler = new ControlerAtuador();

        temp.registerObserver(controler);
        luz.registerObserver(controler);


        Arcondicionado ar = new Arcondicionado();
        Arcondicionado ar2 = new Arcondicionado();

        controler.registerAtenuador(new CondicaoAtuador(new DesligarArcondicionado(ar), XDKtype.Temperatura, '>',30));
        controler.registerAtenuador(new CondicaoAtuador(new LigarArcondicionado(ar), XDKtype.Temperatura, '<',25) );

        controler.registerAtenuador(new CondicaoAtuador(new DesligarArcondicionado(ar2), XDKtype.Temperatura, '>',35));
        controler.registerAtenuador(new CondicaoAtuador(new LigarArcondicionado(ar2), XDKtype.Temperatura, '<',30));

        Estore es1 = new Estore();
        Estore es2 = new Estore();

        controler.registerAtenuador(new CondicaoAtuador(new AbrirEstore(es1), XDKtype.Luminosidade, '>',50));
        controler.registerAtenuador(new CondicaoAtuador(new FecharEstore(es1), XDKtype.Luminosidade, '<',45));

        controler.registerAtenuador(new CondicaoAtuador(new AbrirEstore(es2), XDKtype.Luminosidade, '>',55));
        controler.registerAtenuador(new CondicaoAtuador(new FecharEstore(es2), XDKtype.Luminosidade, '<',45));





    }
}
