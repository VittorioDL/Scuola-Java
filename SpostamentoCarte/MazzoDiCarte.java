import java.util.*;
public class MazzoDiCarte
{ 
    ArrayList<CartaDaGioco> mazzo;
    
    public MazzoDiCarte()
    {
        mazzo = new ArrayList(); 
    }
    
    public void mischiaMazzo()
    {
        Collections.shuffle(mazzo);
    }
    
    public void aggiungiCarta(CartaDaGioco carta)
    {
        mazzo.add(carta);
    }
    
    public void inserisciCarta(CartaDaGioco carta, int posizione)
    {
        mazzo.add(posizione, carta);
    }
    
    public void eliminaCarta(CartaDaGioco carta)
    {
        mazzo.remove(carta);
    }
    
    public void scopriCarta(int posizione)
    {
        mazzo.get(posizione).scopri();
    }
    
    public void copriCarta(int posizione)
    {
        mazzo.get(posizione).copri();
    }
    
    public CartaDaGioco pescaCartaCima()
    {
        CartaDaGioco carta = mazzo.get(0);
        mazzo.remove(0);
        return carta;
    } 
    
    public CartaDaGioco pescaCartaInPosizione(int pos)
    {
        CartaDaGioco a=mazzo.get(pos);
        mazzo.remove(pos);
        return a;
    }
    
    public CartaDaGioco vediCartaCima()
    {
        return mazzo.get(0); 
    }
    
    public String toString()
    {
        String mazzoString = "";
        for(int i = 0; i<mazzo.size();i++)
        {
            mazzoString += Integer.toString(mazzo.get(i).getNumero()) + mazzo.get(i).getSeme().charAt(0) +" ";
        }
        return mazzoString;
    }
    
    public void creaMazzo()
    {
        String[] semi = {"cuori", "quadri", "fiori", "picche"};
        int n = 1, indSeme = 0;
        
        for(int i = 0; i<40; i++)
        {
            if(n==11) 
            {
                n=1;
                if(i<40)indSeme++;
            }
            
            mazzo.add(new CartaDaGioco("napoletane", semi[indSeme], n, "", false));
            n++;
        }
    }
    
    public void creaMazzoNapoletane()
    {
        String[] semi = {"b", "s", "d", "c"};
        int n = 1, indSeme = 0;
        
        for(int i = 0; i<40; i++)
        {
            if(n==11) 
            {
                n=1;
                if(i<40)indSeme++;
            }
            
            mazzo.add(new CartaDaGioco("napoletane", semi[indSeme], n, "", false));
            n++;
        }
    }
    
    public void creaMazzoPoker()
    {
        String[] semi = {"cuori", "quadri", "fiori", "picche"};
        int n = 1, indSeme = 0;
        
        for(int i = 0; i<52; i++)
        {
            if(n==14) 
            {
                n=1;
                if(i<52)indSeme++;
            }
            
            mazzo.add(new CartaDaGioco("poker", semi[indSeme], n, "", false));
            n++;
        }
    }
}
