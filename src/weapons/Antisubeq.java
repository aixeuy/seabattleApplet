package weapons;


public class Antisubeq extends Weapon {
	public Antisubeq(){
	}
	public Antisubeq(int n){
		switch(n)

		{

		case 1:settype("antisub_basic",4,1,0,0,0,0,4,0);break;
		case 2:settype("antisub_improved",5,1,0,0,0,0,5,0);break;
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
		this.type="antisub";
	}
}
