import java.util.ArrayList;

public class Catalogo {
    private final ArrayList<Libro> catalogo = new ArrayList<>();

    public Catalogo() {
        aggiungiLibro(1, false);
        aggiungiLibro(2, true);
        aggiungiLibro(3, false);
        aggiungiLibro(4, true);
    }

    public void aggiungiLibro(int id, boolean raro) {
        if (cercaLibro(id) != null) {
            System.out.println("Esiste già un libro con questo ID.");
            return;
        }
        catalogo.add(new Libro(id, raro));
        System.out.println("Libro aggiunto al catalogo: ID " + id + ", raro=" + raro);
    }

    public Libro cercaLibro(int id) {
        for (Libro libro : catalogo) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public ArrayList<Libro> getCatalogo() {
        return catalogo;
    }
}