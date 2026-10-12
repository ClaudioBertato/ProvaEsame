import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static boolean loop = true;
    static final Scanner input = new Scanner(System.in);
    static ListaUtenti lista = new ListaUtenti();
    static Catalogo catalogo = new Catalogo();

    public static void main(String[] args) {
        while (loop) {
            selezionaProgramma();
        }
        input.close();
    }

    private static void selezionaProgramma() {
        System.out.println("\n=== Biblioteca ===");
        System.out.println("1 - Crea nuovo utente");
        System.out.println("2 - Seleziona un utente");
        System.out.println("3 - Elimina un utente");
        System.out.println("4 - Mostra tutti gli utenti");
        System.out.println("5 - Aggiungi libro al catalogo");
        System.out.println("0 - Esci");

        int selected;
        try {
            selected = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Valore non valido.");
            input.nextLine();
            return;
        }

        switch (selected) {
            case 0:
                loop = false;
                break;
            case 1:
                chiediUtente();
                break;
            case 2:
                selezionaAzioneUtente(chiediCF());
                break;
            case 3:
                lista.remove(chiediCF());
                break;
            case 4:
                lista.showAll();
                break;
            case 5:
                aggiungiLibroCatalogo();
                break;
            default:
                System.out.println("Scelta non valida.");
                break;
        }
    }

    public static String chiediCF() {
        System.out.println("Inserisci il Codice fiscale dell'utente: ");
        return input.nextLine();
    }

    public static void chiediUtente() {
        System.out.println("Inserisci Nome:");
        String nome = input.nextLine();
        System.out.println("Inserisci Cognome:");
        String cognome = input.nextLine();
        System.out.println("Inserisci CF:");
        String cf = input.nextLine();

        if (cf == null || cf.trim().isEmpty()) {
            System.out.println("Il codice fiscale non può essere vuoto.");
            return;
        }

        lista.add(nome, cognome, cf);
        System.out.println("Utente registrato correttamente.");
    }

    public static void aggiungiLibroCatalogo() {
        System.out.println("Inserisci ID del libro:");
        int id;
        try {
            id = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("ID non valido.");
            input.nextLine();
            return;
        }

        System.out.println("Il libro è raro? (s/n)");
        String risposta = input.nextLine();
        boolean raro = risposta.equalsIgnoreCase("s") || risposta.equalsIgnoreCase("si") || risposta.equalsIgnoreCase("y");

        catalogo.aggiungiLibro(id, raro);
    }

    public static void selezionaAzioneUtente(String cf) {
        Utente utente = lista.getUtenteByCf(cf);
        if (utente == null) {
            System.out.println("Utente non trovato.");
            return;
        }

        boolean continua = true;
        while (continua) {
            System.out.println("\n=== Utente: " + utente.getNome() + " " + utente.getCognome() + " ===");
            System.out.println("Affidabile: " + (utente.isAffidabile() ? "Sì" : "No"));
            System.out.println("Libri in prestito: " + utente.getPrestiti().size());
            System.out.println("1 - Aggiungi prestito");
            System.out.println("2 - Restituisci prestito");
            System.out.println("3 - Mostra prestiti");
            System.out.println("0 - Torna al menu principale");

            int selected;
            try {
                selected = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Valore non valido.");
                input.nextLine();
                continue;
            }

            switch (selected) {
                case 0:
                    continua = false;
                    break;
                case 1:
                    aggiungiPrestito(utente);
                    break;
                case 2:
                    restituisciPrestito(utente);
                    break;
                case 3:
                    mostraPrestiti(utente);
                    break;
                default:
                    System.out.println("Scelta non valida.");
                    break;
            }
        }
    }

    public static void aggiungiPrestito(Utente utente) {
        if (!utente.isAffidabile()) {
            System.out.println("L'utente non è affidabile e non può prendere libri in prestito.");
            return;
        }

        if (utente.getPrestiti().size() >= 2) {
            System.out.println("L'utente ha già raggiunto il massimo di 2 libri in prestito.");
            return;
        }

        System.out.println("Inserisci ID del libro:");
        int id;
        try {
            id = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("ID non valido.");
            input.nextLine();
            return;
        }

        Libro libro = catalogo.cercaLibro(id);
        if (libro == null) {
            System.out.println("Libro non trovato nel catalogo.");
            return;
        }

        if (!libro.isDisponibile(true)) {
            System.out.println("Il libro non è disponibile.");
            return;
        }

        Prestito prestito = new Prestito(libro, LocalDate.now(), LocalDate.now().plusDays(14));
        utente.addPrestito(prestito);
        libro.setDisponibile(false);
        System.out.println("Prestito aggiunto al libro ID " + libro.getId() + ". Scadenza: " + prestito.getDataFine());
    }

    public static void restituisciPrestito(Utente utente) {
        if (utente.getPrestiti().isEmpty()) {
            System.out.println("L'utente non ha prestiti da restituire.");
            return;
        }

        Prestito prestito = utente.getPrestiti().remove(utente.getPrestiti().size() - 1);
        prestito.setDataConsegna(LocalDate.now());

        long giorniDiRitardo = prestito.calcolaGiorniDiRitardo(LocalDate.now());
        if (giorniDiRitardo > 0) {
            utente.registraRitardo((int) giorniDiRitardo);
            System.out.println("Libro restituito con " + giorniDiRitardo + " giorni di ritardo.");
            if (!utente.isAffidabile()) {
                System.out.println("L'utente è stato classificato come non affidabile.");
            }
        } else {
            utente.registraConsegnaInOrario();
            System.out.println("Libro restituito in tempo. L'utente è tornato affidabile.");
        }

        prestito.getLibro().setDisponibile(true);
    }

    public static void mostraPrestiti(Utente utente) {
        if (utente.getPrestiti().isEmpty()) {
            System.out.println("Nessun prestito attivo.");
            return;
        }

        int indice = 1;
        for (Prestito prestito : utente.getPrestiti()) {
            System.out.println(indice + " - Libro ID: " + prestito.getLibro().getId() + " | Data fine: " + prestito.getDataFine());
            indice++;
        }
    }
}