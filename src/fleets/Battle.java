package fleets;

import java.util.Random;

import ships.Ship;

public class Battle {
	public Ship[] ships;
	public int numofship;
	public double antiair;
	public double antifire;
	public double antisub;
	public int search;
	public int position;
	public int numofshipaw;
    public int demage;
	
	public Battle()
	{
    demage=0;
	ships=new Ship[10];
	numofship=0;
	antiair=0;
	antisub=0;
	antifire=0;
	position=0;
	}
	
	//set defence value
	public void setvalue(boolean b,int pos){
		Ship[] s=new Ship[numofship];
		for(int i=0;i<numofship;i++){
			if(i==numofship){
				break;
			}
			s[i]=ships[i];
		}
		ships=sortbycost(s);
		numofshipaw=(int)setposition();
		antiair=getantiair(b);
		antifire=getantifire(b);
		antisub=getantisub(b);
		search=getsearch(b,pos);
	}
	public double setposition(){
		position=0;
		double n=0.0;
		for(int i=0;i<numofship;i++){
			if(numofship==0){
				break;
			}
			if(ships[i].type1.equals("submarine")){
				continue;
			}
			position+=ships[i].position;
			n++;
		}
		if(n!=0.0)
		{
		position=ver(position/n);
		}
		else if(numofship!=0){
			for(int i=0;i<numofship;i++){
				if(numofship==0){
					break;
				}
				position+=ships[i].position;
				position=position/numofship;
			}
			return 0;
		}
		return n;
	}
    public double getSearch(int pos){
        double i=0;
        for(Ship s:ships){
            if(s==null){break;}
            if(s.getSight()>=Math.abs(pos-s.position)){
               i++;
            }
        }
        return i;
    }
    public double getAntifire(int pos){
        double i=0;
        for(Ship s:ships){
            if(s==null){break;}
            i+=s.getAntifire(pos);
        }
        return i;
    }
	public double getantiair(boolean b){
	double value=0.0;
	for (int i=0;i<numofship;i++){
		if(ships[i]==null)
		{
			break;
		}
	value+=ships[i].getantiair(b)*positionmod(ships[i].position,position);	
	}
	if(numofshipaw==0){
		return 0;
	}
	value=(value/numofshipaw/36)*2.526/0.9;
	
	if (value>0.9){
		return 0.9;
	}
	return value;
	}
	public double getantisub(boolean b){
		double value=0.0;
		for (int i=0;i<numofship;i++){
			if(ships[i]==null)
			{
				break;
			}
		value+=ships[i].getantisub(b)*positionmod(ships[i].position,position);	
		}
		if(numofshipaw==0){
			return 0;
		}
		value= value/numofshipaw/4/0.9;
		if (value>0.9){
			return 0.9;
		}
		return value;
		}
	public double getrantiair(boolean b,int pos){
		double value=0;
		for (int i=0;i<numofship;i++){
			if(ships[i]==null)
			{
				break;
			}
		value+=ships[i].getantiair(b)*positionmod(ships[i].position,pos);	
		}
		value= value/48;
		if (value>0.9){
			return 0.9;
		}
		return value;
	}
	public double getrantisub(boolean b,int pos){
		double value=0;
		for (int i=0;i<numofship;i++){
			if(ships[i]==null)
			{
				break;
			}
		value+=ships[i].getantisub(b)*positionmod(ships[i].position,pos);	
		}
		value= value/16;
		if (value>0.9){
			return 0.9;
		}
		return value;
	}
	public double getantifire(boolean b){
		double value=0.0;
		for (int i=0;i<numofship;i++){
			if(ships[i]==null)
			{
				break;
			}
		value+=ships[i].getanifire(b)*positionmod(ships[i].position,position);	
		}
		if(numofshipaw==0){
			return 0;
		}
		value= value/numofshipaw/29/0.9;//44;
		if (value>0.9){
			return 0.9;
		}
		return value;
		}
	public int getsearch(boolean b,int pos){
		int value=0;
		for (int i=0;i<numofship;i++){
			if(ships[i]==null)
			{
				break;
			}
			int distance=ships[i].position-pos;
			if(distance<=4&&distance>=-4){
		value+=ships[i].getsearch(b)+1;	
			}
		}
		return value;
		}
	
