/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tombollasantiniionescugraziotti;

/**
 *
 * @author santini.juri
 */
public class Giocatore {
    private int gioId;
    private String gioNome;
    private String gioCognome;
    private String gioUsername;

    // Costruttore vuoto
    public Giocatore() {
    }

    // Costruttore completo
    public Giocatore(int gioId, String gioNome, String gioCognome, String gioUsername) {
        this.gioId = gioId;
        this.gioNome = gioNome;
        this.gioCognome = gioCognome;
        this.gioUsername = gioUsername;
    }

    // Getter e Setter
    public int getGioId() {
        return gioId;
    }

    public void setGioId(int gioId) {
        this.gioId = gioId;
    }

    public String getGioNome() {
        return gioNome;
    }

    public void setGioNome(String gioNome) {
        this.gioNome = gioNome;
    }

    public String getGioCognome() {
        return gioCognome;
    }

    public void setGioCognome(String gioCognome) {
        this.gioCognome = gioCognome;
    }

    public String getGioUsername() {
        return gioUsername;
    }

    public void setGioUsername(String gioUsername) {
        this.gioUsername = gioUsername;
    }

    @Override
    public String toString() {
        return "Giocatore{" +
                "gioId=" + gioId +
                ", gioNome='" + gioNome + '\'' +
                ", gioCognome='" + gioCognome + '\'' +
                ", gioUsername='" + gioUsername + '\'' +
                '}';
    }
}
