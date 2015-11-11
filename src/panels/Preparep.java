package panels;

import game.Startgame;
import panels.preparePanels.Buildp;
import panels.preparePanels.Inspectp;
import panels.preparePanels.Inventionsp;
import panels.preparePanels.Inventp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Win7uX32 on 2015/7/21.
 */
public class Preparep extends JPanel {
    JButton inventions,invent,build,inspect,next;
    JPanel cp;
    public static Inventionsp inventionsp=null;
    public static Inventp inventp=null;
    public static Inspectp inspectp=null;
    public static Buildp buildp=null;
    public static BattlePane battlePane=new BattlePane();
    public static int sth;
    public Preparep(){
        setLayout(null);
        setBackground(Color.cyan);
        setBounds(new Rectangle(0, 0, MainFrame.WID, MainFrame.HEI));

        JLabel cash=new JLabel();
        cash.setText(Startgame.player.cash+"");
        JLabel industry=new JLabel();
        industry.setText(Startgame.player.industry+"");

        inventions=new JButton("inventions");
        invent=new JButton("invent");
        build=new JButton("build");
        inspect=new JButton("inspect");
        next=new JButton("next");

        int nob=5;int sl=50;int height=30;;int usl=10;
        int width=(MainFrame.WID-sl)/nob;sth=usl+height;
        cash.setBounds(new Rectangle(0,0,sl,usl));
        industry.setBounds(new Rectangle(0,usl,sl,usl));
        inventions.setBounds(new Rectangle(sl,usl,width,height));
        invent.setBounds(new Rectangle(sl+width,usl,width,height));
        build.setBounds(new Rectangle(sl+2*width,usl,width,height));
        inspect.setBounds(new Rectangle(sl+3*width,usl, width, height));
        next.setBounds(new Rectangle(sl+4*width,usl,width,height));

        inventions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // Startgame.write();////////////////////////////
                if(inventionsp==null){
                    inventionsp=new Inventionsp();
                }
                set(inventionsp);
            }
        });
        invent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(inventp==null){
                    inventp=new Inventp();
                }
                set(inventp);
            }
        });
        build.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(buildp==null){
                    buildp=new Buildp();
                }
                set(buildp);
                validate();
            }
        });
        inspect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(inspectp==null||MainFrame.cinspectp){
                    inspectp=new Inspectp();
                    MainFrame.cinspectp=false;
                }
                set(inspectp);
                validate();
            }
        });
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Startgame.write();
                MainFrame.set(battlePane);
                BattleFrame bf = new BattleFrame();

                Thread t1 = new Thread(bf);

                t1.start();

                // BattleFrame.start();
            }
        });
        inventionsp=new Inventionsp();
        cp=inventionsp;

        this.add(cash);
        this.add(industry);
        this.add(inventions);
        this.add(invent);
        this.add(build);
        this.add(inspect);
        this.add(next);

        this.add(cp);
    }
    public void set(JPanel p){
        remove(cp);
        add(p);
        cp=p;
        repaint();
        //p.repaint(new Rectangle(0,0,1000,600));
    }
}
