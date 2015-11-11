package panels.BattlePanels;

import ships.Ship;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Win7uX32 on 2015/8/6.
 */
public class Shiplb extends JLabel {
    Ship sh;
    int x;
    int y;
    int DIM;
    public Shiplb(Ship s,int DIM,int ZERO,int ind,boolean isplayer){
        sh=s;
        String txt=simplify(s.type1);
        if(isplayer){
            txt="0"+txt;
        }
        else{
            txt="1"+txt;
        }
        //this.setText(txt);
        if(sh.type1.equals("destroyer")||sh.type1.equals("submarine")){
            txt += "1";
        }
        else {
            if (sh.resthealth * 5 <= sh.health) {
                txt += "0";
            } else {
                txt += "1";
            }
        }
        if(sh.resthealth<=0){
            txt="";
        }
        ImageIcon imageIcon = new ImageIcon("IMG/"+txt+".gif"); // load the image to a imageIcon
        if(imageIcon==null){
            setText(txt);
        }
        else {
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(DIM * 4 / 5, DIM * 4 / 5, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            imageIcon = new ImageIcon(newimg);  // transform it back
            setIcon(imageIcon);
        }

        x=ZERO+sh.position*DIM-DIM/2;
        y=(2+ind)*DIM-DIM/2;
        this.DIM=DIM;
        this.setBounds(new Rectangle(x,y,DIM,DIM));
    }
    public void shuffle(int dim){
        x+=dim;
        y+=dim;
        this.setBounds(new Rectangle(x,y,DIM,DIM));
    }
    public String simplify(String str){
        if(str.equals("carrier")){
            return "CV";
        }
        else if(str.equals("battleship")){
            return "BB";
        }
        else if(str.equals("cruiser")){
            return "LC";
        }
        else if(str.equals("destroyer")){
            return "DD";
        }
        else if(str.equals("submarine")){
            return "SS";
        }
        return str;
    }
}
