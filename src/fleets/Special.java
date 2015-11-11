package fleets;

import java.util.Random;
import java.util.Scanner;

import ships.Ship;

public class Special {
	public Ship[] cv;
	public int numofcv;
    public Ship[] bb;
    public int numofbb;
    public Ship[] c;
    public int numofc;
    public Ship[] dd;
    public int numofdd;
    public Ship[] ss;
    public int numofss;
    public Special(){
    	cv=new Ship[3];
    	numofcv=0;
    	bb=new Ship[3];
    	numofbb=0;
    	c=new Ship[3];
    	numofc=0;
    	dd=new Ship[3];
    	numofdd=0;
    	ss=new Ship[3];
    	numofss=0;
    }
    
    public void doublesize(Ship[] ships){
    	Ship[] ships2=new Ship[ships.length*2];
    	for(int i=0;i<ships.length;i++){
    		ships2[i]=ships[i];
    	}
    	ships=ships2;
    }
    public void add(Ship s){
    	s.setspeed();
    	if(s.type1.equals("carrier")){
    		if(numofcv==cv.length)
        	{
        	doublesize(cv);
        	}
        	cv[numofcv]=s;
        	numofcv++;
    	}
    	else if(s.type1.equals("battleship")){
    		if(numofbb==bb.length)
        	{
        	doublesize(bb);
        	}
        	bb[numofbb]=s;
        	numofbb++;
    	}
    	else if(s.type1.equals("cruiser")){
    		if(numofc==c.length)
        	{
        	doublesize(c);
        	}
        	c[numofc]=s;
        	numofc++;
    	}
    	else if(s.type1.equals("destroyer")){
    		if(numofdd==dd.length)
        	{
        	doublesize(dd);
        	}
        	dd[numofdd]=s;
        	numofdd++;
    	}
    	else{
    	if(numofss==ss.length)
    	{
    	doublesize(ss);
    	}
    	ss[numofss]=s;
    	numofss++;
    }
}
    public void weed(){
    	System.out.println("choose type");
    	System.out.println("1:submarine");
    	System.out.println("2:destroyer");
    	System.out.println("3:cruiser");
    	System.out.println("4:battleship");
    	System.out.println("5:carrier");
    	Scanner sc = new Scanner(System.in);
    	int j=sc.nextInt();
    	switch(j)
    	{
    	case 1:
    		if(numofss==0){
    			System.out.println("no invention");
    			break;
    		}
    		System.out.println("choose ship");
    		for(int i=0;i<numofss;i++){
    			System.out.println(i+" cost"+(ss[i].cost+ss[i].getweapcost())+" "+ss[i].type1+ss[i].type2+
    					" health"+ss[i].health
    					+" antiair"+ss[i].getantiair(true)+" antisub"+
    					ss[i].getantisub(true)+" search"+ss[i].getsearch(true)
    					+" attack"+ss[i].getattack(true)+" speed"+ss[i].speed);
    		}
    		System.out.println(numofss+"cancel");
    		j=sc.nextInt();
    		if(j<numofss){
    			ss[j]=ss[numofss-1];
    			ss[numofss-1]=null;
    			numofss--;
    			System.out.println("deleted");
    		}
    		break;
    	case 2:
    		if(numofdd==0){
    			System.out.println("no invention");
    			break;
    		}
    		System.out.println("choose ship");
    		for(int i=0;i<numofdd;i++){
    			System.out.println(i+" cost"+(dd[i].cost+dd[i].getweapcost())+" "+dd[i].type1+dd[i].type2+
    					" health"+dd[i].health
    					+" antiair"+dd[i].getantiair(true)+" antisub"+
    					dd[i].getantisub(true)+" search"+dd[i].getsearch(true)
    					+" attack"+dd[i].getattack(true)+" speed"+dd[i].speed);
    		}
    		System.out.println(numofdd+"cancel");
    		j=sc.nextInt();
    		if(j<numofdd){
    			dd[j]=dd[numofdd-1];
    			dd[numofdd-1]=null;
    			numofdd--;
    			System.out.println("deleted");
    		}
    		break;
    	case 3:
    		if(numofc==0){
    			System.out.println("no invention");
    			break;
    		}
    		System.out.println("choose ship");
    		for(int i=0;i<numofc;i++){
    			System.out.println(i+" cost"+(c[i].cost+c[i].getweapcost())+" "+c[i].type1+c[i].type2+
    					" health"+c[i].health+" weight"+c[i].weight
    					+" antiair"+c[i].getantiair(true)+" antisub"+
    					c[i].getantisub(true)+" search"+c[i].getsearch(true)
    					+" attack"+c[i].getattack(true)+" speed"+c[i].speed);
    		}
    		System.out.println(numofc+"cancel");
    		j=sc.nextInt();
    		if(j<numofc){
    			c[j]=c[numofc-1];
    			c[numofc-1]=null;
    			numofc--;
    			System.out.println("deleted");
    		}
    		break;
    	case 4:
    		if(numofbb==0){
    			System.out.println("no invention");
    			break;
    		}
    		System.out.println("choose ship");
    		for(int i=0;i<numofbb;i++){
    			System.out.println(i+" cost"+(bb[i].cost+bb[i].getweapcost())+" "+bb[i].type1+bb[i].type2+
    					" health"+bb[i].health+" weight"+bb[i].weight
    					+" antiair"+bb[i].getantiair(true)+" antisub"+
    					bb[i].getantisub(true)+" search"+bb[i].getsearch(true)
    					+" attack"+bb[i].getattack(true)+" speed"+bb[i].speed);
    		}
    		System.out.println(numofbb+"cancel");
    		j=sc.nextInt();
    		if(j<numofbb){
    			bb[j]=bb[numofbb-1];
    			bb[numofbb-1]=null;
    			numofbb--;
    			System.out.println("deleted");
    		}
    		break;
    	case 5:
    		if(numofcv==0){
    			System.out.println("no invention");
    			break;
    		}
    		System.out.println("choose ship");
    		for(int i=0;i<numofcv;i++){
    			System.out.println(i+" cost"+(cv[i].cost+cv[i].getweapcost())+" "+cv[i].type1+cv[i].type2+
    					" health"+cv[i].health+" weight"+cv[i].weight
    					+" antiair"+cv[i].getantiair(true)+" antisub"+
    					cv[i].getantisub(true)+" search"+cv[i].getsearch(true)
    					+" attack"+cv[i].getattack(true)+" speed"+cv[i].speed);
    		}
    		System.out.println(numofcv+"cancel");
    		j=sc.nextInt();
    		if(j<numofcv){
    			cv[j]=cv[numofcv-1];
    			cv[numofcv-1]=null;
    			numofcv--;
    			System.out.println("deleted");
    		}
    		break;
    		default:break;
    	}
    }
    public void weed(Ship s){
        if(s==null){

        }
        else if(s.type1.equals("carrier")) {
            for (int i = 0; i < 3; i++) {
                if (cv[i] == s) {
                    cv[i] = cv[numofcv - 1];
                    cv[numofcv - 1] = null;
                    numofcv--;
                }
            }
        }
        else if(s.type1.equals("battleship")) {
            for (int i = 0; i < 3; i++) {
                if (bb[i] == s) {
                    bb[i] = bb[numofbb - 1];
                    bb[numofbb - 1] = null;
                    numofbb--;
                }
            }
        }
        else if(s.type1.equals("cruiser")) {
            for (int i = 0; i < 3; i++) {
                if (c[i] == s) {
                    c[i] = c[numofc - 1];
                    c[numofc - 1] = null;
                    numofc--;
                }
            }
        }
        else if(s.type1.equals("destroyer")) {
            for (int i = 0; i < 3; i++) {
                if (dd[i] == s) {
                    dd[i] = dd[numofdd - 1];
                    dd[numofdd - 1] = null;
                    numofdd--;
                }
            }
        }
        else if(s.type1.equals("submarine")) {
            for (int i = 0; i < 3; i++) {
                if (ss[i] == s) {
                    ss[i] = ss[numofss - 1];
                    ss[numofss - 1] = null;
                    numofss--;
                }
            }
        }
    }
    public Ship getInv(Ship s){
        if(s==null){
            return null;
        }
        else if(s.type1.equals("carrier")) {
            for (int i = 0; i < 3; i++) {
                if (cv[i].type2.equals(s.type2)) {
                    return cv[i];
                }
            }
        }
        else if(s.type1.equals("battleship")) {
            for (int i = 0; i < 3; i++) {
                if (bb[i].type2.equals(s.type2) ){
                   return bb[i];
                }
            }
        }
        else if(s.type1.equals("cruiser")) {
            for (int i = 0; i < 3; i++) {
                if (c[i].type2.equals(s.type2)) {
                    return c[i];
                }
            }
        }
        else if(s.type1.equals("destroyer")) {
            for (int i = 0; i < 3; i++) {
                if (dd[i].type2.equals( s.type2)) {
                    return dd[i];
                }
            }
        }
        else if(s.type1.equals("submarine")) {
            for (int i = 0; i < 3; i++) {
                if (ss[i].type2.equals(s.type2)) {
                    return ss[i];
                }
            }
        }
        return null;
    }
	public void update() {
		Ship sh = null;
		System.out.println("choose type");
    	System.out.println("1:submarine");
    	System.out.println("2:destroyer");
    	System.out.println("3:cruiser");
    	System.out.println("4:battleship");
    	System.out.println("5:carrier");
    	Scanner sc = new Scanner(System.in);
    	int j=sc.nextInt();
    	switch(j)
    	{
    	case 1:
    		if(numofss==0){
    			System.out.println("no invention");
    			break;
    		}
    		System.out.println("choose ship");
    		for(int i=0;i<numofss;i++){
    			System.out.println(i+" cost"+(ss[i].cost+ss[i].getweapcost())+" "+ss[i].type1+ss[i].type2+
    					" health"+ss[i].health
    					+" antiair"+ss[i].getantiair(true)+" antisub"+
    					ss[i].getantisub(true)+" search"+ss[i].getsearch(true)
    					+" attack"+ss[i].getattack(true)+" speed"+ss[i].speed);
    		}
    		System.out.println(numofss+"cancel");
    		j=sc.nextInt();
    		if(j<numofss){
    			sh=ss[j];
    		}
    		break;
    	case 2:
    		if(numofdd==0){
    			System.out.println("no invention");
    			break;
    		}
    		System.out.println("choose ship");
    		for(int i=0;i<numofdd;i++){
    			System.out.println(i+" cost"+(dd[i].cost+dd[i].getweapcost())+" "+dd[i].type1+dd[i].type2+
    					" health"+dd[i].health
    					+" antiair"+dd[i].getantiair(true)+" antisub"+
    					dd[i].getantisub(true)+" search"+dd[i].getsearch(true)
    					+" attack"+dd[i].getattack(true)+" speed"+dd[i].speed);
    		}
    		System.out.println(numofdd+"cancel");
    		j=sc.nextInt();
    		if(j<numofdd){
    			sh=dd[j];
    		}
    		break;
    	case 3:
    		if(numofc==0){
    			System.out.println("no invention");
    			break;
    		}
    		System.out.println("choose ship");
    		for(int i=0;i<numofc;i++){
    			System.out.println(i+" cost"+(c[i].cost+c[i].getweapcost())+" "+c[i].type1+c[i].type2+
    					" health"+c[i].health+" weight"+c[i].weight
    					+" antiair"+c[i].getantiair(true)+" antisub"+
    					c[i].getantisub(true)+" search"+c[i].getsearch(true)
    					+" attack"+c[i].getattack(true)+" speed"+c[i].speed);
    		}
    		System.out.println(numofc+"cancel");
    		j=sc.nextInt();
    		if(j<numofc){
    			sh=c[j];
    		}
    		break;
    	case 4:
    		if(numofbb==0){
    			System.out.println("no invention");
    			break;
    		}
    		System.out.println("choose ship");
    		for(int i=0;i<numofbb;i++){
    			System.out.println(i+" cost"+(bb[i].cost+bb[i].getweapcost())+" "+bb[i].type1+bb[i].type2+
    					" health"+bb[i].health+" weight"+bb[i].weight
    					+" antiair"+bb[i].getantiair(true)+" antisub"+
    					bb[i].getantisub(true)+" search"+bb[i].getsearch(true)
    					+" attack"+bb[i].getattack(true)+" speed"+bb[i].speed);
    		}
    		System.out.println(numofbb+"cancel");
    		j=sc.nextInt();
    		if(j<numofbb){
    			sh=bb[j];
    		}
    		break;
    	case 5:
    		if(numofcv==0){
    			System.out.println("no invention");
    			break;
    		}
    		System.out.println("choose ship");
    		for(int i=0;i<numofcv;i++){
    			System.out.println(i+" cost"+(cv[i].cost+cv[i].getweapcost())+" "+cv[i].type1+cv[i].type2+
    					" health"+cv[i].health+" weight"+cv[i].weight
    					+" antiair"+cv[i].getantiair(true)+" antisub"+
    					cv[i].getantisub(true)+" search"+cv[i].getsearch(true)
    					+" attack"+cv[i].getattack(true)+" speed"+cv[i].speed);
    		}
    		System.out.println(numofcv+"cancel");
    		j=sc.nextInt();
    		if(j<numofcv){
    			sh=cv[j];
    		}
    		break;
    		default:break;
    	}
    	if(sh!=null){
    		System.out.println("enter name");
    		sc = new Scanner(System.in); 
    		sh.type2= sc.nextLine();
    		for(int i=0;i<5;i++){
    		int t=random()%(sh.numofweap+2);
			if(t<sh.numofweap){
				System.out.print("weap "+sh.weap[t].name);
				sh.weap[t].update();		
			}
			else if(t==sh.numofweap){
				sh.cost+=sh.weight/4;
				sh.speed++;
				System.out.println("speed"+sh.speed);
			}
			else{
				sh.cost+=1;
				sh.health++;
				System.out.println("health"+sh.health);
			}
    		}
    	}
	}
    public String update(Ship sh,String st) {
        sh.type2 = st;
        String tr = "";
        for (int i = 0; i < 5; i++) {
            int t = random() % (sh.numofweap + 2);
            if (t < sh.numofweap) {
                tr += ("weap " + sh.weap[t].name+"\n");
                sh.weap[t].update();
            } else if (t == sh.numofweap) {
                sh.cost += sh.weight / 4;
                sh.speed++;
                tr += ("speed" + sh.speed+"\n");
            } else {
                sh.cost += 1;
                sh.health++;
                tr += ("health" + sh.health+"\n");
            }
        }
        return tr;
    }
	public void old() {
		// TODO Auto-generated method stub
		Ship sh;
		if(random()<20){
			sh=ss[random()%numofss];
			if(random()<50){
				sh=null;
			}
		}
		else if(random()<40){
			sh=dd[random()%numofdd];
			if(random()<40){
				sh=null;
			}
		}
		else if(random()<60){
			sh=c[random()%numofc];
			if(random()<30){
				sh=null;
			}
		}
		else if(random()<80){
			sh=bb[random()%numofbb];
			if(random()<20){
				sh=null;
			}
		}
		else{
			sh=cv[random()%numofcv];
			if(random()<10){
				sh=null;
			}
		}
		if(random()>30){
			sh=null;
		}
		if(sh!=null){
		System.out.println(sh.type2);
		int t=random()%(sh.numofweap+2);
		if(t<sh.numofweap){
			System.out.print("weap "+sh.weap[t].name);
			sh.weap[t].old();		
		}
		else if(t==sh.numofweap){
			sh.speed--;
			System.out.println("speed"+sh.speed);
		}
		else{
			sh.health--;
			System.out.println("health"+sh.health);
		}
		}
	}
	public int random(){
		Random r = new Random();
	    int rv =(int)(100 * r.nextDouble());
	    return rv;
	}
}
