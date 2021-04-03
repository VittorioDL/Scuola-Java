// 
// ESEMPIO DI STRUTTURA DI UN SERVER
//
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Date;
public class Server

{
    // Variabili globali del server necessarie ad elaborare la risposta
    static ArrayList<String> nicknames = new ArrayList<String>();
    static ArrayList<Messaggio> messaggi = new ArrayList<Messaggio>();
    
    public static void main(String args[])
    {
        ServerSocket ss;
        try{
            ss = new ServerSocket(2000);
   
            while(true)
            { 
                try{
                    Socket client = ss.accept();
                    //System.out.println("Accettata connessione da "+client.getRemoteSocketAddress().toString());
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
        //NICK[Nickname]
        if(richiesta.substring(0,4).compareTo("NICK")==0)
        {
            if(nicknames.indexOf(richiesta.substring(4)) == -1)
            {
                nicknames.add(richiesta.substring(4)); 
                s = "ACCEPTED";
            }
            else s = "DECLINED";
        }
        
        //richiesta di abbandonare la chat  
        //QUIT[Nickname]
        if(richiesta.substring(0,4).compareTo("QUIT")==0)
        {
            if(nicknames.indexOf(richiesta.substring(4)) != -1)
            {
                nicknames.remove(nicknames.indexOf(richiesta.substring(4))); 
                s = "DISCONNECTED";
            }
            else s = "NOT FOUND";
        }
        
        //invio messaggio
        //TEXT[Mode][Text]§[nM]§[nD]
        if(richiesta.substring(0,4).compareTo("TEXT")==0)
        {
            String[] parts = richiesta.split("§");
            String nM = parts[1];
            String nD = parts[2];
            String text = parts[0].substring(5);
            //messaggio broadcast
            if(richiesta.charAt(4) == 'B') 
            {
                /*
                invio messaggio a tutti
                */
                s = "RECEIVED";
                Date currentDate = new Date();
                Messaggio messaggio = new Messaggio(text, " ", nM, currentDate, 'B');
                messaggi.add(messaggio);
            }
            
            //messaggio privato
            else if(richiesta.charAt(4) == 'U') 
            {
                if(nicknames.indexOf(nD) != -1)
                {
                   /*
                   invio messaggio al nickname inserito
                   */
                   s = "RECEIVED";                   
                   Date currentDate = new Date();
                   Messaggio messaggio = new Messaggio(text, nD, nM, currentDate, 'U');
                   messaggi.add(messaggio);
                }
                
                else s = "NOT FOUND";    
            }
        }
        
        //chiede di visualizzare tutti i nickname
        //Client: USRS     
        //Server: USERS[n1]§[n2]§[n3]...
        if(richiesta.substring(0,4).compareTo("USRS")==0)
        {
            s = "USERS";
            for(int i = 0; i < nicknames.size(); i++)
            {
                if(i == nicknames.size()-1) s += nicknames.get(i);
                else s += nicknames.get(i)+"§";
            }
        }
        
        //richiesta di ricevere i nuovi messaggi
        //RCVD[Nickname destinatario]
        //RF<N1>§<TEXT1>§<DATE1>§<MODE1>§[<N2>§<TEXT2>§<DATE2>§<MODE2>…] / NOTFOUND / NO MEX
        if(richiesta.substring(0,4).compareTo("RCVD")==0)
        {
            if(nicknames.indexOf(richiesta.substring(4)) != -1)
            {
                s = "RF";
                int cont_new_mex = 0;
                for(int i = 0; i < messaggi.size(); i++)
                {
                    //Invio messaggi privati
                    if((!messaggi.get(i).getSent() && messaggi.get(i).getND().compareTo(richiesta.substring(4))==0))
                    {
                        cont_new_mex++;
                        if(cont_new_mex > 1) s += "§";
                        s += messaggi.get(i).getNM();
                        s += "§";
                        s += messaggi.get(i).getText();
                        s += "§";
                        s += Integer.toString(messaggi.get(i).getDate().getHours())+"/";
                        s += Integer.toString(messaggi.get(i).getDate().getMinutes())+"/";
                        s += Integer.toString(messaggi.get(i).getDate().getSeconds());
                        s += "§";
                        s += messaggi.get(i).getMode();

                        messaggi.get(i).inviato();
                    }
                    
                    //Invio messaggi broadcast
                    else if((!messaggi.get(i).getReceivedUser(richiesta.substring(4)) && messaggi.get(i).getMode()=='B'))
                    {
                        cont_new_mex++;
                        if(cont_new_mex > 1) s += "§";
                        s += messaggi.get(i).getNM();
                        s += "§";
                        s += messaggi.get(i).getText();
                        s += "§";
                        s += Integer.toString(messaggi.get(i).getDate().getHours())+"/";
                        s += Integer.toString(messaggi.get(i).getDate().getMinutes())+"/";
                        s += Integer.toString(messaggi.get(i).getDate().getSeconds());
                        s += "§";
                        s += messaggi.get(i).getMode();
                        
                        if(messaggi.get(i).getMode()=='B') messaggi.get(i).sendTo(richiesta.substring(4));
                    }
                }
                
                if(cont_new_mex == 0) s = "NO MEX";
            }
            else s = "NOT FOUND";
        }
        
        // FINE ELABORAZIONE
        return s;
    }
}