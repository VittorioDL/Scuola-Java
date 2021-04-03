import javax.swing.*;
import java.awt.*;
import java.nio.file.*;

public class CartaDaGioco extends JLabel
{
    private String tipoCarte;
    private String seme;
    private int numero;
    private int mazzo;
    private String colore;
    private boolean scoperta;
    public boolean selezionata;
    
    public CartaDaGioco(String tipoCarte, String seme, int numero, String colore, boolean scoperta)
    {
        super();
        this.tipoCarte = tipoCarte;
        this.seme = seme;
        this.numero = numero;
        this.colore = colore;
        this.scoperta = scoperta;
    }
    
    public void creaIconaCarta()
    {
        String pathCarta = "carte/"+Integer.toString(getNumero()) + getSeme() + ".jpg";
        scoperta = true;
        selezionata = false;
        setIcon(new ImageIcon(new ImageIcon(String.format(pathCarta)).getImage().getScaledInstance(50, 101, Image.SCALE_DEFAULT)));
    }
    
    public void setTipoCarte(String tipoCarte)
    {
       this.tipoCarte = tipoCarte;
    }
    
    public void setSeme(String seme)
    {
       this.tipoCarte = tipoCarte;
    }
    
    public void setNumero(int numero)
    {
       this.numero = numero;
    }
    
    public void setColore(String colore)
    {
       this.colore = colore;
    }
    
    public String getTipoCarte()
    {
        return tipoCarte;
    }
    
    public String getSeme()
    {
        return seme;
    }
    
    public int getNumero()
    {
        return numero;
    }
    
    public String getColore()
    {
        return colore;
    }
    
    public void scopri()
    {
        scoperta = true;
        String pathCarta = "carte/"+Integer.toString(getNumero()) + getSeme() + ".jpg";
        setIcon(new ImageIcon(new ImageIcon(String.format(pathCarta)).getImage().getScaledInstance(50, 101, Image.SCALE_DEFAULT)));
    }
    
    public void copri()
    {
        scoperta = false;
        setIcon(new ImageIcon("carte/11d.jpg"));
    }
    
    public boolean getScoperta()
    {
        return scoperta;
    }
    
    public void seleziona()
    {
        setBorder(BorderFactory.createLineBorder(Color.RED, 4));
        selezionata = true;
    }
    
    public void deseleziona()
    {
        setBorder(BorderFactory.createLineBorder(Color.RED, 0));
        selezionata = false;
    }
    
    public boolean getSelezionata()
    {
        return selezionata;
    }
    
    public void setMazzo(int m)
    {
        mazzo = m;
    }
    
    public int getMazzo()
    {
        return mazzo;
    }
}
