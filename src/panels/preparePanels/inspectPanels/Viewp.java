package panels.preparePanels.inspectPanels;

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
public class Viewp extends JPanel {
    JScrollPane scp;
    static Viewp vp=new Viewp();
    public Viewp(){
        init();
        repaint();
        scp.repaint();
    }
    public void init(){
        Font font1=new Font("SansSerif",Font.BOLD,15);

        setLayout(null);
        setBackground(Color.cyan);
        setBounds(new Rectangle(60, 0, MainFrame.WID - 60, MainFrame.HEI * 6 / 7));

        JPanel txtpn=new JPanel();
        txtpn.setLayout(null);
        txtpn.setBackground(Color.magenta);
        txtpn.setBounds(new Rectangle(60 + MainFrame.WID / 2, Preparep.sth, MainFrame.WID / 2 - 80, MainFrame.HEI * 2 / 3 - Preparep.sth));
        final JLabel lb= new JLabel();
        lb.setBounds(new Rectangle(20, 0, MainFrame.WID/2-100,MainFrame.HEI/2));
        txtpn.add(lb);
        JButton update=new JButton("rename");
        update.setBounds(new Rectangle(0,MainFrame.HEI * 2 / 3 - Preparep.sth-30,100,30));
        //weed.setBounds(new Rectangle(100,MainFrame.HEI * 2 / 3 - Preparep.sth-30,100,30));
        final Ship[] sel = {null};
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = JOptionPane.showInputDialog("Enter name");
                while (Startgame.player.nameUsed(str)||str.equals("")) {
                    str = JOptionPane.showInputDialog("Name not entered or already used,Enter new name");
                }
                sel[0].name=str;
                refresh();
            }
        });
        txtpn.add(update);
        add(txtpn);

        Startgame.player.available.sortbycat();
        Ship[] shs=Startgame.player.available.ships;
        int na=Startgame.player.available.numofship;

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
            if(i>=1&&(!shs[i].type1.equals(shs[i-1].type1))){
                sh+=h;
            }
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
            health.setText(shs[i].health+"");
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
            speed.setText(shs[i].speed+"");
            invp[i].add(speed);

            JLabel continuation=new JLabel();
            continuation.setBounds(new Rectangle(sw+550,0,100,h));
            continuation.setText(shs[i].endurence +"");
            invp[i].add(continuation);

            sh+=h;

            final int I=i;
            invp[i].addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent e) {
                    //if(Startgame.player.special.cv[I - 0]!=null){
                        lb.setText(Startgame.player.available.ships[I].toStringL());
                        sel[0] =Startgame.player.available.ships[I];//}
                }
            });
        }
        /*ScrollPane scp=new JScrollPane();
        scp.setLayout(null);
        scp.setBackground(Color.magenta);
        scp.setBounds(new Rectangle(0,Preparep.sth,60 + MainFrame.WID / 2,MainFrame.HEI * 2 / 3 - Preparep.sth));*/
        JPanel tmp=new JPanel();
        tmp.setBackground(Color.magenta);
        tmp.setLayout(null);
        for(int i=0;i<na;i++){
            //invp[i]=new JPanel();
            invp[i].setBackground(Color.cyan);
            tmp.add(invp[i]);
        }
        tmp.add(tt);
        //this.add(scp);
//tmp.setBounds(new Rectangle(0,0,1000,1000));
        tmp.setPreferredSize(new Dimension(60 + MainFrame.WID / 2-40,(na+6)*h));
        scp=new JScrollPane(tmp);
        scp.setBounds(new Rectangle(0, Preparep.sth, 60 + MainFrame.WID / 2, MainFrame.HEI * 2 / 3 - Preparep.sth));
        scp.getVerticalScrollBar().setUnitIncrement(10);
        //TextArea textArea=new TextArea();
        //textArea.setBounds(new Rectangle(0, 0, 500, 500));
        //scp.setViewportView(textArea);
        //scp.add(textArea);
        tmp.repaint();
        tmp.setVisible(true);
        scp.validate();
        scp.repaint();
        this.setVisible(true);
        tmp.repaint();
        add(scp);
        scp.repaint();
        tmp.repaint();
        scp.repaint();
        /*JLabel label = new JLabel("Label");
        label.setPreferredSize(new Dimension(10000, 10000));
        JScrollPane jScrollPane = new JScrollPane(label);

        jScrollPane.setBounds(new Rectangle(0, Preparep.sth, 60 + MainFrame.WID / 2, MainFrame.HEI * 2 / 3 - Preparep.sth));
        JButton jButton1 = new JButton();

        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setViewportBorder(new LineBorder(Color.RED));
        jScrollPane.getViewport().add(jButton1, null);

        add(jScrollPane);*/
        //setSize(400, 150);
        //frame.setVisible(true);
    }
    public void refresh(){
        this.removeAll();
        this.init();
        MainFrame.f.validate();
        repaint();
    }
}
