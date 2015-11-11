package game;

import ships.Ship;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by Win7uX32 on 2015/8/5.
 */
public class Attack {
    public ArrayList<Ship> pf;
    public ArrayList<Ship> af;
    public Ship a;
    public Ship b;
    public boolean bo;//player attack ai
    public int demage;
    public int type;//0:search;1:fail;2:success;3:not;-1:sink
    public double time;
    public Attack(){
        type=2;
    }
    public void setFleet(Ship[] pf, Ship[] af){
        this.pf=new ArrayList<Ship>();
        for(Ship sh:pf){
            if(sh==null){break;}
            Ship s=new Ship();
            s.deepCopy(sh);
            this.pf.add(s);
        }
        this.af=new ArrayList<Ship>();
        for(Ship sh:af){
            if(sh==null){break;}
            Ship s=new Ship();
            s.deepCopy(sh);
            this.af.add(s);
        }
    }
    public void setAttack(Ship a,Ship b,boolean bo,int demage){
        if(bo) {
            for (Ship s : pf) {
                if (s.name.equals(a.name)) {
                    this.a = s;
                }
            }
            for (Ship s : af) {
                if (s.name.equals(b.name)) {
                    this.b = s;
                }
            }
        }
        else{
            for (Ship s : af) {
                if (s.name.equals(a.name)) {
                    this.a = s;
                }
            }
            for (Ship s : pf) {
                if (s.name.equals(b.name)) {
                    this.b = s;
                }
            }
        }
        this.bo=bo;
        this.demage=demage;
    }
    public void editType(){
        if(demage==0){
            type=0;
        }
        if(b!=null&&b.resthealth<=0){
            type=-1;
        }
    }
}
