import java.io.*;
import javax.swing.*;
import java.awt.*;

public class main
{
    public static void main(String[] args) throws Exception
    {
       InputStreamReader in = new InputStreamReader(System.in);
       BufferedReader tastiera = new BufferedReader(in);
       
       int r=-1;
       
       Coda red = new Coda();
       //red.enqueue(new Nodo("0"));    //divisore rosso-giallo
       Coda yellow = new Coda();
       //yellow.enqueue(new Nodo("0")); //divisore giallo-bianco
       Coda white = new Coda();
       
       ProntoSoccorso P = new ProntoSoccorso(red, yellow, white);
       
       while(r != 0)
       {
           System.out.println("1 --> Aggiungi paziente");
           System.out.println("2 --> Chiama paziente più importante");
           System.out.println("3 --> Numero pazienti");
           System.out.println("4 --> Eliminazione paziente");
           System.out.println("0 --> Esci dall'ospedale");
           
           System.out.println(">>> ");
           r = Integer.parseInt(tastiera.readLine());
           if(r == 1)
           {
               int colore;
               do{
                   System.out.println("Colore emergenza (1:rosso, 2:giallo, 3:bianco):  ");
                   colore = Integer.parseInt(tastiera.readLine());
               }while(colore<=0 || colore >3);
               
               System.out.println("Nome paziente: ");
               String nome = tastiera.readLine();
               System.out.println("Cognome paziente: ");
               String cognome = tastiera.readLine();
               
               String nominativo = nome + " " + cognome;
               Nodo paziente = new Nodo(nominativo); 
               P.aggiungiPaziente(paziente, colore);
           }
           
           else if(r == 2)
           {
               if(!P.isEmpty()) System.out.println("Si faccia avanti: "+P.pazienteConPriorita().getInformazione());
               else System.out.println("La lista è vuota");
           }
           
           else if(r == 3)
           {
               int colore;
               do{
                   System.out.println("Colore settore (1:rosso, 2:giallo, 3:bianco):  ");
                   colore = Integer.parseInt(tastiera.readLine());
               }while(colore<=0 || colore >3);
               if(colore == 1)
               {
                   System.out.println("Numero pazienti settore rosso: "+P.getSizeR());
               }
               else if(colore == 2)
               {
                   System.out.println("Numero pazienti settore giallo: "+P.getSizeY());
               }
               else if(colore == 3)
               {
                   System.out.println("Numero pazienti settore bianco: "+P.getSizeW());
               }  
           }
           
           else if(r == 4)
           {
               if(P.isEmpty())
               {
                   System.out.println("La lista è vuota");
               }
               
               else
               {
                   System.out.println("Inserire nome del paziente da eliminare: ");
                   String nome = tastiera.readLine();
                   System.out.println("Inserire cognome del paziente da eliminare: ");
                   String cognome = tastiera.readLine();
                   String nominativo = nome + " " + cognome;
                   
                   if(P.rimuoviPazienteR(nominativo) | P.rimuoviPazienteY(nominativo) | P.rimuoviPazienteW(nominativo))
                   {
                       System.out.println("Paziente cancellato!"); 
                   }
                   else System.out.println("Paziente inesistente!"); 
                  
               }
               
           }
           
           
           System.out.println();
       }
    }
    
    /*public static void VisualizzazioneLista(Nodo n)
    {
        System.out.println(n.getInformazione());
        if(n.getSuccessivo() != null) VisualizzazioneLista(n.getSuccessivo());
    }*/
}
