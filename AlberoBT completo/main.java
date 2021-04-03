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
       boolean alberoCreato = false;
       while(r != 0)
       {
           System.out.println("1 --> Visualizzazione attraversamento anticipato");
           System.out.println("2 --> Visualizzazione attraversamento simmetrico");
           System.out.println("3 --> Visualizzazione attraversamento posticipato");
           System.out.println("4 --> Visualizza albero come tabella");
           System.out.println("5 --> Numero di nodi dell'albero");
           System.out.println("6 --> Crea nuovo albero binario");
           System.out.println("0 --> Esci dal programma");
           
           System.out.println(">>> ");
           r = Integer.parseInt(tastiera.readLine());
           
           //Riempimento casuale
           if(r == 6)
           {
               for(int i = 0; i < 10; i++)
               {
                   Integer n = new Integer((int)(Math.random()*100 +1));
                   a.inserisciNodo(new NodoBT(n));
               }
               alberoCreato = true;
           }
           
           if(r == 1)
           {
               if(alberoCreato)
               {
                   Lista listaView = new Lista();
                   listaView = a.attraversamentoAnticipato();
                   VisualizzazioneLista(listaView.getTesta());
               }
               else System.out.println("Devi prima creare un albero binario!");
               
           }
           
           if(r == 2)
           {
               if(alberoCreato)
               {
                   Lista listaView = new Lista();
                   listaView = a.attraversamentoSimmetrico();
                   VisualizzazioneLista(listaView.getTesta());
               }
               else System.out.println("Devi prima creare un albero binario!");
               
           }
           
           if(r == 3)
           {
               if(alberoCreato)
               {
                   Lista listaView = new Lista();
                   listaView = a.attraversamentoPosticipato();
                   VisualizzazioneLista(listaView.getTesta());
               }
               else System.out.println("Devi prima creare un albero binario!");
               
           }
           
           if(r == 4)
           {
               if(alberoCreato) a.tabella();
               else System.out.println("Devi prima creare un albero binario!");
           }
           
           if(r == 5)
           {
               if(alberoCreato)
               {
                   Integer newInfo;
                   NodoBT newRadice;
               
                   do
                   {
                       System.out.println("Inserire nodo di cui vuoi sapere il numero di sottonodi: ");
                       newInfo = new Integer(Integer.parseInt(tastiera.readLine()));
                       newRadice = new NodoBT(newInfo);
                    }while(!a.ricercaDato(newRadice));
               
                    System.out.println("Numero nodi: "+a.numeroNodi(newRadice));
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
