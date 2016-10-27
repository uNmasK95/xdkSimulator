/**
 * Created by rjaf on 27/10/2016.
 */
public class Condicao {
    private float valor;
    private char simbolo;

    public Condicao(char simbolo , float valor){
        this.valor = valor;
        this.simbolo = simbolo;
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

    @Override
    public boolean equals(Object obj) {
        Condicao c = (Condicao) obj;
        return this.valor == c.valor && this.simbolo == c.simbolo;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * return true se o valor recebido verificar a condição
     * @param value
     * @return
     */
    public boolean validCondicao(float value){
        switch (this.simbolo) {
            case '>':
                return value > this.valor;
            case '<':
                return value < this.valor;
            case '=':
                return value == this.valor;
            default:
                return false;
        }
    }
}
