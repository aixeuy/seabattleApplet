package panels;

import fleets.Fleet;
import game.Startgame;
import ships.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Win7uX32 on 2015/8/3.
 */
public class BattlePane extends JPanel {
    JButton tobattle;

    JScrollPane scp=new JScrollPane();
    public BattlePane() {
        //init();
        MainFrame.f.validate();
         scp.validate();
        validate();
        repaint();
        scp.repaint();
    }

    public void init() {

        Color[] cs = {Color.white, Color.blue, Color.pink, Color.green, Color.lightGray, Color.orange,
                Color.red, Color.yellow};

        setLayout(null);////////////////////////////////panel2 tutorial
        tobattle = new JButton("tobattle");
        tobattle.setFont(MainFrame.font1);
        int sh = MainFrame.HEI * 5 / 6;
        int h = MainFrame.HEI / 14;
        int hw = MainFrame.WID / 7;
        tobattle.setBounds(new Rectangle(MainFrame.WID / 2 - hw, sh, 2 * hw, h));
        tobattle.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("next");
                Startgame.stop = false;
                synchronized (Startgame.stop) {
                    //如果继续线程为false，则执行循环
                    while (!Startgame.stop) {
                    }
                }
                MainFrame.set(new Roundp());
            }

        });
        add(tobattle);
        setBackground(Color.cyan);
        setBounds(new Rectangle(0, 0, MainFrame.WID, MainFrame.HEI));

        JPanel TMP = new JPanel();
        TMP.setLayout(null);
        TMP.setBackground(Color.cyan);

        int SH = 0;
        h = (MainFrame.HEI - SH) / (22);
        int sw = 10;
        int w = 1000;
        final JLabel tt = new JLabel();
        tt.setBounds(new Rectangle(sw, 0, 1000, h));
        tt.setText("name                                                       category       class " +
                "                     hea we aa as " +
                "sea attc lv exp sp cont");
        //Startgame.player.available.sortbycat();
        int NA = 0;
        SH += h;
        SH += h;
        int i2 = 0;
        Color lastc = Color.cyan;
        for (Fleet f : BattleFrame.PFS) {
            final Fleet F = f;
            Ship[] shs = new Ship[f.getSize()];
            for (int i = 0; i < f.getSize(); i++) {
                shs[i] = f.ships.get(i);
            }
            int na = f.getSize();
            NA += na;
            JPanel[] invp = new JPanel[na];
            for (int i = 0; i < na; i++) {
                invp[i] = new JPanel();
            }
            //sh+=h;


            sh = h;
            for (int i = 0; i < na; i++) {
                invp[i].setBounds(new Rectangle(0, sh, w, h - 5));
                invp[i].setLayout(null);

                JLabel name = new JLabel();
                name.setBounds(new Rectangle(sw + 0, 0, 200, h));
                name.setText(shs[i].name);
                invp[i].add(name);

                JLabel type1 = new JLabel();
                type1.setBounds(new Rectangle(sw + 200, 0, 70, h));
                type1.setText(shs[i].type1);
                invp[i].add(type1);

                JLabel type2 = new JLabel();
                type2.setBounds(new Rectangle(sw + 270, 0, 100, h));
                type2.setText(shs[i].type2);
                invp[i].add(type2);

                JLabel health = new JLabel();
                health.setBounds(new Rectangle(sw + 370, 0, 30, h));
                health.setText(shs[i].health + "");
                invp[i].add(health);

                JLabel weight = new JLabel();
                weight.setBounds(new Rectangle(sw + 390, 0, 30, h));
                weight.setText(shs[i].weight + "");
                invp[i].add(weight);

                JLabel antiair = new JLabel();
                antiair.setBounds(new Rectangle(sw + 410, 0, 30, h));
                antiair.setText(shs[i].getantiair(true) + "");
                invp[i].add(antiair);

                JLabel antisub = new JLabel();
                antisub.setBounds(new Rectangle(sw + 430, 0, 30, h));
                antisub.setText(shs[i].getantisub(true) + "");
                invp[i].add(antisub);

                JLabel search = new JLabel();
                search.setBounds(new Rectangle(sw + 450, 0, 100, h));
                search.setText(shs[i].getsearch(true) + "");
                invp[i].add(search);

                JLabel attack = new JLabel();
                attack.setBounds(new Rectangle(sw + 470, 0, 100, h));
                attack.setText(shs[i].getattack(true) + "");
                invp[i].add(attack);

                JLabel level = new JLabel();
                level.setBounds(new Rectangle(sw + 490, 0, 100, h));
                level.setText(shs[i].level + "");
                invp[i].add(level);

                JLabel experience = new JLabel();
                experience.setBounds(new Rectangle(sw + 510, 0, 100, h));
                experience.setText(shs[i].experience + "");
                invp[i].add(experience);

                JLabel speed = new JLabel();
                speed.setBounds(new Rectangle(sw + 530, 0, 100, h));
                speed.setText(shs[i].speed + "");
                invp[i].add(speed);

                JLabel continuation = new JLabel();
                continuation.setBounds(new Rectangle(sw + 550, 0, 100, h));
                continuation.setText(shs[i].endurence + "");
                invp[i].add(continuation);

                sh += h;
                SH += h;

                final int I = i;
                /*invp[i].addMouseListener(new MouseAdapter() {

                    public void mousePressed(MouseEvent e) {

                    }
                });*/
            }
            Color tmpc = cs[f.getCode() % cs.length];
            if (tmpc == lastc) {
                tmpc = cs[(f.getCode() + 1) % cs.length];
            }
            lastc = tmpc;
            JPanel tmp = new JPanel();
            tmp.setBounds(new Rectangle(0, SH - sh, w, (na + 1) * h));
            tmp.setBackground(tmpc);
            tmp.setLayout(null);
            for (int i = 0; i < na; i++) {
                //invp[i]=new JPanel();
                invp[i].setBackground(tmpc);
                tmp.add(invp[i]);
            }
            JLabel ftn = new JLabel();
            ftn.setBounds(new Rectangle(sw, 0, 200, h));
            ftn.setText(f.name);
            tmp.add(ftn);

            /*JButton rename = new JButton("remname");
            rename.setBounds(new Rectangle(sw + 200, 0, 90, h));
            rename.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String str = JOptionPane.showInputDialog("Enter new name");
                    while (Startgame.player.fleetNameUsed(str)) {
                        str = JOptionPane.showInputDialog("Name used,Enter new name");
                    }
                    if (str != null && !str.equals("")) {
                        Startgame.player.changeFleetName(F, str);
                        refresh();
                    }
                }
            });
            tmp.add(rename);*/

            String[] ss = {"decisive battle", "sea control", "transport attack"};
            //JComboBox<String> list = new JComboBox<String>(ss); //data has type Object[]
            JLabel list=new JLabel();
            //list.setSelectedIndex(f.instr - 1);
            list.setText(f.getMission());
            list.setBounds(new Rectangle(sw + 290, 0, 120, h));
            /*list.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JComboBox cb = (JComboBox) e.getSource();
                    String Instr = (String) cb.getSelectedItem();
                    F.setInstr(F.decodeMission(Instr));
                }
            });*/
            tmp.add(list);

            JPanel big = new JPanel();
            big.setBackground(Color.cyan);
            big.setBounds(new Rectangle(sw + 410, 0, 40, h));
            big.setLayout(null);
            final JLabel oolb = new JLabel(f.getStatus());
            oolb.setBounds(new Rectangle(0, 0, 40, h));
            big.add(oolb);
            /*big.addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent e) {
                    F.outport = !F.outport;
                    oolb.setText(F.getStatus());
                }
            });*/
            tmp.add(big);


            TMP.add(tmp);
            SH += h;
            i2++;
        }
        TMP.add(tt);
        TMP.setBounds(new Rectangle(0, Preparep.sth, MainFrame.WID / 2, MainFrame.HEI * 2 / 3 - Preparep.sth));
        // TMP.setPreferredSize(new Dimension(60 + MainFrame.WID / 2-40,(NA+Startgame.player.getfleets().size()+1)*h));
        add(TMP);
        //scp=new JScrollPane(TMP);
        //scp.setBounds(new Rectangle(0, Preparep.sth, 60 + MainFrame.WID / 2, MainFrame.HEI * 2 / 3 - Preparep.sth));
        //scp.getVerticalScrollBar().setUnitIncrement(10);
        TMP.repaint();
        TMP.setVisible(true);
        //scp.validate();
        //scp.repaint();
        this.setVisible(true);
        TMP.repaint();
        //add(scp);
        //scp.repaint();
        TMP.repaint();
        //scp.repaint();


        JPanel TMP2 = new JPanel();
        TMP2.setLayout(null);
        TMP2.setBackground(Color.cyan);

        SH = 0;
        h = (MainFrame.HEI - SH) / (22);
        sw = 10;
        w = 1000;
        final JLabel tt2 = new JLabel();
        tt2.setBounds(new Rectangle(sw, 0, 1000, h));
        tt2.setText("name                                                       category       class " +
                "                     hea we aa as " +
                "sea attc lv exp sp cont");
        //Startgame.player.available.sortbycat();
        NA = 0;
        SH += h;
        SH += h;
        i2 = 0;
        lastc = Color.cyan;
        for (Fleet f : BattleFrame.AFS) {
            final Fleet F = f;
            Ship[] shs = new Ship[f.getSize()];
            for (int i = 0; i < f.getSize(); i++) {
                shs[i] = f.ships.get(i);
            }
            int na = f.getSize();
            NA += na;
            JPanel[] invp = new JPanel[na];
            for (int i = 0; i < na; i++) {
                invp[i] = new JPanel();
            }
            //sh+=h;


            sh = h;
            for (int i = 0; i < na; i++) {
                invp[i].setBounds(new Rectangle(0, sh, w, h - 5));
                invp[i].setLayout(null);

                JLabel name = new JLabel();
                name.setBounds(new Rectangle(sw + 0, 0, 200, h));
                name.setText(shs[i].name);
                invp[i].add(name);

                JLabel type1 = new JLabel();
                type1.setBounds(new Rectangle(sw + 200, 0, 70, h));
                type1.setText(shs[i].type1);
                invp[i].add(type1);

                JLabel type2 = new JLabel();
                type2.setBounds(new Rectangle(sw + 270, 0, 100, h));
                type2.setText(shs[i].type2);
                invp[i].add(type2);

                JLabel health = new JLabel();
                health.setBounds(new Rectangle(sw + 370, 0, 30, h));
                health.setText(shs[i].health + "");
                invp[i].add(health);

                JLabel weight = new JLabel();
                weight.setBounds(new Rectangle(sw + 390, 0, 30, h));
                weight.setText(shs[i].weight + "");
                invp[i].add(weight);

                JLabel antiair = new JLabel();
                antiair.setBounds(new Rectangle(sw + 410, 0, 30, h));
                antiair.setText(shs[i].getantiair(true) + "");
                invp[i].add(antiair);

                JLabel antisub = new JLabel();
                antisub.setBounds(new Rectangle(sw + 430, 0, 30, h));
                antisub.setText(shs[i].getantisub(true) + "");
                invp[i].add(antisub);

                JLabel search = new JLabel();
                search.setBounds(new Rectangle(sw + 450, 0, 100, h));
                search.setText(shs[i].getsearch(true) + "");
                invp[i].add(search);

                JLabel attack = new JLabel();
                attack.setBounds(new Rectangle(sw + 470, 0, 100, h));
                attack.setText(shs[i].getattack(true) + "");
                invp[i].add(attack);

                JLabel level = new JLabel();
                level.setBounds(new Rectangle(sw + 490, 0, 100, h));
                level.setText(shs[i].level + "");
                invp[i].add(level);

                JLabel experience = new JLabel();
                experience.setBounds(new Rectangle(sw + 510, 0, 100, h));
                experience.setText(shs[i].experience + "");
                invp[i].add(experience);

                JLabel speed = new JLabel();
                speed.setBounds(new Rectangle(sw + 530, 0, 100, h));
                speed.setText(shs[i].speed + "");
                invp[i].add(speed);

                JLabel continuation = new JLabel();
                continuation.setBounds(new Rectangle(sw + 550, 0, 100, h));
                continuation.setText(shs[i].endurence + "");
                invp[i].add(continuation);

                sh += h;
                SH += h;

                final int I = i;
                /*invp[i].addMouseListener(new MouseAdapter() {

                    public void mousePressed(MouseEvent e) {

                    }
                });*/
            }
            Color tmpc = cs[f.getCode() % cs.length];
            if (tmpc == lastc) {
                tmpc = cs[(f.getCode() + 1) % cs.length];
            }
            lastc = tmpc;
            JPanel tmp = new JPanel();
            tmp.setBounds(new Rectangle(0, SH - sh, w, (na + 1) * h));
            tmp.setBackground(tmpc);
            tmp.setLayout(null);
            for (int i = 0; i < na; i++) {
                //invp[i]=new JPanel();
                invp[i].setBackground(tmpc);
                tmp.add(invp[i]);
            }
            JLabel ftn = new JLabel();
            ftn.setBounds(new Rectangle(sw, 0, 200, h));
            ftn.setText(f.name);
            tmp.add(ftn);

            //JButton rename = new JButton("remname");
            //rename.setBounds(new Rectangle(sw + 200, 0, 90, h));
            //tmp.add(rename);

            //String[] ss = {"decisive battle", "sea control", "transport attack"};
            //JComboBox<String> list = new JComboBox<String>(ss); //data has type Object[]
            JLabel list=new JLabel();
            list.setText(f.getMission());
            //list.setSelectedIndex(f.instr - 1);
            list.setBounds(new Rectangle(sw + 290, 0, 120, h));
            tmp.add(list);

            JPanel big = new JPanel();
            big.setBackground(Color.cyan);
            big.setBounds(new Rectangle(sw + 410, 0, 40, h));
            big.setLayout(null);
            final JLabel oolb = new JLabel(f.getStatus());
            oolb.setBounds(new Rectangle(0, 0, 40, h));
            big.add(oolb);
            tmp.add(big);


            TMP2.add(tmp);
            SH += h;
            i2++;
        }
        TMP2.add(tt2);
        TMP2.setBounds(new Rectangle(MainFrame.WID / 2, Preparep.sth, MainFrame.WID / 2, MainFrame.HEI * 2 / 3 - Preparep.sth));
        // TMP.setPreferredSize(new Dimension(60 + MainFrame.WID / 2-40,(NA+Startgame.player.getfleets().size()+1)*h));
        add(TMP2);
        //scp=new JScrollPane(TMP);
        //scp.setBounds(new Rectangle(0, Preparep.sth, 60 + MainFrame.WID / 2, MainFrame.HEI * 2 / 3 - Preparep.sth));
        //scp.getVerticalScrollBar().setUnitIncrement(10);
        TMP2.repaint();
        TMP2.setVisible(true);
        //scp.validate();
        //scp.repaint();
        this.setVisible(true);
        TMP2.repaint();
        //add(scp);
        //scp.repaint();
        TMP2.repaint();

        JLabel yours = new JLabel("Your Fleets");
        JLabel theirs = new JLabel("Enemy's fleets");
        JLabel place = new JLabel("at " + BattleFrame.placeName);

        yours.setBounds(new Rectangle(0, 20, MainFrame.WID / 3, 20));
        theirs.setBounds(new Rectangle(MainFrame.WID / 2, 20, MainFrame.WID / 3, 20));
        place.setBounds(new Rectangle(0, 0, MainFrame.WID / 3, 20));

        add(yours);
        add(theirs);
        add(place);
    }

    public void refresh() {
        this.removeAll();
        this.init();
        MainFrame.f.validate();
        repaint();
    }
    public void select(){
        this.removeAll();
        this.enemySlectp();
        MainFrame.f.validate();
        repaint();
    }
