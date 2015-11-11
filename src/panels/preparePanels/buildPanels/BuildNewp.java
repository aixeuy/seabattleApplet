package panels.preparePanels.buildPanels;

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
public class BuildNewp extends JPanel {
    public static BuildNewp staticBuildNewp;
    public BuildNewp(){
        init();
    }
    public void init(){
        final int[] type = {-1};//0:CV,1:BB...
        final int[] ind = {-1};

        Font font1=new Font("SansSerif",Font.BOLD,15);

        setLayout(null);
        setBackground(Color.cyan);
        setBounds(new Rectangle(60, 0, MainFrame.WID - 60, MainFrame.HEI));

        JPanel txtpn=new JPanel();
        txtpn.setLayout(null);
        txtpn.setBackground(Color.magenta);
        txtpn.setBounds(new Rectangle(60 + MainFrame.WID / 2, Preparep.sth, MainFrame.WID / 2 - 80, MainFrame.HEI * 2 / 3 - Preparep.sth));
        final JLabel lb= new JLabel();
        lb.setBounds(new Rectangle(20, 0, MainFrame.WID/2-100,MainFrame.HEI/2));
        txtpn.add(lb);
        JButton build=new JButton("build");
        build.setBounds(new Rectangle(0, MainFrame.HEI * 2 / 3 - Preparep.sth - 30, 100, 30));
        final Ship[] sel = {null};
        build.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ind[0]>=0) {
                    Ship s = new Ship();
                    switch (type[0]) {/////////////not finished
                        case 0:
                            String str =JOptionPane.showInputDialog("Enter name");
                            while (Startgame.player.nameUsed(str)||str.equals("")) {
                                str = JOptionPane.showInputDialog("Name not entered or already used,Enter new name");
                            }
                            s.copyexceptname(Startgame.player.special.cv[ind[0]]);
                            s.name = str;
                            s.resthealth=0;
                            Startgame.player.cash -= s.cost;
                            Startgame.player.repair.add(s);Startgame.player.toNewFleet(s);
                            JOptionPane.showMessageDialog(MainFrame.f, str + " added to repair");
                            break;
                        case 1:
                            str = JOptionPane.showInputDialog("Enter name");
                            while (Startgame.player.nameUsed(str)||str.equals("")) {
                                str = JOptionPane.showInputDialog("Name not entered or already used,Enter new name");
                            }
                            s.copyexceptname(Startgame.player.special.bb[ind[0]]);
                            s.name = str;
                            s.resthealth=0;
                            Startgame.player.cash -= s.cost;
                            Startgame.player.repair.add(s);Startgame.player.toNewFleet(s);
                            JOptionPane.showMessageDialog(MainFrame.f, str + " added to repair");
                            break;
                        case 2:
                            str = JOptionPane.showInputDialog("Enter name");
                            while (Startgame.player.nameUsed(str)||str.equals("")) {
                                str = JOptionPane.showInputDialog("Name not entered or already used,Enter new name");
                            }
                            s.copyexceptname(Startgame.player.special.c[ind[0]]);
                            s.name = str;
                            s.resthealth=0;
                            Startgame.player.cash -= s.cost;
                            Startgame.player.repair.add(s);Startgame.player.toNewFleet(s);
                            JOptionPane.showMessageDialog(MainFrame.f, str + " added to repair");
                            break;
                        case 3:
                            int numtoadd=0;str="";boolean isint=false;
                            while(!isint) {
                                str = JOptionPane.showInputDialog("Enter number of ships to build");
                                try {
                                    numtoadd = Integer.parseInt(str);
                                    isint = true;
                                } catch (Exception exception) {
                                    isint = false;
                                }
                            }
                            String name="";
                            for(int i=0;i<numtoadd;i++) {
                                s.copyexceptname(Startgame.player.special.dd[ind[0]]);
                                if (Startgame.player.num < 10) {
                                    s.name = Startgame.player.special.dd[ind[0]].type2.substring(0, 2) + "-0" + Startgame.player.num;
                                } else {
                                    s.name = Startgame.player.special.dd[ind[0]].type2.substring(0, 2) + "-" + Startgame.player.num;
                                }
                                while (Startgame.player.nameUsed(s.name)) {
                                    s.name += "I";
                                }
                                Startgame.player.num++;
                                if (Startgame.player.num >= 100) {
                                    Startgame.player.num = 0;
                                }
                                s.resthealth = 0;
                                Startgame.player.cash -= s.cost;
                                Startgame.player.repair.add(s);Startgame.player.toNewFleet(s);
                                name+=s.name;
                                if(i!=numtoadd-1){
                                    name+=",";
                                }
                                s=new Ship();
                            }
                            JOptionPane.showMessageDialog(MainFrame.f, name + " added to repair");
                            break;
                        case 4:
                            numtoadd=0;str="";isint=false;
                            while(!isint) {
                                str = JOptionPane.showInputDialog("Enter number of ships to build");
                                try {
                                    numtoadd = Integer.parseInt(str);
                                    isint = true;
                                } catch (Exception exception) {
                                    isint = false;
                                }
                            }
                            name="";
                            for(int i=0;i<numtoadd;i++) {
                                s.copyexceptname(Startgame.player.special.ss[ind[0]]);
                                if (Startgame.player.num < 10) {
                                    s.name = Startgame.player.special.ss[ind[0]].type2.substring(0, 2) + "-0" + Startgame.player.num;
                                } else {
                                    s.name = Startgame.player.special.ss[ind[0]].type2.substring(0, 2) + "-" + Startgame.player.num;
                                }
                                while (Startgame.player.nameUsed(s.name)) {
                                    s.name += "I";
                                }
                                Startgame.player.num++;
                                if (Startgame.player.num >= 100) {
                                    Startgame.player.num = 0;
                                }
                                s.resthealth = 0;
                                Startgame.player.cash -= s.cost;
                                Startgame.player.repair.add(s);Startgame.player.toNewFleet(s);
                                name+=s.name;
                                if(i!=numtoadd-1){
                                    name+=",";
                                }
                                s=new Ship();
                            }
                            JOptionPane.showMessageDialog(MainFrame.f, name + " added to repair");
                            break;
                        default:
                            break;
                    }
                    /*String str =JOptionPane.showInputDialog("Enter name");
                    while (Startgame.player.nameUsed(str)) {
                        str =JOptionPane.showInputDialog("Enter name");
                    }
                    JOptionPane.showMessageDialog(MainFrame.f, str + "added to repair");*/
                    refresh();
                    MainFrame.cinspectp =true;
                }
            }
        });
        txtpn.add(build);
        add(txtpn);

        JPanel[] invp=new JPanel[15];
        for(int i=0;i<15;i++){
            invp[i]=new JPanel();
        }

        int sh=Preparep.sth;int h=(MainFrame.HEI-sh)/22;int sw=20;int w=MainFrame.WID/2;
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
                        sel[0] =Startgame.player.special.cv[I - 0];type[0] =0;
                        ind[0] =I;}
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
                        sel[0] =Startgame.player.special.bb[I-3];type[0]=1;ind[0] =I-3;}
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
                        sel[0] =Startgame.player.special.c[I-6];type[0]=2;ind[0] =I-6;}
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
                        sel[0] =Startgame.player.special.dd[I-9];type[0]=3;ind[0] =I-9;}
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
                        sel[0] =Startgame.player.special.ss[I-12];type[0]=4;ind[0] =I-12;}
                }
            });
        }

        for(int i=0;i<15;i++){
            //invp[i]=new JPanel();
            invp[i].setBackground(Color.magenta);
            this.add(invp[i]);
        }
    }
    public void refresh(){
        this.removeAll();
        this.init();
        repaint();
    }
}
