package weapons;

public class Hull extends Weapon {
	public Hull(){
	}
	public Hull(int n){
		switch(n)

		{

		case 1:settype("hull_light",4,1,0,0,4,0,0,0);break;
		case 2:settype("hull_heavy",8,1,0,0,8,0,0,0);break;
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
		this.type="hull";
	}
}
