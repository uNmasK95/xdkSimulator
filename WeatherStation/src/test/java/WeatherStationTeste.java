import Original.WeatherStationO;
import Refatoring.WeatherStation;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Vector;

import static org.junit.Assert.assertEquals;

/**
 * Created by rjaf on 23/11/2016.
 */
public class WeatherStationTeste {

    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        Vector<Integer> xdk1_reading_1= new Vector<>();
        xdk1_reading_1.add(23);
        xdk1_reading_1.add(2);
        xdk1_reading_1.add(3);
        xdk1_reading_1.add(54);
        xdk1_reading_1.add(32);

        Vector<Integer> xdk1_reading_2= new Vector<>();
        xdk1_reading_2.add(22);
        xdk1_reading_2.add(24);
        xdk1_reading_2.add(3);
        xdk1_reading_2.add(4);
        xdk1_reading_2.add(5);

        WeatherStation iot = new WeatherStation();
        // simular a recepção de valores
        iot.update(1, xdk1_reading_1);
        iot.update(1, xdk1_reading_2);

        // assert statements
        assertEquals("Tempertura Actual: 22", iot.mostra_temperatura());
        int[] tesge = {2,2};
        assertEquals(new Integer[]{23,22} , iot.mostra_max_minimo(LocalDate.now(), 0) );
        assertEquals(new Integer[]{24,2}  , iot.mostra_max_minimo(LocalDate.now(), 1) );
        assertEquals(new Integer[]{3,3}   , iot.mostra_max_minimo(LocalDate.now(), 2) );
        assertEquals(new Integer[]{54,4}  , iot.mostra_max_minimo(LocalDate.now(), 3) );
        assertEquals(new Integer[]{32,5}  , iot.mostra_max_minimo(LocalDate.now(), 4));
        assertEquals( 3 , iot.mostra_presao_atm());
        assertEquals( 24, iot.mostra_humidade());
        assertEquals( 22, iot.mostra_media(LocalDate.now(),0));
        //assertEquals(new Integer[][]{}{23,22}  , iot.mostra_ultimos_dias(0,2));

    }

}
