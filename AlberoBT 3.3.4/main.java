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
       
       while(r != 0)
       {
           System.out.println("1 --> Inserisci nodo");
           System.out.println("2 --> Ricerca nodo");
           System.out.println("0 --> Esci dall'ospedale");
           
           System.out.println(">>> ");
           r = Integer.parseInt(tastiera.readLine());
           
           if(r == 1)
           {
               System.out.println("Inserire informazione nodo: ");
               String i = tastiera.readLine();
               NodoBT newNodo = new NodoBT(i);
               a.inserisciNodo(newNodo);
           }
           
           else if(r == 2)
           {
               System.out.println("Inserire dato da cercare: ");
               String i = tastiera.readLine();
               NodoBT newNodo = new NodoBT(i);
               if(a.ricercaDato(newNodo)) System.out.println("Il dato è presente nell'albero!");
               else System.out.println("Il dato NON è presente nell'albero!");
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
