package weapons;

public class Launcher extends Weapon {
	public Launcher(){
	}
	public Launcher(int n){
		switch(n)

		{

		case 1:settype("cruiser_spyplane",16,3,0,0,0,3,0,0);break;
		case 2:settype("spyplane",18,8,0,0,0,15,0,0);break;
		case 3:settype("bomber",24,9,16,0,0,15,0,3);break;
		case 4:settype("torpedo_bomber",32,12,20,0,0,15,0,3);break;
		case 5:settype("advanced",40,12,26,0,0,18,0,4);break;
		case 6:settype("jet",50,11,32,0,0,20,0,5);break;
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
		this.type="launcher";
	}
}
