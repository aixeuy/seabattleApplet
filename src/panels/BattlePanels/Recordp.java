package panels.BattlePanels;

import game.Attack;
import game.Startgame;
import panels.MainFrame;
import panels.Preparep;
import panels.Roundp;
import ships.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Win7uX32 on 2015/7/21.
 */
public class Recordp extends JPanel {
    //static Recoedp vp=new Recoedp();

    public Recordp(){
        init();
        repaint();
    }
    public void init(){
        Attack attack=Startgame.br.getCurrentAttack();
        if(attack!=null){attack.editType();}

        Font font1=new Font("SansSerif",Font.BOLD,15);

        setLayout(null);
        setBackground(Color.cyan);
        setBounds(new Rectangle(0, Preparep.sth, MainFrame.WID - 60, MainFrame.HEI * 6 / 7));

        JPanel txtpn=new JPanel();
        txtpn.setLayout(null);
        txtpn.setBackground(Color.magenta);
        txtpn.setBounds(new Rectangle(60 + MainFrame.WID / 2, 0, MainFrame.WID / 2 - 80, MainFrame.HEI * 2 / 3 - Preparep.sth));
        final JLabel lb= new JLabel();
        lb.setBounds(new Rectangle(20, 0, MainFrame.WID/2-100,MainFrame.HEI/2));
        txtpn.add(lb);
        final Ship[] sel = {null};
        add(txtpn);

        if(attack!=null) {
            Mapp map = new Mapp(lb);
            map.setBackground(Color.magenta);
            map.setPos(0,0, MainFrame.WID / 2 + 80,MainFrame.HEI-50-Preparep.sth*3);
            map.translate(attack);
            add(map);
        }

        JLabel next=new JLabel(">>");
        next.setFont(font1);
        next.setBounds(new Rectangle(60 + MainFrame.WID / 2-50,MainFrame.HEI-50-Preparep.sth*3,50,50));
        next.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Startgame.br.next();
                //if(!Startgame.br.end){
                  //  MainFrame.set(new Roundp());
                //}
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        add(next);

        JLabel time=new JLabel();
        if(attack!=null) {
            String timestr="" + attack.time;
            if((int)(attack.time*100)%10==0){
                timestr+="0";
            }
            if(attack.time<=18&&attack.time>=4){
                timestr+=" day";
            }
            else{
                timestr+=" night";
            }
            time.setText(timestr);
            System.out.println(attack.time);
        }
        time.setFont(font1);
        time.setBounds(new Rectangle(60 + MainFrame.WID / 2-150,MainFrame.HEI-50-Preparep.sth*3,100,50));
        add(time);

        JLabel previous=new JLabel("<<");
        previous.setFont(font1);
        previous.setBounds(new Rectangle(60 + MainFrame.WID / 2-200,MainFrame.HEI-50-Preparep.sth*3,50,50));
        previous.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Startgame.br.previous();
                //if(!Startgame.br.end){
                //  MainFrame.set(new Roundp());
                //}
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        add(previous);

        JLabel decrire=new JLabel();
        String txt = "";
        if(attack!=null&&attack.a!=null&&attack.b!=null) {
            if (attack.type == 3) {
                if (attack.bo) {
                    txt = attack.a.name + " " + attack.a.type1 + attack.a.type2;
                } else {
                    txt = attack.b.name + " " + attack.b.type1 + attack.b.type2;
                }
            } else {
                if (attack.bo) {
                    txt = attack.a.name + " " + attack.a.type1 + attack.a.type2;
                    switch (attack.type) {
                        case -1:
                            txt+=" sinks ";
                            break;
                        case 0:
                            txt += " approaches ";
                            break;
                        case 1:
                            txt += " fails to attack ";
                            break;
                        case 2:
                            txt += " attacks ";
                            break;
                    }
                    txt += txt = attack.b.name + " " + attack.b.type1 + attack.b.type2;
                }
                else {
                    txt = attack.b.name + " " + attack.b.type1 + attack.b.type2;
                    switch (attack.type) {
                        case -1:
                            txt+=" sunk by ";
                            break;
                        case 0:
                            txt += " approached by ";
                            break;
                        case 1:
                            txt += " defends ";
                            break;
                        case 2:
                            txt += " attacked by ";
                            break;
                    }
                    txt += attack.a.name + " " + attack.a.type1 + attack.a.type2;
                }
            }
            decrire.setText(txt);
        }
        decrire.setBounds(new Rectangle(80 + MainFrame.WID / 2, MainFrame.HEI * 2 / 3 - Preparep.sth, MainFrame.WID / 2 - 80, 20));
        add(decrire);
        //lb.setText(Startgame.br.currentIndex+"");
    }
    public void refresh(){
        this.removeAll();
        this.init();
        MainFrame.f.validate();
        repaint();
    }
}
