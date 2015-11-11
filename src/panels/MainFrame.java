package panels;

import game.Startgame;
import panels.preparePanels.inventPanels.CVinvp;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by Win7uX32 on 2015/7/21.
 */
public class MainFrame {
    public static JFrame f=new JFrame();
    public static Font font1=new Font("SansSerif",Font.BOLD,20);
    public static JPanel cp=new Startp();
    public static final int WID=1200;
    public static final int HEI=700;
    public static boolean cinspectp =false;
    public static void main(String[] args) throws IOException {
        Startgame.cmd=false;
        f.setBounds(0, 0, WID, HEI);
        f.add(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public static void set(JPanel p){
        f.remove(cp);
        f.add(p);
        cp=p;
        f.repaint();
        //p.repaint(new Rectangle(0,0,1000,600));
    }

    public static void newPrepare() {
        set(new Preparep());
    }
}
