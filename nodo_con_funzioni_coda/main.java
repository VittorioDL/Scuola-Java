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
       
       
       Lista list = new Lista();
       while(r != 0)
       {
           System.out.println("1 --> Inserisci nuova stringa");
           System.out.println("2 --> Visualizza lista");
           System.out.println("3 --> Cancella testa lista");
           System.out.println("4 --> Visualizza coda lista");
           System.out.println("5 --> Cancella coda lista");
           System.out.println("6 --> Inserisci in coda");
           System.out.println("0 --> Esci dal programma");
           System.out.println(">>> ");
           r = Integer.parseInt(tastiera.readLine());
           if(r == 1)
           {
               System.out.println("Inserire nuova stringa:  ");
               String newString = tastiera.readLine();
               Nodo n = new Nodo(newString);
               list.inserisciInTesta(n);
           }
           
           else if(r == 2)
           {
               if(!list.isEmpty()) VisualizzazioneLista(list.getTesta()); 
               else System.out.println("La lista è vuota"); 
           }
           
           else if(r == 3)
           {
               if(list.isEmpty()) System.out.println("La lista è vuota");
               else  list.cancellaTesta();
           }
           
           else if(r == 4)
           {
               if(!list.isEmpty()) System.out.println("Coda della lista: " + list.getCoda().getInformazione());
               else System.out.println("La lista è vuota"); 
           }
           
           else if(r == 5)
           {
               if(list.isEmpty()) System.out.println("La lista è vuota");
               else  list.cancellaCoda(); 
           }
           
           else if(r == 6)
           {
               System.out.println("Inserire nuova coda lista: ");
               String newString = tastiera.readLine();
               Nodo n = new Nodo(newString);
               list.inserisciInCoda(n);
           }
           System.out.println();
       }
    }
    
    public static void VisualizzazioneLista(Nodo n)
    {
        System.out.println(n.getInformazione());
        if(n.getSuccessivo() != null) VisualizzazioneLista(n.getSuccessivo());
        
    }
}
