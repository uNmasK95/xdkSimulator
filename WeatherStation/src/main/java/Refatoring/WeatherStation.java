package Refatoring;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by "amateur programmer”
 */
public class WeatherStation implements WeatherObserver {

    public static int idTemperatura = 0;
    public static int idHumidade = 1;
    public static int idPressao_atm = 2;
    public static int idAudio = 3;
    public static int idLuminosidade = 4;

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

    public WeatherStation() {

        this.humidade = new HashMap<LocalDate,Vector<Integer>>();
        this.temperatura = new HashMap<LocalDate,Vector<Integer>>();
        this.audio = new HashMap<LocalDate,Vector<Integer>>();
        this.luminosidade = new HashMap<LocalDate,Vector<Integer>>();
        this.pressao_atm = new HashMap<LocalDate,Vector<Integer>>();
    }

    /**
     * A estção meteriologica recebe updates dos sensores e armazena os valores na estrutura de dados respectiva.
     * @param id identificador do sensor Refatoring.XDK
     * @param values parametros lidos pelo sensor
     *               posição 0 : temperatura
     *               posição 1 : humidade
     *               posição 2 : pressão atmosféria
     *               posição 3 : audio
     *               posição 4 : luminosidade
     *
     */
    @Override
    public void update(int id, Vector<Integer> values){

        if(id == 1) {

            updateXDKsensor(values.elementAt(idTemperatura), this.temperatura);

            updateXDKsensor(values.elementAt(idHumidade), this.humidade);

            updateXDKsensor(values.elementAt(idPressao_atm), this.pressao_atm);

            updateXDKsensor(values.elementAt(idAudio), this.audio);

            updateXDKsensor(values.elementAt(idLuminosidade), this.luminosidade);
        }
    }

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

    /**
     * Funcionalidade: Mostrar os valores mais recentes dos sensores
     * @return print da temperatura
     */

    private int mostrar(HashMap<LocalDate,Vector<Integer>> sensor_historico){
        int i = -100;
        if (sensor_historico.containsKey(LocalDate.now())){
            int size = sensor_historico.get(LocalDate.now()).size();
            i = sensor_historico.get(LocalDate.now()).elementAt(size-1);
        }
        return i;
    }

    public int mostra_temperatura(){
        return mostrar(this.temperatura);
    }

    public int mostra_humidade(){
        return mostrar(this.humidade);
    }

    public int mostra_presao_atm(){
        return mostrar(this.pressao_atm);
    }

    public int  mostra_audio(){
        return mostrar(this.audio);
    }

    public int mostra_luminusidade(){
        return mostrar(this.luminosidade);
    }

    /**
     * Funcionalidade: mostra a média da temperatura para um determinado dia
     * @param data dia a considerar para a média
     * @param sensor sensor a calcular: 0 temperatura
     */
    public String mostra_media(LocalDate data, int sensor){

        switch (sensor) {
            case 0: //temperatura
                if (false != this.temperatura.containsKey(data)) {

                    int sum = 0;
                    for (Integer val : this.temperatura.get(data)) {
                        sum += val;
                    }

                    return "Média temperatura: " + sum/this.temperatura.get(data).size();
                }
                break;
            case 1: //temperatura
                if (false != this.humidade.containsKey(data)) {

                    int sum = 0;
                    for (Integer val : this.humidade.get(data)) {
                        sum += val;
                    }

                    return "Média humidade: " + sum/this.humidade.get(data).size();
                }
                break;
        }
        return null;
    }

    /**
     * Funcionalidade: Mostar os valores máximos e minimos de um determinado sensor para um determinado dia.
     * @param data dia a considerar para recolher o valor máximo e minímo
     * @param sensor valor do sensor a recolher: temperatura, humidade, pressão atm, audio, luminosidade
     */
    public String  mostra_max_minimo(LocalDate data, int sensor){

        switch (sensor) {
            case 0: //temperatura
                if ( false != this.temperatura.containsKey(data)){
                Vector<Integer> v = this.temperatura.get(data);
                    int max = Collections.max(v);
                    int min = Collections.min(v);
                    return "Max temperatura: "+max+" Min temperatura: "+min;
                }
                break;
            case 1: //humidade
                if ( false != this.humidade.containsKey(data)){
                    Vector<Integer> v = this.humidade.get(data);
                    int max = Collections.max(v);
                    int min = Collections.min(v);
                    return "Max humidade: "+max+" Min humidade: "+min;
                }
                break;
            case 2: //pressão atmosférica
                if ( false != this.pressao_atm.containsKey(data)){
                    Vector<Integer> v = this.pressao_atm.get(data);
                    int max = Collections.max(v);
                    int min = Collections.min(v);
                    return "Max pressão atmosférica: "+max+" Min pressão atmosférica: "+min;
                }
                break;
            case 3: //audio
                if ( false != this.audio.containsKey(data)){
                    Vector<Integer> v = this.audio.get(data);
                    int max = Collections.max(v);
                    int min = Collections.min(v);
                    return "Max Audio: "+max+" Min Audio: "+min;
                }
                break;
            case 4: //luminosidade
                if ( false != this.luminosidade.containsKey(data)){
                    Vector<Integer> v = this.luminosidade.get(data);
                    int max = Collections.max(v);
                    int min = Collections.min(v);
                    return "Max Luminosidade: "+max+" Min Luminosidade: "+min;
                }
                break;
            default:
                break;
        }
        return null;
    }

    /**
     * Mostrar dos ultimos X dias os valores máximos e minumos de um sensor
     * @param sensor sensor a mostrar
     * @param dias numero de dias a considerar desde a leitura mais actual.
     */
    public String mostra_ultimos_dias(int sensor, int dias) {

        int dias_counter = dias-1;
        HashMap<LocalDate, Vector<Integer>> last_values = new HashMap<LocalDate, Vector<Integer>>();
        Vector max_min_values = new Vector();
        switch (sensor) {
            case 0: //temperatura
                LocalDate today = LocalDate.now();
                while (dias_counter >= 0) {

                    if (false != this.temperatura.containsKey(today.minusDays(dias_counter))) {
                        Vector<Integer> temp_values = this.temperatura.get(today.minusDays(dias_counter));
                        max_min_values.add(Collections.max(temp_values));
                        max_min_values.add(Collections.min(temp_values));
                        last_values.put(today.minusDays(dias_counter), max_min_values);

                    }
                    dias_counter -= 1;
                }
                break;
        }
        return "Valores máximos e mínimos: "+last_values.toString();
    }


    public static void main(String args[]) {
        // Create a hash map

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
       // iot.update(1, xdk1_reading_1);
        //iot.update(1, xdk1_reading_2);

        // Views
        iot.mostra_temperatura();
        iot.mostra_max_minimo(LocalDate.now(), 0);
        iot.mostra_max_minimo(LocalDate.now(), 1);
        iot.mostra_max_minimo(LocalDate.now(), 2);
        iot.mostra_max_minimo(LocalDate.now(), 3);
        iot.mostra_max_minimo(LocalDate.now(), 4);
        iot.mostra_presao_atm();
        iot.mostra_humidade();
        iot.mostra_media(LocalDate.now(),0);
        iot.mostra_ultimos_dias(0,2);


    }

}
