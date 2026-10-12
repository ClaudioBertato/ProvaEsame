import java.util.ArrayList;

public class Utente {
    public static final String getCF = null;

    String nome;
    String cognome;
    String cf;
    int affidabilità = 0;
    boolean affidabile = false;
    int ritardi = 0;
    ArrayList<Prestito> prestiti = new ArrayList<>();

    public Utente(String nome, String cognome, String cf) {
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.affidabilità = 0;
        this.affidabile = false;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCf() {
        return cf;
    }

    public int getAffidabilita() {
        return affidabilità;
    }

    public boolean isAffidabile() {
        return affidabile;
    }

    public void setAffidabile(boolean affidabile) {
        this.affidabile = affidabile;
        this.affidabilità = affidabile ? 1 : 0;
    }

    public ArrayList<Prestito> getPrestiti() {
        return prestiti;
    }

    public void addPrestito(Prestito prestito) {
        prestiti.add(prestito);
    }

    public boolean puoPrendereLibro() {
        return affidabile && prestiti.size() < 2;
    }

    public void registraRitardo(int giorniDiRitardo) {
        if (giorniDiRitardo <= 0) {
            registraConsegnaInOrario();
            return;
        }

        ritardi++;
        if (giorniDiRitardo >= 7 || ritardi >= 2) {
            affidabile = false;
            affidabilità = 0;
            ritardi = 2;
        }
    }

    public void registraConsegnaInOrario() {
        affidabile = true;
        affidabilità = 1;
        ritardi = 0;
    }
}