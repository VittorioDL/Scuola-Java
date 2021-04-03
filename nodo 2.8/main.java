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
       Coda c = new Coda();
       Pila p = new Pila();
       while(r != 0)
       {
           System.out.println("Metodi lista:");
           System.out.println("1 --> Inserisci nuova stringa");
           System.out.println("2 --> Visualizza lista");
           System.out.println("3 --> Cancella testa lista");
           System.out.println("4 --> Visualizza coda lista");
           System.out.println("5 --> Cancella coda lista");
           System.out.println("6 --> Inserisci in coda");
           System.out.println("7 --> Dimensione lista");
           System.out.println("8 --> Cancella in posizione");
           System.out.println("9 --> Aggiungi in posizione");
           System.out.println("10 --> Ottieni in posizione");
           System.out.println("11 --> Concatena liste");
           System.out.println("12 --> Concatena liste in posizione");
           System.out.println("13 --> Ottieni posizione nodo");
           System.out.println("14 --> Svuota lista");
           
           System.out.println("\nMetodi coda:");
           System.out.println("15 --> Inserisci in testa della coda");
           System.out.println("16 --> Estrai coda della coda");
           System.out.println("17 --> Visualizza coda");
           
           System.out.println("\nMetodi pila:");
           System.out.println("18 --> Aggiungi in testa della pila");
           System.out.println("19 --> Estrai testa della pila");
           System.out.println("20 --> Visualizza pila");
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
           
           else if(r == 7)
           {
               System.out.println("Dimensione: " + list.getSize());
           }
           
           else if(r == 8)
           {
               System.out.println("Inserire posizione da elimiare: "); 
               int i = Integer.parseInt(tastiera.readLine());
               list.rimuoviInPosizione(i);
           }
           
           else if(r == 9)
           {
               System.out.println("Posizione nuovo nodo: "); 
               int i = Integer.parseInt(tastiera.readLine());
               System.out.println("Inserire nuova nodo: ");
               String newString = tastiera.readLine();
               Nodo n = new Nodo(newString);
               list.inserisciInPosizione(i, n);
           }
           
           else if(r == 10)
           {
               System.out.println("Indice nodo da visualizzare: "); 
               int i = Integer.parseInt(tastiera.readLine());
               if(list.getInPosizione(i) != null) System.out.println("Nodo in posizione "+i+"°: "+list.getInPosizione(i).getInformazione());
               
           }
           
           else if(r == 11)
           {
               System.out.println("Inserisci testa nuova lista: "); 
               String newString = tastiera.readLine();
               Nodo n = new Nodo(newString);
               Lista list2 = new Lista(n);
               list.concatena(list2);
           }
           
           else if(r == 12)
           {
               System.out.println("Inserisci testa nuova lista: "); 
               String newString = tastiera.readLine();
               System.out.println("Indice nodo da concatenare: "); 
               int i = Integer.parseInt(tastiera.readLine());
               Nodo n = new Nodo(newString);
               Lista list2 = new Lista(n);
               list.concatenaInPosizione(list2, i);
           }
           
           else if(r == 13)
           {
               System.out.println("Inserire nodo di cui vuoi conoscere la posizione: "); 
               String newString = tastiera.readLine();
               System.out.println("Posizione nodo: " + list.posizioneNodo(newString));
           }
           
           else if(r == 14)
           {
               list.clear();
               System.out.println("Lista svuotata!");
           }
           //Coda---------------------------------------------------------------
           else if(r == 15)
           {
               System.out.println("Inserire nuova testa: ");
               String newString = tastiera.readLine();
               Nodo n = new Nodo(newString);
               c.enqueue(n);
           }
           
           else if(r == 16)
           {
               if(!c.isEmpty()) System.out.println("Coda della coda: " + c.dequeue().getInformazione());
               else System.out.println("La coda è vuota"); 
           }
           
           else if(r == 17)
           {
               if(!c.isEmpty()) VisualizzazioneLista(c.getTesta()); 
               else System.out.println("La coda è vuota"); 
           }
           //Pila---------------------------------------------------------------
           else if(r == 18)
           {
               System.out.println("Inserire nuova elemento: ");
               String newString = tastiera.readLine();
               Nodo n = new Nodo(newString);
               p.push(n);
           }
           
           else if(r == 19)
           {
               if(!p.isEmpty()) System.out.println("Top della pila: " + p.pop().getInformazione());
               else System.out.println("La pila è vuota"); 
           }
           
           else if(r == 20)
           {
               if(!p.isEmpty()) VisualizzazioneLista(p.getTesta()); 
               else System.out.println("La pila è vuota"); 
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
