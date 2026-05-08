/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tombollasantiniionescugraziotti;

/**
 *
 * @author santini.juri
 */
public class Cartella {
    private int carId;
    private String carCodice;
    private int carParId;
    private int carGioId;

    // Costruttore vuoto
    public Cartella() {
    }

    // Costruttore completo
    public Cartella(int carId, String carCodice, int carParId, int carGioId) {
        this.carId = carId;
        this.carCodice = carCodice;
        this.carParId = carParId;
        this.carGioId = carGioId;
    }

    // Getter e Setter
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarCodice() {
        return carCodice;
    }

    public void setCarCodice(String carCodice) {
        this.carCodice = carCodice;
    }

    public int getCarParId() {
        return carParId;
    }

    public void setCarParId(int carParId) {
        this.carParId = carParId;
    }

    public int getCarGioId() {
        return carGioId;
    }

    public void setCarGioId(int carGioId) {
        this.carGioId = carGioId;
    }

    @Override
    public String toString() {
        return "Cartella{" +
                "carId=" + carId +
                ", carCodice='" + carCodice + '\'' +
                ", carParId=" + carParId +
                ", carGioId=" + carGioId +
                '}';
    }
}