public void enemySlectp(){
    Color[] cs = {Color.white, Color.blue, Color.pink, Color.green, Color.lightGray, Color.orange,
            Color.red, Color.yellow};

    setLayout(null);////////////////////////////////panel2 tutorial


    JLabel reminder=new JLabel("Your fleet ready to attack");
    reminder.setBounds(new Rectangle(0,0,600,20));
    add(reminder);

    JPanel TMP = new JPanel();
    TMP.setLayout(null);
    TMP.setBackground(Color.cyan);

    int SH = 0;
    int h = (MainFrame.HEI - SH) / (22);
    int sw = 10;
    int w = 1000;
    final JLabel tt = new JLabel();
    tt.setBounds(new Rectangle(sw, 0, 1000, h));
    tt.setText("name                                                       category       class " +
            "                     hea we aa as " +
            "sea attc lv exp sp cont");
    //Startgame.player.available.sortbycat();
    int NA = 0;
    SH += h;
    SH += h;
    int i2 = 0;
    Color lastc = Color.cyan;
    for (Fleet f : BattleFrame.PFS) {
        final Fleet F = f;
        Ship[] shs = new Ship[f.getSize()];
        for (int i = 0; i < f.getSize(); i++) {
            shs[i] = f.ships.get(i);
        }
        int na = f.getSize();
        NA += na;
        JPanel[] invp = new JPanel[na];
        for (int i = 0; i < na; i++) {
            invp[i] = new JPanel();
        }
        //sh+=h;


        int sh = h;
        for (int i = 0; i < na; i++) {
            invp[i].setBounds(new Rectangle(0, sh, w, h - 5));
            invp[i].setLayout(null);

            JLabel name = new JLabel();
            name.setBounds(new Rectangle(sw + 0, 0, 200, h));
            name.setText(shs[i].name);
            invp[i].add(name);

            JLabel type1 = new JLabel();
            type1.setBounds(new Rectangle(sw + 200, 0, 70, h));
            type1.setText(shs[i].type1);
            invp[i].add(type1);

            JLabel type2 = new JLabel();
            type2.setBounds(new Rectangle(sw + 270, 0, 100, h));
            type2.setText(shs[i].type2);
            invp[i].add(type2);

            JLabel health = new JLabel();
            health.setBounds(new Rectangle(sw + 370, 0, 30, h));
            health.setText(shs[i].health + "");
            invp[i].add(health);

            JLabel weight = new JLabel();
            weight.setBounds(new Rectangle(sw + 390, 0, 30, h));
            weight.setText(shs[i].weight + "");
            invp[i].add(weight);

            JLabel antiair = new JLabel();
            antiair.setBounds(new Rectangle(sw + 410, 0, 30, h));
            antiair.setText(shs[i].getantiair(true) + "");
            invp[i].add(antiair);

            JLabel antisub = new JLabel();
            antisub.setBounds(new Rectangle(sw + 430, 0, 30, h));
            antisub.setText(shs[i].getantisub(true) + "");
            invp[i].add(antisub);

            JLabel search = new JLabel();
            search.setBounds(new Rectangle(sw + 450, 0, 100, h));
            search.setText(shs[i].getsearch(true) + "");
            invp[i].add(search);

            JLabel attack = new JLabel();
            attack.setBounds(new Rectangle(sw + 470, 0, 100, h));
            attack.setText(shs[i].getattack(true) + "");
            invp[i].add(attack);

            JLabel level = new JLabel();
            level.setBounds(new Rectangle(sw + 490, 0, 100, h));
            level.setText(shs[i].level + "");
            invp[i].add(level);

            JLabel experience = new JLabel();
            experience.setBounds(new Rectangle(sw + 510, 0, 100, h));
            experience.setText(shs[i].experience + "");
            invp[i].add(experience);

            JLabel speed = new JLabel();
            speed.setBounds(new Rectangle(sw + 530, 0, 100, h));
            speed.setText(shs[i].speed + "");
            invp[i].add(speed);

            JLabel continuation = new JLabel();
            continuation.setBounds(new Rectangle(sw + 550, 0, 100, h));
            continuation.setText(shs[i].endurence + "");
            invp[i].add(continuation);

            sh += h;
            SH += h;

            final int I = i;
                /*invp[i].addMouseListener(new MouseAdapter() {

                    public void mousePressed(MouseEvent e) {

                    }
                });*/
        }
        Color tmpc = cs[f.getCode() % cs.length];
        if (tmpc == lastc) {
            tmpc = cs[(f.getCode() + 1) % cs.length];
        }
        lastc = tmpc;
        JPanel tmp = new JPanel();
        tmp.setBounds(new Rectangle(0, SH - sh, w, (na + 1) * h));
        tmp.setBackground(tmpc);
        tmp.setLayout(null);
        for (int i = 0; i < na; i++) {
            //invp[i]=new JPanel();
            invp[i].setBackground(tmpc);
            tmp.add(invp[i]);
        }
        JLabel ftn = new JLabel();
        ftn.setBounds(new Rectangle(sw, 0, 200, h));
        ftn.setText(f.name);
        tmp.add(ftn);

            /*JButton rename = new JButton("remname");
            rename.setBounds(new Rectangle(sw + 200, 0, 90, h));
            rename.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String str = JOptionPane.showInputDialog("Enter new name");
                    while (Startgame.player.fleetNameUsed(str)) {
                        str = JOptionPane.showInputDialog("Name used,Enter new name");
                    }
                    if (str != null && !str.equals("")) {
                        Startgame.player.changeFleetName(F, str);
                        refresh();
                    }
                }
            });
            tmp.add(rename);*/

        String[] ss = {"decisive battle", "sea control", "transport attack"};
        //JComboBox<String> list = new JComboBox<String>(ss); //data has type Object[]
        JLabel list=new JLabel();
        //list.setSelectedIndex(f.instr - 1);
        list.setText(f.getMission());
        list.setBounds(new Rectangle(sw + 290, 0, 120, h));
            /*list.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JComboBox cb = (JComboBox) e.getSource();
                    String Instr = (String) cb.getSelectedItem();
                    F.setInstr(F.decodeMission(Instr));
                }
            });*/
        tmp.add(list);

        JPanel big = new JPanel();
        big.setBackground(Color.cyan);
        big.setBounds(new Rectangle(sw + 410, 0, 40, h));
        big.setLayout(null);
        final JLabel oolb = new JLabel(f.getStatus());
        oolb.setBounds(new Rectangle(0, 0, 40, h));
        big.add(oolb);
            /*big.addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent e) {
                    F.outport = !F.outport;
                    oolb.setText(F.getStatus());
                }
            });*/
        tmp.add(big);


        TMP.add(tmp);
        SH += h;
        i2++;
    }
    TMP.add(tt);
    TMP.setBounds(new Rectangle(0-2, Preparep.sth, MainFrame.WID / 2-20, MainFrame.HEI * 2 / 3 - Preparep.sth));
    // TMP.setPreferredSize(new Dimension(60 + MainFrame.WID / 2-40,(NA+Startgame.player.getfleets().size()+1)*h));
    add(TMP);
    //scp=new JScrollPane(TMP);
    //scp.setBounds(new Rectangle(0, Preparep.sth, 60 + MainFrame.WID / 2, MainFrame.HEI * 2 / 3 - Preparep.sth));
    //scp.getVerticalScrollBar().setUnitIncrement(10);
    TMP.repaint();
    TMP.setVisible(true);
    //scp.validate();
    //scp.repaint();
    this.setVisible(true);
    TMP.repaint();
    //add(scp);
    //scp.repaint();
    TMP.repaint();





    int sh = MainFrame.HEI * 5 / 6;
    h = MainFrame.HEI / 14;
    int hw = MainFrame.WID / 7;


    setBackground(Color.cyan);

    setBounds(new Rectangle(0, 0,MainFrame.WID, MainFrame.HEI)

    );

    JPanel TMP2 = new JPanel();
    TMP2.setLayout(null);
    TMP2.setBackground(Color.cyan);

    SH = 0;
    h=(MainFrame.HEI-SH)/(22);
    sw = 10;
    w = 1000;
    final JLabel tt2 = new JLabel();
    tt2.setBounds(new

                    Rectangle(sw, 0, 1000, h)

    );
    tt2.setText("name                                                       category       class " +
            "                     hea we aa as " +
            "sea attc lv exp sp cont");
    //Startgame.player.available.sortbycat();
    NA = 1;
    SH+=h;
    SH+=h;
    i2 = 0;
    lastc = Color.cyan;
    for(
    Fleet f
    :Startgame.ai.getfleets())

    {
        if(f.outport==false){continue;}
        NA++;
        final Fleet F = f;
        Ship[] shs = new Ship[f.getSize()];
        for (int i = 0; i < f.getSize(); i++) {
            shs[i] = f.ships.get(i);
        }
        int na = f.getSize();
        NA += na;
        JPanel[] invp = new JPanel[na];
        for (int i = 0; i < na; i++) {
            invp[i] = new JPanel();
        }
        //sh+=h;


        sh = h;
        for (int i = 0; i < na; i++) {
            invp[i].setBounds(new Rectangle(0, sh, w, h - 5));
            invp[i].setLayout(null);

            JLabel name = new JLabel();
            name.setBounds(new Rectangle(sw + 0, 0, 200, h));
            name.setText(shs[i].name);
            invp[i].add(name);

            JLabel type1 = new JLabel();
            type1.setBounds(new Rectangle(sw + 200, 0, 70, h));
            type1.setText(shs[i].type1);
            invp[i].add(type1);

            JLabel type2 = new JLabel();
            type2.setBounds(new Rectangle(sw + 270, 0, 100, h));
            type2.setText(shs[i].type2);
            invp[i].add(type2);

            JLabel health = new JLabel();
            health.setBounds(new Rectangle(sw + 370, 0, 30, h));
            health.setText(shs[i].health + "");
            invp[i].add(health);

            JLabel weight = new JLabel();
            weight.setBounds(new Rectangle(sw + 390, 0, 30, h));
            weight.setText(shs[i].weight + "");
            invp[i].add(weight);

            JLabel antiair = new JLabel();
            antiair.setBounds(new Rectangle(sw + 410, 0, 30, h));
            antiair.setText(shs[i].getantiair(true) + "");
            invp[i].add(antiair);

            JLabel antisub = new JLabel();
            antisub.setBounds(new Rectangle(sw + 430, 0, 30, h));
            antisub.setText(shs[i].getantisub(true) + "");
            invp[i].add(antisub);

            JLabel search = new JLabel();
            search.setBounds(new Rectangle(sw + 450, 0, 100, h));
            search.setText(shs[i].getsearch(true) + "");
            invp[i].add(search);

            JLabel attack = new JLabel();
            attack.setBounds(new Rectangle(sw + 470, 0, 100, h));
            attack.setText(shs[i].getattack(true) + "");
            invp[i].add(attack);

            JLabel level = new JLabel();
            level.setBounds(new Rectangle(sw + 490, 0, 100, h));
            level.setText(shs[i].level + "");
            invp[i].add(level);

            JLabel experience = new JLabel();
            experience.setBounds(new Rectangle(sw + 510, 0, 100, h));
            experience.setText(shs[i].experience + "");
            invp[i].add(experience);

            JLabel speed = new JLabel();
            speed.setBounds(new Rectangle(sw + 530, 0, 100, h));
            speed.setText(shs[i].speed + "");
            invp[i].add(speed);

            JLabel continuation = new JLabel();
            continuation.setBounds(new Rectangle(sw + 550, 0, 100, h));
            continuation.setText(shs[i].endurence + "");
            invp[i].add(continuation);

            sh += h;
            SH += h;

            final int I = i;
            /*invp[i].addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent e) {

                }
            });*/
        }
        Color tmpc = cs[f.getCode() % cs.length];
        if (tmpc == lastc) {
            tmpc = cs[(f.getCode() + 1) % cs.length];
        }
        lastc = tmpc;
        JPanel tmp = new JPanel();
        tmp.setBounds(new Rectangle(0, SH - sh, w, (na + 1) * h));
        tmp.setBackground(tmpc);
        tmp.setLayout(null);
        for (int i = 0; i < na; i++) {
            //invp[i]=new JPanel();
            invp[i].setBackground(tmpc);
            tmp.add(invp[i]);
        }
        JLabel ftn = new JLabel();
        ftn.setBounds(new Rectangle(sw, 0, 200, h));
        ftn.setText(f.name);
        tmp.add(ftn);

        //JButton rename = new JButton("remname");
        /*rename.setBounds(new Rectangle(sw + 200, 0, 90, h));
        rename.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = JOptionPane.showInputDialog("Enter new name");
                while (Startgame.player.fleetNameUsed(str)) {
                    str = JOptionPane.showInputDialog("Name used,Enter new name");
                }
                if (str != null && !str.equals("")) {
                    Startgame.player.changeFleetName(F, str);
                    refresh();
                }
            }
        });
        tmp.add(rename);*/

        String[] ss = {"decisive battle", "sea control", "transport attack"};
        //JComboBox<String> list = new JComboBox<String>(ss); //data has type Object[]
        JLabel list=new JLabel();
        list.setText(f.getMission());
        //list.setSelectedIndex(f.instr - 1);
        list.setBounds(new Rectangle(sw + 290, 0, 120, h));
        /*list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String Instr = (String) cb.getSelectedItem();
                F.setInstr(F.decodeMission(Instr));
            }
        });*/
        tmp.add(list);

        JPanel big = new JPanel();
        big.setBackground(Color.cyan);
        big.setBounds(new Rectangle(sw + 410, 0, 40, h));
        big.setLayout(null);
        final JLabel oolb = new JLabel(f.getStatus());
        oolb.setBounds(new Rectangle(0, 0, 40, h));
        big.add(oolb);
        /*big.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                F.outport = !F.outport;
                oolb.setText(F.getStatus());
            }
        });*/
        tmp.add(big);

        JButton add = new JButton("catch");
        add.setBounds(new Rectangle(sw + 450, 0, 100, h));
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BattleFrame.AFS.add(F);
                Startgame.stop=false;
            }
        });
        tmp.add(add);

        TMP2.add(tmp);
        SH += h;
        i2++;
    }

    TMP2.add(tt2);
    //TMP.setBounds(newRectangle(0,Preparep.sth, MainFrame.WID/2, MainFrame.HEI*2/3-Preparep.sth));

     TMP2.setPreferredSize(new Dimension(MainFrame.WID / 2 - 20, (NA + 1) * h));
    add(TMP2);
    scp=new JScrollPane(TMP2);
    scp.setBounds(new Rectangle(MainFrame.WID / 2-20, Preparep.sth,MainFrame.WID / 2, MainFrame.HEI * 2 / 3 - Preparep.sth));
    scp.getVerticalScrollBar().setUnitIncrement(10);
    TMP2.repaint();
    TMP2.setVisible(true);
    scp.validate();
    scp.repaint();
    this.

    setVisible(true);

    TMP2.repaint();
    add(scp);
    scp.repaint();
    TMP2.repaint();
    scp.repaint();
}
}
