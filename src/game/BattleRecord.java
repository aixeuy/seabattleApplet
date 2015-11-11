package game;

import fleets.Battle;
import panels.MainFrame;
import panels.Preparep;
import panels.Roundp;

import java.util.ArrayList;

/**
 * Created by Win7uX32 on 2015/8/5.
 */
public class BattleRecord {
    public ArrayList<Attack> attacks;
    public boolean end;
    public int currentIndex;
    public BattleRecord(){
        attacks=new ArrayList<Attack>();
        end=false;
        currentIndex=-1;
    }
    public void push(Attack attack){
        attacks.add(attack);
        currentIndex=attacks.size()-1;
    }
    public void previous(){
        currentIndex--;
        if(currentIndex<0){
            currentIndex=0;
        }
        MainFrame.set(new Roundp());
    }
    public void next(){
        currentIndex++;
        if(currentIndex>=attacks.size()) {


            if (end && currentIndex >attacks.size()) {
                MainFrame.set(Preparep.battlePane);
                Startgame.stop = false;
            } else if (end) {
                MainFrame.set(new Roundp());
            } else {
                //MainFrame.set(new Roundp());
                if (currentIndex >= attacks.size()) {
                    Startgame.stop = false;
                }
                synchronized (Startgame.stop) {
                    //如果继续线程为false，则执行循环
                    while (!Startgame.stop) {
                    }
                }
                MainFrame.set(new Roundp());
            }
        }
        else{
            MainFrame.set(new Roundp());
        }
    }
    public Attack getCurrentAttack(){
        try {
            return attacks.get(currentIndex);
        }
        catch(Exception e){
            return null;
        }
    }
}
