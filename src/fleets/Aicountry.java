package fleets;

import java.util.HashMap;
import java.util.Random;

import game.Startgame;
import ships.Ship;

public class Aicountry extends Country {
    public int numoffleets=15;
    public boolean reserve=false;
	public String[] names={"基辅","瓦良格","库兹涅佐夫","施佩尔海军上将","无畏","基洛夫","德意志"
			,"俾斯麦","勇气","皇家方舟","皇家橡树","厌战","决心","胡德","决心","复仇","黎塞留"
			,"赤城","加贺","苍龙","飞龙","飞鹰","隼鹰","翔鹤","瑞鹤","大凤","长门","日向","出云"
			,"金刚","武藏","大和","扶桑","沙恩霍斯特","维内托","青花鱼","企业","黄蜂","萨拉托加"
			,"约克城","列克星敦","北卡罗来纳","史密斯","衣阿华","密苏里","怀俄明","尼米兹","福煦"
			,"欧根亲王","吕佐夫","提尔皮茨","皇家橡树","独眼巨人"};
	public Aicountry(){
		industry=50;
		cash=100;
		available =new Available();
		repair=new Underrepair();
		battle=new Battle();
        special=new Special();
		num=0;
        reserve=false;
		}
    public void buildfleet(){
        fleets=new HashMap<String,Fleet>();
        for(int i=0;i<numoffleets;i++){
            Fleet f=new Fleet("fleet"+(i+1));
            fleets.put(f.name,f);
        }
        Fleet f=new Fleet("tmp");
        fleets.put("tmp",f);
        for(Ship s:available.ships){
            if(s==null){
                break;
            }
            fleets.get(s.fleetname).add(s);
        }
        for(Ship s:repair.ships){
            if(s==null){
                break;
            }
            fleets.get(s.fleetname).add(s);
        }
    }
    public void removefromfleet(Ship s){
        if(s==null){return;}
        Fleet f=fleets.get(s.fleetname);
        f.remove(s);
        s.instr=3;
        if(!canControlSea(f)){
            f.setInstr(3);
        }
        if(f.instr==1&&f.getSize()<5){
            f.setInstr(2);
        }
    }
    public void randomAddToFleet(Ship s,int time){
        s.instr=3;
        int r;
        if(reserve){
            r = (int) (Math.random() * numoffleets/3) + 1;
        }
        else {
            r = (int) (Math.random() * numoffleets) + 1;
        }
        if(fleets.get("fleet"+r).instr==0){
            fleets.get("fleet"+r).setInstr(3);
        }
        if(time>7){
            addtofleet(s,"fleet"+r);
        }
        if(fleets.get("fleet"+r).getSize()>9){
            randomAddToFleet(s,time+1);
        }
        else if(fleets.get("fleet"+r).getSize()>4){
            int nfo4=0;
            for(int i=0;i<numoffleets;i++){
                if(fleets.get("fleet"+(i+1)).instr==1){
                    nfo4++;
                }
            }
            if(nfo4<2){
                addtofleet(s,"fleet"+r);
                fleets.get("fleet"+r).setInstr(1);
            }
            else{
                randomAddToFleet(s,time+1);
            }
        }
        else{
            addtofleet(s,"fleet"+r);
            Fleet f=fleets.get("fleet"+r);
            if(canControlSea(f)){
                f.setInstr(2);
            }
        }
    }
    public void resetInstr(Fleet f){
        f.setInstr(3);
        if(f.getSize()>4){
            int nfo4=0;
            for(int i=0;i<numoffleets;i++){
                if(fleets.get("fleet"+(i+1)).instr==1){
                    nfo4++;
                }
            }
            if(nfo4<2){
                f.setInstr(1);
            }
        }
        else{
            if(canControlSea(f)){
                f.setInstr(2);
            }
        }
    }
    public boolean canControlSea(Fleet f){
        if(f.getSize()<=1){
            return false;
        }
        boolean allsub=true;
        for(Ship s:f.ships){
            if(s.type1.equals("submarine")){
                allsub=false;
            }
        }
        if(allsub){
            return false;
        }
        return true;
    }
    public void passyear(boolean b){
        cash+=industry;
        int sum=0;
        for(Ship sh:available.ships){
            if(sh==null){
                break;
            }
            sum+=sh.cost;
        }
        cash-=sum;
        if(cash<0){
            cash=0;
            //System.out.println(cash);////////
        }
        repair(b);
        for(Ship s:available.ships){
            if(s==null){
                break;
            }
            if(s.fleetname.equals("tmp")){
                removefromfleet(s);
                randomAddToFleet(s,0);
            }
        }
        if(b){
            special.old();
        }
        updateFleetStatus();
        for(Fleet f:getfleets()){
            if(f.name.equals("tmp")){continue;}
            if(f.instr==0){
                resetInstr(f);
            }
        }
        if(available.numofship<=5){
            reserve=true;
        }
        if(available.numofship>=15){
            reserve=false;
        }
        //System.out.println(cash);////////
    }
	public void buildship(){
		int i=random();
		do{
			if(cash<0){
				break;
			}
			Ship s=new Ship();
			
			int n=i%4;
			
			if (n==0){
			int m=random()%6+1;	
			switch(m)
			{    //name,health,cost,type1,type2,antisub,antiair,antifire,search,attack
			case 1:
                s.copyexceptname(special.cv[0]);
                s.name = rdname(0);
                s.resthealth=0;
			//=new Ship(rdname(),11,22,30,"carrier","light",0,3,0,8,1,8);
			break;
			case 2:
                s.copyexceptname(special.cv[1]);
                s.name = rdname(0);
                s.resthealth=0;
			//s=new Ship(rdname(),14,28,48,"carrier","normal",0,3,5,5,20,7);
			break;
			case 3:
                s.copyexceptname(special.cv[2]);
                s.name = rdname(0);
                s.resthealth=0;
			//s=new Ship(rdname(),18,36,65,"carrier","heavy",0,9,6,5,26,7);
			break;
			case 4:
                s.copyexceptname(special.bb[0]);
                s.name = rdname(0);
                s.resthealth=0;
			//s=new Ship(rdname(),15,30,41,"battleship","mini",0,9,14,0,9,9);
			break;
			case 5:
                s.copyexceptname(special.bb[1]);
                s.name = rdname(0);
                s.resthealth=0;
			//s=new Ship(rdname(),18,36,46,"battleship","normal",0,10,17,0,22,8);
			break;
			case 6:
                s.copyexceptname(special.bb[2]);
                s.name = rdname(0);
                s.resthealth=0;
			//s=new Ship(rdname(),22,48,56,"battleship","superheavy",0,16,17,0,27,7);
			break;
			default:break;
			}
			}
			else{
				int m=random()%9+1;	
				switch(m)
				{    //name,health,cost,type1,type2,antisub,antiair,antifire,search,attack
				case 1:
                    s.copyexceptname(special.c[0]);
                    s.name = rdname(0);
                    s.resthealth=0;
				//s=new Ship(rdname(),8,16,23,"cruiser","light",4,6,4,0,3,13);
				break;
				case 2:
                    s.copyexceptname(special.c[1]);
                    s.name = rdname(0);
                    s.resthealth=0;
				//s=new Ship(rdname(),10,20,28,"cruiser","heavy",4,10,4,0,3,11);
				break;
				case 3:
                    s.copyexceptname(special.c[2]);
                    s.name = rdname(0);
                    s.resthealth=0;
				//s=new Ship(rdname(),13,26,39,"cruiser","battle",5,10,7,4,5,10);
				break;
				case 4:
                    s.copyexceptname(special.dd[0]);
                    s.name = rdname("DD");
                    s.resthealth=0;
				//s=new Ship(rdname("DD"),3,6,11,"destroyer","early",4,0,2,0,2,17);
				break;
				case 5:
                    s.copyexceptname(special.dd[1]);
                    s.name = rdname("DD");
                    s.resthealth=0;
				//s=new Ship(rdname("DD"),4,8,15,"destroyer","basic",5,0,3,0,3,18);
				break;
				case 6:
                    s.copyexceptname(special.dd[2]);
                    s.name = rdname("DD");
                    s.resthealth=0;
				//s=new Ship(rdname("DD"),5,10,18,"destroyer","morden",5,0,5,0,4,20);
				break;
				case 7:
                    s.copyexceptname(special.ss[0]);
                    s.name = rdname("SS");
                    s.resthealth=0;
				//s=new Ship(rdname("SS"),2,4,5,"submarine","early",0,0,0,1,12,9);
				break;
				case 8:
                    s.copyexceptname(special.ss[1]);
                    s.name = rdname("SS");
                    s.resthealth=0;
				//s=new Ship(rdname("SS"),3,6,6,"submarine","basic",0,0,0,1,12,10);
				break;
				case 9:
                    s.copyexceptname(special.ss[2]);
                    s.name = rdname("SS");
                    s.resthealth=0;
				//s=new Ship(rdname("SS"),4,8,8,"submarine","morden",0,0,0,1,18,11);
				break;
				default:break;
				}
			}
			repair.add(s);
            s.instr=3;
            fleets.get("tmp").add(s);
            fleets.get("tmp").setInstr(0);
			cash=cash-s.cost;
			i++;
		}while(cash>28);
	}
	public void arrangebattle(){
		for(int i=0;i< available.numofship;i++){
			if(i>= available.numofship||i>5){
				break;
			}
		addtobattle(available.ships[i]);
    	available.delete(available.ships[i]);
		}
	}
	public int random(){
		Random r = new Random();
	    int rv =(int)(100 * r.nextDouble());
	    return rv;
	}
	public String rdname(int tm){
		String name=names[random()%names.length];
        if(tm>=5){
            name=name+"I";
        }
		for(int i=0;i< available.numofship;i++)
		{
		if(available.ships[i].name.equals(name)){
			name=rdname(tm+1);
		}
		}
		for(int i=0;i<repair.numofship;i++)
		{
		if(repair.ships[i].name.equals(name)){
			name=rdname(tm+1);
			break;
		}
		}
		return name;
	}
	public String rdname(String s){
		num++;
		if(num>=100){
		num=0;	
		}
		return s+"-"+num;
	}
}