public class Libro {
    private final int id;
    private final boolean raro;
    private boolean disponibile = true;

    public Libro(int id, boolean raro) {
        this.id = id;
        this.raro = raro;
    }

    public int getId() {
        return id;
    }

    public boolean isRaro() {
        return raro;
    }

    public boolean isDisponibile(boolean par) {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }
}