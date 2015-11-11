package ships;

import java.util.Scanner;

import weapons.Gun;
import weapons.Hull;
import weapons.Launcher;
import weapons.Radar;
import weapons.Torpedo;
import weapons.Weapon;

public class Carrier extends Ship {

	public Carrier()
	{
	}
	public void setship(String name,int weight,int health,int cost,String type2,int speed){
		this.name=name;
		this.cost=cost;
		this.health=health;
		this.numofweap=0;
		this.resthealth=0;
		this.type1="carrier";
		this.type2=type2;
		this.weap=new Weapon[4];
		this.weight=weight;
		this.level=0;
		this.point=0;
		this.speed=speed;
		position=4;
	}
	public Carrier(int j,String name) {
		switch(j){
		case 1:setship(name,14,28,14,"early",8);break;
		case 2:setship(name,16,32,16,"basic",7);break;
		case 3:setship(name,18,36,18,"morden",7);break;
		default:System.out.println("unable to build");break;
		}
		
	}
	public Carrier(String type2,int j) {
		switch(j){
		case 1:setship(null,14,28,14,type2,8);break;
		case 2:setship(null,16,32,16,type2,7);break;
		case 3:setship(null,18,36,18,type2,7);break;
		default:System.out.println("unable to build");break;
		}
		
	}
	public int getaiattack(int distance){
		int attack=0;
		if(weight==11){
			attack+=2;
		}
		else if(weight==14){
			attack+=20;
		}
		else{
			attack+=26;
		}
		return attack;
	}
	public int addweapspecial(){
		Scanner sc = new Scanner(System.in);
		System.out.println("1:radar");
    	System.out.println("2:gun");
    	System.out.println("3:hull");
    	System.out.println("4:torpedo");
    	System.out.println("5:launcher");
    	System.out.println("choose type");
    	int j = sc.nextInt();
    	switch(j)
    	{
    	case 1:
    	System.out.println("1:early 1 3");
    	System.out.println("2:basic 1 4");
    	System.out.println("3:morden 1 5");
    	int k1 = sc.nextInt();
    	Weapon w1=new Radar(k1);
    	if(findweaptype(w1.type)!=-1){
        	System.out.println("unable to add");
        	break;
        	}
    	addweapon(w1);
    	return w1.cost;
    	
    	case 2:
    	System.out.println("1:antiairbasic 2 3");
        System.out.println("2:antiairimproved 3 4");
       	System.out.println("4:medium 2 4");
    	System.out.println("5:large 3 5");
    	System.out.println("6:superlarge 4 6");
       	int k2 = sc.nextInt();
       	Weapon w2=new Gun(k2);
       	addweapon(w2);
       	return w2.cost;
    	
    	case 3:
    	System.out.println("1:normal 1 4");
        System.out.println("2:heavy 1 8");
        int k3 = sc.nextInt();
        Weapon w3=new Hull(k3);
        if(findweaptype(w3.type)!=-1){
        	System.out.println("unable to add");
        	break;
        	}
        addweapon(w3);
        return w3.cost;
    	
    	case 4:
    	System.out.println("1:basic 2 2");
        System.out.println("2:improved 2 3");
        int k5 = sc.nextInt();
        Weapon w5=new Torpedo(k5);
        if(findweaptype(w5.type)!=-1){
        	System.out.println("unable to add");
        	break;
        	}
        addweapon(w5);
        return w5.cost;
    	
    	case 5:
        System.out.println("1:helicopter 7 16");
        System.out.println("2:spyplane 8 18");
        System.out.println("3:fighter&&bomber 9 24");
        System.out.println("4:alldressed 12 32");
        System.out.println("5:advanced 12 40");
        System.out.println("6:jet 11 50");
        int k4 = sc.nextInt();
        Weapon w4=new Launcher(k4);
        if(findweaptype(w4.type)!=-1){
        	System.out.println("unable to add");
        	break;
        	}
        addweapon(w4);
        return w4.cost;
    	
    	default:System.out.println("unable to add");break;
    	}
		return 0;
	}

}
