package panels.BattlePanels;

import game.Attack;
import game.Startgame;
import ships.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by Win7uX32 on 2015/8/6.
 */
public class Mapp extends JPanel {
    JLabel lb;
    Attack attack;
    int H;
    int W;
    int DIM;
    int ZERO;
    Shiplb alb;
    Shiplb blb;
    public Mapp(JLabel lb){
        this.setLayout(null);
        this.setBackground(Color.magenta);
        this.lb=lb;
    }
    public void setPos(int x,int y,int w,int h){
        setBounds(new Rectangle(x,y,w,h));
        H=h;W=w;
    }
    public void translate(Attack attack){
        this.attack=attack;
        int leftmost=0;int rightmost=0;
        if(attack.pf.size()!=0){
            leftmost=attack.pf.get(0).position;rightmost=attack.pf.get(0).position;
        }
        else{
            leftmost=attack.af.get(0).position;rightmost=attack.af.get(0).position;
        }
        for(Ship s:attack.pf){
            if(s.position<leftmost){
                leftmost=s.position;
            }
            if(s.position>rightmost){
                rightmost=s.position;
            }
        }
        for(Ship s:attack.af){
            if(s.position<leftmost){
                leftmost=s.position;
            }
            if(s.position>rightmost){
                rightmost=s.position;
            }
        }
        //System.out.println("leftmost:"+leftmost+" rightmost:"+rightmost);
        DIM=Math.min(W/((rightmost-leftmost)+2),H/(2+Math.max(attack.pf.size(),attack.af.size())));
        ZERO=(1-leftmost)*DIM;
        ArrayList<Shiplb> lbs=new ArrayList<Shiplb>();
        for(int i=0;i<attack.pf.size();i++){
            Shiplb slb=new Shiplb(attack.pf.get(i),DIM,ZERO,i,true);
            lbs.add(slb);
            final Ship SH=slb.sh;
            slb.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    lb.setText(SH.toStringL());
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
            this.add(slb);
        }
        for(int i=0;i<attack.af.size();i++){
            Shiplb slb=new Shiplb(attack.af.get(i),DIM,ZERO,i,false);
            lbs.add(slb);
            final Ship SH=slb.sh;
            slb.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    lb.setText(SH.toStringL());
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
            this.add(slb);
        }
       // boolean[] posreg=new boolean[31];
        //ArrayList<Shiplb> problems=new ArrayList<Shiplb>();
        int shuffle=DIM/3;
        for(int i=0;i<lbs.size();i++){
            for(int j=i+1;j<lbs.size();j++){
                if(Startgame.ditanza(lbs.get(i).x,lbs.get(i).y,lbs.get(j).x,lbs.get(j).y)<shuffle){
                    lbs.get(j).shuffle(shuffle);
                    remove(lbs.get(j));
                    add(lbs.get(j));
                }
            }
        }

        for (Shiplb slb : lbs) {
            JPanel health = new JPanel();
            health.setBounds(new Rectangle(slb.x, slb.y + DIM, DIM * slb.sh.resthealth * DIM / 5000, 5));
            health.setBackground(Color.green);
            add(health);
                if(attack.type==2||attack.type==-1) {
                    if(attack.a==slb.sh){
                        alb=slb;
                    }
                    if (attack.b == slb.sh) {
                        blb=slb;
                        JLabel demage = new JLabel();
                        demage.setText(attack.demage + "");
                        demage.setFont(new Font("SansSerif", Font.BOLD, DIM / 4));
                        demage.setBounds(new Rectangle(slb.x + DIM * 2 / 5, slb.y + DIM / 5, DIM / 2, DIM / 2));
                        add(demage);

                        JLabel boom = new JLabel();
                        boom.setBounds(new Rectangle(slb.x, slb.y, DIM * 2, DIM * 2));
                        ImageIcon imageIcon = new ImageIcon("IMG/boom.png");
                        Image image = imageIcon.getImage();
                        Image newimg = image.getScaledInstance(DIM * 2, DIM * 2, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                        imageIcon = new ImageIcon(newimg);  // transform it back
                        boom.setIcon(imageIcon);
                        add(boom);
                        remove(slb);
                        add(slb);
                    }
                }
        }
        repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawLine(0,DIM,W,DIM);
        int x=0;
        while(x<=W){
            g.drawLine(x,DIM,x,DIM+10);
            x+=DIM;
        }
        for(int i=-5;i<=5;i++){
            g.drawString(i+"",ZERO+i*DIM,DIM/2);
        }
        if(alb!=null&&blb!=null) {
            Graphics2D g2d = (Graphics2D) g.create();
            double thickness = 2;
            Stroke oldStroke;
            //g2d.drawRect(1, 1, this.getWidth()-2, this.getHeight()-2);
            switch (attack.type) {
                case -1:
                    g2d.setColor(Color.black);
                    oldStroke = g2d.getStroke();
                    g2d.setStroke(new BasicStroke((float) thickness));
                    g2d.drawLine(alb.x+DIM/2,alb.y+DIM/2,blb.x+DIM/2,blb.y+DIM/2);
                    g2d.setStroke(oldStroke);
                    break;//sink
                case 0:
                    g2d.setColor(Color.green);
                    oldStroke = g2d.getStroke();
                    g2d.setStroke(new BasicStroke((float) thickness));
                    g2d.drawLine(alb.x+DIM/2,alb.y+DIM/2,blb.x+DIM/2,blb.y+DIM/2);
                    g2d.setStroke(oldStroke);
                    break;//search
                case 1:
                    g2d.setColor(Color.yellow);
                    oldStroke = g2d.getStroke();
                    g2d.setStroke(new BasicStroke((float) thickness));
                    g2d.drawLine(alb.x+DIM/2,alb.y+DIM/2,blb.x+DIM/2,blb.y+DIM/2);
                    g2d.setStroke(oldStroke);
                    break;//fail
                case 2:
                    g2d.setColor(Color.red);
                    oldStroke = g2d.getStroke();
                    g2d.setStroke(new BasicStroke((float) thickness));
                    g2d.drawLine(alb.x+DIM/2,alb.y+DIM/2,blb.x+DIM/2,blb.y+DIM/2);
                    g2d.setStroke(oldStroke);
                    break;//success
            }
        }
    }
}
