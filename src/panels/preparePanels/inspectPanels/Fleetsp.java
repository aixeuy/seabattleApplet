package panels.preparePanels.inspectPanels;

import fleets.Fleet;
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
public class Fleetsp extends JPanel {
    JScrollPane scp;
//    static Fleetsp vp=new Fleetsp();
    public Fleetsp(){
        init();
        repaint();
        scp.repaint();
    }
    public void init(){
        Font font1=new Font("SansSerif",Font.BOLD,15);
        Color[] cs={Color.white,Color.blue,Color.pink,Color.green,Color.lightGray,Color.orange,
        Color.red,Color.yellow};

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
        JButton update=new JButton("drop");
        update.setBounds(new Rectangle(0,MainFrame.HEI * 2 / 3 - Preparep.sth-30,100,30));
        //weed.setBounds(new Rectangle(100,MainFrame.HEI * 2 / 3 - Preparep.sth-30,100,30));
        final Ship[] sel = {null};
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Startgame.player.dropFleet(sel[0]);
                refresh();
            }
        });
        txtpn.add(update);
        add(txtpn);

        JPanel TMP=new JPanel();
        TMP.setLayout(null);
        TMP.setBackground(Color.cyan);

        int SH = 0;
        int h = (MainFrame.HEI - SH) / (22);
        int sw = 10;
        int w = 1000;
        final JLabel tt = new JLabel();
        tt.setBounds(new Rectangle(sw, 0, 1000, h));
        tt.setText("name                                                    " +
                "                                              mission             status");
        //Startgame.player.available.sortbycat();
        int NA=0;
        SH += h;
        SH+=h;
        int i2=0;
        Color lastc=Color.cyan;
        for(Fleet f:Startgame.player.getfleets()) {
            final Fleet F=f;
            Ship[] shs = new Ship[f.getSize()];
            for(int i=0;i<f.getSize();i++){
                shs[i]=f.ships.get(i);
            }
            int na = f.getSize();
            NA+=na;
            JPanel[] invp = new JPanel[na];
            for (int i = 0; i < na; i++) {
                invp[i] = new JPanel();
            }
            //sh+=h;


            int sh =h;
            for (int i = 0; i < na; i++) {
                invp[i].setBounds(new Rectangle(0, sh, 370, h - 5));
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

                sh += h;
                SH+=h;

                final int I = i;
                invp[i].addMouseListener(new MouseAdapter() {

                    public void mousePressed(MouseEvent e) {
                        lb.setText( F.ships.get(I).toStringL());
                        sel[0] = F.ships.get(I);//}
                    }
                });
            }
            Color tmpc=cs[f.getCode()%cs.length];
            if(tmpc==lastc){tmpc=cs[(f.getCode()+1)%cs.length];}
            lastc=tmpc;
            JPanel tmp = new JPanel();
            tmp.setBounds(new Rectangle(0,SH-sh,w,(na+1)*h));
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

            JButton rename=new JButton("remname");
            rename.setBounds(new Rectangle(sw+200,0,90,h));
            rename.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String str = JOptionPane.showInputDialog("Enter new name");
                    while (Startgame.player.fleetNameUsed(str)){
                        str = JOptionPane.showInputDialog("Name used,Enter new name");
                    }
                    if(str!=null&&!str.equals("")) {
                        Startgame.player.changeFleetName(F, str);
                        refresh();
                    }
                }
            });
            tmp.add(rename);

            String[] ss={"decisive battle","sea control","transport attack"};
            JComboBox <String> list = new JComboBox<String>(ss); //data has type Object[]
            list.setSelectedIndex(f.instr-1);
            list.setBounds(new Rectangle(sw+290,0,120,h));
            list.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JComboBox cb = (JComboBox)e.getSource();
                    String Instr = (String)cb.getSelectedItem();
                    F.setInstr(F.decodeMission(Instr));
                }
            });
            tmp.add(list);

            JPanel big=new JPanel();
            big.setBackground(Color.cyan);
            big.setBounds(new Rectangle(sw + 410, 0, 40, h));
            big.setLayout(null);
            final JLabel oolb=new JLabel(f.getStatus());
            oolb.setBounds(new Rectangle(0, 0, 40, h));
            big.add(oolb);
            big.addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent e) {
                    F.outport=!F.outport;
                    oolb.setText(F.getStatus());
                }
            });
            tmp.add(big);

            JButton add=new JButton("add");
            add.setBounds(new Rectangle(sw+450,0,60,h));
            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(sel[0]==null) {
                        JOptionPane.showMessageDialog(MainFrame.f, "first click on the ship to add,then" +
                                " click this button");
                    }
                    else{
                        Startgame.player.changeFleet(sel[0], F);
                    }
                    refresh();
                }
            });
            tmp.add(add);

            TMP.add(tmp);
            SH += h;
            i2++;
        }
        TMP.add(tt);
        TMP.setPreferredSize(new Dimension(60 + MainFrame.WID / 2-40,(NA+Startgame.player.getfleets().size()+1)*h));
        scp=new JScrollPane(TMP);
        scp.setBounds(new Rectangle(0, Preparep.sth, 60 + MainFrame.WID / 2, MainFrame.HEI * 2 / 3 - Preparep.sth));
        scp.getVerticalScrollBar().setUnitIncrement(10);
        TMP.repaint();
        TMP.setVisible(true);
        scp.validate();
        scp.repaint();
        this.setVisible(true);
        TMP.repaint();
        add(scp);
        scp.repaint();
        TMP.repaint();
        scp.repaint();
    }
    public void refresh(){
        this.removeAll();
        this.init();
        MainFrame.f.validate();
        repaint();
    }
}
