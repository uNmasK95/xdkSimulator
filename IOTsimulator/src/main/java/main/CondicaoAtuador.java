package main;

import main.Object.Atuador;

/**
 * Created by rjaf on 27/10/2016.
 */
public class CondicaoAtuador {

    private Atuador atuador;
    private XDKtype type;
    private float valor;
    private char simbolo;
    private int horaInicio;
    private int minutosInicio;
    private int horaFim;
    private int minutosFim;

    public CondicaoAtuador(Atuador atuador, XDKtype type, char simbolo , float valor, int horaInicio, int minutosInicio, int horaFim, int minutosFim){
        this.atuador = atuador;
        this.type = type;
        this.valor = valor;
        this.simbolo = simbolo;

        this.horaInicio = horaInicio;
        this.minutosInicio = minutosInicio;
        this.horaFim = horaFim;
        this.minutosFim = minutosFim;

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
    public boolean validarCondicao(XDKtype type, float value, /*int horaControler, int minutosContoler*/){
        if(this.type==type){
            if(horaFim > horaInicio){

            }else{
            }
            switch (this.simbolo) {
                case '>':
                    return value > this.valor;
                case '<':
                    return value < this.valor;
                case '=':
                    return value == this.valor;
            }
        }
        return false;
    }
}
