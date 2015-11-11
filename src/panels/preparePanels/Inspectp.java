package panels.preparePanels;

import panels.MainFrame;
import panels.Preparep;
import panels.preparePanels.inspectPanels.Fleetsp;
import panels.preparePanels.inspectPanels.Viewp;
import panels.preparePanels.inventPanels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Win7uX32 on 2015/7/22.
 */
public class Inspectp extends JPanel {
    JPanel cp=new Viewp();
    //public static CVinvp cvinvp=new CVinvp();

    public Inspectp(){
        init();
    }
    public void init(){
        setLayout(null);
        setBackground(Color.magenta);
        setBounds(new Rectangle(0, Preparep.sth, MainFrame.WID, MainFrame.HEI));

        JButton cvj=new JButton("view");
        JButton bbj=new JButton("fleet");

        int ls=0; int hs=Preparep.sth;int hsp=MainFrame.HEI/3;;int h=30;int w=60;
        cvj.setBounds(new Rectangle(ls,hs,w,h));hs+=hsp;
        bbj.setBounds(new Rectangle(ls,hs,w,h));hs+=hsp;

        cvj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                set(new Viewp());
                validate();
            }
        });
        bbj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                set(new Fleetsp());
                validate();
            }
        });

        add(cvj);add(bbj);

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
