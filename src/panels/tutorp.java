package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Win7uX32 on 2015/7/21.
 */
public class tutorp extends JPanel {
    JButton b2;
    public tutorp(){
        setLayout(null);////////////////////////////////panel2 tutorial
        b2=new JButton("back");
        b2.setBounds(new Rectangle(10,350,150,30));
        b2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                /*tutorialend();
                startmenu();*/
                MainFrame.set(new Startp());
            }

        });
        //pn2.setimage(getImage(this.getClass().getResource("ptsd.jpg")));
        //pn2.repaint();
        add(b2);
        setBackground(Color.cyan);
        setBounds(new Rectangle(0, 0, MainFrame.WID, MainFrame.HEI));
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.setFont(new Font("abc",Font.BOLD,20));
        g.drawString("有关海战：背景二战时期，没有核动力和导弹",10,30);
        g.drawString("  船只：船只分为航母，战列舰，巡洋舰（轻巡，重巡，战巡），驱逐舰，潜艇",10,50);
        g.drawString("建造船只时要考虑吨位，吨位决定抗揍能力和武器数量",10,70);
        g.drawString("然后可以给船只装配武器，根据不同舰种可以装配舰炮，防空炮，鱼雷，装甲，雷达，声呐，舰载机",10,90);
        g.drawString("为了方便，可以发明装配好武器的舰型（xx级），也可以将其删除",10,110);
        g.drawString("  舰队：不同舰种相互配合才能提高舰队的生存率和攻击力",10,130);
        g.drawString("主力舰（航母，战列舰）是主要攻击力量，辅助舰（轻巡，驱逐）为舰队提供保护",10,150);
        g.drawString("潜艇有特殊的攻击方式，如果舰队缺乏反潜能力会遭受惨重损失，驱逐舰是潜艇的克星",10,170);
        g.drawString("  攻击：舰队的搜索能力决定能否优先攻击",10,190);
        g.drawString("距离决定攻击舰使用的武器，炮在攻击范围内才能发挥作用，不同炮的攻击范围不同，近距离的鱼雷射击" +
                "是致命的，舰载机不受距离限制",10,210);
        g.drawString("被进攻舰会拉开距离，而进攻方企图接近对方，此时较高的航速可以使船只处于有利位置",10,2130);
        g.drawString("吨位低的船只（如驱逐舰）有更高的航速，遭受攻击的船的航速会降低，甚至会瘫痪",10,250);
        g.drawString("  防守：潜艇和舰载机的攻击力最强大，舰队必须有反潜和防空能力",10,270);
        g.drawString("舰队的反潜和防空能力取决于各舰的反潜防空能力和水上舰队的数量",10,290);
        g.drawString("紧凑的阵型能提高舰队的防御力，如果阵型被打乱要及时调整",10,310);
        g.drawString("打不过的话可以撤退,但不一定能成功",10,330);
    }
}
