//
//  ESEMPIO DI STRUTTURA DI UN CLIENT
//
import java.io.*;
import java.awt.event.*;

public class Main 
{
    // VARIABILI GLOBALI CHE SERVONO PER RICHIEDERE
    // SERVIZI AL SERVER
    String richiesta="";
    
    // CREAZIONE DI UN OGGETTO PER LA CONNESSIONE AL SERVER 
    // SPECIFICANDO INDIRIZZO E PORTA
    // (Vedi classe definita in seguito)
    ConnessioneAServer conn=new ConnessioneAServer("151.76.221.45",2000);
    
    public void main() throws Exception
    {
       InputStreamReader in = new InputStreamReader(System.in);
       BufferedReader tastiera = new BufferedReader(in);  
       int r = -1;
       do
       {
           System.out.println("1 --> Inserisci il cognome");    
           System.out.println("0 --> Esci dal programma");
           System.out.println(">>> ");
           r = Integer.parseInt(tastiera.readLine());
           
           if(r == 1)
           {
               richiesta = tastiera.readLine();
               String a=conn.risposta(richiesta);
               System.out.println("Risposta server: "+a);
           }

           System.out.println("\n");    
       }while(r != 0);  
    }
 
}