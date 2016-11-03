package main;

import main.Object.Atuador;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by rjaf on 27/10/2016.
 */
public class CondicaoAtuador {

    private Atuador atuador;
    private XDKtype type;
    private float valor;
    private char simbolo;
    private Calendar inicio;
    private Calendar fim;

    public CondicaoAtuador(Atuador atuador, XDKtype type, char simbolo , float valor, int horaInicio, int minutosInicio, int horaFim, int minutosFim){
        this.atuador = atuador;
        this.type = type;
        this.valor = valor;
        this.simbolo = simbolo;

        this.inicio = Calendar.getInstance();
        this.inicio.set(Calendar.HOUR, horaInicio);
        this.inicio.set(Calendar.MINUTE, minutosInicio);

        this.fim = Calendar.getInstance();
        this.fim.set(Calendar.HOUR, horaFim);
        this.fim.set(Calendar.MINUTE, minutosFim);
    }

    public XDKtype getType() {
        return type;
    }

    public void setType(XDKtype type) {
        this.type = type;
    }

    public Atuador getAtuador() {
        return atuador;
    }

    public void setAtuador(Atuador atuador) {
        this.atuador = atuador;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * return true se o valor recebido verificar a condição
     * @param value
     * @return
     */
    public boolean validarCondicao(XDKtype type, float value, Calendar controler){
        boolean date = false;
        if(this.type==type){
            if(fim.after(inicio)){
                date = controler.after(inicio) && controler.before(fim);
            }else{
                date = controler.after(inicio) || controler.before(fim);
            }
            switch (this.simbolo) {
                case '>':
                    return value > this.valor && date;
                case '<':
                    return value < this.valor && date;
                case '=':
                    return value == this.valor && date;
            }
        }
        return false;
    }
}
