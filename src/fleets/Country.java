package fleets;
import ships.Battleship;
import ships.Carrier;
import ships.Cruiser;
import ships.Destroyer;
import ships.Ship;
import ships.Submarine;

import java.util.*;

public class Country {
	public int num;
	public int industry;
	public int cash;
	public Available available;
	public Underrepair repair;
	public Battle battle;
	public Special special;
    public HashMap<String,Fleet> fleets;
    public boolean reserve;
	public Country(){
	industry=50;
	cash=100;
	available =new Available();
	repair=new Underrepair();
	battle=new Battle();
	special=new Special();
	num=0;
    fleets=new HashMap<String,Fleet>();
	}

    public void buildfleet(){
        fleets=new HashMap<String,Fleet>();
        for(Ship s:available.ships){
            if(s==null){
                break;
            }
            if(fleets.containsKey(s.fleetname)){
                fleets.get(s.fleetname).add(s);
            }
            else{
                Fleet f=new Fleet(s.fleetname);
                f.add(s);
                fleets.put(s.fleetname,f);
            }
        }
        for(Ship s:repair.ships){
            if(s==null){
                break;
            }
            if(fleets.containsKey(s.fleetname)){
                fleets.get(s.fleetname).add(s);
            }
            else{
                Fleet f=new Fleet(s.fleetname);
                f.add(s);
                fleets.put(s.fleetname,f);
            }
        }
    }
    public void addtofleet(Ship s,String name){
        s.fleetname=name;
        if(fleets.containsKey(s.fleetname)){
            fleets.get(s.fleetname).add(s);
        }
        else{
            Fleet f=new Fleet(s.fleetname);
            f.add(s);
            fleets.put(s.fleetname,f);
        }
    }
    public void removefromfleet(Ship s){
        if(s==null){return;}
        Fleet f=fleets.get(s.fleetname);
        if(f!=null) {
            f.remove(s);
            if (f.getSize() <= 0) {
                fleets.remove(f.name);
            }
        }
        s.instr=3;
    }
    public void dropFleet(Ship s){
        if(s==null){return;}
        removefromfleet(s);
        String name=s.name;
       while (fleetNameUsed(name)){
           name+="I";
       }
        Fleet f=new Fleet(name);
        f.add(s);
        fleets.put(name,f);
    }
    public void changeFleet(Ship s, Fleet f){
        removefromfleet(s);
        addtofleet(s,f.name);
    }
    public boolean fleetNameUsed(String name){
        return fleets.containsKey(name);
    }
    public void toNewFleet(Ship s){
        String name=s.name;
        while (fleetNameUsed(name)){
            name+="I";
        }
        Fleet f=new Fleet(name);
        f.add(s);
        fleets.put(name,f);
    }
	public void updateFleetStatus(){
        for(Fleet f:getfleets()){
            if(f.name.equals("tmp")){continue;}
            f.autoSetStatus();
        }
    }
    public void buildship(){
		System.out.println("choose type");
		System.out.println("1:submarine");
		System.out.println("2:destroyer");
		System.out.println("3:cruiser");
		System.out.println("4:battleship");
		System.out.println("5:carrier");
		Scanner sc = new Scanner(System.in); 
        int i = sc.nextInt();
        System.out.println("choose type");
		System.out.println("1:early");
		System.out.println("2:basic");
		System.out.println("3:morden");
		System.out.println("4:invent");
		switch(i)
		{
		case 1:
			if(special.numofss==0){
				break;
			}
			for(int n=0;n<special.numofss;n++){
			System.out.println(5+n+":"+special.ss[n].type2+" "
			+(special.ss[n].cost+special.ss[n].getweapcost())+" attack"
			+special.ss[n].getattack(true)+" speed"+special.ss[n].speed);
			}
			break;
		case 2:
			if(special.numofdd==0){
				break;
			}
			for(int n=0;n<special.numofdd;n++){
				System.out.println(5+n+":"+special.dd[n].type2+" "
						+(special.dd[n].cost+special.dd[n].getweapcost())+" health"+
						special.dd[n].health+" antiair"+special.dd[n].getantiair(true)+" antisub"
						+special.dd[n].getantisub(true)+" attack"+special.dd[n].getattack(true)+
						" search"+special.dd[n].getsearch(true)+" speed"+special.dd[n].speed);
				}
			break;
		case 3:
			if(special.numofc==0){
				break;
			}
			for(int n=0;n<special.numofc;n++){
				System.out.println(5+n+":"+special.c[n].type2+" "
						+(special.c[n].cost+special.c[n].getweapcost())
						+" health"+special.c[n].health
						+" antiair"+special.c[n].getantiair(true)+" antisub"+special.c[n].getantisub(true)
						+" attack"+special.c[n].getattack(true)+" search"+special.c[n].getsearch(true)
						+" speed"+special.c[n].speed);
				}
			break;
		case 4:
			if(special.numofbb==0){
				break;
			}
			for(int n=0;n<special.numofbb;n++){
				System.out.println(5+n+":"+special.bb[n].type2+" "
						+(special.bb[n].cost+special.bb[n].getweapcost())
						+" health"+special.bb[n].health
						+" antiair"+special.bb[n].getantiair(true)+" antisub"+special.bb[n].getantisub(true)
						+" attack"+special.bb[n].getattack(true)+" search"+special.bb[n].getsearch(true)
						+" speed"+special.bb[n].speed);
				}
			break;
		case 5:
			if(special.numofcv==0){
				break;
			}
			for(int n=0;n<special.numofcv;n++){
				System.out.println(5+n+":"+special.cv[n].type2+" "
						+(special.cv[n].cost+special.cv[n].getweapcost())
						+" health"+special.cv[n].health
						+" antiair"+special.cv[n].getantiair(true)+" antisub"+special.cv[n].getantisub(true)
						+" attack"+special.cv[n].getattack(true)+" search"+special.cv[n].getsearch(true)
						+" speed"+special.cv[n].speed);
				}
			break;
		default:break;
		}
		int j = sc.nextInt();
		String name=null;
		if(!(((i==1)||(i==2))&&j>4)){
		System.out.println("enter name");
		name=getname();
		}
		Ship s=new Ship();
		switch(i)
		{
		case 1:
			if(j==4){
				System.out.println("choose weight");
				System.out.println("1:2");
				System.out.println("2:3");
				System.out.println("3:4");
				//s=new Submarine(j,name);
				int k = sc.nextInt();
					s=new Submarine(name,k);
					System.out.println("choose engin system");
					System.out.println("1:fast");
					System.out.println("2:normal");
					System.out.println("3:slow");
					//Scanner sc = new Scanner(System.in);
					int p=sc.nextInt();
					switch(p)
					{
					case 1:s.speed+=ver(s.speed*0.2);s.cost+=s.weight/4;break;
					case 2:break;
					case 3:s.speed-=ver(s.speed*0.2);s.cost-=s.weight/4;break;
					default:break;
					}
					System.out.println("choose power system");
					System.out.println("1:strong");
					System.out.println("2:normal");
					System.out.println("3:weak");
					//Scanner sc = new Scanner(System.in);
					p=sc.nextInt();
					switch(p)
					{
					case 1:s.endurence +=ver(s.endurence *0.2);s.cost+=s.weight/4;break;
					case 2:break;
					case 3:s.endurence -=ver(s.endurence *0.2);s.cost-=s.weight/4;break;
					default:break;
					}
					addwhilebuildspecial(s);
					special.add(s);
					break;
			}
			else if(j>4){
				s.copyexceptname(special.ss[j-5]);
				if(num<10){
				s.name=special.ss[j-5].type2.substring(0,2)+"-0"+num;
				}
				else{
					s.name=special.ss[j-5].type2.substring(0,2)+"-"+num;
				}
				num++;
				if(num>=100){
					num=0;
				}
				cash-=s.cost;
				repair.add(s);
                toNewFleet(s);
				cash-=s.getweapcost();
				s.cost+=s.getweapcost();
				break;
			}
			else{
			s=new Submarine(j,name);
			addwhilebuild(s);
			repair.add(s);
            toNewFleet(s);
			cash-=s.cost;
		//Weapon w8=new Subtorpedo(1);
		//s.addweapon(w8);
		//cash-=w8.cost;
		break;
			}
		case 2:
			if(j==4){
				System.out.println("choose weight");
				System.out.println("1:3");
				System.out.println("2:4");
				System.out.println("3:5");
				//s=new Destroyer(j,name);
				int k = sc.nextInt();
					s=new Destroyer(name,k);
					System.out.println("choose engin system");
					System.out.println("1:fast");
					System.out.println("2:normal");
					System.out.println("3:slow");
					//Scanner sc = new Scanner(System.in);
					int p=sc.nextInt();
					switch(p)
					{
					case 1:s.speed+=ver(s.speed*0.2);s.cost+=s.weight/4;break;
					case 2:break;
					case 3:s.speed-=ver(s.speed*0.2);s.cost-=s.weight/4;break;
					default:break;
					}
					System.out.println("choose power system");
					System.out.println("1:strong");
					System.out.println("2:normal");
					System.out.println("3:weak");
					//Scanner sc = new Scanner(System.in);
					p=sc.nextInt();
					switch(p)
					{
					case 1:s.endurence +=ver(s.endurence *0.2);s.cost+=s.weight/4;break;
					case 2:break;
					case 3:s.endurence -=ver(s.endurence *0.2);s.cost-=s.weight/4;break;
					default:break;
					}
					addwhilebuildspecial(s);
					special.add(s);
					break;
			}
			else if(j>4){
				s.copyexceptname(special.dd[j-5]);
				if(num<10){
					s.name=special.dd[j-5].type2.substring(0,2)+"-0"+num;
					}
					else{
						s.name=special.dd[j-5].type2.substring(0,2)+"-"+num;
					}
				num++;
				if(num>=100){
					num=0;
				}
				cash-=s.cost;
				repair.add(s);
                toNewFleet(s);
				cash-=s.getweapcost();
				s.cost+=s.getweapcost();
				break;
			}
		else{
			s=new Destroyer(j,name);
		addwhilebuild(s);
		repair.add(s);
                toNewFleet(s);
		cash-=s.cost;
		//Weapon w3=new Gun(3);
		//Weapon w4=new Antisubeq(1);
		//s.addweapon(w3);
		//s.addweapon(w4);
		//cash-=(w3.cost+w4.cost);
		break;
		}
		case 3:
			if(j==4){
				System.out.println("choose weight");
				System.out.println("1:8");
				System.out.println("2:10");
				System.out.println("3:13");
				//s=new Destroyer(j,name);
				int k = sc.nextInt();
					s=new Cruiser(name,k);
					System.out.println("choose engin system");
					System.out.println("1:fast");
					System.out.println("2:normal");
					System.out.println("3:slow");
					//Scanner sc = new Scanner(System.in);
					int p=sc.nextInt();
					switch(p)
					{
					case 1:s.speed+=ver(s.speed*0.2);s.cost+=s.weight/4;break;
					case 2:break;
					case 3:s.speed-=ver(s.speed*0.2);s.cost-=s.weight/4;break;
					default:break;
					}
					System.out.println("choose power system");
					System.out.println("1:strong");
					System.out.println("2:normal");
					System.out.println("3:weak");
					//Scanner sc = new Scanner(System.in);
					p=sc.nextInt();
					switch(p)
					{
					case 1:s.endurence +=ver(s.endurence *0.2);s.cost+=s.weight/4;break;
					case 2:break;
					case 3:s.endurence -=ver(s.endurence *0.2);s.cost-=s.weight/4;break;
					default:break;
					}
					addwhilebuildspecial(s);
					special.add(s);
					break;
			}
			else if(j>4){
				s.copyexceptname(special.c[j-5]);
				s.name=name;
				cash-=s.cost;
				repair.add(s);toNewFleet(s);
				cash-=s.getweapcost();
				s.cost+=s.getweapcost();
				break;
			}
		else{
			s=new Cruiser(j,name);
		addwhilebuild(s);
		repair.add(s);toNewFleet(s);
		cash-=s.cost;
		//Weapon w5=new Gun(3);
		//Weapon w6=new Gun(1);
		//s.addweapon(w5);
		//s.addweapon(w6);
		//cash-=(w5.cost+w6.cost);
		break;}
		case 4:
			if(j==4){
				System.out.println("choose weight");
				System.out.println("1:15");
				System.out.println("2:18");
				System.out.println("3:22");
				//s=new Destroyer(j,name);
				int k = sc.nextInt();
					s=new Battleship(name,k);
					System.out.println("choose engin system");
					System.out.println("1:fast");
					System.out.println("2:normal");
					System.out.println("3:slow");
					//Scanner sc = new Scanner(System.in);
					int p=sc.nextInt();
					switch(p)
					{
					case 1:s.speed+=ver(s.speed*0.2);s.cost+=s.weight/4;break;
					case 2:break;
					case 3:s.speed-=ver(s.speed*0.2);s.cost-=s.weight/4;break;
					default:break;
					}
					System.out.println("choose power system");
					System.out.println("1:strong");
					System.out.println("2:normal");
					System.out.println("3:weak");
					//Scanner sc = new Scanner(System.in);
					p=sc.nextInt();
					switch(p)
					{
					case 1:s.endurence +=ver(s.endurence *0.2);s.cost+=s.weight/4;break;
					case 2:break;
					case 3:s.endurence -=ver(s.endurence *0.2);s.cost-=s.weight/4;break;
					default:break;
					}
					addwhilebuildspecial(s);
					special.add(s);
					break;
			}
			else if(j>4){
				s.copyexceptname(special.bb[j-5]);
				s.name=name;
				cash-=s.cost;
				repair.add(s);toNewFleet(s);
				cash-=s.getweapcost();
				s.cost+=s.getweapcost();
				break;
			}
		else{
			s=new Battleship(j,name);
		addwhilebuild(s);
		repair.add(s);toNewFleet(s);
		cash-=s.cost;
		//Weapon w1=new Gun(1);
		//Weapon w2=new Gun(4);
		//s.addweapon(w1);
		//s.addweapon(w2);
		//cash-=(w1.cost+w2.cost);
		break;}
		case 5:
			if(j==4){
				System.out.println("choose weight");
				System.out.println("1:11");
				System.out.println("2:14");
				System.out.println("3:18");
				//s=new Destroyer(j,name);
				int k = sc.nextInt();
					s=new Carrier(name,k);
					System.out.println("chose engin system");
					System.out.println("1:fast");
					System.out.println("2:normal");
					System.out.println("3:slow");
					//Scanner sc = new Scanner(System.in);
					int p=sc.nextInt();
					switch(p)
					{
					case 1:s.speed+=ver(s.speed*0.2);s.cost+=s.weight/4;break;
					case 2:break;
					case 3:s.speed-=ver(s.speed*0.2);s.cost-=s.weight/4;break;
					default:break;
					}
					System.out.println("choose power system");
					System.out.println("1:strong");
					System.out.println("2:normal");
					System.out.println("3:weak");
					//Scanner sc = new Scanner(System.in);
					p=sc.nextInt();
					switch(p)
					{
					case 1:s.endurence +=ver(s.endurence *0.2);s.cost+=s.weight/4;break;
					case 2:break;
					case 3:s.endurence -=ver(s.endurence *0.2);s.cost-=s.weight/4;break;
					default:break;
					}
					addwhilebuildspecial(s);
					special.add(s);
					break;
			}
			else if(j>4){
				s.copyexceptname(special.cv[j-5]);
				s.name=name;
				cash-=s.cost;
				repair.add(s);toNewFleet(s);
				cash-=s.getweapcost();
				s.cost+=s.getweapcost();
				break;
			}
		else{
			s=new Carrier(j,name);
		addwhilebuild(s);
		repair.add(s);toNewFleet(s);
		cash-=s.cost;
		//Weapon w7=new Launcher(3);
		//s.addweapon(w7);
		//cash-=w7.cost;
		break;}
		default:System.out.println("unable to build");break;	
		}
		
	}
	
