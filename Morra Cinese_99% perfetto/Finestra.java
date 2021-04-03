import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Finestra extends JFrame implements ActionListener, KeyListener, MouseListener
{  
    JPanel down = new JPanel();
    JPanel top = new JPanel();
    JPanel center = new JPanel();
    
    JLabel sasso = new JLabel();
    JLabel rete = new JLabel();
    JLabel forbici = new JLabel();
    
    JLabel user = new JLabel();
    JLabel pc = new JLabel();
    JLabel userText = new JLabel();
    JLabel pcText = new JLabel();
    
    //1: sasso, 2: carta, 3: forbici
    ArrayList<Integer> mosseUser; 
    ArrayList<Integer> mossePc;
    
    int draws = 0, wins = 0, losses = 0;
    JLabel w = new JLabel("Win: "+ wins);
    JLabel d = new JLabel("Draw: "+ draws);
    JLabel l = new JLabel("Lost: "+ losses);
    
    boolean end = true;
    
    public Finestra()
    {  
        setSize(700, 700);
        setResizable(false);
        setLocation(0, 0);
        setLayout(new BorderLayout());
        
        top.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
        down.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
        center.setLayout(null);
        
        top.setPreferredSize(new Dimension(700, 80));
        down.setPreferredSize(new Dimension(700, 120));
        
        top.setBackground(new Color(217, 217, 217));
        center.setBackground(new Color(230, 230, 230));
        down.setBackground(new Color(77, 255, 77));
      
        add(top, BorderLayout.NORTH); 
        add(down, BorderLayout.SOUTH); 
        add(center, BorderLayout.CENTER);
        //--------------------------------------------------
        
        //Creazione mosse tra cui scegliere-----------------
        sasso.setIcon(new ImageIcon(new ImageIcon("rock.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        sasso.setName("rock");
        sasso.setVisible(true);
        sasso.addMouseListener(this);
        down.add(sasso);
        
        rete.setIcon(new ImageIcon(new ImageIcon("paper.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        rete.setName("paper");
        rete.setVisible(true);
        rete.addMouseListener(this);
        down.add(rete);
        
        forbici.setIcon(new ImageIcon(new ImageIcon("scissor.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        forbici.setName("scissor");
        forbici.setVisible(true);
        forbici.addMouseListener(this);
        down.add(forbici);    
        
        //Visualizzazione punteggi---------------------------- 
        w.setVisible(true);
        w.setFont(new Font("Century Gothic", Font.PLAIN, 30));
        top.add(w);
        
        d.setVisible(true);
        d.setFont(new Font("Century Gothic", Font.PLAIN, 30));
        top.add(d);
        
        l.setVisible(true);
        l.setFont(new Font("Century Gothic", Font.PLAIN, 30));
        top.add(l);
           
        //Creazione user--------------------------------------
        mosseUser = new ArrayList();
        user.setIcon(new ImageIcon("user.png"));
        user.setVisible(true);
        user.setBounds(300, 280, 100, 100);
        center.add(user); 
        //--Label user----------------------------------------
        userText = new JLabel("USER");
        userText.setVisible(true);
        userText.setFont(new Font("Century Gothic", Font.BOLD, 20));  
        userText.setBounds(330, 380, 100, 30);
        center.add(userText); 
        
        //Creazione pc----------------------------------------
        mossePc = new ArrayList();
        pc.setIcon(new ImageIcon("pc.png"));
        pc.setVisible(true);
        pc.setBounds(300, 40, 100, 100);
        center.add(pc); 
        //--Label pc----------------------------------------
        pcText = new JLabel("PC");
        pcText.setVisible(true);
        pcText.setFont(new Font("Century Gothic", Font.BOLD, 20));  
        pcText.setBounds(335, 10, 100, 30);
        center.add(pcText); 

        //--------------------------------------------------
        setVisible(true);
    }
    
    public void mousePressed(MouseEvent e)
    {  
        
        if(e.getButton() == MouseEvent.BUTTON1 && e.getSource() instanceof JLabel && end)
        {
            JLabel source = (JLabel)e.getSource();
            if(source.getName() == "rock") 
            {
                user.setIcon(new ImageIcon(new ImageIcon("rock.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
                mosseUser.add(1);
                int mossaPc = (int)(Math.random()*3+1);
                if(mossaPc == 1)
                {
                    pc.setIcon(new ImageIcon(new ImageIcon("rock.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
                    draws++;
                    pc.setBorder(BorderFactory.createLineBorder(new Color(128, 191, 255), 4));
                    user.setBorder(BorderFactory.createLineBorder(new Color(128, 191, 255), 4));
                }
                
                if(mossaPc == 2)
                {
                    pc.setIcon(new ImageIcon(new ImageIcon("paper.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
                    losses++;
                    user.setBorder(BorderFactory.createLineBorder(new Color(255, 92, 51), 4));
                    pc.setBorder(BorderFactory.createLineBorder(new Color(0, 179, 0), 4));
                }
                
                if(mossaPc == 3)
                {
                    pc.setIcon(new ImageIcon(new ImageIcon("scissor.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
                    wins++;
                    user.setBorder(BorderFactory.createLineBorder(new Color(0, 179, 0), 4));
                    pc.setBorder(BorderFactory.createLineBorder(new Color(255, 92, 51), 4));
                }
                mossePc.add(mossaPc);
            }
            
            if(source.getName() == "paper") 
            {
                user.setIcon(new ImageIcon(new ImageIcon("paper.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
                mosseUser.add(2);
                int mossaPc = (int)(Math.random()*3+1);
                if(mossaPc == 1)
                {
                    pc.setIcon(new ImageIcon(new ImageIcon("rock.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
                    wins++;
                    pc.setBorder(BorderFactory.createLineBorder(new Color(255, 92, 51), 4));
                    user.setBorder(BorderFactory.createLineBorder(new Color(0, 179, 0), 4));
                }
                
                if(mossaPc == 2)
                {
                    pc.setIcon(new ImageIcon(new ImageIcon("paper.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
                    draws++;
                    user.setBorder(BorderFactory.createLineBorder(new Color(128, 191, 255), 4));
                    pc.setBorder(BorderFactory.createLineBorder(new Color(128, 191, 255), 4));
                }
                
                if(mossaPc == 3)
                {
                    pc.setIcon(new ImageIcon(new ImageIcon("scissor.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
                    losses++;
                    user.setBorder(BorderFactory.createLineBorder(new Color(255, 92, 51), 4));
                    pc.setBorder(BorderFactory.createLineBorder(new Color(0, 179, 0), 4));
                }
                mossePc.add(mossaPc);
            }
            
            if(source.getName() == "scissor")
            {
                user.setIcon(new ImageIcon(new ImageIcon("scissor.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
                mosseUser.add(3);
                int mossaPc = (int)(Math.random()*3+1);
                if(mossaPc == 1)
                {
                    pc.setIcon(new ImageIcon(new ImageIcon("rock.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
                    losses++;
                    user.setBorder(BorderFactory.createLineBorder(new Color(255, 92, 51), 4));
                    pc.setBorder(BorderFactory.createLineBorder(new Color(0, 179, 0), 4));
                }
                
                if(mossaPc == 2)
                {
                    pc.setIcon(new ImageIcon(new ImageIcon("paper.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
                    wins++;
                    pc.setBorder(BorderFactory.createLineBorder(new Color(255, 92, 51), 4));
                    user.setBorder(BorderFactory.createLineBorder(new Color(0, 179, 0), 4));
                }
                
                if(mossaPc == 3)
                {
                    pc.setIcon(new ImageIcon(new ImageIcon("scissor.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
                    draws++;
                    user.setBorder(BorderFactory.createLineBorder(new Color(128, 191, 255), 4));
                    pc.setBorder(BorderFactory.createLineBorder(new Color(128, 191, 255), 4));
                }
                mossePc.add(mossaPc);
            }
            w.setText("Win: "+wins);
            d.setText("Draw: "+draws);
            l.setText("Lost: "+losses);
            
            //Vittoria user
            if(wins == 5)
            {
                pc.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
                user.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
                
                pc.setIcon(new ImageIcon(new ImageIcon("second.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
                user.setIcon(new ImageIcon(new ImageIcon("first.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
                end = false;
            }
            
            //Vittoria user
            if(losses == 5)
            {
                pc.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
                user.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
                pc.setIcon(new ImageIcon(new ImageIcon("first.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
                user.setIcon(new ImageIcon(new ImageIcon("second.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
                end = false;
            }
            
            if(!end)
            {   
                pcText.setBounds(505, 5, 60, 30);
                userText.setBounds(130, 5, 60, 30);
                
                pc.setBounds(470, 40, 100, 100);
                user.setBounds(100, 40, 100, 100);
                
                JPanel p = new JPanel(new GridBagLayout());

                add(new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(4,4,4,4);
                
                gbc.gridy = 10;
                gbc.gridx = 2;
                JLabel rounds = new JLabel("ROUNDS");
                rounds.setVisible(true);
                rounds.setFont(new Font("Century Gothic", Font.PLAIN, 20));    
                rounds.setBounds(305, 10, 100, 30);
                p.add(rounds, gbc);
                
                for(int i=0; i<mossePc.size(); i++) 
                {
                    gbc.gridy = i+20;
                    
                    JLabel U = new JLabel();
                    JLabel P = new JLabel();
                    
                    //Aggiunta mosse user
                    if(mosseUser.get(i) == 1) U.setIcon(new ImageIcon(new ImageIcon("s.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
                    if(mosseUser.get(i) == 2) U.setIcon(new ImageIcon(new ImageIcon("r.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
                    if(mosseUser.get(i) == 3) U.setIcon(new ImageIcon(new ImageIcon("f.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
                    U.setVisible(true);
                    gbc.gridx = 1;
                    p.add(U, gbc);
                    
                    //Aggiunta numero round
                    JLabel nRound = new JLabel(Integer.toString(i+1));
                    nRound.setFont(new Font("Century Gothic", Font.PLAIN, 20));
                    gbc.gridx = 2;
                    p.add(nRound, gbc);
                    
                    //Aggiunta mosse pc
                    if(mossePc.get(i) == 1) P.setIcon(new ImageIcon(new ImageIcon("s.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
                    if(mossePc.get(i) == 2) P.setIcon(new ImageIcon(new ImageIcon("r.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
                    if(mossePc.get(i) == 3) P.setIcon(new ImageIcon(new ImageIcon("f.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
                    P.setVisible(true);
                    gbc.gridx = 3;
                    p.add(P, gbc);
                    
                    if(mosseUser.get(i) == 1 && mossePc.get(i) == 3 || 
                       mosseUser.get(i) == 2 && mossePc.get(i) == 1 || 
                       mosseUser.get(i) == 3 && mossePc.get(i) == 2)
                    {
                        U.setBorder(BorderFactory.createLineBorder(new Color(0, 179, 0), 2));
                        P.setBorder(BorderFactory.createLineBorder(new Color(255, 92, 51), 2));
                    }
                    
                    else if(mosseUser.get(i) == mossePc.get(i))
                    {
                        U.setBorder(BorderFactory.createLineBorder(new Color(128, 191, 255), 2));
                        P.setBorder(BorderFactory.createLineBorder(new Color(128, 191, 255), 2));
                    }
                    
                    else
                    {
                        U.setBorder(BorderFactory.createLineBorder(new Color(255, 92, 51), 2));
                        P.setBorder(BorderFactory.createLineBorder(new Color(0, 179, 0), 2));
                    }                  
                    center.setOpaque(false);
                }
            }
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
