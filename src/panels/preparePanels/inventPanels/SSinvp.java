package panels.preparePanels.inventPanels;

import game.Startgame;
import panels.MainFrame;
import panels.Preparep;
import panels.preparePanels.Inventionsp;
import ships.Submarine;
import weapons.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

/**
 * Created by Win7uX32 on 2015/7/22.
 */
public class SSinvp extends JPanel {
    int stw, sth, sstw, w, h;
    Font font1 = new Font("SansSerif", Font.BOLD, 15);
    int weight=3;
    int weapweight=0;
    int syse=0;
    int sysp=0;
    int cost=3;
    int weapcost=0;
    ArrayList<Weapon> lst=new ArrayList<Weapon>();
    JLabel rw=new JLabel("rest weight:"+(weight+weapweight));
    JLabel tc=new JLabel("total cost:"+(cost+weapcost+(syse+sysp)*weight/4));
    final int[] weightmod={2};
    public SSinvp() {
        setLayout(null);
        //setLayout(new GridLayout(1, 0, 2, 2));
        setBackground(Color.cyan);
        setBounds(new Rectangle(60, 0, MainFrame.WID - 60, MainFrame.HEI * 6 / 7));

        stw = 40;
        sth = 0;
        sstw = 20;
        w = (MainFrame.WID - 60) / 3;
        h = MainFrame.HEI * 6 / 7 / 20;

        sth += h;
        JLabel Name = new JLabel("name");
        Name.setBounds(new Rectangle(sstw, sth, 100, h));
        Name.setFont(font1);
        add(Name);
        final JTextArea name = new JTextArea();
        name.setBounds(new Rectangle(60, sth, w - 100, h));
        sth += h;
        name.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(name);
        sth += h;
        ButtonGroup cvw = new ButtonGroup();
        Cb heavy = new Cb("weight 4 health 8", false, cvw, 1);put(heavy);
        Cb medium = new Cb("weight 3 health 6", true, cvw, 2);put(medium);
        Cb light = new Cb("weight 2 health 4", false, cvw, 3);put(light);
        sth += h;
        heavy.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                weight=4;
                cost=4;
                settext();
                weightmod[0]=3;
            }
        });
        medium.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                weight=3;
                cost=3;
                settext();
                weightmod[0]=2;
            }
        });
        light.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                weight=2;
                cost=2;
                settext();
                weightmod[0]=1;
            }
        });

        JLabel engine = new JLabel("engine");
        engine.setBounds(new Rectangle(sstw, sth, 100, h));
        sth += h;
        engine.setFont(font1);
        add(engine);
        ButtonGroup cvs = new ButtonGroup();
        Cb fast = new Cb("fast", false, cvs, 1);
        put(fast);
        Cb normal = new Cb("normal", true, cvs, 2);
        put(normal);
        Cb slow = new Cb("slow", false, cvs, 3);
        put(slow);
        sth += h;
        fast.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                syse=1;
                settext();
            }
        });
        normal.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                syse=0;
                settext();
            }
        });
        slow.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                syse=-1;
                settext();
            }
        });

        JLabel power = new JLabel("power");
        power.setBounds(new Rectangle(sstw, sth, 100, h));
        sth += h;
        power.setFont(font1);
        add(power);
        ButtonGroup cvp = new ButtonGroup();
        Cb strong = new Cb("strong", false, cvp, 1);
        put(strong);
        Cb nrmal = new Cb("normal", true, cvp, 2);
        put(nrmal);
        Cb weak = new Cb("weak", false, cvp, 3);
        put(weak);
        sth = h;
        stw += w + 40;
        sstw += w + 40;
        strong.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                sysp=1;
                settext();
            }
        });
        nrmal.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                sysp=0;
                settext();
            }
        });
        weak.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                sysp=-1;
                settext();
            }
        });

        JLabel hull = new JLabel("hull");
        hull.setBounds(new Rectangle(sstw, sth, 100, h));
        sth += h;
        hull.setFont(font1);
        add(hull);
        ButtonGroup hullg = new ButtonGroup();
        Cb hulll = new Cb("light", false, hullg, 1);
        put(hulll);
        Cb hullh = new Cb("heavy", false, hullg, 2);
        put(hullh);
        Cb nhull = new Cb("none", true, hullg, -1);
        put(nhull);
        sth += h;
        hulll.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                replace(new Hull(1));
                settext();
            }
        });
        hullh.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                replace(new Hull(2));
                settext();
            }
        });
        nhull.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                removeWp("hull");
                settext();
            }
        });

        JLabel torpedo = new JLabel("torpedo");
        torpedo.setBounds(new Rectangle(sstw, sth, 100, h));
        sth += h;
        torpedo.setFont(font1);
        add(torpedo);
        ButtonGroup torpedog = new ButtonGroup();
        Cb torpedob = new Cb("basic", false, torpedog, 1);
        put(torpedob);
        Cb torpedoi = new Cb("improved", false, torpedog, 2);
        put(torpedoi);
        Cb ntorpedo = new Cb("none", true, torpedog, -1);
        put(ntorpedo);
        sth += h;
        torpedob.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                replace(new Subtorpedo(1));
                settext();
            }
        });
        torpedoi.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                replace(new Subtorpedo(2));
                settext();
            }
        });
        ntorpedo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                removeWp("subtorpedo");
                settext();
            }
        });

        JLabel gun = new JLabel("gun");
        gun.setBounds(new Rectangle(sstw, sth, 100, h));
        sth += h;w/=3;
        gun.setFont(font1);
        add(gun);
        JLabel guns = new JLabel("small");
        final JLabel gunst = new JLabel();
        JButton gunsp=new JButton("+");JButton gunsm=new JButton("-");
        put(guns);putlb(gunst);putb(true,gunsp);putb(false,gunsm);
        JLabel gunm = new JLabel("medium");
        final JLabel gunmt = new JLabel();
        JButton gunmp=new JButton("+");JButton gunmm=new JButton("-");
        put(gunm);putlb(gunmt);putb(true,gunmp);putb(false,gunmm);
        JLabel gunl = new JLabel("large");
        final JLabel gunlt = new JLabel();
        JButton gunlp=new JButton("+");JButton gunlm=new JButton("-");
        put(gunl);putlb(gunlt);putb(true,gunlp);putb(false,gunlm);
        sth+=h;
        gunsp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gunst.setText(Integer.parseInt(gunst.getText())+1+"");
                addWp(new Gun(3));
                settext();
            }
        });
        gunsm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(gunst.getText())>0) {
                    minusWp(new Gun(3));
                    gunst.setText(Integer.parseInt(gunst.getText()) - 1 + "");
                    settext();
                }
            }
        });
        gunmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gunmt.setText(Integer.parseInt(gunmt.getText())+1+"");
                addWp(new Gun(4));
                settext();
            }
        });
        gunmm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(gunmt.getText())>0) {
                    minusWp(new Gun(4));
                    gunmt.setText(Integer.parseInt(gunmt.getText()) - 1 + "");
                    settext();
                }
            }
        });
        gunlp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gunlt.setText(Integer.parseInt(gunlt.getText())+1+"");
                addWp(new Gun(5));
                settext();
            }
        });
        gunlm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(gunlt.getText())>0) {
                    minusWp(new Gun(5));
                    gunlt.setText(Integer.parseInt(gunlt.getText()) - 1 + "");
                    settext();
                }
            }
        });

        put(rw);put(tc);
        sth++;
        JButton submit=new JButton("invent");
        put(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(name.getText()==null||name.getText().equals("")){
                    JOptionPane.showMessageDialog(MainFrame.cp, "no name entered");
                }
                else if(Startgame.player.special.numofss>=3){
                    JOptionPane.showMessageDialog(MainFrame.cp, "maximum number of inventions reached\n" +
                            "need to weed one invention of the same type first");
                }
                else if(weight-weapweight<0){
                    JOptionPane.showMessageDialog(MainFrame.cp, "weapons overweight" );
                }
                else{
                    Submarine sh=new Submarine(name.getText(),weightmod[0]);
                    sh.speed+=syse*sh.weight/4;
                    sh.endurence +=sysp*100/4;
                    sh.cost=cost+weapcost+(syse+sysp)*weight/4;
                    for(Weapon w:lst){
                        sh.addweapon(w);
                    }
                    Startgame.player.special.add(sh);
                    JOptionPane.showMessageDialog(MainFrame.cp, sh.type2+" added to list" );
                    Preparep.inventionsp=new Inventionsp();
                }
            }
        });
    }

    public void put(Component c) {
        c.setBounds(new Rectangle(stw, sth, w, h));
        sth += h;
        c.setFont(font1);
        add(c);
    }
    public void putlb(JLabel l){
        l.setBounds(new Rectangle(stw + w, sth - h, w / 4, h));
        l.setFont(font1);
        l.setText("0");
        add(l);
    }
    public void putb(boolean add,JButton b){
        if(add) {
            b.setBounds(new Rectangle(stw + w+w/4, sth - h, w / 3, h));
        }
        else {
            b.setBounds(new Rectangle(stw + w+w/4+w / 3, sth - h, w / 3, h));
        }
        //b.setFont(font1);
        add(b);
    }
    public void settext(){
        rw.setText("rest weight:"+(weight-weapweight));
        tc.setText("total cost:"+(cost+weapcost+(syse+sysp)*weight/4));
    }
    public void replace(Weapon w){
        for(Weapon tr:lst){
            if(tr.type.equals(w.type)){
                weapweight-=tr.weight;
                weapcost-=tr.cost;
                lst.remove(tr);
                break;
            }
        }
        lst.add(w);
        weapweight+=w.weight;
        weapcost+=w.cost;
    }
    public void removeWp(String tp){
        for(Weapon tr:lst){
            if(tr.type.equals(tp)){
                weapweight-=tr.weight;
                weapcost-=tr.cost;
                lst.remove(tr);
                break;
            }
        }
    }
    public void addWp(Weapon wp){
        lst.add(wp);
        weapcost+= (wp.cost);
        weapweight+=wp.weight;
    }
    public void minusWp(Weapon wp){
        for(Weapon tr:lst){
            if(tr.name.equals(wp.name)){
                weapweight-=tr.weight;
                weapcost-=tr.cost;
                lst.remove(tr);
                break;
            }
        }
    }
}
