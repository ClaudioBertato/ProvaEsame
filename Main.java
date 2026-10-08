import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    static boolean loop = true;
        ArrayList<Utente> listaUtenti = new ArrayList<>();
        static ListaUtenti lista = new ListaUtenti();
                
                public static void main(String[] args){
                    while(loop){
                    selezionaProgramma();
                }
            }
        
            private static void selezionaProgramma(){
                Scanner t = new Scanner(System.in);
                System.out.println("1 - Crea nuovo utente");
                System.out.println("2 - Seleziona un utente");
                System.out.println("3 - Elimina un utente");
                System.out.println("4 - Mostra tutti gli utenti");
                int selected = t.nextInt();
                switch(selected){
                    case 0:
                        loop = false;
                    case 1: 
                        chiediUtente();
                        break;
                    case 2: 
                        String cf = chiediCF(); //Ricera NUMERO IN ORDINE DELLL UTENTE TRAMITE CF
                        selezionaAzioneUtente(/*NUMERO UTENTE*/);
                        break;
                    case 3:
                        lista.remove(chiediCF());
                        break;
                    case 4: 
                        lista.showAll();
                        break;
                }
            }

            public static String chiediCF(){
                Scanner t = new Scanner(System.in);
                System.out.println("Inserisci il Codice fiscale dell'utente: ");
                return t.nextLine();
            }
        
            public static void chiediUtente(){
                Scanner t = new Scanner(System.in);
                System.out.println("Inserisci Nome:");
                String nome = t.nextLine();
                System.out.println("Inserisci Cognome:");
                String cognome = t.nextLine();
                System.out.println("Inserisci CF:");
                String CF = t.nextLine();
                lista.add(nome, cognome, CF);
            }

            public static void selezionaAzioneUtente(/*NUMERO UTENTE */){
                Scanner t = new Scanner(System.in);
                System.out.println("1 - Aggiungi prestito");
                System.out.println("2 - Restituisci prestito");
                int selected = t.nextInt();
                t.close();
                switch(selected){
                    case 1:
                        //AGGIUNGI LIBRO u[i].(chiediIDLibro)
                }

            }

            public static String chiediIDlibro(){
                Scanner t = new Scanner(System.in);
                System.out.println("Inserisci il codice ID del libro: ");
                String id = t.nextLine();
                t.close();
                return id;
            }
}