import Refatoring.WeatherModel;
import Refatoring.WeatherStation;
import Refatoring.WeatherView;
import Refatoring.XDK;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Vector;

import static org.junit.Assert.assertEquals;

/**
 * Created by rjaf on 23/11/2016.
 */
public class WeatherStationTeste {

    @Parameterized.Parameter
    Vector<Integer> xdk1_reading_1= new Vector<>();

    @Parameterized.Parameter
    Vector<Integer> xdk1_reading_2= new Vector<>();

    @Parameterized.Parameter
    HashMap<LocalDate, Vector<Integer>> last_values = new HashMap<LocalDate, Vector<Integer>>();


    @Test
    public void xdkTesteReading1_2() {

        xdk1_reading_1.add(23);
        xdk1_reading_1.add(2);
        xdk1_reading_1.add(3);
        xdk1_reading_1.add(54);
        xdk1_reading_1.add(32);

        xdk1_reading_2.add(22);
        xdk1_reading_2.add(24);
        xdk1_reading_2.add(3);
        xdk1_reading_2.add(4);
        xdk1_reading_2.add(5);

        WeatherStation iot = new WeatherStation();
        XDK xdk1 = new XDK(iot,1);

        xdk1.start(xdk1_reading_1);
        xdk1.start(xdk1_reading_2);

        // assert statements
        assertEquals(22, iot.mostra_temperatura());
        assertEquals("Max temperatura: 23 Min temperatura: 22" , iot.mostra_max_minimo(LocalDate.now(), WeatherModel.idTemperatura) );
        assertEquals("Max humidade: 24 Min humidade: 2"  , iot.mostra_max_minimo(LocalDate.now(), WeatherModel.idHumidade) );
        assertEquals("Max pressão atmosférica: 3 Min pressão atmosférica: 3", iot.mostra_max_minimo(LocalDate.now(), WeatherModel.idPressao_atm) );

        assertEquals("Max Audio: 54 Min Audio: 4" , iot.mostra_max_minimo(LocalDate.now(), WeatherModel.idAudio) );

        assertEquals("Max Luminosidade: 32 Min Luminosidade: 5"  , iot.mostra_max_minimo(LocalDate.now(), WeatherModel.idLuminosidade));
        assertEquals( 3 , iot.mostra_presao_atm());
        assertEquals( 24, iot.mostra_humidade());

        assertEquals( "Média temperatura: 22", iot.mostra_media(LocalDate.now(),0));

        Vector max_min_values = new Vector();
        max_min_values.add(23);
        max_min_values.add(22);
        last_values.put(LocalDate.now(),max_min_values);

        assertEquals(last_values , iot.mostra_ultimos_dias(0,2));

    }


    @Test
    public void xdkTesteReading() {

        xdk1_reading_1.add(23);
        xdk1_reading_1.add(2);
        xdk1_reading_1.add(3);
        xdk1_reading_1.add(54);
        xdk1_reading_1.add(32);

        xdk1_reading_2.add(22);
        xdk1_reading_2.add(24);
        xdk1_reading_2.add(3);
        xdk1_reading_2.add(4);
        xdk1_reading_2.add(5);

        WeatherStation iot = new WeatherStation();
        XDK xdk1 = new XDK(iot,1);

        xdk1.start(xdk1_reading_1);
        xdk1.start(xdk1_reading_2);

        WeatherView view = new WeatherView(iot);


    }
}
