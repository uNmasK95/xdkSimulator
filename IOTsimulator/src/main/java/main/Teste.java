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

        controler.registerAtuador(new CondicaoAtuador(new DesligarArcondicionado(ar), XDKtype.Temperatura, '>',30, 4 , 0 , 0 , 30 ));
        controler.registerAtuador(new CondicaoAtuador(new LigarArcondicionado(ar), XDKtype.Temperatura, '<', 30 , 0 , 30 , 4 , 0) );

        controler.registerAtuador(new CondicaoAtuador(new DesligarArcondicionado(ar2), XDKtype.Temperatura, '>',35 , 1 , 0 , 3 , 30 ));
        controler.registerAtuador(new CondicaoAtuador(new LigarArcondicionado(ar2), XDKtype.Temperatura, '<',30, 1, 0 , 3 , 30));

        Estore es1 = new Estore();
        Estore es2 = new Estore();


        controler.registerAtuador(new CondicaoAtuador(new AbrirEstore(es1), XDKtype.Luminosidade, '>',50 , 12 , 0 , 14 , 0));
        controler.registerAtuador(new CondicaoAtuador(new FecharEstore(es1), XDKtype.Luminosidade, '<',45, 12 , 0 , 14 , 0));

        controler.registerAtuador(new CondicaoAtuador(new AbrirEstore(es2), XDKtype.Luminosidade, '>',55, 8 ,0 ,11, 0));
        controler.registerAtuador(new CondicaoAtuador(new FecharEstore(es2), XDKtype.Luminosidade, '<',45, 8, 0 ,11 ,0));


    }
}
