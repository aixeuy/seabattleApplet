package weapons;

public class Weapon {
	public String type;
	public int cost;
	public int weight;
	public int attack;
	public int range;
	public int amor;
	public int search;
	public int antisub;
	public int antiair;
	public String name;
	public Weapon(){
        type=null;
	}
	public void settype(){
	}
	public void old(){
		if(attack>1){
		attack--;
		System.out.print(attack+" ");
		}
		if(search>1){
		search--;
		System.out.print(search+" ");
		}
		if(antisub>1){
		antisub--;
		System.out.print(antisub+" ");
		}
		if(antiair>1){
		antiair--;
		System.out.print(antiair+" ");
		}
		System.out.println("");
	}
	public void update(){
		if(attack!=0){
		attack++;
		System.out.print(attack+" ");
		}
		if(search!=0){
		search++;
		System.out.print(search+" ");
		}
		if(antisub!=0){
		antisub++;
		System.out.print(antisub+" ");
		}
		if(antiair!=0){
		antiair++;
		System.out.print(antiair+" ");
		}
		System.out.println("");
	}
	public void print(){
		System.out.println(name+" weight"+weight+" attack"+attack+" range"+range+
				" amor"+amor+" search"+search+" antisub"+antisub+" antiair"+antiair);
	}
    public String toString(){
        return name+" weight"+weight+" attack"+attack+" range"+range+
                " amor"+amor+" search"+search+" antisub"+antisub+" antiair"+antiair;
    }
}
