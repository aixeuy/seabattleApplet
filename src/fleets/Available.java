package fleets;

import java.util.Scanner;

import ships.Ship;

public class Available {
public Ship[] ships;
public int numofship;

public Available()
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
public void delete(Ship s){
    if(find(s)==numofship){
        return;
    }
	ships[find(s)]=ships[numofship-1];
	ships[numofship-1]=null;
	numofship--;
}



//////////////////////////////////////////////////////////////
public int addweap(){
	System.out.println("choose ship");
	printlist(true);
	Scanner sc = new Scanner(System.in); 
    int i = sc.nextInt();
    if(ships[i].weight-ships[i].getweight()>0){
    	return ships[i].addweapspecial();
    }
    return 0;
}
////////////////////////////////////////////////////////////




public void unload(){
	System.out.println("choose ship");
	printlist(true);
	Scanner sc = new Scanner(System.in); 
    int i = sc.nextInt();
	System.out.println("choose weapon");
    printweap(i);
    int j=sc.nextInt();
    ships[i].unload(j);
}

public void printweap(int i){
	ships[i].printweap();
}
public void printlist(boolean b){
	sortbycat();
	for(int i=0;i<numofship;i++){
		char ch=' ';
		if(i/2==(i+1)/2){ch='-';}
		if(i<10){System.out.print(" ");}
		System.out.print(i+" "+ships[i].name);
		for(int j=0;j<=25-ships[i].name.length();j++){System.out.print(ch);}
		System.out.print(ships[i].type1+" "+ships[i].type2);
		for(int j=0;j<=25-ships[i].type1.length()-ships[i].type2.length()
				;j++){System.out.print(ch);}
		System.out.println(
				" health"+ships[i].resthealth
				+" antiair"+ships[i].getantiair(b)+" antisub"+
				ships[i].getantisub(b)+" search"+ships[i].getsearch(b)
				+" attack"+ships[i].getattack(b)+" level"+ships[i].level+"   speed"+
				ships[i].speed+" endurence"+ships[i].endurence);
		if(i+1<numofship){
		 if(!ships[i].type1.equals(ships[i+1].type1)){
			 System.out.println(""); 
		 }
		}
	}
}
public void sortbycat(){
	int n=0;
	if(numofship!=0){
		for(int i=0;i<numofship;i++){
			if(ships[i].type1.equals("carrier")){
				switchshipnum(i,ships[n],n);
				n++;
			}
		}
		for(int i=0;i<numofship;i++){
			if(ships[i].type1.equals("battleship")){
				switchshipnum(i,ships[n],n);
				n++;
			}
		}
		for(int i=0;i<numofship;i++){
			if(ships[i].type1.equals("cruiser")){
				switchshipnum(i,ships[n],n);
				n++;
			}
		}
		for(int i=0;i<numofship;i++){
			if(ships[i].type1.equals("destroyer")){
				switchshipnum(i,ships[n],n);
				n++;
			}
		}
	}
}
public void switchshipnum(int i,Ship sh,int n){
	ships[n]=ships[i];ships[i]=sh;
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
	return numofship;
}
}