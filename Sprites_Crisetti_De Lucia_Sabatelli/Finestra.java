import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Finestra extends JFrame implements ActionListener, KeyListener, MouseListener
{
    int nSprite = (int)(Math.random()*7+3);
    
    ArrayList<Sprite> sprites;
    ArrayList<Point> posizioni; 
    ArrayList<Point> destinazioni;
    
    Timer t = new Timer(10, this);
    public Finestra()
    {  
        setSize(600, 800);
        setLocation(50, 50);
        setLayout(null); 
        setResizable(false);
        setVisible(true);
        
        t.setActionCommand("TIMER");
        
        //Creiamo gli sprites in modo random
        sprites = new ArrayList<Sprite>(nSprite); 
        for(int i = 0; i < nSprite; i++)
        { 
            int tipoRandom = (int)(Math.random()*2+1);
            
            if(tipoRandom == 1) sprites.add(i, new Sprite("buono", new JLabel()));
            else if(tipoRandom == 2) sprites.add(i, new Sprite("cattivo", new JLabel()));
            sprites.get(i).creaSprite();
        }
        
        //Posizioniamo e visualizziamo gli sprites in modo random
        posizioni = new ArrayList<Point>(nSprite); 
        destinazioni = new ArrayList<Point>(nSprite); 
        
        for(int i = 0; i < nSprite; i++)
        {
            int x = (int)(Math.random()*(500))+50;
            int y = (int)(Math.random()*(700));
            
            int x1 = (int)(Math.random()*(500))+50;
            int y1 = (int)(Math.random()*(700));
            
            posizioni.add(new Point(x, y));
            destinazioni.add(new Point(x1, y1));
            
            sprites.get(i).label.setBounds(x, y, 40, 40);
            
            add(sprites.get(i).label);
        }
        t.start();
    }
    
    public void spostamentoLabel(int currentX, int currentY, int x, int y, JLabel testo) 
    {   
        if(currentX<x)
        {
            currentX++;
            testo.setLocation(currentX, currentY);
        }
                
        else if(currentX>x)
        {
            currentX--;
            testo.setLocation(currentX, currentY);
        }
                
        if(currentY<y)
        {
            currentY++;
            testo.setLocation(currentX, currentY);
        }
                
        else if(currentY>y)
        {
            currentY--;
            testo.setLocation(currentX, currentY);
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getActionCommand() == "TIMER")
        {
            for(int i = 0; i < nSprite; i++)
            {
               posizioni.set(i, new Point(sprites.get(i).getX(), sprites.get(i).getY()));      
            }
            
            for(int i = 0; i < nSprite; i++)
            {
                spostamentoLabel((int)posizioni.get(i).getX(), (int)posizioni.get(i).getY(), destinazioni.get(i).x, destinazioni.get(i).y, sprites.get(i).getLabel());
            }
            
            for(int i = 0; i < nSprite; i++)
            {
                if(posizioni.get(i).x == destinazioni.get(i).x && posizioni.get(i).y == destinazioni.get(i).y)
                {
                    destinazioni.get(i).x = (int)(Math.random()*(500)+50);
                    destinazioni.get(i).y = (int)(Math.random()*(700));
                }
            }
        }
    }
    
    public void keyReleased(KeyEvent e)
    {
        
    }
    
    public void keyTyped(KeyEvent e)
    {
        
    }
    
    public void keyPressed(KeyEvent e)
    {
       
    }
    
    public void mouseExited(MouseEvent e)
    {
        
    }
    
    public void mouseEntered(MouseEvent e)
    {
        
    }
    
    public void mouseReleased(MouseEvent e)
    {
        
    }
    
    public void mousePressed(MouseEvent e)
    {
      
    }
    
    public void mouseClicked(MouseEvent e)
    {
           
    }
    
}
