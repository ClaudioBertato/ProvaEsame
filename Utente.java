import java.util.ArrayList;

public class Utente{
    public static final String getCF = null;
    String nome;
    String cognome;
    String cf; 
    int affidabilità = 0;
    ArrayList<Prestito> prestiti = new ArrayList<>();

public Utente(String nome, String cognome,String cf){
    this.nome = nome;
    this.cognome = cognome;
    this.cf = cf;
    this.affidabilità = 0;
}

public String getNome(){
    return nome;
}

public String getCognome(){
    return cognome;
}

public String getCf(){
    return cf;
}

public void addprestito(String IDLibro){
    prestiti.add(new Prestito(IDLibro));
}



}