	public void addwhilebuild(Ship s){///////////////////////////
		System.out.println("rest weight"+(s.weight-s.getweight())+" cash"+cash);
		System.out.println("add weapon?");
		System.out.println("1:yes");
		System.out.println("2:no");
		Scanner sc = new Scanner(System.in);
		int i=sc.nextInt();
		switch(i)
		{
		case 1:cash-=s.addweapspecial();addwhilebuild(s);break;
		case 2:break;
		}
	}
	public void addwhilebuildspecial(Ship s){///////////////////////////
		System.out.println("rest weight"+(s.weight-s.getweight()));
		System.out.println("add weapon?");
		System.out.println("1:yes");
		System.out.println("2:no");
		Scanner sc = new Scanner(System.in);
		int i=sc.nextInt();
		switch(i)
		{
		case 1:s.addweapspecial();addwhilebuildspecial(s);break;
		case 2:break;
		}
	}
	
	public void addtorepair(){
		if(available.numofship!=0){
		Ship[] sh=new Ship[available.numofship];
		int n=0;
		for(int i=0;i< available.numofship;i++){
			if(available.ships[i].health!= available.ships[i].resthealth){
				sh[n]= available.ships[i];
				n++;
				cash-=(available.ships[i].health- available.ships[i].resthealth)/2;
			}
		}
		for(int i=0;i<n;i++){
			available.delete(sh[i]);
			repair.add(sh[i]);
			//cash-=(sh[i].health-sh[i].resthealth)/2;
		}
		}
	}
	public void repair(boolean b){
		//for(int i=0;i<repair.numofship;i++){
			//if(repair.ships[i]==null){
			//break;
			//}
			//if(repair.ships[i].resthealth+12<repair.ships[i].health){
			//cash-=6;
			//}
			//else{
//cash-=(repair.ships[i].health-repair.ships[i].resthealth)/2;
			//}
		//}
		Ship[] list=repair.repair(b);
		if(list.length!=0){
		for(int i=0;i<list.length;i++){
			available.add(list[i]);
			repair.delete(list[i]);
		}
		}
	}
	public void addtofleet(){
		if(battle.numofship!=0)
		{
		int n=battle.numofship;
		for(int i=0;i<n;i++){
			available.add(battle.ships[i]);
		}
		}
	}
    public void addtobattle(Fleet f){
        for(Ship s:f.ships){
            addtobattle(s);
        }
    }
	public void addtobattle(Ship s){
        repair.delete(s);
        available.delete(s);
		battle.add(s);
	}
	public void newbattle(){
		battle=new Battle();
	}
	public void arrangebattle(){
		if(available.numofship!=0||repair.numofship!=0)
		{
		Scanner sc = new Scanner(System.in);
		System.out.println("add ship?");
		System.out.println("1:yes");
		System.out.println("2:no");
		System.out.println("3:view battle list");
		int k = sc.nextInt();
		switch(k)
		{
		case 1:
		System.out.println("choose ship");
		available.printlist(true);
		System.out.println(available.numofship+"choose ship under repair"+"\n"+
		(available.numofship+1)+"cancel");
        int i = sc.nextInt();
        if(i< available.numofship){
        	addtobattle(available.ships[i]);
        	available.delete(available.ships[i]);
        }
        else if(i== available.numofship){
        	if(repair.numofship!=0){
        	System.out.println("choose ship");
        	repair.printlist(true);
        	int j=sc.nextInt();
        	addtobattle(repair.ships[j]);
        	repair.delete(repair.ships[j]);
        }
        	else{
        		System.out.println("no ship");
        	}
        }
        arrangebattle();
        break;
		case 2:
		break;
		case 3:
		battle.printlist(true);
		arrangebattle();
		break;
		default:break;
		}
		}
	}
	public void sink(Ship s){
		battle.delete(s);
		try{
			available.delete(s);
		}
		catch(Exception e){
		}
		try{
			repair.delete(s);
		}
		catch(Exception e){
		}
	}
	public void addeq(){
		System.out.println("add or unload");
		System.out.println("1:add");
		System.out.println("2:unload");
		Scanner sc = new Scanner(System.in); 
        int i = sc.nextInt();
        if(available.numofship==0){
        	System.out.println("no ship available");
        }
        else{
        switch (i)
        {
        case 1:cash-= available.addweap();break;
        case 2:
            available.unload();break;
        default:break;
        }
        }
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
        cash-=sum/12;
        if(cash<0){
            cash=0;
            //System.out.println(cash);////////
        }
        repair(b);
    	if(b){
    		special.old();
    	}
        updateFleetStatus();
        if(cash<0){
            cash=0;
            //System.out.println(cash);////////
        }
    	//System.out.println(cash);////////
    }
	//helper
	public String getname(){
		Scanner sc = new Scanner(System.in); 
		String name = sc.nextLine();
		for(int i=0;i< available.numofship;i++)
		{
		if(available.ships[i].name.equals(name)){
			System.out.println("already exist,enter again");
			name=getname();
		}
		}
		for(int i=0;i<repair.numofship;i++)
		{
		if(repair.ships[i].name.equals(name)){
			System.out.println("already exist,enter again");
			name=getname();
			break;
		}
		}
		return name;
	}
    public boolean nameUsed(String name){
        for(int i=0;i< available.numofship;i++)
        {
            if(available.ships[i].name.equals(name)){
                //System.out.println("already exist,enter again");
                //name=getname();
                return true;
            }
        }
        for(int i=0;i<repair.numofship;i++)
        {
            if(repair.ships[i].name.equals(name)){
                return true;
            }
        }
        return false;
    }
	public void setspeed(){
		for(int i=0;i< available.numofship;i++){
			if(available.numofship==0){
				break;
			}
			available.ships[i].setspeed();
		}
		for(int i=0;i<repair.numofship;i++){
			if(repair.numofship==0){
				break;
			}
			repair.ships[i].setspeed();
		}
	}
	public int ver(double d){
		int i=(int)d;
		d=d-i;
		if(d>0.5){
			return(i+1);
		}
		return i;
	}

    public ArrayList<Fleet> getfleets() {
        Set<String>ks= fleets.keySet();
        ArrayList<Fleet> fs=new ArrayList<Fleet>();
        for(String str:ks){
            if(fleets.get(str).getSize()>=1) {
                fs.add(fleets.get(str));
            }
        }
        return sortFlets(fs);
    }
    public ArrayList<Fleet> sortFlets(ArrayList<Fleet> fs){
        ArrayList<Fleet>[] fi= new ArrayList[]{new ArrayList<Fleet>(),new ArrayList<Fleet>()
        ,new ArrayList<Fleet>(),new ArrayList<Fleet>()};
        for(Fleet f:fs){
            fi[f.instr].add(f);
        }
        ArrayList<Fleet> fss=new ArrayList<Fleet>();
        for(int i=0;i<4;i++){
            for(Fleet f:fi[i]){
             fss.add(f);
            }
        }
        return fss;
    }
    public void changeFleetName(Fleet f,String name){
        fleets.remove(f.name);
        f.setName(name);
        fleets.put(name,f);
    }

    public void setInvRecord(Ship s) {
        Ship inv=special.getInv(s);
        if (inv==null){return;}
        inv.experience+=s.experience;
        inv.level+=s.level;
        inv.point++;
    }
}
