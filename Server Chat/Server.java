// 
// ESEMPIO DI STRUTTURA DI UN SERVER
//
import java.net.*;
import java.io.*;
import java.util.*;
public class Server

{
    // Variabili globali del server necessarie ad elaborare la risposta
    static ArrayList<String> nicknames = new ArrayList<String>();
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
        
        //richiesta di aggiungere un nickname
        if(richiesta.substring(0,3).compareTo("NEW")==0)
        {
            if(nicknames.indexOf(richiesta.substring(3)) == -1)
            {
                nicknames.add(richiesta.substring(3)); 
                s = "ACCEPTED";
            }
            else s = "DECLINED";
        }
        
        //richiesta di abbandonare la chat
        int index = nicknames.indexOf(richiesta.substring(4));
        
        if(richiesta.substring(0,4).compareTo("QUIT")==0)
        {
            if(index != -1)
            {
                nicknames.remove(index); 
                s = "DELETED";
            }
            else s = "NOTFOUND";
        }
        
        // FINE ELABORAZIONE
        return s;
    }
}