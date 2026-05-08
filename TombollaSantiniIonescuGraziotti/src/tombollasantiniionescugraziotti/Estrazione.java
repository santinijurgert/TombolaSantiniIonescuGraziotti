/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tombollasantiniionescugraziotti;

/**
 *
 * @author santini.juri
 */
import java.time.LocalDateTime;

public class Estrazione {
    private int estId;
    private LocalDateTime estTimestamp;
    private int estNumeroEstratto;
    private int parId;

    // Costruttore vuoto
    public Estrazione() {
    }

    // Costruttore completo
    public Estrazione(int estId, LocalDateTime estTimestamp, int estNumeroEstratto, int parId) {
        this.estId = estId;
        this.estTimestamp = estTimestamp;
        this.estNumeroEstratto = estNumeroEstratto;
        this.parId = parId;
    }

    // Getter e Setter
    public int getEstId() {
        return estId;
    }

    public void setEstId(int estId) {
        this.estId = estId;
    }

    public LocalDateTime getEstTimestamp() {
        return estTimestamp;
    }

    public void setEstTimestamp(LocalDateTime estTimestamp) {
        this.estTimestamp = estTimestamp;
    }

    public int getEstNumeroEstratto() {
        return estNumeroEstratto;
    }

    public void setEstNumeroEstratto(int estNumeroEstratto) {
        this.estNumeroEstratto = estNumeroEstratto;
    }

    public int getParId() {
        return parId;
    }

    public void setParId(int parId) {
        this.parId = parId;
    }

    @Override
    public String toString() {
        return "Estrazione{" +
                "estId=" + estId +
                ", estTimestamp=" + estTimestamp +
                ", estNumeroEstratto=" + estNumeroEstratto +
                ", parId=" + parId +
                '}';
    }
}
