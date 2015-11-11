package ships;

import java.util.Scanner;

import weapons.Subtorpedo;
import weapons.Weapon;

public class Submarine extends Ship {

	public Submarine()
	{
	}
	public void setship(String name,int weight,int health,int cost,String type2,int speed){
		this.name=name;
		this.cost=cost;
		this.health=health;
		this.numofweap=0;
		this.resthealth=0;
		this.type1="submarine";
		this.type2=type2;
		this.weap=new Weapon[4];
		this.weight=weight;
		this.level=0;
		this.point=0;
		this.speed=speed;
		position=4;
	}
	public Submarine(int j,String name) {
		switch(j){
		case 1:setship(name,2,4,2,"early",9);break;
		case 2:setship(name,3,6,3,"basic",10);break;
		case 3:setship(name,4,8,4,"morden",11);break;
		default:System.out.println("unable to build");break;
		}
		
	}
	public Submarine(String type2,int j) {
		switch(j){
		case 1:setship(null,2,4,2,type2,9);break;
		case 2:setship(null,3,6,3,type2,10);break;
		case 3:setship(null,4,8,4,type2,11);break;
		default:System.out.println("unable to build");break;
		}
		
	}
	
	public int getaiattack(int distance){
		int attack=0;
		if(weight==2){
			if(distance<=1){
				attack+=12;
			}
		}
		else if(weight==3){
			if(distance<=1){
				attack+=12;
			}
		}
		else{
			if(distance<=2){
				attack+=18;
			}
		}
		return attack;
	}
	public int addweapspecial(){
		System.out.println("1:torpedo");
    	System.out.println("choose type");
    	System.out.println("1:basic 2 3"+"\n"+"2:improved 2 4");
    	Scanner sc = new Scanner(System.in);
    	int j = sc.nextInt();
    	Weapon w=new Subtorpedo(j);
    	if(findweaptype(w.type)==-1){
    	addweapon(w);
    	return w.cost;
    	}
    	else{
    		System.out.println("weapon not added");
    		return 0;
    	}
		
	}
}
