/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tombollasantiniionescugraziotti;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author santini.juri
 */
public class TombollaSantiniIonescuGraziotti {
    private static TombolaDAO dao;
    private static Scanner scanner;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection connection = DBConnection.getConnection();
            dao = new TombolaDAO(connection);
            scanner = new Scanner(System.in);

            boolean running = true;
            while (running) {
                mostraMenu();
                int scelta = scanner.nextInt();
                scanner.nextLine(); // Consuma il newline

                switch (scelta) {
                    case 1:
                        gestisciGiocatori();
                        break;
                    case 2:
                        gestisciTombolate();
                        break;
                    case 3:
                        gestisciCartelle();
                        break;
                    case 4:
                        gestisciEstrazioni();
                        break;
                    case 5:
                        gestisciVincite();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Arrivederci!");
                        break;
                    default:
                        System.out.println("Scelta non valida!");
                }
            }

            DBConnection.closeConnection();
        } catch (SQLException e) {
            System.err.println("Errore di connessione al database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void mostraMenu() {
        System.out.println("\n=== MENU PRINCIPALE TOMBOLA ===");
        System.out.println("1. Gestisci Giocatori");
        System.out.println("2. Gestisci Tombolate");
        System.out.println("3. Gestisci Cartelle");
        System.out.println("4. Gestisci Estrazioni");
        System.out.println("5. Gestisci Vincite");
        System.out.println("0. Esci");
        System.out.print("Scegli: ");
    }

    // ==================== GIOCATORI ====================
    private static void gestisciGiocatori() throws SQLException {
        boolean back = false;
        while (!back) {
            System.out.println("\n=== GESTIONE GIOCATORI ===");
            System.out.println("1. Visualizza tutti i giocatori");
            System.out.println("2. Cerca giocatore per ID");
            System.out.println("3. Aggiungi nuovo giocatore");
            System.out.println("0. Torna al menu principale");
            System.out.print("Scegli: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    visualizzaGiocatori();
                    break;
                case 2:
                    cercaGiocatore();
                    break;
                case 3:
                    aggiungiGiocatore();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Scelta non valida!");
            }
        }
    }

    private static void visualizzaGiocatori() throws SQLException {
        List<Giocatore> giocatori = dao.getAllGiocatori();
        if (giocatori.isEmpty()) {
            System.out.println("Nessun giocatore trovato.");
        } else {
            System.out.println("\n--- ELENCO GIOCATORI ---");
            for (Giocatore g : giocatori) {
                System.out.println(g);
            }
        }
    }

    private static void cercaGiocatore() throws SQLException {
        System.out.print("Inserisci ID giocatore: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Giocatore g = dao.getGiocatoreById(id);
        if (g != null) {
            System.out.println(g);
        } else {
            System.out.println("Giocatore non trovato.");
        }
    }

    private static void aggiungiGiocatore() throws SQLException {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Cognome: ");
        String cognome = scanner.nextLine();
        System.out.print("Username: ");
        String username = scanner.nextLine();

        Giocatore g = new Giocatore();
        g.setGioNome(nome);
        g.setGioCognome(cognome);
        g.setGioUsername(username);

        dao.addGiocatore(g);
        System.out.println("Giocatore aggiunto con successo!");
    }

    // ==================== TOMBOLATE ====================
    private static void gestisciTombolate() throws SQLException {
        boolean back = false;
        while (!back) {
            System.out.println("\n=== GESTIONE TOMBOLATE ===");
            System.out.println("1. Visualizza tutte le tombolate");
            System.out.println("2. Cerca tombolata per ID");
            System.out.println("3. Crea nuova tombolata");
            System.out.println("0. Torna al menu principale");
            System.out.print("Scegli: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    visualizzaTombolate();
                    break;
                case 2:
                    cercaTombolata();
                    break;
                case 3:
                    creaTombolata();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Scelta non valida!");
            }
        }
    }

    private static void visualizzaTombolate() throws SQLException {
        List<Tombolata> tombolate = dao.getAllTombolate();
        if (tombolate.isEmpty()) {
            System.out.println("Nessuna tombolata trovata.");
        } else {
            System.out.println("\n--- ELENCO TOMBOLATE ---");
            for (Tombolata t : tombolate) {
                System.out.println(t);
            }
        }
    }

    private static void cercaTombolata() throws SQLException {
        System.out.print("Inserisci ID tombolata: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Tombolata t = dao.getTombolataById(id);
        if (t != null) {
            System.out.println(t);
        } else {
            System.out.println("Tombolata non trovata.");
        }
    }

    private static void creaTombolata() throws SQLException {
        System.out.print("Inserisci ID giocatore organizzatore: ");
        int gioId = scanner.nextInt();
        scanner.nextLine();

        Giocatore g = dao.getGiocatoreById(gioId);
        if (g == null) {
            System.out.println("Giocatore non trovato!");
            return;
        }

        Tombolata t = new Tombolata();
        t.setParDataOraInizio(LocalDateTime.now());
        t.setParStato("In corso");
        t.setParGioId(gioId);

        dao.addTombolata(t);
        System.out.println("Tombolata creata con successo!");
    }

    // ==================== CARTELLE ====================
    private static void gestisciCartelle() throws SQLException {
        boolean back = false;
        while (!back) {
            System.out.println("\n=== GESTIONE CARTELLE ===");
            System.out.println("1. Visualizza cartelle di una tombolata");
            System.out.println("2. Visualizza numeri di una cartella");
            System.out.println("3. Aggiungi cartella a tombolata");
            System.out.println("0. Torna al menu principale");
            System.out.print("Scegli: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    visualizzaCartelle();
                    break;
                case 2:
                    visualizzaNumeriCartella();
                    break;
                case 3:
                    aggiungiCartella();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Scelta non valida!");
            }
        }
    }

    private static void visualizzaCartelle() throws SQLException {
        System.out.print("Inserisci ID tombolata: ");
        int parId = scanner.nextInt();
        scanner.nextLine();

        List<Cartella> cartelle = dao.getCartelleByTombolata(parId);
        if (cartelle.isEmpty()) {
            System.out.println("Nessuna cartella trovata.");
        } else {
            System.out.println("\n--- CARTELLE DELLA TOMBOLATA ---");
            for (Cartella c : cartelle) {
                System.out.println(c);
            }
        }
    }

    private static void visualizzaNumeriCartella() throws SQLException {
        System.out.print("Inserisci ID cartella: ");
        int carId = scanner.nextInt();
        scanner.nextLine();

        List<Numero> numeri = dao.getNumeriByCartella(carId);
        if (numeri.isEmpty()) {
            System.out.println("Nessun numero trovato.");
        } else {
            System.out.println("\n--- NUMERI DELLA CARTELLA ---");
            for (Numero n : numeri) {
                System.out.println(n);
            }
        }
    }

    private static void aggiungiCartella() throws SQLException {
        System.out.print("Inserisci codice cartella: ");
        String codice = scanner.nextLine();
        System.out.print("Inserisci ID tombolata: ");
        int parId = scanner.nextInt();
        System.out.print("Inserisci ID giocatore: ");
        int gioId = scanner.nextInt();
        scanner.nextLine();

        Cartella c = new Cartella();
        c.setCarCodice(codice);
        c.setCarParId(parId);
        c.setCarGioId(gioId);

        dao.addCartella(c);
        System.out.println("Cartella aggiunta con successo!");
    }

    // ==================== ESTRAZIONI ====================
    private static void gestisciEstrazioni() throws SQLException {
        boolean back = false;
        while (!back) {
            System.out.println("\n=== GESTIONE ESTRAZIONI ===");
            System.out.println("1. Visualizza estrazioni di una tombolata");
            System.out.println("2. Esegui estrazione");
            System.out.println("0. Torna al menu principale");
            System.out.print("Scegli: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    visualizzaEstrazioni();
                    break;
                case 2:
                    eseguiEstrazione();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Scelta non valida!");
            }
        }
    }

    private static void visualizzaEstrazioni() throws SQLException {
        System.out.print("Inserisci ID tombolata: ");
        int parId = scanner.nextInt();
        scanner.nextLine();

        List<Estrazione> estrazioni = dao.getEstrazioniByTombolata(parId);
        if (estrazioni.isEmpty()) {
            System.out.println("Nessuna estrazione trovata.");
        } else {
            System.out.println("\n--- ESTRAZIONI ---");
            for (Estrazione e : estrazioni) {
                System.out.println(e);
            }
        }
    }

    private static void eseguiEstrazione() throws SQLException {
        System.out.print("Inserisci ID tombolata: ");
        int parId = scanner.nextInt();
        System.out.print("Inserisci numero da estrarre: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        Estrazione e = new Estrazione();
        e.setEstTimestamp(LocalDateTime.now());
        e.setEstNumeroEstratto(numero);
        e.setParId(parId);

        dao.addEstrazione(e);
        System.out.println("Numero " + numero + " estratto con successo!");
    }

    // ==================== VINCITE ====================
    private static void gestisciVincite() throws SQLException {
        boolean back = false;
        while (!back) {
            System.out.println("\n=== GESTIONE VINCITE ===");
            System.out.println("1. Visualizza vincite di una cartella");
            System.out.println("2. Registra vincita");
            System.out.println("0. Torna al menu principale");
            System.out.print("Scegli: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    visualizzaVincite();
                    break;
                case 2:
                    registraVincita();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Scelta non valida!");
            }
        }
    }

    private static void visualizzaVincite() throws SQLException {
        System.out.print("Inserisci ID cartella: ");
        int carId = scanner.nextInt();
        scanner.nextLine();

        List<Vincita> vincite = dao.getVinciteByCartella(carId);
        if (vincite.isEmpty()) {
            System.out.println("Nessuna vincita trovata.");
        } else {
            System.out.println("\n--- VINCITE ---");
            for (Vincita v : vincite) {
                System.out.println(v);
            }
        }
    }

    private static void registraVincita() throws SQLException {
        System.out.print("Inserisci ID cartella: ");
        int carId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tipo di vincita (Ambo/Terno/Quaterna/Cinquina/Tombola): ");
        String tipo = scanner.nextLine();
        System.out.print("Importo: ");
        java.math.BigDecimal importo = new java.math.BigDecimal(scanner.nextLine());

        Vincita v = new Vincita();
        v.setVinTipo(tipo);
        v.setVinImporto(importo);
        v.setCarId(carId);

        dao.addVincita(v);
        System.out.println("Vincita registrata con successo!");
    }
}
