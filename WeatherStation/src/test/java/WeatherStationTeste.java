import Refatoring.WeatherModel;
import Refatoring.WeatherStation;
import Refatoring.WeatherView;
import Refatoring.XDK;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Vector;

import static org.junit.Assert.assertEquals;

/**
 * Created by rjaf on 23/11/2016.
 */
public class WeatherStationTeste {

    @Parameterized.Parameter
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Parameterized.Parameter
    Vector<Integer> xdk1_reading_1= new Vector<>();

    @Parameterized.Parameter
    Vector<Integer> xdk1_reading_2= new Vector<>();

    @Parameterized.Parameter
    HashMap<LocalDate, Vector<Integer>> last_values = new HashMap<LocalDate, Vector<Integer>>();

    @Parameterized.Parameter
    WeatherModel wModel = new WeatherModel();

    @Parameterized.Parameter
    WeatherStation wStation = new WeatherStation(wModel);

    @Parameterized.Parameter
    WeatherView wView = new WeatherView(wStation);


    @Before
    public void xdkReading1_2() {

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

        XDK xdk1 = new XDK(wStation,1);

        xdk1.start(xdk1_reading_1);
        xdk1.start(xdk1_reading_2);
    }


    @Test
    public void mostra_temperaturaTeste(){
        wView.mostra_temperatura();
        assertEquals("Tempertura Actual: 22\n",outContent.toString());
    }

    @Test
    public void mostra_presao_atmTeste(){
        wView.mostra_presao_atm();
        assertEquals("pressao atmosférica actual: 3\n"  , outContent.toString());
    }

    @Test
    public void mostra_humidadeTeste(){
        wView.mostra_humidade();
        assertEquals("Humidade Actual: 24\n"  , outContent.toString());
    }

    @Test
    public void mostra_max_minimo_temperaturaTeste(){
        wView.mostra_max_minimo(LocalDate.now(), WeatherModel.idTemperatura);
        assertEquals("Max temperatura: 23 Min temperatura: 22\n" , outContent.toString());
    }

    @Test
    public void mostra_max_minimo_humidadeTeste(){
        wView.mostra_max_minimo(LocalDate.now(), WeatherModel.idHumidade);
        assertEquals("Max humidade: 24 Min humidade: 2\n"  , outContent.toString() );
    }

    @Test
    public void mostra_max_minimo_pressãoTeste(){
        wView.mostra_max_minimo(LocalDate.now(), WeatherModel.idPressao_atm);
        assertEquals("Max pressão atmosférica: 3 Min pressão atmosférica: 3\n", outContent.toString() );
    }

    @Test
    public void mostra_max_minimo_audioTeste(){
        wView.mostra_max_minimo(LocalDate.now(), WeatherModel.idAudio);
        assertEquals("Max Audio: 54 Min Audio: 4\n", outContent.toString() );
    }

    @Test
    public void mostra_max_minimo_luminosidadeTeste(){
        wView.mostra_max_minimo(LocalDate.now(), WeatherModel.idLuminosidade);
        assertEquals("Max Luminosidade: 32 Min Luminosidade: 5\n"  , outContent.toString());
    }

    @Test
    public void mostra_mediaTeste(){
        wView.mostra_media(LocalDate.now(),0);
        assertEquals( "Média temperatura: 22\n", outContent.toString() );
    }

    @Test
    public void mostra_ultimos_dias(){
        wView.mostra_ultimos_dias(0,2);
        assertEquals("Valores máximos e mínimos: {2016-12-07=[23, 22]}\n" , outContent.toString() );
    }

}
