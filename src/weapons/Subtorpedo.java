package weapons;

public class Subtorpedo extends Weapon {
	public Subtorpedo(){
	}
	public Subtorpedo(int n){
		switch(n)

		{

		case 1:settype("torpedo_basic",3,2,12,1,0,1,0,0);break;
		case 2:settype("torpedo_improved",4,2,18,2,0,1,0,0);break;
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
		this.type="subtorpedo";
	}

}
