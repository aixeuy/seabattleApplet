package weapons;

public class Gun extends Weapon {
	public Gun(){
	}
	public Gun(int n){
		switch(n)

		{

		case 1:settype("antiair_basic",3,2,0,0,0,0,0,3);break;
		case 2:settype("antiair_improved",4,3,0,0,0,0,0,5);break;
		case 3:settype("gun_small",2,1,1,2,0,0,0,0);break;
		case 4:settype("gun_medium",4,2,2,3,0,0,0,1);break;
		case 5:settype("gun_large",5,3,3,4,0,0,0,0);break;
		case 6:settype("gun_superlarge",6,4,4,5,0,0,0,0);break;
		default:System.out.println("unable to add");break;	
		}
	}
	public void settype(String type,int cost,int weight,int attack,int range,int add,int search,
			int antisub,int antiair){
		this.amor=add;
		this.antiair=antiair;
		this.antisub=antisub;
		this.attack=attack;
		this.cost=cost;
		this.range=range;
		this.search=search;
		this.name=type;
		this.weight=weight;
		this.type="gun";
	}
}
