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
       AlberoBT a = new AlberoBT();
       Lista listaPersone = new Lista();
       int numPersone = 0;

       while(r != 0)
       {
           System.out.println("1 --> Inserisci persona");
           System.out.println("2 --> Visualizza dati persona");
           System.out.println("0 --> Esci dal programma");
           System.out.println(">>> ");
           r = Integer.parseInt(tastiera.readLine());
             
           if(r == 1)
           { 
               System.out.println("Nome: ");
               String newNome = tastiera.readLine();
               System.out.println("Cognome: ");
               String newCognome = tastiera.readLine();
               System.out.println("Anno nascita: ");
               int newAnno = Integer.parseInt(tastiera.readLine());
               System.out.println("Mese nascita: ");
               int newMese = Integer.parseInt(tastiera.readLine());
               System.out.println("Giorno nascita: ");
               int newGiorno = Integer.parseInt(tastiera.readLine());
               System.out.println("Codice fiscale: ");
               String newCF = tastiera.readLine();
               
               Persona newP = new Persona(newNome, newCognome, newCF, newAnno, newMese, newGiorno);
               IndicePersona newID = new IndicePersona(numPersone, newCF);
               
               a.inserisciNodo(new NodoBT(newID));
               listaPersone.inserisciInCoda(new Nodo(newP));
               
               numPersone++;
           }
           
           if(r == 2)
           {  
               System.out.println("Codice fiscale persona: ");
               String cf = tastiera.readLine();
               int n;
               Persona personaTrovata;
               if(a.ricercaDato(new NodoBT(cf))) 
               {
                   n = ((IndicePersona)(a.getDato(new NodoBT(cf)).getInfo())).getPosInLista();
                   
                   personaTrovata = (Persona)listaPersone.getInPosizione(n).getInformazione();
                   System.out.println("Nome: "+ personaTrovata.getNome());
                   System.out.println("Cognome: "+ personaTrovata.getCognome());
                   System.out.println("Data di nascita: "+ personaTrovata.getGiorno()+"/"+personaTrovata.getMese()+"/"+personaTrovata.getAnno());
                   System.out.println("Codice fiscale: "+personaTrovata.getCF());
            
               }
               else System.out.println("Persona non trovata!");
           }
           System.out.println();
       }
    }
    
    private static void VisualizzazioneLista(Nodo n)
    {
        System.out.println(n.getInformazione());
        if(n.getSuccessivo() != null) VisualizzazioneLista(n.getSuccessivo());
    }
}