import java.util.ArrayList;

public class ListaUtenti {
    private final ArrayList<Utente> lista = new ArrayList<>();

    public void add(String nome, String cognome, String CF) {
        lista.add(new Utente(nome, cognome, CF));
    }

    public Utente getUtenteByCf(String cf) {
        for (Utente utente : lista) {
            if (utente.getCf().equalsIgnoreCase(cf)) {
                return utente;
            }
        }
        return null;
    }

    public void remove(String key) {
        int i = 0;
        for (Utente u : lista) {
            if (u.getCf().equalsIgnoreCase(key)) {
                lista.remove(i);
                break;
            }
            i++;
        }
    }

    public void showAll() {
        if (lista.isEmpty()) {
            System.out.println("Nessun utente registrato.");
            return;
        }

        for (Utente u : lista) {
            System.out.println("\nNome: " + u.getNome());
            System.out.println("Cognome: " + u.getCognome());
            System.out.println("CF: " + u.getCf());
            System.out.println("Affidabile: " + (u.isAffidabile() ? "Sì" : "No"));
            System.out.println("Prestiti attivi: " + u.getPrestiti().size());
        }
        System.out.println();
    }
}