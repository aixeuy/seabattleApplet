package fleets;

import ships.Ship;

import java.util.ArrayList;

/**
 * Created by Win7uX32 on 2015/7/26.
 */
public class Fleet {
    public String name;
    public ArrayList<Ship> ships;
    public int instr;
    public boolean outport;
    public Fleet(){
        ships=new ArrayList<Ship>();outport=true;
    }
    public Fleet(String name){
        this.name=name;
        outport=true;
        ships=new ArrayList<Ship>();
        instr=3;//1:主战,2:制海,3:破交
    }
    public void add(Ship s){
        if(ships.size()==0){
            instr=s.instr;
        }
        else {
            s.instr=instr;
        }
        s.fleetname=name;
        ships.add(s);
    }
    public void remove(Ship s){
        ships.remove(s);
    }
    public void portcheck(){
        outport=true;
        for(Ship s:ships){
            if(s.resthealth<s.health){
                outport=false;
                break;
            }
        }
    }
    public int getSize(){
        return ships.size();
    }
    public String getMission(){
        switch (instr){
            case 1:return "decisive battle";
            case 2:return "sea control";
            case 3:return "transport attack";
        }
        return "";
    }
    public int decodeMission(String s){
        if(s.equals("decisive battle")){
            return 1;
        }
        else if(s.equals("sea control")){
            return 2;
        }
        else if(s.equals("transport attack")){
            return 3;
        }
        return 0;
    }
    public String getStatus(){
        if(outport){
            return "active";
        }
        return "resting";
    }
    public void setName(String name){
        this.name=name;
        for(Ship s:ships){
            s.fleetname=name;
        }
    }
    public void setInstr(int instr){
        this.instr=instr;
        for(Ship s:ships){
            s.instr=instr;
        }
    }
    public int getCode(){
        char[] ca=name.toCharArray();
        int sum=0;
        for(char c:ca){
            sum+=c;
        }
        return sum;
    }
    public void autoSetStatus(){
        outport=true;
        for(Ship s:ships){
            if(s.resthealth<s.health){
                outport=false;
            }
        }
    }
}
