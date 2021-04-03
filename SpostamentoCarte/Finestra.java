import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Finestra extends JFrame implements ActionListener, KeyListener, MouseListener
{ 
    int nG = 6, totCarte = 40;
    ArrayList<MazzoDiCarte> mazzi;
    CartaDaGioco cSelected = new CartaDaGioco("", "", -1, "", false);
    
    JPanel top = new JPanel();
    JPanel down = new JPanel();
    JPanel right = new JPanel();
    JPanel left = new JPanel();
    JPanel center = new JPanel();
    
    GridBagConstraints gbc = new GridBagConstraints();
    
    public Finestra()
    {  
        setSize(800, 700);
        setResizable(false);
        setLocation(0, 0);
        Container c = this.getContentPane();
        c.setBackground(new Color(0, 179, 0));
        
        setLayout(new BorderLayout());
        
        left.setLayout(new GridLayout(5, 1, 0, 4));
        right.setLayout(new GridLayout(5, 1, 0, 4));
        
        center.setLayout(new GridBagLayout());
        gbc.insets = new Insets(0, 2, 0, 2);
        
        left.setPreferredSize(new Dimension(63, 541));
        right.setPreferredSize(new Dimension(63, 541));
        top.setPreferredSize(new Dimension(786, 119));
        down.setPreferredSize(new Dimension(786, 119));
        
        top.setOpaque(false);
        down.setOpaque(false);
        right.setOpaque(false);
        left.setOpaque(false);
        center.setBackground(new Color(0, 140, 0));
        
        left.addMouseListener(this);
        right.addMouseListener(this);
        top.addMouseListener(this);
        down.addMouseListener(this);
        center.addMouseListener(this);
        
        top.setBorder(BorderFactory.createLineBorder(new Color(218,165,32), 3));
        down.setBorder(BorderFactory.createLineBorder(new Color(218,165,32), 3));
        left.setBorder(BorderFactory.createLineBorder(new Color(218,165,32), 3));
        right.setBorder(BorderFactory.createLineBorder(new Color(218,165,32), 3));
        
        add(top, BorderLayout.NORTH);      
        add(down, BorderLayout.SOUTH);  
        add(right, BorderLayout.EAST);
        add(left, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);
        
        //--------------------------------------------------
        
        mazzi = new ArrayList(nG);
        for(int i = 0; i < nG; i++) mazzi.add(i, new MazzoDiCarte());
        
        //Creazione mazzo principale
        mazzi.get(0).creaMazzoNapoletane();
        mazzi.get(0).mischiaMazzo();
        
        //Creazione mazzi ai bordi
        for(int i = 1; i <= 4; i++)
        {
            int nC = (int)(Math.random()*6);
            for(int j = 1; j <= nC; j++)
            {       
                mazzi.get(i).aggiungiCarta(mazzi.get(0).pescaCartaCima());
                mazzi.get(i).mazzo.get(j-1).setMazzo(i);
                totCarte--;
            }
        }
        
        //Creazione icone carte bordi
        for(int i = 1; i <= 4; i++)
        {
            for(int j = 0; j < mazzi.get(i).mazzo.size(); j++)
            {
                mazzi.get(i).mazzo.get(j).creaIconaCarta();
                mazzi.get(i).mazzo.get(j).addMouseListener(this);
            }
        }
        
        //Aggiunta carte ai relativi pannelli
        for(int i = 0; i < mazzi.get(1).mazzo.size(); i++) top.add(mazzi.get(1).mazzo.get(i));
        for(int i = 0; i < mazzi.get(2).mazzo.size(); i++) right.add(mazzi.get(2).mazzo.get(i));
        for(int i = 0; i < mazzi.get(3).mazzo.size(); i++) left.add(mazzi.get(3).mazzo.get(i));
        for(int i = 0; i < mazzi.get(4).mazzo.size(); i++) down.add(mazzi.get(4).mazzo.get(i));
        
        //--------------------------------------------------
        
        //Creazione mazzo centrale
        int nCarteCentro = (int)(Math.random()*8);
        
        for(int i = 1; i <= nCarteCentro; i++)
        {
            mazzi.get(5).aggiungiCarta(mazzi.get(0).pescaCartaCima());
            mazzi.get(5).mazzo.get(i-1).setMazzo(5);
            totCarte--;
        }
        
        //Creazione icone mazzo centrale 
        for(int i = 0; i < mazzi.get(5).mazzo.size(); i++)
        {
            mazzi.get(5).mazzo.get(i).creaIconaCarta();
            mazzi.get(5).mazzo.get(i).addMouseListener(this);
        }
        
        //Aggiunta carte del mazzo centrale 
        for(int i = 0; i < nCarteCentro; i++) center.add(mazzi.get(5).mazzo.get(i), gbc);

        setVisible(true);
    }
    
    public void mousePressed(MouseEvent e)
    {  
        //Seleziona la carta
        Object source = e.getSource();
        if(e.getButton() == MouseEvent.BUTTON1 && source instanceof JLabel)
        {
            CartaDaGioco carta = (CartaDaGioco)e.getSource();
            if(carta.getSelezionata()) carta.deseleziona();                 
            else
            {
                carta.seleziona();
                if(cSelected.getNumero() == -1) cSelected = carta;
            }
        }
        
        if(e.getButton() == MouseEvent.BUTTON1 && source instanceof JPanel)
        { 
            if(cSelected.getNumero() != -1 && cSelected.getSelezionata())
            {
                if(e.getSource() == left && mazzi.get(3).mazzo.size() < 5)
                {
                    mazzi.get(cSelected.getMazzo()).eliminaCarta(cSelected);
                    cSelected.deseleziona();
                    cSelected.setMazzo(3);
                    mazzi.get(3).aggiungiCarta(cSelected);
                    left.add(cSelected);
                    cSelected = new CartaDaGioco("", "", -1, "", false);
                    cSelected.setNumero(-1);
                    remove(cSelected);
                    invalidate();
                    validate();
                    repaint();
                }
                
                if(e.getSource() == right && mazzi.get(2).mazzo.size() < 5)
                {
                    mazzi.get(cSelected.getMazzo()).eliminaCarta(cSelected);
                    cSelected.deseleziona();
                    cSelected.setMazzo(2);
                    mazzi.get(2).aggiungiCarta(cSelected);
                    right.add(cSelected);
                    cSelected = new CartaDaGioco("", "", -1, "", false);
                    cSelected.setNumero(-1);
                    remove(cSelected);
                    invalidate();
                    validate();
                    repaint();                  
                }
                
                if(e.getSource() == top && mazzi.get(1).mazzo.size() < 5)
                {
                    mazzi.get(cSelected.getMazzo()).eliminaCarta(cSelected);
                    cSelected.deseleziona();
                    cSelected.setMazzo(1);
                    mazzi.get(1).aggiungiCarta(cSelected);
                    top.add(cSelected);
                    cSelected = new CartaDaGioco("", "", -1, "", false);
                    remove(cSelected);
                    invalidate();
                    validate();
                    repaint();
                }
                
                if(e.getSource() == down && mazzi.get(4).mazzo.size() < 5)
                {
                    mazzi.get(cSelected.getMazzo()).eliminaCarta(cSelected);
                    cSelected.deseleziona();
                    cSelected.setMazzo(4);
                    mazzi.get(4).aggiungiCarta(cSelected);
                    down.add(cSelected);
                    cSelected = new CartaDaGioco("", "", -1, "", false);
                    cSelected.setNumero(-1);
                    remove(cSelected);
                    invalidate();
                    validate();
                    repaint();
                }
                
                if(e.getSource() == center && mazzi.get(5).mazzo.size() < 7)
                {
                    mazzi.get(cSelected.getMazzo()).eliminaCarta(cSelected);
                    cSelected.deseleziona();
                    cSelected.setMazzo(5);
                    mazzi.get(5).aggiungiCarta(cSelected);
                    center.add(cSelected);
                    cSelected = new CartaDaGioco("", "", -1, "", false);
                    cSelected.setNumero(-1);
                    remove(cSelected);
                    invalidate();
                    validate();
                    repaint();
                }
            }
        }
        
        //Copre o scopre la carta
        if(e.getButton() == MouseEvent.BUTTON3)
        {
            CartaDaGioco carta = (CartaDaGioco)e.getSource();
            
            if(carta.getScoperta()) carta.copri();
            else carta.scopri();   
        }  
    }
    
    public void actionPerformed(ActionEvent e) {}

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {}
 
    public void mouseExited(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}
    
    public void mouseClicked(MouseEvent e) {}
    
}
