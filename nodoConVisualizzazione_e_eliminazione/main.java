import java.io.*;
import javax.swing.*;
import java.awt.*;

public class main
{
    public static void main(String[] args) throws Exception
    {
       InputStreamReader in = new InputStreamReader(System.in);
       BufferedReader tastiera = new BufferedReader(in);
       
       System.out.println("1 --> Inserisci nuova stringa");
       System.out.println("2 --> Visualizza lista");
       System.out.println("3 --> Cancella testa lista");
       System.out.println("0 --> Esci dal programma");
       System.out.println(">>> ");
       
       int r;
       r = Integer.parseInt(tastiera.readLine());
       
       Lista list = new Lista();
       while(r != 0)
       {
           if(r == 1)
           {
               System.out.println("Inserire nuova stringa:  ");
               String newString = tastiera.readLine();
               Nodo n = new Nodo(newString);
               list.inserisciInTesta(n);
           }
           
           else if(r == 2)
           {
               VisualizzazioneLista(list.getTesta()); 
           }
           
           else if(r == 3)
           {
               list.cancellaTesta();
               
           }
           System.out.println(">>> ");
           r = Integer.parseInt(tastiera.readLine());
       }
    }
    
    public static void VisualizzazioneLista(Nodo n)
    {
        System.out.println(n.getInformazione());
        if(n.getSuccessivo() != null) VisualizzazioneLista(n.getSuccessivo());
        
    }
}
