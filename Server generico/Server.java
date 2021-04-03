// 
// ESEMPIO DI STRUTTURA DI UN SERVER
//

import java.net.*;
import java.io.*;
public class Server

{
    // Variabili globali del server necessarie ad elaborare la risposta
    static int[] clientiReparti = new int[]{0,0,0};
    
    public static void main(String args[])
    {
        ServerSocket ss;
        try{
            ss = new ServerSocket(2000);
   
            while(true)
            { 
                try{
                    Socket client = ss.accept();
                    System.out.println("Accettata connessione da "+client.getRemoteSocketAddress().toString());
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                    
                    // Lettura richiesta dal client
                    String str=in.readLine();  
                    String risposta = elaborazione(str);
                    
                    //trasmissione risposta del server 
                    out.write(risposta);  
                    out.flush();

                    // chiusura connessione
                    client.close(); 
                    in.close();
                    out.close();
                }
                catch(Exception e) { 
                    System.out.println("COMUNICAZIONE FALLITA!\nErrore: " + e.getMessage());
                } 
            }
            
        }
        catch(Exception e) {
            System.out.println("APERTURA ServerSocket FALLITA!\nErrore: " + e.getMessage());
        } 
    }
    
    static private String elaborazione(String richiesta)
    {
        String s="";
        // ELABORAZIONE RISPOSTA CON L'UTILIZZO DELLE VARIABILI GLOBALI
        
         //richiesta di mettersi in coda in un reparto
        if(richiesta.compareTo("M")==0) clientiReparti[0]++;
        if(richiesta.compareTo("P")==0) clientiReparti[1]++;
        if(richiesta.compareTo("O")==0) clientiReparti[2]++;
        
         //richiesta del ticket di un reparto
        if(richiesta.compareTo("TICKETM")==0) s = Integer.toString(clientiReparti[0]);
        if(richiesta.compareTo("TICKETP")==0) s = Integer.toString(clientiReparti[1]);
        if(richiesta.compareTo("TICKETO")==0) s = Integer.toString(clientiReparti[2]);
        
        // FINE ELABORAZIONE
        return s;
    }
}