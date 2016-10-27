/**
 * Created by rjaf on 27/10/2016.
 */
public class Teste {

    public static void main(String[] args){

        TemperatureXDK temp = new TemperatureXDK(5000);
        //LuminosidadeXDK luz = new LuminosidadeXDK(1000);

        Arcondicionado ar = new Arcondicionado();
        Arcondicionado ar2 = new Arcondicionado();

        temp.registerAtenuador(new Condicao('>',30),new DesligarArcondicionado(ar));
        temp.registerAtenuador(new Condicao('>',30), new LigarArcondicionado(ar2));
        temp.registerAtenuador(new Condicao('<',20), new LigarArcondicionado(ar));

    }
}
