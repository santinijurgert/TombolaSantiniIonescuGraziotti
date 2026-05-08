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

public class Tombolata {
    private int parId;
    private LocalDateTime parDataOraInizio;
    private LocalDateTime parDataOraFine;
    private String parStato;
    private int parGioId;

    // Costruttore vuoto
    public Tombolata() {
    }

    // Costruttore completo
    public Tombolata(int parId, LocalDateTime parDataOraInizio, LocalDateTime parDataOraFine, 
                     String parStato, int parGioId) {
        this.parId = parId;
        this.parDataOraInizio = parDataOraInizio;
        this.parDataOraFine = parDataOraFine;
        this.parStato = parStato;
        this.parGioId = parGioId;
    }

    // Getter e Setter
    public int getParId() {
        return parId;
    }

    public void setParId(int parId) {
        this.parId = parId;
    }

    public LocalDateTime getParDataOraInizio() {
        return parDataOraInizio;
    }

    public void setParDataOraInizio(LocalDateTime parDataOraInizio) {
        this.parDataOraInizio = parDataOraInizio;
    }

    public LocalDateTime getParDataOraFine() {
        return parDataOraFine;
    }

    public void setParDataOraFine(LocalDateTime parDataOraFine) {
        this.parDataOraFine = parDataOraFine;
    }

    public String getParStato() {
        return parStato;
    }

    public void setParStato(String parStato) {
        this.parStato = parStato;
    }

    public int getParGioId() {
        return parGioId;
    }

    public void setParGioId(int parGioId) {
        this.parGioId = parGioId;
    }

    @Override
    public String toString() {
        return "Tombolata{" +
                "parId=" + parId +
                ", parDataOraInizio=" + parDataOraInizio +
                ", parDataOraFine=" + parDataOraFine +
                ", parStato='" + parStato + '\'' +
                ", parGioId=" + parGioId +
                '}';
    }
}
