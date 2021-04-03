import java.io.*;
import javax.swing.*;
import java.awt.*;

public class main
{
    public static void main(String[] args) throws Exception
    {
       InputStreamReader in = new InputStreamReader(System.in);
       BufferedReader tastiera = new BufferedReader(in);
       
       int r=-1, nPersone = 0, max = 10000;
       Persona listaPersone[] = new Persona[max];

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
               
               VDLHash2 hashPos = new VDLHash2(newCF);
               Persona newP = new Persona(newNome, newCognome, newCF, newAnno, newMese, newGiorno);    
               listaPersone[hashPos.hashing(max)] = newP;
           }
           
           if(r == 2)
           {  
               System.out.println("Codice fiscale persona: ");
               String cf = tastiera.readLine();
               int n;
               VDLHash2 hashPos = new VDLHash2(cf);
               Persona personaTrovata = listaPersone[hashPos.hashing(max)];
               
               if(personaTrovata != null)
               {
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
}