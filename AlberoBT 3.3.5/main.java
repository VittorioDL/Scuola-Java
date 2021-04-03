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
           System.out.println("1 --> Visualizzazione attraversamento anticipato");
           System.out.println("2 --> Visualizzazione attraversamento simmetrico");
           System.out.println("3 --> Visualizzazione attraversamento posticipato");
           System.out.println("4 --> Crea nuovo albero binario");
           System.out.println("0 --> Esci dal programma");
           
           System.out.println(">>> ");
           r = Integer.parseInt(tastiera.readLine());
           
           //Riempimento casuale
           if(r == 4)
           {
               for(int i = 0; i < 10; i++)
               {
                   Integer n = new Integer((int)(Math.random()*100 +1));
                   a.inserisciNodo(new NodoBT(n));
               }
           }
           
           if(r == 1)
           {
               if(a.Radice != null)
               {
                   Lista listaView = new Lista();
                   listaView = a.attraversamentoAnticipato();
                   VisualizzazioneLista(listaView.getTesta());
               }
               else System.out.println("Devi prima creare un albero binario!");
               
           }
           
           if(r == 2)
           {
               if(a.Radice != null)
               {
                   Lista listaView = new Lista();
                   listaView = a.attraversamentoSimmetrico();
                   VisualizzazioneLista(listaView.getTesta());
               }
               else System.out.println("Devi prima creare un albero binario!");
               
           }
           
           if(r == 3)
           {
               if(a.Radice != null)
               {
                   Lista listaView = new Lista();
                   listaView = a.attraversamentoPosticipato();
                   VisualizzazioneLista(listaView.getTesta());
               }
               else System.out.println("Devi prima creare un albero binario!");
               
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
