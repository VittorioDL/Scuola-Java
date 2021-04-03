import java.io.*;
import javax.swing.*;
import java.awt.*;

public class main
{
    public static void main(String[] args) throws Exception
    {
       InputStreamReader in = new InputStreamReader(System.in);
       BufferedReader tastiera = new BufferedReader(in);
       
       int r=-1, nPersone = 0, max = 10, nCollisioni=0;
       Persona listaPersone[] = new Persona[max];

       while(r != 0)
       {
           System.out.println("1 --> Inserisci persona");
           System.out.println("2 --> Visualizza dati persona");
           System.out.println("0 --> Esci dal programma");
           System.out.println(">>> ");
           r = Integer.parseInt(tastiera.readLine());
           nCollisioni = 0;
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
               
               VDLHash2 hashPos = new VDLHash2(newCF);
               Persona newP = new Persona(newNome, newCognome, newCF, newAnno, newMese, newGiorno);    
               
               int nextPos = hashPos.hashing(max);
               
               while(listaPersone[nextPos] != null) 
               {
                   if(nextPos+1 >= max) nextPos = 0;
                   else nextPos++;  
                   nCollisioni++;
               }
               
               listaPersone[nextPos] = newP;
               System.out.println("Collisioni inserimento: "+nCollisioni);
           }
           
           if(r == 2)
           {  
               System.out.println("Codice fiscale persona: ");
               String cf = tastiera.readLine();
           
               VDLHash2 hashPos = new VDLHash2(cf);

               int nextPos = hashPos.hashing(max);
               
               while(listaPersone[nextPos] != null && listaPersone[nextPos].getCF().compareTo(cf)!=0) 
               {
                   if(nextPos+1 >= max) nextPos = 0;
                   else nextPos++;  
                   nCollisioni++;       
               }
              
               Persona personaTrovata = listaPersone[nextPos];
               if(personaTrovata != null)
               {
                   System.out.println("Nome: "+ personaTrovata.getNome());
                   System.out.println("Cognome: "+ personaTrovata.getCognome());
                   System.out.println("Data di nascita: "+ personaTrovata.getGiorno()+"/"+personaTrovata.getMese()+"/"+personaTrovata.getAnno());
                   System.out.println("Codice fiscale: "+personaTrovata.getCF());
               }
               
               else System.out.println("Persona non trovata!");
               System.out.println("Collisioni in ricerca: "+nCollisioni);
           }
           System.out.println();
       }
    }
}