	//basic
	public void add(Ship s){
        s.experience++;
		if(numofship==ships.length)
		{
		doublesize();
		}
		ships[numofship]=s;
		numofship++;
	}
	public void delete(Ship s){
		ships[find(s)]=ships[numofship-1];
		ships[numofship-1]=null;
		numofship--;
	}
	public void printlist(boolean b){
		if(b){
		for(int i=0;i<numofship;i++){
			char ch=' ';
			if(i/2==(i+1)/2){ch='-';}
			if(i<10){System.out.print(" ");}
			System.out.print(i+" "+ships[i].name);
			for(int j=0;j<=25-ships[i].name.length();j++){
				System.out.print(ch);
				}
			System.out.print(ships[i].type1+" "+ships[i].type2);
			for(int j=0;j<=25-ships[i].type1.length()-ships[i].type2.length()
					;j++){
				System.out.print(ch);
				}
			System.out.println(
					" health"+ships[i].resthealth+" weight"+ships[i].weight
					+" antiair"+ships[i].getantiair(b)+" antisub"+
					ships[i].getantisub(b)+" search"+ships[i].getsearch(b)
					+" attack"+ships[i].getattack(b)+" level"+ships[i].level+"   speed"+
					ships[i].insspeed+" position"+
					ships[i].position+" status"+ships[i].status+" tiredness"+ships[i].tiredness
					+"/"+ships[i].endurence);
		}
		}
		else{
			for(int i=0;i<numofship;i++){
				System.out.println(i+" "+ships[i].name+" "+ships[i].type1+ships[i].type2+
						" health"+ships[i].resthealth
						+" antiair"+ships[i].getantiair(b)+" antisub"+
						ships[i].getantisub(b)+" search"+ships[i].getsearch(b)
						+" attack"+ships[i].getattack(b)+" level"+ships[i].level+"   speed"+
						ships[i].insspeed+" position"+
						ships[i].position+" status"+ships[i].status+" tiredness"+ships[i].tiredness
						+"/"+ships[i].endurence);
			}
		}
	}
	public void printinstructionlist(boolean b){
		for(int i=0;i<numofship;i++){
			System.out.println(i+" "+ships[i].name+" "+ships[i].type1+ships[i].type2+
					" health"+ships[i].resthealth
					+" antiair"+ships[i].getantiair(b)+" antisub"+
					ships[i].getantisub(b)+" search"+ships[i].getsearch(b)
					+" attack"+ships[i].getattack(b)+" level"+ships[i].level+"   speed"+
					ships[i].insspeed+" position"+
					ships[i].position+" status"+ships[i].status+" instruction"+ships[i].instruction+" target"
					+ships[i].target.name+" tiredness"+ships[i].tiredness+"/"+ships[i].endurence);
		}
	}
	public Ship chooseship(){
		return ships[random()];
	}
	public int random(){
		Random r = new Random();
	    int rv = (int)(100 * r.nextDouble());
	    int n=numofship;
	    return rv%n;
	}
	public double positionmod(int p,int targetp){
		int distance=p-targetp;
		if(distance<0){
			distance=0-distance;
		}
		double mod=1-distance*0.2;
		if(mod>0){
		return mod;
		}
		return 0;
	}
	public int getcost(){
		int c=0;
		for(int i=0;i<numofship;i++){
			c+=ships[i].cost;
		}
		return c;
	}
	
	//helper
	public void doublesize(){
		Ship[] ships2=new Ship[ships.length*2];
		for(int i=0;i<ships.length;i++){
			ships2[i]=ships[i];
		}
		ships=ships2;
	}
	
	public int find(Ship s){
		for(int i=0;i<numofship;i++){
			if(s.name.equals(ships[i].name)){
				return i;
			}
		}
		System.out.println("cannotfind numofship"+numofship);
		return numofship;
	}
    public Ship find(String s){
        for(Ship sh:ships){
            if(sh==null){
                break;
            }
            if(s.equals(sh.name)){
                return sh;
            }
        }
        System.out.println("cannotfind numofship"+numofship);
        return null;
    }
	public static int ver(double d){
		int i=(int)d;
		d=d-i;
		if(d>0.5){
			return(i+1);
		}
		return i;
	}
	public Ship[] sortbycost(Ship[] c){
		if(c.length<=1){
			return c;
		}
		Ship[] a=new Ship[c.length/2];Ship[] b=new Ship[c.length-c.length/2];
		for(int i=0;i<a.length;i++){
			a[i]=c[i];
		}
		for(int i=0;i<b.length;i++){
			b[i]=c[a.length+i];
		}
		return mergebycost(sortbycost(a),sortbycost(b));
	}
	public Ship[] mergebycost(Ship[] a,Ship[] b){
		Ship[] c=new Ship[a.length+b.length];
		int i=0;int j=0;
		while(i<a.length&&j<b.length){
				if(a[i].cost>b[j].cost){
					c[i+j]=a[i];i++;
				}
				else{
					c[i+j]=b[j];j++;
				}
		}
		if(i==a.length){
			for(int k=j;k<b.length;k++){
				c[i+k]=b[k];
			}
		}
		else{
			for(int k=i;k<a.length;k++){
				c[k+j]=a[k];
			}
		}
		return c;
	}
	public int lastposition(boolean b){
		int n=position;
		if(b){
		for(int i=0;i<numofship;i++){
			if(ships[i]==null){
				break;
			}
			if(ships[i].position<n){
				n=ships[i].position;
			}
		}
		}
		else{
			for(int i=0;i<numofship;i++){
				if(ships[i]==null){
					break;
				}
				if(ships[i].position>n){
					n=ships[i].position;
				}
		}
		}
		return n;
	}
}
