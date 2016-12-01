package Refatoring;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by pedro on 01-12-2016.
 */
public class WeatherModel {


    public static final int idTemperatura = 0;
    public static final int idHumidade = 1;
    public static final int idPressao_atm = 2;
    public static final int idAudio = 3;
    public static final int idLuminosidade = 4;

    /**  Data objects
     *
     * Registos do valor de temperaturas
     * Registos do valor de humidade
     * Registos do valor de pressão atmosférica
     * Registos de audio
     * Registos de luminosidade
     * */

    HashMap<LocalDate,Vector<Integer>> temperatura;
    HashMap<LocalDate,Vector<Integer>> humidade;
    HashMap<LocalDate,Vector<Integer>> pressao_atm;
    HashMap<LocalDate,Vector<Integer>> audio;
    HashMap<LocalDate,Vector<Integer>> luminosidade;

    public WeatherModel() {

        this.humidade = new HashMap<LocalDate,Vector<Integer>>();
        this.temperatura = new HashMap<LocalDate,Vector<Integer>>();
        this.audio = new HashMap<LocalDate,Vector<Integer>>();
        this.luminosidade = new HashMap<LocalDate,Vector<Integer>>();
        this.pressao_atm = new HashMap<LocalDate,Vector<Integer>>();
    }

    public void update(int id, Vector<Integer> values){

        if(id == 1) {

            updateXDKsensor(values.elementAt(idTemperatura),this.temperatura);

            updateXDKsensor(values.elementAt(idHumidade), this.humidade);

            updateXDKsensor(values.elementAt(idPressao_atm), this.pressao_atm);

            updateXDKsensor(values.elementAt(idAudio), this.audio);

            updateXDKsensor(values.elementAt(idLuminosidade), this.luminosidade);
        }
    }
    // VERIFICAR SE PODEMOS ALTERAR O METODO DE ADD DELE.
    private void updateXDKsensor(Integer value, HashMap<LocalDate,Vector<Integer>> sensor_historico ){
        if (sensor_historico.get(LocalDate.now()) != null){
            Vector<Integer> val_temp = sensor_historico.get(LocalDate.now());
            val_temp.add(value);
        } else
        {
            Vector<Integer> new_vector  =  new Vector<Integer>();
            new_vector.add(value);
            sensor_historico.put(LocalDate.now(), new_vector);
        }
    }

    public int getIdTemperatura(){
        return idTemperatura;
    }
    public int getIdHumidade(){
        return idHumidade;
    }
    public int getIdPressao_atm(){
        return idPressao_atm;
    }
    public int getIdAudio(){
        return idAudio;
    }
    public int getIdLuminosidade(){
        return idLuminosidade;
    }


    public HashMap<LocalDate, Vector<Integer>> getTemperatura() {
        return temperatura;
    }

    public HashMap<LocalDate, Vector<Integer>> getHumidade() {
        return humidade;
    }

    public HashMap<LocalDate, Vector<Integer>> getPressao_atm() {
        return pressao_atm;
    }

    public HashMap<LocalDate, Vector<Integer>> getAudio() {
        return audio;
    }

    public HashMap<LocalDate, Vector<Integer>> getLuminosidade() {
        return luminosidade;
    }

}
