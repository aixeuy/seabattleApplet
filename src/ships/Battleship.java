package ships;

import java.util.Scanner;

import weapons.Gun;
import weapons.Hull;
import weapons.Radar;
import weapons.Torpedo;
import weapons.Weapon;

public class Battleship extends Ship {
	public Battleship()
	{
	}
	public void setship(String name,int weight,int health,int cost,String type2,int speed){
		this.name=name;
		this.cost=cost;
		this.health=health;
		this.numofweap=0;
		this.resthealth=0;
		this.type1="battleship";
		this.type2=type2;
		this.weap=new Weapon[4];
		this.weight=weight;
		this.level=0;
		this.point=0;
		this.speed=speed;
		position=4;
	}
	public Battleship(int j,String name) {
		switch(j){
		case 1:setship(name,15,30,15,"early",9);break;
		case 2:setship(name,18,36,18,"basic",7);break;
		case 3:setship(name,22,44,22,"morden",6);break;
		default:System.out.println("unable to build");break;
		}
		
	}
	public Battleship(String type2,int j) {
		switch(j){
		case 1:setship(null,15,30,15,type2,9);break;
		case 2:setship(null,18,36,18,type2,8);break;
		case 3:setship(null,22,44,22,type2,7);break;
		default:System.out.println("unable to build");break;
		}
		
	}
	public int getaiattack(int distance){
		int attack=0;
		if(weight==15){
			if(distance<=3){
				attack+=6;
			}
			if(distance<=5){
				attack+=3;
			}
		}
		else if(weight==18){
			if(distance<=1){
				attack+=12;
			}
			if(distance<=3){
				attack+=4;
			}
			if(distance<=5){
				attack+=6;
			}
		}
		else{
			if(distance<=2){
				attack+=18;
			}
			if(distance<=3){
				attack+=2;
			}
			if(distance<=5){
				attack+=3;
			}
			if(distance<=8){
				attack+=4;
			}
		}
		return attack;
	}
	public int addweapspecial(){
		Scanner sc = new Scanner(System.in);
		System.out.println("1:radar");
    	System.out.println("2:gun");
    	System.out.println("3:hull");
    	System.out.println("4:torpedo");
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
    	if(findweap(w1.name)!=-1){
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
        if(findweap(w3.name)!=-1){
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
        if(findweap(w5.name)!=-1){
        	System.out.println("unable to add");
        	break;
        	}
        addweapon(w5);
        return w5.cost;
    	default:System.out.println("unable to add");break;
    	}
		return 0;
	}

}
