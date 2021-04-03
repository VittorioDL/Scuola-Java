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
               VisualizzazioneLista(list.getTesta()); 
           }
           
           else if(r == 3)
           {
               list.cancellaTesta();
           }
           
           else if(r == 4)
           {
               System.out.println("Coda della lista: " + list.getCoda().getInformazione());
           }
       }
    }
    
    public static void VisualizzazioneLista(Nodo n)
    {
        System.out.println(n.getInformazione());
        if(n.getSuccessivo() != null) VisualizzazioneLista(n.getSuccessivo());
        
    }
}
