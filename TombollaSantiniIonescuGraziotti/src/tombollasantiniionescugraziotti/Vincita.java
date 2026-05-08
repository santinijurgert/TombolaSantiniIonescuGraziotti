/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tombollasantiniionescugraziotti;

/**
 *
 * @author santini.juri
 */
import java.math.BigDecimal;

public class Vincita {
    private int vinId;
    private String vinTipo;
    private BigDecimal vinImporto;
    private int carId;

    // Costruttore vuoto
    public Vincita() {
    }

    // Costruttore completo
    public Vincita(int vinId, String vinTipo, BigDecimal vinImporto, int carId) {
        this.vinId = vinId;
        this.vinTipo = vinTipo;
        this.vinImporto = vinImporto;
        this.carId = carId;
    }

    // Getter e Setter
    public int getVinId() {
        return vinId;
    }

    public void setVinId(int vinId) {
        this.vinId = vinId;
    }

    public String getVinTipo() {
        return vinTipo;
    }

    public void setVinTipo(String vinTipo) {
        this.vinTipo = vinTipo;
    }

    public BigDecimal getVinImporto() {
        return vinImporto;
    }

    public void setVinImporto(BigDecimal vinImporto) {
        this.vinImporto = vinImporto;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "Vincita{" +
                "vinId=" + vinId +
                ", vinTipo='" + vinTipo + '\'' +
                ", vinImporto=" + vinImporto +
                ", carId=" + carId +
                '}';
    }
}
