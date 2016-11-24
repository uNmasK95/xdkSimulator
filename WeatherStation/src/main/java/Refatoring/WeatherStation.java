package Refatoring;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by "amateur programmer”
 */
public class WeatherStation implements WeatherObserver {


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

    /**
     * Funcionalidade: retornar o último valor do sensor_historico do dia atual.
     * @param sensor_historico
     * @return int
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
            case idTemperatura:
                return mostra_media_temperatura(data);
            case idHumidade:
                return mostra_media_humidade(data);
        }
        return null;
    }

    private String mostra_media_temperatura(LocalDate data){
        if (false != this.temperatura.containsKey(data)) {
            return "Média temperatura: " + mostra_media_generico(data, this.temperatura);
        }
        return null;
    }

    private String mostra_media_humidade(LocalDate data){
        if (false != this.humidade.containsKey(data)) {
            return "Média humidade: " + mostra_media_generico(data, this.humidade);
        }
        return null;
    }

    private float mostra_media_generico(LocalDate data, HashMap<LocalDate,Vector<Integer>> sensor_historico){
        int sum = 0;
        for (Integer val : sensor_historico.get(data)) {
            sum += val;
        }
        return  sum/sensor_historico.get(data).size();
    }

    /**
     * Funcionalidade: Mostar os valores máximos e minimos de um determinado sensor para um determinado dia.
     * @param data dia a considerar para recolher o valor máximo e minímo
     * @param sensor valor do sensor a recolher: temperatura, humidade, pressão atm, audio, luminosidade
     */
    public String  mostra_max_minimo(LocalDate data, int sensor){
        switch (sensor) {
            case idTemperatura: //temperatura
                if ( false != this.temperatura.containsKey(data)){
                    return "Max temperatura: "+ mostra_max_minimo_generico(data,this.temperatura)[0] +" Min temperatura: "+ mostra_max_minimo_generico(data,this.temperatura)[1];
                }
                break;
            case idHumidade: //humidade
                if ( false != this.humidade.containsKey(data)){
                    return "Max humidade: "+mostra_max_minimo_generico(data,this.humidade)[0]+" Min humidade: "+mostra_max_minimo_generico(data,this.humidade)[1];
                }
                break;
            case idPressao_atm: //pressão atmosférica
                if ( false != this.pressao_atm.containsKey(data)){
                    return "Max pressão atmosférica: "+mostra_max_minimo_generico(data,this.pressao_atm)[0]+" Min pressão atmosférica: "+mostra_max_minimo_generico(data,this.temperatura)[1];
                }
                break;
            case idAudio: //audio
                if ( false != this.audio.containsKey(data)){
                    return "Max Audio: "+ mostra_max_minimo_generico(data,this.audio)[0] +" Min Audio: "+mostra_max_minimo_generico(data,this.audio)[1];
                }
                break;
            case idLuminosidade: //luminosidade
                if ( false != this.luminosidade.containsKey(data)){
                    return "Max Luminosidade: "+mostra_max_minimo_generico(data,this.luminosidade)[0]+" Min Luminosidade: "+mostra_max_minimo_generico(data,this.temperatura)[1];
                }
                break;
            default:
                break;
        }
        return null;
    }

    private Integer[] mostra_max_minimo_generico(LocalDate data, HashMap<LocalDate,Vector<Integer>> sensor_historico){
        Vector<Integer> v = sensor_historico.get(data);
        int max = Collections.max(v);
        int min = Collections.min(v);
        return new Integer[]{max,min};
    }

    /**
     * Mostrar dos ultimos X dias os valores máximos e minumos de um sensor
     * @param sensor sensor a mostrar
     * @param dias numero de dias a considerar desde a leitura mais actual.
     */
    public Map<LocalDate, Vector<Integer>> mostra_ultimos_dias(int sensor, int dias) {

        int dias_counter = dias-1;
        HashMap<LocalDate, Vector<Integer>> last_values = new HashMap<LocalDate, Vector<Integer>>();
        Vector max_min_values = new Vector();

        if(sensor==idTemperatura){
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
        }
        return last_values;
    }

}
