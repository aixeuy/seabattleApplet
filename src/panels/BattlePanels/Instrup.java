package panels.BattlePanels;

import game.Startgame;
import panels.MainFrame;
import panels.Preparep;
import ships.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Win7uX32 on 2015/7/21.
 */
public class Instrup extends JPanel {
    JScrollPane scp1;
    JScrollPane scp2;
    public Instrup(){
        init();
        repaint();
        scp1.repaint();
    }
    public void init(){

        setLayout(null);
        setBackground(Color.cyan);
        setBounds(new Rectangle(0, Preparep.sth, MainFrame.WID, MainFrame.HEI * 6 / 7));

        final Ship[] shs=Startgame.player.battle.ships;
        int na=Startgame.player.battle.numofship;

        JPanel[] invp=new JPanel[na];
        for(int i=0;i<na;i++){
            invp[i]=new JPanel();
        }

        int w1=1000;
        int sh=0;int h=(MainFrame.HEI-sh)/(22);int sw=10;int www=MainFrame.WID / 2-10-10+140;
        //sh+=h;
        JLabel tt=new JLabel();
        tt.setBounds(new Rectangle(sw, 0, 1000, h));
        tt.setText("name                                                       category       class " +
                "                     hea aa as " +
                "sea attc sp endu");

        sh+=h;
        JPanel all=new JPanel();
        all.setBounds(new Rectangle(0, sh, www, h-5));
        all.setLayout(null);
        all.setBackground(Color.cyan);

        JLabel fleet =new JLabel("fleet");
        fleet.setBounds(new Rectangle(sw+0,0,200,h));
        all.add(fleet);

        String[] ss={"rest","hunt","forward","defence","backward","retreat","none",null};
        int index=7;

        JComboBox <String> list = new JComboBox<String>(ss); //data has type Object[]
        list.setSelectedIndex(index);
        list.setBounds(new Rectangle(sw+530,0,90,h));
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String Instr = (String)cb.getSelectedItem();
                if(Instr==null){return;}
                if(Instr.equals("forward")||Instr.equals("backward")){
                    boolean first=true;
                    for(Ship s:shs){
                        if(s==null){break;}
                        if(s.type1.equals("carrier")||s.type1.equals("battleship")||first){
                            s.instruction=Instr;
                            first=false;
                        }
                        else{
                            s.instruction="defence";
                        }
                    }
                }
                else{
                    for(Ship s:shs){
                        if(s==null){break;}
                            s.instruction=Instr;
                    }
                }
                refresh();
            }
        });
        all.add(list);

        ArrayList<String> ts=new ArrayList<String>();
        index=0;
        for(int j=0;j<Startgame.ai.battle.numofship;j++){
            if(Startgame.ai.battle.ships[j]==null){
                break;
            }
            ts.add(Startgame.ai.battle.ships[j].name);
        }
        String[] tts=new String[ts.size()+1];
        for(int j=0;j<tts.length-1;j++){
            tts[j]=ts.get(j);
        }
        index=tts.length-1;
        JComboBox <String> targetlist = new JComboBox<String>(tts);
        targetlist.setSelectedIndex(index);
        targetlist.setBounds(new Rectangle(sw+620,0,90,h));
        targetlist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String Instr = (String)cb.getSelectedItem();
                if(Instr==null){
                    for(Ship s:shs) {
                        if(s==null){break;}
                        Startgame.choosetarget(s, Startgame.ai.battle.ships, Startgame.ai.battle.numofship);
                    }
                }
                else {
                    for(Ship s:shs) {
                        if(s==null){break;}
                        s.target = Startgame.ai.battle.find(Instr);
                    }
                }
                refresh();
            }
        });
        all.add(targetlist);
        sh+=h;



        for(int i=0;i<na;i++){
            invp[i].setBounds(new Rectangle(0, sh, www, h-5));
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

            JLabel antiair=new JLabel();
            antiair.setBounds(new Rectangle(sw+390,0,30,h));
            antiair.setText(shs[i].getantiair(true)+"");
            invp[i].add(antiair);

            JLabel antisub=new JLabel();
            antisub.setBounds(new Rectangle(sw+410,0,30,h));
            antisub.setText(shs[i].getantisub(true)+"");
            invp[i].add(antisub);

            JLabel search=new JLabel();
            search.setBounds(new Rectangle(sw+430,0,100,h));
            search.setText(shs[i].getsearch(true)+"");
            invp[i].add(search);

            JLabel attack=new JLabel();
            attack.setBounds(new Rectangle(sw+450,0,100,h));
            attack.setText(shs[i].getattack(true)+"");
            invp[i].add(attack);

            JLabel speed=new JLabel();
            speed.setBounds(new Rectangle(sw+470,0,100,h));
            speed.setText(shs[i].insspeed+"");
            invp[i].add(speed);

            JLabel continuation=new JLabel();
            continuation.setBounds(new Rectangle(sw+490,0,100,h));
            continuation.setText(shs[i].tiredness+"/"+shs[i].endurence +"");
            invp[i].add(continuation);


            String[] ss2={"rest","hunt","forward","defence","backward","retreat","none"};
            index=0;
            for(int j=0;j<7;j++){
                if(ss2[j].equals(shs[i].instruction)){
                    index=j;
                    break;
                }
            }
            JComboBox <String> list2 = new JComboBox<String>(ss2); //data has type Object[]
            list2.setSelectedIndex(index);
            list2.setBounds(new Rectangle(sw + 530, 0, 90, h));
            final Ship ship=shs[i];
            list2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JComboBox cb = (JComboBox) e.getSource();
                    String Instr = (String) cb.getSelectedItem();
                    ship.instruction = Instr;
                }
            });
            invp[i].add(list2);

            ArrayList<String> ts2=new ArrayList<String>();
            index=0;
            for(int j=0;j<Startgame.ai.battle.numofship;j++){
                if(Startgame.ai.battle.ships[j]==null){
                    break;
                }
                ts2.add(Startgame.ai.battle.ships[j].name);
                if(Startgame.ai.battle.ships[j].equals(shs[i].target)){
                    index=j;
                }
            }
            String[] tts2=new String[ts2.size()+1];
            for(int j=0;j<tts2.length-1;j++){
                tts2[j]=ts2.get(j);
            }
            JComboBox <String> targetlist2 = new JComboBox<String>(tts2);
            targetlist2.setSelectedIndex(index);
            targetlist2.setBounds(new Rectangle(sw + 620, 0, 90, h));
            targetlist2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JComboBox cb = (JComboBox) e.getSource();
                    String Instr = (String) cb.getSelectedItem();
                    if (Instr == null) {
                        Startgame.choosetarget(ship, Startgame.ai.battle.ships, Startgame.ai.battle.numofship);
                    } else {
                        ship.target = Startgame.ai.battle.find(Instr);
                    }
                }
            });
            invp[i].add(targetlist2);


            sh+=h;
        }
        JPanel tmp=new JPanel();
        tmp.setBackground(Color.magenta);
        tmp.setLayout(null);

        tmp.add(all);
        for(int i=0;i<na;i++){
            invp[i].setBackground(Color.cyan);
            tmp.add(invp[i]);
        }
        tmp.add(tt);
        tmp.setPreferredSize(new Dimension(www,(na+6+1)*h));
        scp1=new JScrollPane(tmp);
        scp1.setBounds(new Rectangle(0, Preparep.sth, www+10, MainFrame.HEI * 2 / 3 - Preparep.sth));
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

        sh=0;h=(MainFrame.HEI-sh)/(22);sw=10;www=MainFrame.WID / 2-10-10-140;
        //sh+=h;
        JLabel tt2=new JLabel();
        tt2.setBounds(new Rectangle(sw, 0, 1000, h));
        tt2.setText("name                       category       class " +
                "    health aa as " +
                "sea attc sp endurence");

        sh+=h;
        for(int i=0;i<na2;i++){
            invp2[i].setBounds(new Rectangle(0, sh, www, h - 5));
            invp2[i].setLayout(null);

            JLabel name=new JLabel();
            name.setBounds(new Rectangle(sw+0,0,200,h));
            name.setText(shs2[i].name);
            invp2[i].add(name);

            JLabel type1=new JLabel();
            type1.setBounds(new Rectangle(sw+100,0,70,h));
            type1.setText(shs2[i].type1);
            invp2[i].add(type1);

            JLabel type2=new JLabel();
            type2.setBounds(new Rectangle(sw+170,0,100,h));
            type2.setText(shs2[i].type2);
            invp2[i].add(type2);

            JLabel health=new JLabel();
            health.setBounds(new Rectangle(sw+230,0,30,h));
            health.setText(shs2[i].resthealth+"");
            invp2[i].add(health);

            JLabel antiair=new JLabel();
            antiair.setBounds(new Rectangle(sw+260,0,30,h));
            antiair.setText(shs2[i].getantiair(true)+"");
            invp2[i].add(antiair);

            JLabel antisub=new JLabel();
            antisub.setBounds(new Rectangle(sw+280,0,30,h));
            antisub.setText(shs2[i].getantisub(true)+"");
            invp2[i].add(antisub);

            JLabel search=new JLabel();
            search.setBounds(new Rectangle(sw+300,0,100,h));
            search.setText(shs2[i].getsearch(true)+"");
            invp2[i].add(search);

            JLabel attack=new JLabel();
            attack.setBounds(new Rectangle(sw+320,0,100,h));
            attack.setText(shs2[i].getattack(true)+"");
            invp2[i].add(attack);

            JLabel speed=new JLabel();
            speed.setBounds(new Rectangle(sw+340,0,100,h));
            speed.setText(shs2[i].insspeed+"");
            invp2[i].add(speed);

            JLabel continuation=new JLabel();
            continuation.setBounds(new Rectangle(sw+360,0,100,h));
            continuation.setText(shs2[i].tiredness + "/" + shs2[i].endurence + "");
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
        tmp2.setPreferredSize(new Dimension(www, (na2 + 6) * h));
        scp2=new JScrollPane(tmp2);
        scp2.setBounds(new Rectangle(MainFrame.WID / 2-10+140, Preparep.sth,www+10, MainFrame.HEI * 2 / 3 - Preparep.sth));
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
