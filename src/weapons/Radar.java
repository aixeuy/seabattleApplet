package weapons;

public class Radar extends Weapon {
	public Radar(){
	}
	public Radar(int n){
		switch(n)

		{

		case 1:settype("radar_early",3,1,0,0,0,7,0,0);break;
		case 2:settype("radar_basic",4,1,0,0,0,10,0,0);break;
		case 3:settype("radar_morden",5,1,0,0,0,15,0,0);break;
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
		this.type="radar";
	}
}
