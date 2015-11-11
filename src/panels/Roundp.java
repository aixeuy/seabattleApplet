package panels;

import game.Startgame;
import panels.BattlePanels.Comparep;
import panels.BattlePanels.Instrup;
import panels.BattlePanels.Recordp;
import panels.preparePanels.Inspectp;
import panels.preparePanels.Inventp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Win7uX32 on 2015/7/21.
 */
public class Roundp extends JPanel {
    JButton record, compare, instruct;//,inspect,next;
    JPanel cp;
    //public static Inventionsp recordp =null;
    //public static Inventp comparep =null;
    //public static Inspectp instructp =null;
    //public static Buildp buildp=null;
    public static BattlePane battlePane=new BattlePane();
    public static int sth;
    public Roundp(){
        setLayout(null);
        setBackground(Color.cyan);
        setBounds(new Rectangle(0, 0, MainFrame.WID, MainFrame.HEI));

        JLabel cash=new JLabel();
        cash.setText(Startgame.player.cash+"");
        record =new JButton("record");
        compare =new JButton("compare");
        instruct =new JButton("instruct");
        //inspect=new JButton("inspect");
        //next=new JButton("next");

        int nob=5;int sl=50;int height=30;int usl=10;
        int width=(MainFrame.WID-sl)/nob;sth=usl+height;
        cash.setBounds(new Rectangle(0,0,sl,usl));
        record.setBounds(new Rectangle(sl, usl, width, height));
        compare.setBounds(new Rectangle(sl + width, usl, width, height));
        instruct.setBounds(new Rectangle(sl + 2 * width, usl, width, height));
        //inspect.setBounds(new Rectangle(sl+3*width,usl, width, height));
        //next.setBounds(new Rectangle(sl+4*width,usl,width,height));

        record.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                set(new Recordp());
            }
        });
        compare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                set(new Comparep());
                MainFrame.f.validate();
            }
        });
        instruct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                set(new Instrup());
                MainFrame.f.validate();
            }
        });
        /*inspect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(instructp ==null||MainFrame.cinspectp){
                    instructp =new Inspectp();
                    MainFrame.cinspectp=false;
                }
                set(instructp);
                validate();
            }
        });
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Startgame.br.next();
            }
        });*/
        //recordp =new Inventionsp();
        cp= new Recordp();

        this.add(cash);
        this.add(record);
        this.add(compare);
        this.add(instruct);
        //this.add(inspect);
        //this.add(next);

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
