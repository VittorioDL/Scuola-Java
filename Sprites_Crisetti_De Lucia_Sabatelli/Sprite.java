import javax.swing.*;
import java.awt.*;

public class Sprite
{
    private String tipo;
    public JLabel label;
    
    public Sprite(String tipo, JLabel label)
    {
        this.tipo = tipo;
        this.label = label;
    }
    
    public void creaSprite()
    {
        if(tipo == "buono")
        {
            label.setIcon(new ImageIcon(new ImageIcon("buono.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
        }
        else if(tipo == "cattivo")
        {
            label.setIcon(new ImageIcon(new ImageIcon("cattivo.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));   
        }
        label.setVisible(true);
    }
    
    public JLabel getLabel()
    {
        label.setVisible(true);
        return label;
    }
    
    public int getX()
    {
        label.setVisible(true);
        return (int)label.getLocation().x;
    }
    
    public int getY()
    {
        label.setVisible(true);
        return (int)label.getLocation().y;
    }
    
}
