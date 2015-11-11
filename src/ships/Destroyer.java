package ships;

import java.util.Scanner;

import weapons.Antisubeq;
import weapons.Gun;
import weapons.Radar;
import weapons.Torpedo;
import weapons.Weapon;

public class Destroyer extends Ship {

	public Destroyer()
	{
	}
	public void setship(String name,int weight,int health,int cost,String type2,int speed){
		this.name=name;
		this.cost=cost;
		this.health=health;
		this.numofweap=0;
		this.resthealth=0;
		this.type1="destroyer";
		this.type2=type2;
		this.weap=new Weapon[4];
		this.weight=weight;
		this.level=0;
		this.point=0;
		this.speed=speed;
		position=4;
	}
	public Destroyer(int j,String name) {
		switch(j){
		case 1:setship(name,3,6,3,"early",17);break;
		case 2:setship(name,4,8,4,"basic",18);break;
		case 3:setship(name,5,10,5,"morden",20);break;
		default:System.out.println("unable to build");break;
		}
		
	}
	public Destroyer(String type2,int j) {
		switch(j){
		case 1:setship(null,3,6,3,type2,17);break;
		case 2:setship(null,4,8,4,type2,18);break;
		case 3:setship(null,5,10,5,type2,20);break;
		default:System.out.println("unable to build");break;
		}
		
	}
	public int getaiattack(int distance){
		int attack=0;
		if(weight==3){
			if(distance<=1){
				attack+=2;
			}
		}
		else if(weight==4){
			if(distance<=1){
				attack+=3;
			}
		}
		else{
			if(distance<=1){
				attack+=2;
			}
			if(distance<=3){
				attack+=2;
			}
		}
		return attack;
	}
	public int addweapspecial(){
		Scanner sc = new Scanner(System.in);
		System.out.println("1:radar");
    	System.out.println("2:gun");
    	System.out.println("3:antisub");
    	System.out.println("5:torpedo");
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
    	System.out.println("3:small 1 2");
       	System.out.println("4:medium 2 4");
       	int k2 = sc.nextInt();
       	Weapon w2=new Gun(k2);
       	addweapon(w2);
       	return w2.cost;
    	case 3:
    	System.out.println("1:basic 1 4");
        System.out.println("2:improved 1 5");
        int k3 = sc.nextInt();
        Weapon w3=new Antisubeq(k3);
        if(findweaptype(w3.type)!=-1){
        	System.out.println("unable to add");
        	break;
        	}
        addweapon(w3);
        return w3.cost;
    	case 5:
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
    	default:System.out.println("unable to add");break;
    	}
		return 0;
	}

}
