package panels.preparePanels;

import panels.MainFrame;
import panels.Preparep;
import panels.preparePanels.inventPanels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Win7uX32 on 2015/7/22.
 */
public class Inventp extends JPanel {
    JPanel cp=new CVinvp();;
    //public static CVinvp cvinvp=new CVinvp();

    public Inventp(){
        init();
    }
    public void init(){
        setLayout(null);
        setBackground(Color.magenta);
        setBounds(new Rectangle(0, Preparep.sth, MainFrame.WID, MainFrame.HEI));

        JButton cvj=new JButton("CV");
        JButton bbj=new JButton("BB");
        JButton cj=new JButton("C");
        JButton ddj=new JButton("DD");
        JButton ssj=new JButton("SS");

        int ls=0; int hs=Preparep.sth;int hsp=MainFrame.HEI/6;;int h=30;int w=60;
        cvj.setBounds(new Rectangle(ls,hs,w,h));hs+=hsp;
        bbj.setBounds(new Rectangle(ls,hs,w,h));hs+=hsp;
        cj.setBounds(new Rectangle(ls,hs,w,h));hs+=hsp;
        ddj.setBounds(new Rectangle(ls,hs,w,h));hs+=hsp;
        ssj.setBounds(new Rectangle(ls,hs,w,h));hs+=hsp;

        cvj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                set(new CVinvp());
            }
        });
        bbj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                set(new BBinvp());
            }
        });
        cj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                set(new Cinvp());
            }
        });
        ddj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                set(new DDinvp());
            }
        });
        ssj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                set(new SSinvp());
            }
        });

        add(cvj);add(bbj);add(cj);add(ddj);add(ssj);

    //    cp=cvinvp;
        add(cp);

    }
    public void set(JPanel p){
        remove(cp);
        add(p);
        cp=p;
        repaint();
        //p.repaint(new Rectangle(0,0,1000,600));
    }
    public void refresh(){
        this.removeAll();
        this.init();
        repaint();
    }
}
