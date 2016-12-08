import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by "amateur programmer”
 */
public class WeatherStation implements WeatherObserver {


    private WeatherModel weatherModel;
    private WeatherView weatherView;

    public WeatherStation(WeatherModel weatherModel, WeatherView weatherView) {
        this.weatherModel = weatherModel;
        this.weatherView = weatherView;
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
        weatherModel.update(id,values);
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

    public String mostra_temperatura(){
        return  "Tempertura Actual: " + mostrar(weatherModel.getTemperatura());
    }

    public String mostra_humidade(){
        return "Humidade Actual: " + mostrar(weatherModel.getHumidade());
    }

    public String mostra_presao_atm(){
        return "pressao atmosférica actual: " + mostrar(weatherModel.getPressao_atm());
    }

    public String mostra_audio(){

        return "Audio actual: " + mostrar(weatherModel.getAudio());
    }

    public String mostra_luminusidade(){
        return "Luminosidade actual: " + mostrar(weatherModel.getLuminosidade());
    }
    public void mostra_temperatura_station(){
        weatherView.mostra_temperatura();
    }

    public void mostra_humidade_station(){
        weatherView.mostra_luminusidade();
    }

    public void mostra_presao_atm_station(){
        weatherView.mostra_luminusidade();
    }

    public void mostra_audio_station(){
        weatherView.mostra_luminusidade();
    }
    public void mostra_luminusidade_station(){
        weatherView.mostra_luminusidade();
    }
    /**
     * Funcionalidade: mostra a média da temperatura para um determinado dia
     * @param data dia a considerar para a média
     * @param sensor sensor a calcular: 0 temperatura
     */
    public String mostra_media(LocalDate data, int sensor){
        switch (sensor) {
            case WeatherModel.idTemperatura:
                return mostra_media_temperatura(data);
            case WeatherModel.idHumidade:
                return mostra_media_humidade(data);
        }
        return "";
    }

    private String mostra_media_temperatura(LocalDate data){
        if (false != weatherModel.getTemperatura().containsKey(data)) {
            return "Média temperatura: " + mostra_media_generico(data, weatherModel.getTemperatura());
        }
        return "";
    }

    public void mostra_media_temperatura_station(LocalDate date, int sensor){
        weatherView.mostra_media(date,sensor);
    }

    private String mostra_media_humidade(LocalDate data){
        if (false != weatherModel.getHumidade().containsKey(data)) {
            return "Média humidade: " + mostra_media_generico(data, weatherModel.getHumidade());
        }
        return "";
    }

    public void mostra_media_humidade_station(LocalDate date, int sensor){
        weatherView.mostra_media(date,sensor);
    }

    private int mostra_media_generico(LocalDate data, HashMap<LocalDate,Vector<Integer>> sensor_historico){
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
    public void mostra_max_minimo_station(LocalDate data, int sensor){
        weatherView.mostra_max_minimo(data,sensor);
    }

    public String  mostra_max_minimo(LocalDate data, int sensor){
        final int MAX = 0;
        final int MIN = 1;

        switch (sensor) {
            case WeatherModel.idTemperatura: //temperatura
                if ( false != weatherModel.getTemperatura().containsKey(data)){
                    return "Max temperatura: "+ mostra_max_minimo_generico(data,weatherModel.getTemperatura())[MAX] +
                            " Min temperatura: "+ mostra_max_minimo_generico(data,weatherModel.getTemperatura())[MIN];
                }
                break;
            case WeatherModel.idHumidade: //humidade
                if ( false != weatherModel.getHumidade().containsKey(data)){
                    return "Max humidade: "+mostra_max_minimo_generico(data,weatherModel.getHumidade())[MAX]+
                            " Min humidade: "+mostra_max_minimo_generico(data,weatherModel.getHumidade())[MIN];
                }
                break;
            case WeatherModel.idPressao_atm: //pressão atmosférica
                if ( false != weatherModel.getPressao_atm().containsKey(data)){
                    return "Max pressão atmosférica: "+mostra_max_minimo_generico(data,weatherModel.getPressao_atm())[MAX]+
                            " Min pressão atmosférica: "+mostra_max_minimo_generico(data,weatherModel.getPressao_atm())[MIN];
                }
                break;
            case WeatherModel.idAudio: //audio
                if ( false != weatherModel.getAudio().containsKey(data)){
                    return "Max Audio: "+ mostra_max_minimo_generico(data,weatherModel.getAudio())[MAX] +
                            " Min Audio: "+mostra_max_minimo_generico(data,weatherModel.getAudio())[MIN];
                }
                break;
            case WeatherModel.idLuminosidade: //luminosidade
                if ( false !=  weatherModel.getLuminosidade().containsKey(data)){
                    return "Max Luminosidade: "+mostra_max_minimo_generico(data,weatherModel.getLuminosidade())[MAX]+
                            " Min Luminosidade: "+mostra_max_minimo_generico(data,weatherModel.getLuminosidade())[MIN];
                }
                break;
            default:
                break;
        }
        return "";
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
    public String mostra_ultimos_dias(int sensor, int dias) {

        int dias_counter = dias-1;
        HashMap<LocalDate, Vector<Integer>> last_values = new HashMap<LocalDate, Vector<Integer>>();
        Vector max_min_values = new Vector();

        if(sensor==WeatherModel.idTemperatura){
            LocalDate today = LocalDate.now();
            while (dias_counter >= 0) {

                if (false != weatherModel.getTemperatura().containsKey(today.minusDays(dias_counter))) {
                    Vector<Integer> temp_values = weatherModel.getTemperatura().get(today.minusDays(dias_counter));
                    max_min_values.add(Collections.max(temp_values));
                    max_min_values.add(Collections.min(temp_values));
                    last_values.put(today.minusDays(dias_counter), max_min_values);

                }
                dias_counter -= 1;
            }
        }
        return "Valores máximos e mínimos: " + last_values.toString();
    }

    public void mostra_ultimos_dias_station(int sensor, int dias){
        weatherView.mostra_ultimos_dias(sensor,dias);
    }

}
