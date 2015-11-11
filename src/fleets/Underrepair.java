package fleets;

import java.util.Random;

import ships.Ship;

public class Underrepair {
	public Ship[] ships;
	public int numofship;

	public Underrepair()
	{
	ships=new Ship[10];
	numofship=0;
	}

	public void add(Ship s){
		if(numofship==ships.length)
		{
		    doublesize();
		}
		ships[numofship]=s;
		numofship++;
	}
	public void doublesize(){
		Ship[] ships2=new Ship[ships.length*2];
		for(int i=0;i<ships.length;i++){
			ships2[i]=ships[i];
		}
		ships=ships2;
	}
	public void delete(Ship s){
        if(find(s)<0||find(s)==numofship){return;}
        for(int i=find(s);i<numofship;i++){
            if(i+1>=ships.length){
                ships[i]=null;
            }
            else {
                ships[i] = ships[i + 1];
            }
        }
		//ships[find(s)]=ships[numofship-1];
		//ships[numofship-1]=null;
		numofship--;
	}
	public int find(Ship s){
        if(s==null){
            return -1;
        }
		for(int i=0;i<numofship;i++){
			if(s.name.equals(ships[i].name)){
				return i;
			}
		}
		return numofship;
	}
	public Ship[] repair(boolean b){
		int n=0;
		Ship[] list=new Ship[numofship];
		int rest=100;
		if(b){
			//rest=30;
		}
		int add;
	for(int i=0;i<numofship;i++){
		if(rest<=0){
			break;
		}
		if(ships[i]==null){
		break;
		}
		if(ships[i].resthealth+6<ships[i].health){
			add=6;
			if(rest<add){
				add=rest;
			}
		ships[i].resthealth+=add;
		rest-=add;
		if(random()<15){
            if(ships[i].experience!=0) {
                System.out.println("not recoverable " + ships[i].name);
                Ship sh = ships[i];
                int t = random() % (sh.numofweap * 2 + 1);
                if (t < sh.numofweap) {
                    System.out.print("weap " + sh.weap[t].name);
                    sh.weap[t].old();
                } else if (random() < 50) {
                    sh.endurence -= random() / 20;
                    System.out.println("endurence" + sh.endurence);
                } else if (random() < 20) {
                    sh.speed--;
                    System.out.println("speed" + sh.speed);
                } else {
                    sh.health--;
                    System.out.println("health" + sh.health);
                }
            }
		}
		}
		else{
			add=(ships[i].health-ships[i].resthealth);
			if(add<=rest){
			ships[i].resthealth=ships[i].health	;
			ships[i].insspeed=ships[i].speed;
			rest-=(ships[i].health-ships[i].resthealth);
			list[n]=ships[i];
			n++;
			}
			else{
				add=rest;
				ships[i].resthealth+=add;
				rest-=add;
			}
		}
	}
	Ship[] list2=new Ship[n];
	for(int i=0;i<n;i++){
		list2[i]=list[i];
	}
	return list2;
	}
	public void printweap(int i){
		ships[i].printweap();
	}
	public void printlist(boolean b){
		for(int i=0;i<numofship;i++){
			System.out.println(i+" "+ships[i].name+" weight"+ships[i].weight+" "+ships[i].type1+ships[i].type2+
					" health"+ships[i].resthealth+"/"+ships[i].health
					+" antiair"+ships[i].getantiair(b)+" antisub"+ships[i].getantisub(b)
					+" attack"+ships[i].getattack(b)+" search"+ships[i].getsearch(b)+" level"+ships[i].level
					+" speed"+ships[i].speed);
		}
	}
	public int random(){
		Random r = new Random();
	    int rv =(int)(100 * r.nextDouble());
	    return rv;
	}
}
