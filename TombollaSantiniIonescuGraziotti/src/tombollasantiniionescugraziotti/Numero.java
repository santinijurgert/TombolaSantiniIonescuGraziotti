/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tombollasantiniionescugraziotti;

/**
 *
 * @author santini.juri
 */
public class Numero {
    private int numId;
    private int numNumero;
    private int numCarId;

    // Costruttore vuoto
    public Numero() {
    }

    // Costruttore completo
    public Numero(int numId, int numNumero, int numCarId) {
        this.numId = numId;
        this.numNumero = numNumero;
        this.numCarId = numCarId;
    }

    // Getter e Setter
    public int getNumId() {
        return numId;
    }

    public void setNumId(int numId) {
        this.numId = numId;
    }

    public int getNumNumero() {
        return numNumero;
    }

    public void setNumNumero(int numNumero) {
        this.numNumero = numNumero;
    }

    public int getNumCarId() {
        return numCarId;
    }

    public void setNumCarId(int numCarId) {
        this.numCarId = numCarId;
    }

    @Override
    public String toString() {
        return "Numero{" +
                "numId=" + numId +
                ", numNumero=" + numNumero +
                ", numCarId=" + numCarId +
                '}';
    }
}
