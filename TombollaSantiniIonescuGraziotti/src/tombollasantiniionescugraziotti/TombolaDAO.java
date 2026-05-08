/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tombollasantiniionescugraziotti;

/**
 *
 * @author santini.juri
 */
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TombolaDAO {
    private Connection connection;

    public TombolaDAO(Connection connection) {
        this.connection = connection;
    }

    // Metodi per Giocatore
    public Giocatore getGiocatoreById(int gioId) throws SQLException {
        String query = "SELECT * FROM giocatore WHERE GIO_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, gioId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Giocatore(rs.getInt("GIO_ID"), rs.getString("GIO_nome"),
                        rs.getString("GIO_cognome"), rs.getString("GIO_username"));
            }
        }
        return null;
    }

    public List<Giocatore> getAllGiocatori() throws SQLException {
        List<Giocatore> giocatori = new ArrayList<>();
        String query = "SELECT * FROM giocatore";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                giocatori.add(new Giocatore(rs.getInt("GIO_ID"), rs.getString("GIO_nome"),
                        rs.getString("GIO_cognome"), rs.getString("GIO_username")));
            }
        }
        return giocatori;
    }

    public void addGiocatore(Giocatore giocatore) throws SQLException {
        String query = "INSERT INTO giocatore (GIO_nome, GIO_cognome, GIO_username) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, giocatore.getGioNome());
            stmt.setString(2, giocatore.getGioCognome());
            stmt.setString(3, giocatore.getGioUsername());
            stmt.executeUpdate();
        }
    }

    // Metodi per Tombolata
    public Tombolata getTombolataById(int parId) throws SQLException {
        String query = "SELECT * FROM tombolata WHERE PAR_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, parId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Tombolata(rs.getInt("PAR_ID"), 
                        rs.getTimestamp("PAR_data_ora_inizio").toLocalDateTime(),
                        rs.getTimestamp("PAR_data_ora_fine") != null ? 
                            rs.getTimestamp("PAR_data_ora_fine").toLocalDateTime() : null,
                        rs.getString("PAR_stato"), rs.getInt("PAR_GIO_ID"));
            }
        }
        return null;
    }

    public List<Tombolata> getAllTombolate() throws SQLException {
        List<Tombolata> tombolate = new ArrayList<>();
        String query = "SELECT * FROM tombolata";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                tombolate.add(new Tombolata(rs.getInt("PAR_ID"),
                        rs.getTimestamp("PAR_data_ora_inizio").toLocalDateTime(),
                        rs.getTimestamp("PAR_data_ora_fine") != null ? 
                            rs.getTimestamp("PAR_data_ora_fine").toLocalDateTime() : null,
                        rs.getString("PAR_stato"), rs.getInt("PAR_GIO_ID")));
            }
        }
        return tombolate;
    }

    public void addTombolata(Tombolata tombolata) throws SQLException {
        String query = "INSERT INTO tombolata (PAR_data_ora_inizio, PAR_data_ora_fine, PAR_stato, PAR_GIO_ID) " +
                "VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setTimestamp(1, Timestamp.valueOf(tombolata.getParDataOraInizio()));
            stmt.setTimestamp(2, tombolata.getParDataOraFine() != null ? 
                    Timestamp.valueOf(tombolata.getParDataOraFine()) : null);
            stmt.setString(3, tombolata.getParStato());
            stmt.setInt(4, tombolata.getParGioId());
            stmt.executeUpdate();
        }
    }

    // Metodi per Cartella
    public Cartella getCartellaById(int carId) throws SQLException {
        String query = "SELECT * FROM cartella WHERE CAR_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, carId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cartella(rs.getInt("CAR_ID"), rs.getString("CAR_codice"),
                        rs.getInt("CAR_PAR_ID"), rs.getInt("CAR_GIO_ID"));
            }
        }
        return null;
    }

    public List<Cartella> getCartelleByTombolata(int parId) throws SQLException {
        List<Cartella> cartelle = new ArrayList<>();
        String query = "SELECT * FROM cartella WHERE CAR_PAR_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, parId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cartelle.add(new Cartella(rs.getInt("CAR_ID"), rs.getString("CAR_codice"),
                        rs.getInt("CAR_PAR_ID"), rs.getInt("CAR_GIO_ID")));
            }
        }
        return cartelle;
    }

    public void addCartella(Cartella cartella) throws SQLException {
        String query = "INSERT INTO cartella (CAR_codice, CAR_PAR_ID, CAR_GIO_ID) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, cartella.getCarCodice());
            stmt.setInt(2, cartella.getCarParId());
            stmt.setInt(3, cartella.getCarGioId());
            stmt.executeUpdate();
        }
    }

    // Metodi per Numero
    public List<Numero> getNumeriByCartella(int carId) throws SQLException {
        List<Numero> numeri = new ArrayList<>();
        String query = "SELECT * FROM numero WHERE NUM_CAR_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, carId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                numeri.add(new Numero(rs.getInt("NUM_ID"), rs.getInt("NUM_numero"),
                        rs.getInt("NUM_CAR_ID")));
            }
        }
        return numeri;
    }

    public void addNumero(Numero numero) throws SQLException {
        String query = "INSERT INTO numero (NUM_numero, NUM_CAR_ID) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, numero.getNumNumero());
            stmt.setInt(2, numero.getNumCarId());
            stmt.executeUpdate();
        }
    }

    // Metodi per Estrazione
    public List<Estrazione> getEstrazioniByTombolata(int parId) throws SQLException {
        List<Estrazione> estrazioni = new ArrayList<>();
        String query = "SELECT * FROM estrazione WHERE PAR_ID = ? ORDER BY EST_timestamp";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, parId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                estrazioni.add(new Estrazione(rs.getInt("EST_ID"),
                        rs.getTimestamp("EST_timestamp").toLocalDateTime(),
                        rs.getInt("EST_numero_estratto"), rs.getInt("PAR_ID")));
            }
        }
        return estrazioni;
    }

    public void addEstrazione(Estrazione estrazione) throws SQLException {
        String query = "INSERT INTO estrazione (EST_timestamp, EST_numero_estratto, PAR_ID) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setTimestamp(1, Timestamp.valueOf(estrazione.getEstTimestamp()));
            stmt.setInt(2, estrazione.getEstNumeroEstratto());
            stmt.setInt(3, estrazione.getParId());
            stmt.executeUpdate();
        }
    }

    // Metodi per Vincita
    public List<Vincita> getVinciteByCartella(int carId) throws SQLException {
        List<Vincita> vincite = new ArrayList<>();
        String query = "SELECT * FROM vincita WHERE CAR_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, carId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                vincite.add(new Vincita(rs.getInt("VIN_ID"), rs.getString("VIN_tipo"),
                        rs.getBigDecimal("VIN_importo"), rs.getInt("CAR_ID")));
            }
        }
        return vincite;
    }

    public void addVincita(Vincita vincita) throws SQLException {
        String query = "INSERT INTO vincita (VIN_tipo, VIN_importo, CAR_ID) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, vincita.getVinTipo());
            stmt.setBigDecimal(2, vincita.getVinImporto());
            stmt.setInt(3, vincita.getCarId());
            stmt.executeUpdate();
        }
    }
}
