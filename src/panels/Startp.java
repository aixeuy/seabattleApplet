package panels;

import game.Startgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Win7uX32 on 2015/7/21.
 */
public class Startp extends JPanel {
    JButton b11;
    JButton b12;
    JButton b13;
    JButton b14;
    public Startp(){
        setLayout(null);////////////////////////////////panel2 tutorial
        b11=new JButton("toturial");
        b12=new JButton("load game");
        b13=new JButton("new game");
        b14=new JButton("exit");
        b11.setFont(MainFrame.font1);
        b12.setFont(MainFrame.font1);
        b13.setFont(MainFrame.font1);
        b14.setFont(MainFrame.font1);
        int sh=MainFrame.HEI*3/5;int h=MainFrame.HEI/14;int hw= MainFrame.WID/7;
        b11.setBounds(new Rectangle(MainFrame.WID/2-hw, sh, 2*hw, h));
        b11.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.set(new tutorp());
            }

        });
        b12.setBounds(new Rectangle(MainFrame.WID/2-hw, sh+h, 2*hw, h));
        b12.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Startgame.read();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Startgame.player.updateFleetStatus();
                Startgame.ai.updateFleetStatus();
                MainFrame.set(new Preparep());
            }

        });
        b13.setBounds(new Rectangle(MainFrame.WID/2-hw, sh+2*h, 2*hw, h));
        b13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JDialog dialog = new JDialog((Frame) null, "", true);
                JLabel name = new JLabel("are you sure you want to start a new game");
                JButton ok = new JButton("yes"),
                        cancel = new JButton("no");
                ok.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        dialog.setVisible(false);
                        /*startmenuend();
                        restyear=3;
                        Startgame.player=new Country();
                        Startgame.ai=new Aicountry();
                        gamepanel();
                        game();*/
                    }

                });
                cancel.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        dialog.setVisible(false);
                    }

                });
            }
        });
        b14.setBounds(new Rectangle(MainFrame.WID/2-hw, sh+3*h, 2*hw, h));
        b14.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               // MainFrame.set(new tutorp());
            }

        });
        add(b11);
        add(b12);
        add(b13);
        add(b14);
        setBackground(Color.magenta);
        setBounds(new Rectangle(0, 0, MainFrame.WID, MainFrame.HEI));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        /*g.setColor(Color.black);
        g.drawRect(200,0,600,400);*/
    }
}