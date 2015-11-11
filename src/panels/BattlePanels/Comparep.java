package panels.BattlePanels;

import game.Startgame;
import panels.MainFrame;
import panels.Preparep;
import ships.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Win7uX32 on 2015/7/21.
 */
public class Comparep extends JPanel {
    JScrollPane scp1;
    JScrollPane scp2;
    public Comparep(){
        init();
        repaint();
        scp1.repaint();
    }
    public void init(){

        setLayout(null);
        setBackground(Color.cyan);
        setBounds(new Rectangle(0, Preparep.sth, MainFrame.WID, MainFrame.HEI * 6 / 7));

        Ship[] shs=Startgame.player.battle.ships;
        int na=Startgame.player.battle.numofship;

        JPanel[] invp=new JPanel[na];
        for(int i=0;i<na;i++){
            invp[i]=new JPanel();
        }

        int sh=0;int h=(MainFrame.HEI-sh)/(22);int sw=10;int w=1000;
        //sh+=h;
        JLabel tt=new JLabel();
        tt.setBounds(new Rectangle(sw,0,1000,h));
        tt.setText("name                                                       category       class " +
                "                     hea we aa as " +
                "sea attc lv exp sp cont");

        sh+=h;
        for(int i=0;i<na;i++){
            invp[i].setBounds(new Rectangle(0, sh, w, h-5));
            invp[i].setLayout(null);

            JLabel name=new JLabel();
            name.setBounds(new Rectangle(sw+0,0,200,h));
            name.setText(shs[i].name);
            invp[i].add(name);

            JLabel type1=new JLabel();
            type1.setBounds(new Rectangle(sw+200,0,70,h));
            type1.setText(shs[i].type1);
            invp[i].add(type1);

            JLabel type2=new JLabel();
            type2.setBounds(new Rectangle(sw+270,0,100,h));
            type2.setText(shs[i].type2);
            invp[i].add(type2);

            JLabel health=new JLabel();
            health.setBounds(new Rectangle(sw+370,0,30,h));
            health.setText(shs[i].resthealth+"");
            invp[i].add(health);

            JLabel weight=new JLabel();
            weight.setBounds(new Rectangle(sw+390,0,30,h));
            weight.setText(shs[i].weight+"");
            invp[i].add(weight);

            JLabel antiair=new JLabel();
            antiair.setBounds(new Rectangle(sw+410,0,30,h));
            antiair.setText(shs[i].getantiair(true)+"");
            invp[i].add(antiair);

            JLabel antisub=new JLabel();
            antisub.setBounds(new Rectangle(sw+430,0,30,h));
            antisub.setText(shs[i].getantisub(true)+"");
            invp[i].add(antisub);

            JLabel search=new JLabel();
            search.setBounds(new Rectangle(sw+450,0,100,h));
            search.setText(shs[i].getsearch(true)+"");
            invp[i].add(search);

            JLabel attack=new JLabel();
            attack.setBounds(new Rectangle(sw+470,0,100,h));
            attack.setText(shs[i].getattack(true)+"");
            invp[i].add(attack);

            JLabel level=new JLabel();
            level.setBounds(new Rectangle(sw+490,0,100,h));
            level.setText(shs[i].level+"");
            invp[i].add(level);

            JLabel experience=new JLabel();
            experience.setBounds(new Rectangle(sw+510,0,100,h));
            experience.setText(shs[i].experience+"");
            invp[i].add(experience);

            JLabel speed=new JLabel();
            speed.setBounds(new Rectangle(sw+530,0,100,h));
            speed.setText(shs[i].insspeed+"");
            invp[i].add(speed);

            JLabel continuation=new JLabel();
            continuation.setBounds(new Rectangle(sw+550,0,100,h));
            continuation.setText(shs[i].endurence +"");
            invp[i].add(continuation);

            sh+=h;
        }
        JPanel tmp=new JPanel();
        tmp.setBackground(Color.magenta);
        tmp.setLayout(null);
        for(int i=0;i<na;i++){
            invp[i].setBackground(Color.cyan);
            tmp.add(invp[i]);
        }
        tmp.add(tt);
        tmp.setPreferredSize(new Dimension(MainFrame.WID / 2-10-10,(na+6)*h));
        scp1=new JScrollPane(tmp);
        scp1.setBounds(new Rectangle(0, Preparep.sth, MainFrame.WID / 2-10, MainFrame.HEI * 2 / 3 - Preparep.sth));
        scp1.getVerticalScrollBar().setUnitIncrement(10);
        tmp.repaint();
        tmp.setVisible(true);
        scp1.validate();
        scp1.repaint();
        this.setVisible(true);
        tmp.repaint();
        add(scp1);
        scp1.repaint();
        tmp.repaint();
        scp1.repaint();








        Ship[] shs2=Startgame.ai.battle.ships;
        int na2=Startgame.ai.battle.numofship;

        JPanel[] invp2=new JPanel[na2];
        for(int i=0;i<na2;i++){
            invp2[i]=new JPanel();
        }

        sh=0;h=(MainFrame.HEI-sh)/(22);sw=10;w=1000;
        //sh+=h;
        JLabel tt2=new JLabel();
        tt2.setBounds(new Rectangle(sw, 0, 1000, h));
        tt2.setText("name                                                       category       class " +
                "                     hea we aa as " +
                "sea attc lv exp sp cont");

        sh+=h;
        for(int i=0;i<na2;i++){
            invp2[i].setBounds(new Rectangle(0, sh, w, h-5));
            invp2[i].setLayout(null);

            JLabel name=new JLabel();
            name.setBounds(new Rectangle(sw+0,0,200,h));
            name.setText(shs2[i].name);
            invp2[i].add(name);

            JLabel type1=new JLabel();
            type1.setBounds(new Rectangle(sw+200,0,70,h));
            type1.setText(shs2[i].type1);
            invp2[i].add(type1);

            JLabel type2=new JLabel();
            type2.setBounds(new Rectangle(sw+270,0,100,h));
            type2.setText(shs2[i].type2);
            invp2[i].add(type2);

            JLabel health=new JLabel();
            health.setBounds(new Rectangle(sw+370,0,30,h));
            health.setText(shs2[i].resthealth+"");
            invp2[i].add(health);

            JLabel weight=new JLabel();
            weight.setBounds(new Rectangle(sw+390,0,30,h));
            weight.setText(shs2[i].weight+"");
            invp2[i].add(weight);

            JLabel antiair=new JLabel();
            antiair.setBounds(new Rectangle(sw+410,0,30,h));
            antiair.setText(shs2[i].getantiair(true)+"");
            invp2[i].add(antiair);

            JLabel antisub=new JLabel();
            antisub.setBounds(new Rectangle(sw+430,0,30,h));
            antisub.setText(shs2[i].getantisub(true)+"");
            invp2[i].add(antisub);

            JLabel search=new JLabel();
            search.setBounds(new Rectangle(sw+450,0,100,h));
            search.setText(shs2[i].getsearch(true)+"");
            invp2[i].add(search);

            JLabel attack=new JLabel();
            attack.setBounds(new Rectangle(sw+470,0,100,h));
            attack.setText(shs2[i].getattack(true)+"");
            invp2[i].add(attack);

            JLabel level=new JLabel();
            level.setBounds(new Rectangle(sw+490,0,100,h));
            level.setText(shs2[i].level+"");
            invp2[i].add(level);

            JLabel experience=new JLabel();
            experience.setBounds(new Rectangle(sw+510,0,100,h));
            experience.setText(shs2[i].experience+"");
            invp2[i].add(experience);

            JLabel speed=new JLabel();
            speed.setBounds(new Rectangle(sw+530,0,100,h));
            speed.setText(shs2[i].insspeed+"");
            invp2[i].add(speed);

            JLabel continuation=new JLabel();
            continuation.setBounds(new Rectangle(sw+550,0,100,h));
            continuation.setText(shs2[i].endurence +"");
            invp2[i].add(continuation);

            sh+=h;
        }
        JPanel tmp2=new JPanel();
        tmp2.setBackground(Color.magenta);
        tmp2.setLayout(null);
        for(int i=0;i<na2;i++){
            invp2[i].setBackground(Color.cyan);
            tmp2.add(invp2[i]);
        }
        tmp2.add(tt2);
        tmp2.setPreferredSize(new Dimension(MainFrame.WID / 2 - 10-10, (na2 + 6) * h));
        scp2=new JScrollPane(tmp2);
        scp2.setBounds(new Rectangle(MainFrame.WID / 2-10, Preparep.sth, MainFrame.WID / 2-10, MainFrame.HEI * 2 / 3 - Preparep.sth));
        scp2.getVerticalScrollBar().setUnitIncrement(10);
        tmp2.repaint();
        tmp2.setVisible(true);
        scp2.validate();
        scp2.repaint();
        this.setVisible(true);
        tmp2.repaint();
        add(scp2);
        scp2.repaint();
        tmp2.repaint();
        scp2.repaint();
    }
    public void refresh(){
        this.removeAll();
        this.init();
        MainFrame.f.validate();
        repaint();
    }
}
