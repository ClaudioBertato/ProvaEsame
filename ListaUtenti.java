import java.util.ArrayList;

public class ListaUtenti{
    private ArrayList<Utente> lista = new ArrayList<>();

    
    public void add(String nome, String cognome, String CF){
        lista.add(new Utente(nome, cognome, CF));
    }

    public void remove(String key){
        int i = 0;
        for(Utente u: lista){
            if(u.getCf().equals(key)){
                lista.remove(i);
                break;
            }
            i ++;
        }
    }

    public void showAll(){
        for(Utente u: lista){
            System.out.println("\n\n\nNome: " + u.getNome() + "\nCognome: " + u.getCognome() + "\nCF: " + u.getCf() + "\n");
        }
        System.out.println("\n\n\n");
    }

}