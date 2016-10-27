/**
 * Created by rjaf on 27/10/2016.
 */
public interface Subject {


    //colocamos aqui a condição para que no caso de queremos evoluir/ adicionar novos parametros á condição não precisams de andar a mudar estes metodos
    public void registerAtenuador(Condicao c, Atuador a );
    public void removeAtenuar(Condicao c, Atuador a );
    public void executeComand();

}
