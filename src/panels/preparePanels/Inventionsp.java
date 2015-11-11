package panels.preparePanels;

import game.Startgame;
import panels.MainFrame;
import panels.Preparep;
import ships.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Win7uX32 on 2015/7/21.
 */
public class Inventionsp extends JPanel {

    public Inventionsp(){
        init();
    }
    public void init(){
        Font font1=new Font("SansSerif",Font.BOLD,15);

        setLayout(null);
        setBackground(Color.magenta);
        setBounds(new Rectangle(0, Preparep.sth, MainFrame.WID, MainFrame.HEI));

        JPanel txtpn=new JPanel();
        txtpn.setLayout(null);
        txtpn.setBackground(Color.cyan);
        txtpn.setBounds(new Rectangle(60 + MainFrame.WID / 2, Preparep.sth, MainFrame.WID / 2 - 80, MainFrame.HEI * 2 / 3 - Preparep.sth));
        final JLabel lb= new JLabel();
        lb.setBounds(new Rectangle(20, 0, MainFrame.WID/2-100,MainFrame.HEI * 2 / 3 - Preparep.sth));
        txtpn.add(lb);
        JButton update=new JButton("update");JButton weed=new JButton("weed");
        update.setBounds(new Rectangle(0,MainFrame.HEI * 2 / 3 - Preparep.sth-30,100,30));
        weed.setBounds(new Rectangle(100,MainFrame.HEI * 2 / 3 - Preparep.sth-30,100,30));
        final Ship[] sel = {null};
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str=Startgame.player.special.update(sel[0],JOptionPane.showInputDialog( "Enter new name"));
                JOptionPane.showMessageDialog(MainFrame.f, str);
                refresh();
            }
        });
        weed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Startgame.player.special.weed(sel[0]);
                refresh();
            }
        });
        txtpn.add(update);txtpn.add(weed);
        add(txtpn);

        JPanel[] invp=new JPanel[15];
        for(int i=0;i<15;i++){
            invp[i]=new JPanel();
        }

        int sh=Preparep.sth;int h=(MainFrame.HEI-sh)/22;int sw=50;int w=MainFrame.WID/2;
        //sh+=h;
        for(int i=0;i<3;i++){
            invp[i].setBounds(new Rectangle(sw, sh, w, h-5));

            invp[i].setLayout(null);
            JLabel jl=new JLabel();
            jl.setFont(font1);
            jl.setBounds(new Rectangle(20,0,w,h));
            if(Startgame.player.special.cv[i - 0]!=null){jl.setText(Startgame.player.special.cv[i - 0].type2);}
            invp[i].add(jl);
            sh+=h;

            final int I=i;
            invp[i].addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent e) {
                    if(Startgame.player.special.cv[I - 0]!=null){lb.setText(Startgame.player.special.cv[I - 0].toStringL());
                        sel[0] =Startgame.player.special.cv[I - 0];}
                }
            });
        }
        sh+=h;
        for(int i=3;i<6;i++){
            invp[i].setBounds(new Rectangle(sw,sh,w,h-5));
            //invp[i].add(new JLabel(Startgame.player.special.bb[i-3].type2));
            sh+=h;
            invp[i].setLayout(null);
            JLabel jl=new JLabel();
            jl.setFont(font1);
            jl.setBounds(new Rectangle(20,0,w,h));
            if(Startgame.player.special.bb[i-3]!=null){jl.setText(Startgame.player.special.bb[i-3].type2);}
            invp[i].add(jl);

            final int I=i;
            invp[i].addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent e) {
                    if(Startgame.player.special.bb[I-3]!=null){lb.setText(Startgame.player.special.bb[I-3].toStringL());
                        sel[0] =Startgame.player.special.bb[I-3];}
                }
            });
        }
        sh+=h;
        for(int i=6;i<9;i++){
            invp[i].setBounds(new Rectangle(sw,sh,w,h-5));
            //invp[i].add(new JLabel(Startgame.player.special.c[i-6].type2));
            sh+=h;
            invp[i].setLayout(null);
            JLabel jl=new JLabel();
            jl.setFont(font1);
            jl.setBounds(new Rectangle(20,0,w,h));
            if(Startgame.player.special.c[i-6]!=null){jl.setText(Startgame.player.special.c[i-6].type2);}
            invp[i].add(jl);

            final int I=i;
            invp[i].addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent e) {
                    if(Startgame.player.special.c[I-6]!=null){lb.setText(Startgame.player.special.c[I - 6].toStringL());
                        sel[0] =Startgame.player.special.c[I-6];}
                }
            });
        }
        sh+=h;
        for(int i=9;i<12;i++){
            invp[i].setBounds(new Rectangle(sw,sh,w,h-5));
            //invp[i].add(new JLabel(Startgame.player.special.dd[i-9].type2));
            sh+=h;
            invp[i].setLayout(null);
            JLabel jl=new JLabel();
            jl.setFont(font1);
            jl.setBounds(new Rectangle(20,0,w,h-5));
            if(Startgame.player.special.dd[i-9]!=null){jl.setText(Startgame.player.special.dd[i-9].type2);}
            invp[i].add(jl);

            final int I=i;
            invp[i].addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent e) {
                    if(Startgame.player.special.dd[I-9]!=null){ lb.setText(Startgame.player.special.dd[I - 9].toStringL());
                        sel[0] =Startgame.player.special.dd[I-9];}
                }
            });
        }
        sh+=h;
        for(int i=12;i<15;i++){
            invp[i].setBounds(new Rectangle(sw,sh,w,h-5));
            //invp[i].add(new JLabel(Startgame.player.special.ss[i-12].type2));
            sh+=h;
            invp[i].setLayout(null);
            JLabel jl=new JLabel();
            jl.setFont(font1);
            jl.setBounds(new Rectangle(20,0,w,h));
            if(Startgame.player.special.ss[i-12]!=null){jl.setText(Startgame.player.special.ss[i-12].type2);}
            invp[i].add(jl);

            final int I=i;
            invp[i].addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent e) {
                    if(Startgame.player.special.ss[I-12]!=null){lb.setText(Startgame.player.special.ss[I - 12].toStringL());
                        sel[0] =Startgame.player.special.ss[I-12];}
                }
            });
        }

        for(int i=0;i<15;i++){
            //invp[i]=new JPanel();
            invp[i].setBackground(Color.cyan);
            this.add(invp[i]);
        }
    }
    public void refresh(){
        this.removeAll();
        this.init();
        repaint();
    }
}
