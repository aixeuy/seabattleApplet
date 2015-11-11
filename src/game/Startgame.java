package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import fleets.Fleet;
import panels.BattleFrame;
import panels.MainFrame;
import ships.Ship;
import weapons.Weapon;

import fleets.Aicountry;
import fleets.Country;

public class Startgame {
	public static Ship Null=new Ship();
	public static int year=0;
	public static Country player=new Country();
	public static Country ai=new Aicountry();
	public static String[] place={"拉普拉塔河口","日德兰","中途岛","瓜达尔卡纳尔岛"
		,"圣克鲁斯","吉尔伯托"/*,"铁底湾"*/,"关岛","阿留申群岛"/*,"所罗门群岛"*/,"马绍尔群岛","马里亚纳"
		,"莱特湾","硫磺岛","冲绳"/*,"奄美"*/,"纽约港","北海","英吉利海峡","北冰洋","纳尔维克","地中海"
    ,"印度洋"};
	public static Position[] p=new Position[31];
	public static double time;
    public static boolean cmd;
    public static Boolean stop;
    public static BattleRecord br;
    public static int sight=0;
public static void main(String[] args) throws IOException{
    cmd=true;
	read();
    //write();
	start();	
}
/////////////////////////process file/////////////////////////////////////////////
    public static void read() throws IOException {
        read("player.txt",player);
        read("ai.txt",ai);
    }
    public static void write(){
        write("player.txt",player);
        write("ai.txt",ai);
    }
public static void read(String file,Country c) throws IOException{
	//try{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s;  
        s = br.readLine();
        c.num=toint(s);
        s = br.readLine();
        c.cash=Integer.parseInt(s);
        s = br.readLine();
        c.industry=toint(s);
        s = br.readLine();
        c.available.numofship=0;
        int pfs=toint(s);
        s = br.readLine();
        c.repair.numofship=0;
        int prs=toint(s);
        for(int i=0;i<pfs;i++){
            Ship sh=new Ship();
        	s = br.readLine();
        	sh.numofweap=0;
        	int nw=toint(s);
        	s = br.readLine();
        	sh.name=s;
        	s = br.readLine();
        	sh.weight=toint(s);
        	s = br.readLine();
        	sh.speed=toint(s);
        	s = br.readLine();
        	sh.endurence =toint(s);
        	s = br.readLine();
        	sh.health=toint(s);
        	s = br.readLine();
        	sh.resthealth=toint(s);
        	s = br.readLine();
        	sh.cost=toint(s);
        	s = br.readLine();
        	sh.type1=s;
        	s = br.readLine();
        	sh.type2=s;
        	s = br.readLine();
        	sh.level=toint(s);
        	s = br.readLine();
        	sh.point=toint(s);
            s = br.readLine();
            sh.experience=toint(s);
            s = br.readLine();
            sh.fleetname=s;
            s = br.readLine();
            sh.instr=toint(s);
        	c.available.add(sh);
        	//System.out.println(c.available.ships[0].numofweap);
        	 for(int j=0;j<nw;j++){
             	Weapon wp=new Weapon();
        		s = br.readLine();
        		wp.amor=toint(s);
        		s = br.readLine();
        		wp.antiair=toint(s);
        		s = br.readLine();
        		wp.antisub=toint(s);
        		s = br.readLine();
        		wp.attack=toint(s);
        		s = br.readLine();
        		wp.cost=toint(s);
        		s = br.readLine();
        		wp.name=s;
        		s = br.readLine();
        		wp.range=toint(s);
        		s = br.readLine();
        		wp.search=toint(s);
        		s = br.readLine();
        		wp.type=s;
        		s = br.readLine();
        		wp.weight=toint(s);
        		c.available.ships[i].addweapon(wp);
        	 }
        }
        
        
        
        
        for(int i=0;i<prs;i++){
            Ship sh=new Ship();
        	s = br.readLine();
        	sh.numofweap=0;
        	int nw=toint(s);
        	s = br.readLine();
        	sh.name=s;
        	s = br.readLine();
        	sh.weight=toint(s);
        	s = br.readLine();
        	sh.speed=toint(s);
        	s = br.readLine();
        	sh.endurence =toint(s);
        	s = br.readLine();
        	sh.health=toint(s);
        	s = br.readLine();
        	sh.resthealth=toint(s);
        	s = br.readLine();
        	sh.cost=toint(s);
        	s = br.readLine();
        	sh.type1=s;
        	s = br.readLine();
        	sh.type2=s;
        	s = br.readLine();
        	sh.level=toint(s);
        	s = br.readLine();
        	sh.point=toint(s);
            s = br.readLine();
            sh.experience=toint(s);
            s = br.readLine();
            sh.fleetname=s;
            s = br.readLine();
            sh.instr=toint(s);
        	c.repair.add(sh);
        	 for(int j=0;j<nw;j++){
             	Weapon wp=new Weapon();
        		s = br.readLine();
        		wp.amor=toint(s);
        		s = br.readLine();
        		wp.antiair=toint(s);
        		s = br.readLine();
        		wp.antisub=toint(s);
        		s = br.readLine();
        		wp.attack=toint(s);
        		s = br.readLine();
        		wp.cost=toint(s);
        		s = br.readLine();
        		wp.name=s;
        		s = br.readLine();
        		wp.range=toint(s);
        		s = br.readLine();
        		wp.search=toint(s);
        		s = br.readLine();
        		wp.type=s;
        		s = br.readLine();
        		wp.weight=toint(s);
        		c.repair.ships[i].addweapon(wp);
        	 }
        }///////////////////////////special
        s = br.readLine();///////#####################################
		c.special.numofss=0;
		int noss=toint(s);
		for(int i=0;i<noss;i++){
			Ship sh=new Ship();
        	s = br.readLine();
			sh.cost=toint(s);
			s = br.readLine();
			sh.health=toint(s);
			s = br.readLine();
			int now=toint(s);
			sh.numofweap=0;
			s = br.readLine();
			sh.weight=toint(s);
			s = br.readLine();
        	sh.speed=toint(s);
			s = br.readLine();
			sh.endurence =toint(s);
			s = br.readLine();
			sh.type1=s;
			s = br.readLine();
			sh.type2=s;
            s = br.readLine();
            sh.level =toint(s);
            s = br.readLine();
            sh.experience =toint(s);
            s = br.readLine();
            sh.point =toint(s);
			for(int j=0;j<now;j++){
				Weapon wp=new Weapon();
				s = br.readLine();
          	  wp.amor=toint(s);
          	s = br.readLine();
        	  wp.antiair=toint(s);
        	  s = br.readLine();
          	  wp.antisub=toint(s);
          	s = br.readLine();
        	  wp.attack=toint(s);
        	  s = br.readLine();
          	  wp.cost=toint(s);
          	s = br.readLine();
        	  wp.name=s;
        	  s = br.readLine();
          	  wp.range=toint(s);
          	s = br.readLine();
        	  wp.search=toint(s);
        	  s = br.readLine();
          	  wp.type=s;
          	s = br.readLine();
        	  wp.weight=toint(s);
        	  sh.addweapon(wp);
            }
			c.special.add(sh);
		}
		s = br.readLine();///////#####################################
		c.special.numofdd=0;
		int nodd=toint(s);
		for(int i=0;i<nodd;i++){
			Ship sh=new Ship();
        	s = br.readLine();
			sh.cost=toint(s);
			s = br.readLine();
			sh.health=toint(s);
			s = br.readLine();
			int now=toint(s);
			sh.numofweap=0;
			s = br.readLine();
			sh.weight=toint(s);
			s = br.readLine();
        	sh.speed=toint(s);
			s = br.readLine();
			sh.endurence =toint(s);
			s = br.readLine();
			sh.type1=s;
			s = br.readLine();
			sh.type2=s;
            s = br.readLine();
            sh.level =toint(s);
            s = br.readLine();
            sh.experience =toint(s);
            s = br.readLine();
            sh.point =toint(s);
			for(int j=0;j<now;j++){
				Weapon wp=new Weapon();
				s = br.readLine();
          	  wp.amor=toint(s);
          	s = br.readLine();
        	  wp.antiair=toint(s);
        	  s = br.readLine();
          	  wp.antisub=toint(s);
          	s = br.readLine();
        	  wp.attack=toint(s);
        	  s = br.readLine();
          	  wp.cost=toint(s);
          	s = br.readLine();
        	  wp.name=s;
        	  s = br.readLine();
          	  wp.range=toint(s);
          	s = br.readLine();
        	  wp.search=toint(s);
        	  s = br.readLine();
          	  wp.type=s;
          	s = br.readLine();
        	  wp.weight=toint(s);
        	  sh.addweapon(wp);
            }
			c.special.add(sh);
		}
		s = br.readLine();///////#####################################
		c.special.numofc=0;
		int noc=toint(s);
		for(int i=0;i<noc;i++){
			Ship sh=new Ship();
        	s = br.readLine();
			sh.cost=toint(s);
			s = br.readLine();
			sh.health=toint(s);
			s = br.readLine();
			int now=toint(s);
			sh.numofweap=0;
			s = br.readLine();
			sh.weight=toint(s);
			s = br.readLine();
			sh.speed=toint(s);
			s = br.readLine();
			sh.endurence =toint(s);
			s = br.readLine();
			sh.type1=s;
			s = br.readLine();
			sh.type2=s;
            s = br.readLine();
            sh.level =toint(s);
            s = br.readLine();
            sh.experience =toint(s);
            s = br.readLine();
            sh.point =toint(s);
			for(int j=0;j<now;j++){
				Weapon wp=new Weapon();
				s = br.readLine();
          	  wp.amor=toint(s);
          	s = br.readLine();
        	  wp.antiair=toint(s);
        	  s = br.readLine();
          	  wp.antisub=toint(s);
          	s = br.readLine();
        	  wp.attack=toint(s);
        	  s = br.readLine();
          	  wp.cost=toint(s);
          	s = br.readLine();
        	  wp.name=s;
        	  s = br.readLine();
          	  wp.range=toint(s);
          	s = br.readLine();
        	  wp.search=toint(s);
        	  s = br.readLine();
          	  wp.type=s;
          	s = br.readLine();
        	  wp.weight=toint(s);
        	  sh.addweapon(wp);
            }
			c.special.add(sh);
		}
		s = br.readLine();///////#####################################
		c.special.numofbb=0;
		int nobb=toint(s);
		for(int i=0;i<nobb;i++){
			Ship sh=new Ship();
        	s = br.readLine();
			sh.cost=toint(s);
			s = br.readLine();
			sh.health=toint(s);
			s = br.readLine();
			int now=toint(s);
			sh.numofweap=0;
			s = br.readLine();
			sh.weight=toint(s);
			s = br.readLine();
			sh.speed=toint(s);
			s = br.readLine();
			sh.endurence =toint(s);
			s = br.readLine();
			sh.type1=s;
			s = br.readLine();
			sh.type2=s;
            s = br.readLine();
            sh.level =toint(s);
            s = br.readLine();
            sh.experience =toint(s);
            s = br.readLine();
            sh.point =toint(s);
			for(int j=0;j<now;j++){
				Weapon wp=new Weapon();
				s = br.readLine();
          	  wp.amor=toint(s);
          	s = br.readLine();
        	  wp.antiair=toint(s);
        	  s = br.readLine();
          	  wp.antisub=toint(s);
          	s = br.readLine();
        	  wp.attack=toint(s);
        	  s = br.readLine();
          	  wp.cost=toint(s);
          	s = br.readLine();
        	  wp.name=s;
        	  s = br.readLine();
          	  wp.range=toint(s);
          	s = br.readLine();
        	  wp.search=toint(s);
        	  s = br.readLine();
          	  wp.type=s;
          	s = br.readLine();
        	  wp.weight=toint(s);
        	  sh.addweapon(wp);
            }
			c.special.add(sh);
		}
		s = br.readLine();///////#####################################
		c.special.numofcv=0;
		int nocv=toint(s);
		for(int i=0;i<nocv;i++){
			Ship sh=new Ship();
        	s = br.readLine();
			sh.cost=toint(s);
			s = br.readLine();
			sh.health=toint(s);
			s = br.readLine();
			int now=toint(s);
			sh.numofweap=0;
			s = br.readLine();
			sh.weight=toint(s);
			s = br.readLine();
			sh.speed=toint(s);
			s = br.readLine();
			sh.endurence =toint(s);
			s = br.readLine();
			sh.type1=s;
			s = br.readLine();
			sh.type2=s;
            s = br.readLine();
            sh.level =toint(s);
            s = br.readLine();
            sh.experience =toint(s);
            s = br.readLine();
            sh.point =toint(s);
			for(int j=0;j<now;j++){
				Weapon wp=new Weapon();
				s = br.readLine();
          	  wp.amor=toint(s);
          	s = br.readLine();
        	  wp.antiair=toint(s);
        	  s = br.readLine();
          	  wp.antisub=toint(s);
          	s = br.readLine();
        	  wp.attack=toint(s);
        	  s = br.readLine();
          	  wp.cost=toint(s);
          	s = br.readLine();
        	  wp.name=s;
        	  s = br.readLine();
          	  wp.range=toint(s);
          	s = br.readLine();
        	  wp.search=toint(s);
        	  s = br.readLine();
          	  wp.type=s;
          	s = br.readLine();
        	  wp.weight=toint(s);
        	  sh.addweapon(wp);
            }
			c.special.add(sh);
		}
        
        br.close(); 

    //}
    //catch(Exception e){
        //System.out.println(e);
    //}
	
	///////////////////////////////read ai/////////////

//try{
       /* BufferedReader br2 = new BufferedReader(new FileReader("ai.txt"));
        String s1;  
        s1 = br2.readLine();
        ai.num=toint(s1);
        s1 = br2.readLine();
        ai.cash=toint(s1);
        s1 = br2.readLine();
        ai.industry=toint(s1);
        s1 = br2.readLine();
        ai.available.numofship=0;
        int afn=toint(s1);
        s1 = br2.readLine();
        ai.repair.numofship=0;
        int arn=toint(s1);
        for(int i=0;i<afn;i++){
        	Ship sh=new Ship();
        	s1 = br2.readLine();
        	sh.antiair=toint(s1);
        	s1 = br2.readLine();
        	sh.antifire=toint(s1);
        	s1 = br2.readLine();
        	sh.antisub=toint(s1);
        	s1 = br2.readLine();
        	sh.attack=toint(s1);
        	s1 = br2.readLine();
        	sh.cost=toint(s1);
        	s1 = br2.readLine();
        	sh.health=toint(s1);
        	s1 = br2.readLine();
        	sh.level=toint(s1);
        	s1 = br2.readLine();
        	sh.name=s1;
        	s1 = br2.readLine();
        	sh.weight=toint(s1);
        	s1 = br2.readLine();
        	sh.speed=toint(s1);
        	s1 = br2.readLine();
        	sh.endurence=toint(s1);
        	s1 = br2.readLine();
        	sh.point=toint(s1);
        	s1 = br2.readLine();
        	sh.resthealth=toint(s1);
        	s1 = br2.readLine();
        	sh.search=toint(s1);
        	s1 = br2.readLine();
        	sh.type1=s1;
        	s1 = br2.readLine();
        	sh.type2=s1;
        	ai.available.add(sh);
        }
        for(int i=0;i<arn;i++){
        	Ship sh=new Ship();
        	s1 = br2.readLine();
        	sh.antiair=toint(s1);
        	s1 = br2.readLine();
        	sh.antifire=toint(s1);
        	s1 = br2.readLine();
        	sh.antisub=toint(s1);
        	s1 = br2.readLine();
        	sh.attack=toint(s1);
        	s1 = br2.readLine();
        	sh.cost=toint(s1);
        	s1 = br2.readLine();
        	sh.health=toint(s1);
        	s1 = br2.readLine();
        	sh.level=toint(s1);
        	s1 = br2.readLine();
        	sh.name=s1;
        	s1 = br2.readLine();
        	sh.weight=toint(s1);
        	s1 = br2.readLine();
        	sh.speed=toint(s1);
        	s1 = br2.readLine();
        	sh.endurence=toint(s1);
        	s1 = br2.readLine();
        	sh.point=toint(s1);
        	s1 = br2.readLine();
        	sh.resthealth=toint(s1);
        	s1 = br2.readLine();
        	sh.search=toint(s1);
        	s1 = br2.readLine();
        	sh.type1=s1;
        	s1 = br2.readLine();
        	sh.type2=s1;
        	ai.repair.add(sh);
        }
        
        
        br2.close(); */
    //}
    //catch(Exception e){
        //System.out.println(e);
    //}
	c.setspeed();
    c.buildfleet();
	//ai.setspeed();
}
public static void write(String file,Country c){
	     try
	        {
	          BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	          	  bw.write(tostring(c.num));
	          	  bw.newLine();    
	          	  bw.write(tostring(c.cash));
	              bw.newLine();
	              bw.write(tostring(c.industry));
	              bw.newLine();
	              bw.write(tostring(c.available.numofship));
	              bw.newLine();
	              bw.write(tostring(c.repair.numofship));
	              bw.newLine();
	              for(int i=0;i<c.available.numofship;i++){
	            	  bw.write(tostring(c.available.ships[i].numofweap));
		              bw.newLine();
	            	  bw.write(c.available.ships[i].name);
		              bw.newLine();
		              bw.write(tostring(c.available.ships[i].weight));
		              bw.newLine();
		              bw.write(tostring(c.available.ships[i].speed));
		              bw.newLine();
		              bw.write(tostring(c.available.ships[i].endurence));
		              bw.newLine();
		              bw.write(tostring(c.available.ships[i].health));
		              bw.newLine();
		              bw.write(tostring(c.available.ships[i].resthealth));
		              bw.newLine();
		              bw.write(tostring(c.available.ships[i].cost));
		              bw.newLine();
		              bw.write(c.available.ships[i].type1);
		              bw.newLine();
		              bw.write(c.available.ships[i].type2);
		              bw.newLine();
		              bw.write(tostring(c.available.ships[i].level));
		              bw.newLine();
		              bw.write(tostring(c.available.ships[i].point));
		              bw.newLine();
                      bw.write(tostring(c.available.ships[i].experience));
                      bw.newLine();
                      bw.write(c.available.ships[i].fleetname);
                      bw.newLine();
                      bw.write(tostring(c.available.ships[i].instr));
                      bw.newLine();
		              for(int j=0;j<c.available.ships[i].numofweap;j++){
		            	  bw.write(tostring(c.available.ships[i].weap[j].amor));
			              bw.newLine();
			              bw.write(tostring(c.available.ships[i].weap[j].antiair));
			              bw.newLine();
			              bw.write(tostring(c.available.ships[i].weap[j].antisub));
			              bw.newLine();
			              bw.write(tostring(c.available.ships[i].weap[j].attack));
			              bw.newLine();
			              bw.write(tostring(c.available.ships[i].weap[j].cost));
			              bw.newLine();
			              bw.write(c.available.ships[i].weap[j].name);
			              bw.newLine();
			              bw.write(tostring(c.available.ships[i].weap[j].range));
			              bw.newLine();
			              bw.write(tostring(c.available.ships[i].weap[j].search));
			              bw.newLine();
			              bw.write(c.available.ships[i].weap[j].type);
			              bw.newLine();
			              bw.write(tostring(c.available.ships[i].weap[j].weight));
			              bw.newLine();
		              }
	              }
	              
	              
	              
	              for(int i=0;i<c.repair.numofship;i++){
	            	  bw.write(tostring(c.repair.ships[i].numofweap));
		              bw.newLine();
	            	  bw.write(c.repair.ships[i].name);
		              bw.newLine();
		              bw.write(tostring(c.repair.ships[i].weight));
		              bw.newLine();
		              bw.write(tostring(c.repair.ships[i].speed));
		              bw.newLine();
		              bw.write(tostring(c.repair.ships[i].endurence));
		              bw.newLine();
		              bw.write(tostring(c.repair.ships[i].health));
		              bw.newLine();
		              bw.write(tostring(c.repair.ships[i].resthealth));
		              bw.newLine();
		              bw.write(tostring(c.repair.ships[i].cost));
		              bw.newLine();
		              bw.write(c.repair.ships[i].type1);
		              bw.newLine();
		              bw.write(c.repair.ships[i].type2);
		              bw.newLine();
		              bw.write(tostring(c.repair.ships[i].level));
		              bw.newLine();
		              bw.write(tostring(c.repair.ships[i].point));
		              bw.newLine();
                      bw.write(tostring(c.repair.ships[i].experience));
                      bw.newLine();
                      bw.write(c.repair.ships[i].fleetname);
                      bw.newLine();
                      bw.write(tostring(c.repair.ships[i].instr));
                      bw.newLine();
		              for(int j=0;j<c.repair.ships[i].numofweap;j++){
		            	  bw.write(tostring(c.repair.ships[i].weap[j].amor));
			              bw.newLine();
			              bw.write(tostring(c.repair.ships[i].weap[j].antiair));
			              bw.newLine();
			              bw.write(tostring(c.repair.ships[i].weap[j].antisub));
			              bw.newLine();
			              bw.write(tostring(c.repair.ships[i].weap[j].attack));
			              bw.newLine();
			              bw.write(tostring(c.repair.ships[i].weap[j].cost));
			              bw.newLine();
			              bw.write(c.repair.ships[i].weap[j].name);
			              bw.newLine();
			              bw.write(tostring(c.repair.ships[i].weap[j].range));
			              bw.newLine();
			              bw.write(tostring(c.repair.ships[i].weap[j].search));
			              bw.newLine();
			              bw.write(c.repair.ships[i].weap[j].type);
			              bw.newLine();
			              bw.write(tostring(c.repair.ships[i].weap[j].weight));
			              bw.newLine();
		              }
	              }
	              
	              ///////////////////special//////###################
	              bw.write(tostring(c.special.numofss));
	              bw.newLine();
	              for(int i=0;i<c.special.numofss;i++){
	            	  if(c.special.numofss==0){
	            		  break;
	            	  }
	            	  bw.write(tostring(c.special.ss[i].cost));
		              bw.newLine();
		              bw.write(tostring(c.special.ss[i].health));
		              bw.newLine();
		              bw.write(tostring(c.special.ss[i].numofweap));
		              bw.newLine();
		              bw.write(tostring(c.special.ss[i].weight));
		              bw.newLine();
		              bw.write(tostring(c.special.ss[i].speed));
		              bw.newLine();
		              bw.write(tostring(c.special.ss[i].endurence));
		              bw.newLine();
		              bw.write(c.special.ss[i].type1);
		              bw.newLine();
		              bw.write(c.special.ss[i].type2);
		              bw.newLine();
                      bw.write(tostring(c.special.ss[i].level));
                      bw.newLine();
                      bw.write(tostring(c.special.ss[i].experience));
                      bw.newLine();
                      bw.write(tostring(c.special.ss[i].point));
                      bw.newLine();
		              for(int j=0;j<c.special.ss[i].numofweap;j++){
		            	  if(c.special.ss[i].weap[j]==null){
		            		  break;
		            	  }
		            	  bw.write(tostring(c.special.ss[i].weap[j].amor));
			              bw.newLine();
			              bw.write(tostring(c.special.ss[i].weap[j].antiair));
			              bw.newLine();
			              bw.write(tostring(c.special.ss[i].weap[j].antisub));
			              bw.newLine();
			              bw.write(tostring(c.special.ss[i].weap[j].attack));
			              bw.newLine();
			              bw.write(tostring(c.special.ss[i].weap[j].cost));
			              bw.newLine();
			              bw.write(c.special.ss[i].weap[j].name);
			              bw.newLine();
			              bw.write(tostring(c.special.ss[i].weap[j].range));
			              bw.newLine();
			              bw.write(tostring(c.special.ss[i].weap[j].search));
			              bw.newLine();
			              bw.write(c.special.ss[i].weap[j].type);
			              bw.newLine();
			              bw.write(tostring(c.special.ss[i].weap[j].weight));
			              bw.newLine();
		              }
	              }/////////////////////
	              bw.write(tostring(c.special.numofdd));
	              bw.newLine();
	              for(int i=0;i<c.special.numofdd;i++){
	            	  if(c.special.numofdd==0){
	            		  break;
	            	  }
	            	  bw.write(tostring(c.special.dd[i].cost));
		              bw.newLine();
		              bw.write(tostring(c.special.dd[i].health));
		              bw.newLine();
		              bw.write(tostring(c.special.dd[i].numofweap));
		              bw.newLine();
		              bw.write(tostring(c.special.dd[i].weight));
		              bw.newLine();
		              bw.write(tostring(c.special.dd[i].speed));
		              bw.newLine();
		              bw.write(tostring(c.special.dd[i].endurence));
		              bw.newLine();
		              bw.write(c.special.dd[i].type1);
		              bw.newLine();
		              bw.write(c.special.dd[i].type2);
		              bw.newLine();
                      bw.write(tostring(c.special.dd[i].level));
                      bw.newLine();
                      bw.write(tostring(c.special.dd[i].experience));
                      bw.newLine();
                      bw.write(tostring(c.special.dd[i].point));
                      bw.newLine();
		              for(int j=0;j<c.special.dd[i].numofweap;j++){
		            	  if(c.special.dd[i].weap[j]==null){
		            		  break;
		            	  }
		            	  bw.write(tostring(c.special.dd[i].weap[j].amor));
			              bw.newLine();
			              bw.write(tostring(c.special.dd[i].weap[j].antiair));
			              bw.newLine();
			              bw.write(tostring(c.special.dd[i].weap[j].antisub));
			              bw.newLine();
			              bw.write(tostring(c.special.dd[i].weap[j].attack));
			              bw.newLine();
			              bw.write(tostring(c.special.dd[i].weap[j].cost));
			              bw.newLine();
			              bw.write(c.special.dd[i].weap[j].name);
			              bw.newLine();
			              bw.write(tostring(c.special.dd[i].weap[j].range));
			              bw.newLine();
			              bw.write(tostring(c.special.dd[i].weap[j].search));
			              bw.newLine();
			              bw.write(c.special.dd[i].weap[j].type);
			              bw.newLine();
			              bw.write(tostring(c.special.dd[i].weap[j].weight));
			              bw.newLine();
		              }
	              }
	              bw.write(tostring(c.special.numofc));
	              bw.newLine();
	              for(int i=0;i<c.special.numofc;i++){
	            	  if(c.special.numofc==0){
	            		  break;
	            	  }
	            	  bw.write(tostring(c.special.c[i].cost));
		              bw.newLine();
		              bw.write(tostring(c.special.c[i].health));
		              bw.newLine();
		              bw.write(tostring(c.special.c[i].numofweap));
		              bw.newLine();
		              bw.write(tostring(c.special.c[i].weight));
		              bw.newLine();
		              bw.write(tostring(c.special.c[i].speed));
		              bw.newLine();
		              bw.write(tostring(c.special.c[i].endurence));
		              bw.newLine();
		              bw.write(c.special.c[i].type1);
		              bw.newLine();
		              bw.write(c.special.c[i].type2);
		              bw.newLine();
                      bw.write(tostring(c.special.c[i].level));
                      bw.newLine();
                      bw.write(tostring(c.special.c[i].experience));
                      bw.newLine();
                      bw.write(tostring(c.special.c[i].point));
                      bw.newLine();
		              for(int j=0;j<c.special.c[i].numofweap;j++){
		            	  if(c.special.c[i].weap[j]==null){
		            		  break;
		            	  }
		            	  bw.write(tostring(c.special.c[i].weap[j].amor));
			              bw.newLine();
			              bw.write(tostring(c.special.c[i].weap[j].antiair));
			              bw.newLine();
			              bw.write(tostring(c.special.c[i].weap[j].antisub));
			              bw.newLine();
			              bw.write(tostring(c.special.c[i].weap[j].attack));
			              bw.newLine();
			              bw.write(tostring(c.special.c[i].weap[j].cost));
			              bw.newLine();
			              bw.write(c.special.c[i].weap[j].name);
			              bw.newLine();
			              bw.write(tostring(c.special.c[i].weap[j].range));
			              bw.newLine();
			              bw.write(tostring(c.special.c[i].weap[j].search));
			              bw.newLine();
			              bw.write(c.special.c[i].weap[j].type);
			              bw.newLine();
			              bw.write(tostring(c.special.c[i].weap[j].weight));
			              bw.newLine();
		              }
	              }
	              bw.write(tostring(c.special.numofbb));
	              bw.newLine();
	              for(int i=0;i<c.special.numofbb;i++){
	            	  if(c.special.numofbb==0){
	            		  break;
	            	  }
	            	  bw.write(tostring(c.special.bb[i].cost));
		              bw.newLine();
		              bw.write(tostring(c.special.bb[i].health));
		              bw.newLine();
		              bw.write(tostring(c.special.bb[i].numofweap));
		              bw.newLine();
		              bw.write(tostring(c.special.bb[i].weight));
		              bw.newLine();
		              bw.write(tostring(c.special.bb[i].speed));
		              bw.newLine();
		              bw.write(tostring(c.special.bb[i].endurence));
		              bw.newLine();
		              bw.write(c.special.bb[i].type1);
		              bw.newLine();
		              bw.write(c.special.bb[i].type2);
		              bw.newLine();
                      bw.write(tostring(c.special.bb[i].level));
                      bw.newLine();
                      bw.write(tostring(c.special.bb[i].experience));
                      bw.newLine();
                      bw.write(tostring(c.special.bb[i].point));
                      bw.newLine();
		              for(int j=0;j<c.special.bb[i].numofweap;j++){
		            	  if(c.special.bb[i].weap[j]==null){
		            		  break;
		            	  }
		            	  bw.write(tostring(c.special.bb[i].weap[j].amor));
			              bw.newLine();
			              bw.write(tostring(c.special.bb[i].weap[j].antiair));
			              bw.newLine();
			              bw.write(tostring(c.special.bb[i].weap[j].antisub));
			              bw.newLine();
			              bw.write(tostring(c.special.bb[i].weap[j].attack));
			              bw.newLine();
			              bw.write(tostring(c.special.bb[i].weap[j].cost));
			              bw.newLine();
			              bw.write(c.special.bb[i].weap[j].name);
			              bw.newLine();
			              bw.write(tostring(c.special.bb[i].weap[j].range));
			              bw.newLine();
			              bw.write(tostring(c.special.bb[i].weap[j].search));
			              bw.newLine();
			              bw.write(c.special.bb[i].weap[j].type);
			              bw.newLine();
			              bw.write(tostring(c.special.bb[i].weap[j].weight));
			              bw.newLine();
		              }
	              }
	              bw.write(tostring(c.special.numofcv));
	              bw.newLine();
	              for(int i=0;i<c.special.numofcv;i++){
	            	  if(c.special.numofcv==0){
	            		  break;
	            	  }
	            	  bw.write(tostring(c.special.cv[i].cost));
		              bw.newLine();
		              bw.write(tostring(c.special.cv[i].health));
		              bw.newLine();
		              bw.write(tostring(c.special.cv[i].numofweap));
		              bw.newLine();
		              bw.write(tostring(c.special.cv[i].weight));
		              bw.newLine();
		              bw.write(tostring(c.special.cv[i].speed));
		              bw.newLine();
		              bw.write(tostring(c.special.cv[i].endurence));
		              bw.newLine();
		              bw.write(c.special.cv[i].type1);
		              bw.newLine();
		              bw.write(c.special.cv[i].type2);
		              bw.newLine();
                      bw.write(tostring(c.special.cv[i].level));
                      bw.newLine();
                      bw.write(tostring(c.special.cv[i].experience));
                      bw.newLine();
                      bw.write(tostring(c.special.cv[i].point));
                      bw.newLine();
		              for(int j=0;j<c.special.cv[i].numofweap;j++){
		            	  if(c.special.cv[i].weap[j]==null){
		            		  break;
		            	  }
		            	  bw.write(tostring(c.special.cv[i].weap[j].amor));
			              bw.newLine();
			              bw.write(tostring(c.special.cv[i].weap[j].antiair));
			              bw.newLine();
			              bw.write(tostring(c.special.cv[i].weap[j].antisub));
			              bw.newLine();
			              bw.write(tostring(c.special.cv[i].weap[j].attack));
			              bw.newLine();
			              bw.write(tostring(c.special.cv[i].weap[j].cost));
			              bw.newLine();
			              bw.write(c.special.cv[i].weap[j].name);
			              bw.newLine();
			              bw.write(tostring(c.special.cv[i].weap[j].range));
			              bw.newLine();
			              bw.write(tostring(c.special.cv[i].weap[j].search));
			              bw.newLine();
			              bw.write(c.special.cv[i].weap[j].type);
			              bw.newLine();
			              bw.write(tostring(c.special.cv[i].weap[j].weight));
			              bw.newLine();
		              }
	              }
	              
	              
	          bw.close();
	        }
	        
	        catch(Exception ee){
	            System.out.println(ee);
	        }
	     
	     
	     
	     ////////////////write ai////////////
	     /*try
	        {
	          BufferedWriter bw = new BufferedWriter(new FileWriter("ai.txt"));
	          bw.write(tostring(ai.num));
              bw.newLine();
	          bw.write(tostring(ai.cash));
              bw.newLine();
              bw.write(tostring(ai.industry));
              bw.newLine();
              bw.write(tostring(ai.available.numofship));
              bw.newLine();
              bw.write(tostring(ai.repair.numofship));
              bw.newLine();
              for(int i=0;i<ai.available.numofship;i++){
            	  bw.write(tostring(ai.available.ships[i].antiair));
                  bw.newLine();
                  bw.write(tostring(ai.available.ships[i].antifire));
                  bw.newLine();
                  bw.write(tostring(ai.available.ships[i].antisub));
                  bw.newLine();
                  bw.write(tostring(ai.available.ships[i].attack));
                  bw.newLine();
                  bw.write(tostring(ai.available.ships[i].cost));
                  bw.newLine();
                  bw.write(tostring(ai.available.ships[i].health));
                  bw.newLine();
                  bw.write(tostring(ai.available.ships[i].level));
                  bw.newLine();
                  bw.write(ai.available.ships[i].name);
                  bw.newLine();
                  bw.write(tostring(ai.available.ships[i].weight));
                  bw.newLine();
                  bw.write(tostring(ai.available.ships[i].speed));
                  bw.newLine();
                  bw.write(tostring(ai.available.ships[i].endurence));
                  bw.newLine();
                  bw.write(tostring(ai.available.ships[i].point));
                  bw.newLine();
                  bw.write(tostring(ai.available.ships[i].resthealth));
                  bw.newLine();
                  bw.write(tostring(ai.available.ships[i].search));
                  bw.newLine();
                  bw.write(ai.available.ships[i].type1);
                  bw.newLine();
                  bw.write(ai.available.ships[i].type2);
                  bw.newLine();
              }
              for(int i=0;i<ai.repair.numofship;i++){
            	  bw.write(tostring(ai.repair.ships[i].antiair));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].antifire));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].antisub));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].attack));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].cost));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].health));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].level));
                  bw.newLine();
                  bw.write(ai.repair.ships[i].name);
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].weight));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].speed));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].endurence));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].point));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].resthealth));
                  bw.newLine();
                  bw.write(tostring(ai.repair.ships[i].search));
                  bw.newLine();
                  bw.write(ai.repair.ships[i].type1);
                  bw.newLine();
                  bw.write(ai.repair.ships[i].type2);
                  bw.newLine();
              }
              
              
	              bw.close();
	        }
	        
	        catch(Exception ee){
	            System.out.println(ee);
	        }*/
	
}
public static int toint(String s)
{
  if(s.length()==1)
  {
    return s.charAt(0)-48;
  }
  else
  {
    return (s.charAt(s.length()-1)-48)+10*toint(s.substring(0,s.length()-1));
  }
}
public static String tostring(int i)
{
  return ""+i;
} 
/////////////////////////////cover page////////////////////////////////////////
public static void start(){
	System.out.println("1.tutourial");
	System.out.println("2.loadgame");
	System.out.println("3.newgame");
	System.out.println("4.exit");
	Scanner sc = new Scanner(System.in); 
    int i = sc.nextInt();
	switch(i)
	{
	case 1:tutour();break;
	case 2:
        player.updateFleetStatus();
        ai.updateFleetStatus();
        play();break;
	case 3:newgame();break;
	case 4:break;
	default:break;
	}
}
////////////////////////////////core///////////////////////////////////////////
public static void play(){
	//try{
    System.out.println("play");
	prepare();
    write();
    if(cmd) {
        war();
        passyear();
        check();
    }
    else{

        //BattleFrame.start();
    }
//else{
        //System.out.println("see panel");
      //  MainFrame.newPrepare();
    //}
	//}
	//catch(Exception e){
		//System.out.println("you fool!");
	//}
}
public static void war(){
    Place[] seaarea=new Place[15];
    for(int i=0;i<15;i++){
        seaarea[i]=new Place(place[i]);
    }
    ArrayList<Fleet> pfs=player.getfleets();
    ArrayList<Fleet> afs=ai.getfleets();
    for(Fleet f:pfs){
        if(f.instr==2&&f.outport){
            int r=(int)(15*Math.random());
            seaarea[r].playerFleets.add(f);
            seaarea[r].pub=false;
        }
    }
    for(Fleet f:afs){
        if(f.instr==2&&f.outport){
            int r=(int)(15*Math.random());
            if(seaarea[r].playerFleets.size()>0){
                r=(int)(15*Math.random());
            }
            seaarea[r].aiFleets.add(f);
            seaarea[r].pub=false;
        }
    }
    for(int i=0;i<15;i++){
        if(seaarea[i].playerFleets.size()!=0&&seaarea[i].aiFleets.size()!=0) {
            //Scanner sc = new Scanner(System.in);
            //String na = sc.nextLine();
            stop=true;
            System.out.println("stop2");
            while (stop){
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("next2");
            System.out.println("place " + place[i]);
            ai.newbattle();
            player.newbattle();
    /*ai.arrangebattle();
    System.out.println("their available number"+ai.battle.numofship);
    player.arrangebattle();*/
            for (Fleet pf : seaarea[i].playerFleets) {
                player.addtobattle(pf);
                System.out.print(pf.name);
                player.battle.printlist(true);
            }
            for (Fleet af : seaarea[i].aiFleets) {
                ai.addtobattle(af);
                System.out.print(af.name);
                ai.battle.printlist(true);
            }
            boolean winner = battle(place[i]);
            if (winner) {
                seaarea[i].aiFleets = new ArrayList<Fleet>();
            } else {
                seaarea[i].playerFleets = new ArrayList<Fleet>();
            }
            //sc = new Scanner(System.in);
            //na = sc.nextLine();
            stop=true;
            System.out.println("stop3");
            while (stop){
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("next3");
        }
    }
    for(int i=0;i<20;i++){
        int r=(int)(Math.random()*15);
        if(seaarea[r].aiFleets.size()>0){
            r=(int)(Math.random()*15);
            if(seaarea[r].aiFleets.size()>0){

            }
            else{
                seaarea[r].playerTp++;
            }
        }
        else{
            seaarea[r].playerTp++;
        }
    }
    for(int i=0;i<20;i++){
        int r=(int)(Math.random()*15);
        if(seaarea[r].playerFleets.size()>0){
            r=(int)(Math.random()*15);
            if(seaarea[r].playerFleets.size()>0){

            }
            else{
                seaarea[r].aiTp++;
            }
        }
        else{
            seaarea[r].aiTp++;
        }
    }
    for(Fleet f:player.getfleets()){
        if(f.instr==3&&f.outport){
            int r=(int)(Math.random()*15);
            for(int j=0;j<5;j++) {
                if (seaarea[r].playerFleets.size() > 0) {
                    r=(int)(Math.random()*15);
                }
                else{
                    break;
                }
            }
            if(seaarea[r].aiFleets.size()>0){
                stop=true;
                System.out.println("stop2");
                while (stop){
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ai.newbattle();
                player.newbattle();
                for (Fleet af : seaarea[r].aiFleets) {
                    ai.addtobattle(af);
                    System.out.print(af.name);
                    ai.battle.printlist(true);
                }
                player.addtobattle(f);
                System.out.println(place[r]);
                //Scanner sc = new Scanner(System.in);
                //String na = sc.nextLine();
                stop=true;
                System.out.println("stop2");
                while (stop){
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                boolean winner = battle(place[r]);
                if(winner&&seaarea[r].aiTp>0){
                    System.out.println(f.name+"sinks "+seaarea[r].aiTp+" Tp");
                    seaarea[r].aiTp=0;
                }
            }
            else{
                if(seaarea[r].aiTp>0){
                    System.out.println(f.name+"sinks "+seaarea[r].aiTp+" Tp");
                    seaarea[r].aiTp=0;
                }
            }
        }
    }
    for(Fleet f:ai.getfleets()){
        if(f.instr==3&&f.outport){
            int r=(int)(Math.random()*15);
            for(int j=0;j<5;j++) {
                if (seaarea[r].aiFleets.size() > 0) {
                    r=(int)(Math.random()*15);
                }
                else{
                    break;
                }
            }
            if(seaarea[r].playerFleets.size()>0){
                stop=true;
                System.out.println("stop2");
                while (stop){
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ai.newbattle();
                player.newbattle();
                for (Fleet pf : seaarea[r].playerFleets) {
                    player.addtobattle(pf);
                    System.out.print(pf.name);
                    player.battle.printlist(true);
                }
                ai.addtobattle(f);
                System.out.println(place[r]);
                Scanner sc = new Scanner(System.in);
                String na = sc.nextLine();
                boolean winner = battle(place[r]);
                if(!winner&&seaarea[r].playerTp>0){
                    System.out.println(f.name+"sinks "+seaarea[r].playerTp+" Tp");
                    seaarea[r].playerTp=0;
                }
            }
            else{
                if(seaarea[r].playerTp>0){
                    System.out.println(f.name+"sinks "+seaarea[r].playerTp+" Tp");
                    seaarea[r].playerTp=0;
                }
            }
        }
    }
    int playerControl=0;int playerTp=0;
    int aiControl=0;int aiTp=0;
    for(Place p:seaarea){
        if(p.playerFleets.size()>0){
            playerControl++;
        }
        playerTp+=p.playerTp;
        if(p.aiFleets.size()>0){
            aiControl++;
        }
        aiTp+=p.aiTp;
    }

    for(Fleet f:player.getfleets()){
        if(f.outport==false||f.instr!=1){continue;}
        System.out.print(f.name+" ready to attack ");
        for(Fleet f2:ai.getfleets()){
            if(f2.outport==false){
                continue;
            }
            System.out.println(f2.name);
        }
            Scanner sc = new Scanner(System.in);
            String fn = sc.nextLine();
            Fleet f2 = ai.fleets.get(fn);
            if(Math.random()>0.66&&f2!=null) {
                stop=true;
                System.out.println("stop2");
                while (stop){
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            ai.newbattle();
            player.newbattle();
            player.addtobattle(f);
            System.out.print(f.name);
            player.battle.printlist(true);
            ai.addtobattle(f2);
            ai.battle.printlist(true);
            sc = new Scanner(System.in);
            String na = sc.nextLine();
            int r = (int) (Math.random() * 15);
            boolean winner = battle(place[r]);
        }
        else{
            System.out.println("miss");
        }
    }
    for(Fleet f:ai.getfleets()){
        if(f.outport==false||f.instr!=1){continue;}
        System.out.print(f.name+" ready to attack ");
        ArrayList<Fleet> ca=new ArrayList<Fleet>();
        for(Fleet f2:player.getfleets()){
            if(f2.outport){
                ca.add(f2);
            }
        }
        if(Math.random()>0.66) {
            int r = (int) (Math.random() * ca.size());
            Fleet f2 = ca.get(r);
            stop=true;
            System.out.println("stop2");
            while (stop){
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ai.newbattle();
            player.newbattle();
            player.addtobattle(f2);
            System.out.print(f2.name);
            player.battle.printlist(true);
            ai.addtobattle(f);
            ai.battle.printlist(true);
            Scanner sc = new Scanner(System.in);
            String na = sc.nextLine();
            r = (int) (Math.random() * 15);
            boolean winner = battle(place[r]);
        }
        else{
            System.out.println("miss");
        }
    }


    player.industry=80+5*playerTp;
    ai.industry=80+5*aiTp;
    System.out.println("Control:"+playerControl+":"+aiControl+";Tp"+playerTp+":"+aiTp);
    System.out.println("Cash:"+player.cash+":"+ai.cash+";Industry"+player.industry+":"+ai.industry);
}
public static void tutour(){
	System.out.println("defeat the other side by building ships and arranging" +
			" battles,losing a battle will cause the decrease of gdp,your country " +
			"will break down if your debt is larger than 100,the interest is 20%." +
			"the defence value of the available will be printed at the beginning of each" +
			" battle,a higher search value will earn you a larger chance of attacking");
	System.out.println("有关海战：背景二战时期，没有核动力和导弹");
	System.out.println("  船只：船只分为航母，战列舰（包括袖珍，超重），巡洋舰（轻巡，重巡，战巡），驱逐舰，潜艇");
	System.out.println("建造船只时要考虑吨位，吨位决定抗揍能力和武器数量");
	System.out.println("然后可以给船只装配武器，根据不同舰种可以装配舰炮，防空炮，鱼雷，装甲，雷达，声呐，舰载机");
	System.out.println("为了方便，可以发明装配好武器的舰型（xx级），也可以将其删除");
	System.out.println("  舰队：不同舰种相互配合才能提高舰队的生存率和攻击力");
	System.out.println("主力舰（航母，战列舰）是主要攻击力量，辅助舰（轻巡，驱逐）为舰队提供保护");
	System.out.println("潜艇有特殊的攻击方式，如果舰队缺乏反潜能力会遭受惨重损失，驱逐舰是潜艇的克星");
	System.out.println("  攻击：舰队的搜索能力决定能否优先攻击");
	System.out.println("距离决定攻击舰使用的武器，炮在攻击范围内才能发挥作用，不同炮的攻击范围不同，近距离的鱼雷射击" +
			"是致命的，舰载机不受距离限制");
	System.out.println("被进攻舰会拉开距离，而进攻方企图接近对方，此时较高的航速可以使船只处于有利位置");
	System.out.println("吨位低的船只（如驱逐舰）有更高的航速，遭受攻击的船的航速会降低，甚至会瘫痪");
	System.out.println("  防守：潜艇和舰载机的攻击力最强大，舰队必须有反潜和防空能力");
	System.out.println("舰队的反潜和防空能力取决于各舰的反潜防空能力和水上舰队的数量");
	System.out.println("紧凑的阵型能提高舰队的防御力，如果阵型被打乱要及时调整");
	System.out.println("打不过的话可以撤退");
	start();
}
public static void newgame(){
	if(!(player.cash<-100||ai.cash<-100)){
		System.out.println("as a country leader,you cannot surrender unless your " +
				"parliamenthas approved,this happens only when they have run out of " +
				"money.");
		start();
	}
	else{
	player=new Country();
	ai=new Aicountry();//System.out.println("start"+ai.cash);/////////////
	prepare();ai.repair.printlist(true);///////////////////////
	passyear();
	prepare();ai.repair.printlist(true);///////////////////////
	passyear();
	prepare();ai.repair.printlist(true);///////////////////////
	passyear();
	write();
	play();
	}
}
///////////////////////////////helper for play///////////////////////////////////
public static void passyear(){
	year++;
	player.passyear(true);System.out.println("before"+ai.cash);//////
	ai.passyear(false);System.out.println("after"+ai.cash);/////////
}
public static void prepare(){
	ai.buildship();
    if(cmd) {
        System.out.println("cash" + player.cash + " industry" + player.industry);
        System.out.println("0:done");
        System.out.println("1:check available");
        System.out.println("2:build ship");
        System.out.println("3:renew weapon");
        System.out.println("4:weed invention");
        System.out.println("5:update invention");
        //System.out.println("4:exit");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 0:
                break;
            case 1:
                checkfleet();
                prepare();
                break;
            case 2:
                player.buildship();
                prepare();
                break;
            case 3:
                player.addeq();
                prepare();
                break;
            case 4:
                player.special.weed();
                prepare();
                break;
            case 5:
                player.special.update();
                prepare();
                break;
            default:
                break;
        }
    }
	
}
/////////////////////////for battle/////////



public static boolean battle(String location){
	System.out.println("your available");
	player.battle.printlist(true);
	System.out.println("their available");
	ai.battle.printlist(true);
	player.battle.setvalue(true,ai.battle.position);
	ai.battle.setvalue(true,player.battle.position);
	time=ver(random(0.0)*24);
	int psupply=ver(random(0.5)*20);
	int asupply=ver(random(0.5)*20);
	p=new Position[31];
	for(int i=0;i<31;i++){
		p[i]=new Position();
	}
	System.out.println("place"+location+" condition"+" you"+psupply+"ai"+asupply);
	for(int i=0;i<player.battle.numofship;i++){
		if(player.battle.ships[i]==null){
			break;
		}
		player.battle.ships[i].tiredness=0;
		player.battle.ships[i].status=1;
		if(!player.battle.ships[i].type1.equals("submarine")){
			p[2+15].add();///////////////////////////////////////////////position
		}
		player.battle.ships[i].position=2;
		if(player.battle.ships[i].type1.equals("submarine")){
			player.battle.ships[i].instruction="forward";
		}
		else{
		player.battle.ships[i].instruction="none";
		}
		player.battle.ships[i].insspeed=player.battle.ships[i].speed;
		choosetarget(player.battle.ships[i],ai.battle.ships,ai.battle.numofship);
	}
	for(int i=0;i<ai.battle.numofship;i++){
		if(ai.battle.ships[i]==null){
			break;
		}
		ai.battle.ships[i].tiredness=0;
		ai.battle.ships[i].status=1;
		if(!ai.battle.ships[i].type1.equals("submarine")){
			p[-2+15].add();///////////////////////////////////////////////position
		}
		ai.battle.ships[i].position=-2;
		if(ai.battle.ships[i].type1.equals("submarine")){
			ai.battle.ships[i].instruction="forward";
		}
		else{
		ai.battle.ships[i].instruction="none";
		}
		ai.battle.ships[i].insspeed=ai.battle.ships[i].speed;
		choosetarget(ai.battle.ships[i],player.battle.ships,player.battle.numofship);
	}
	boolean winner=round(psupply,asupply);
	player.addtofleet();
	player.addtorepair();
	ai.addtofleet();
	ai.addtorepair();
    br.end=true;
    if(!cmd) {
        stop = true;
        System.out.println("stop");
        synchronized (stop) {
            //如果继续线程为false，则执行循环
            while (stop) {
            }
        }
    }
    return winner;
}





public static boolean round(int psupply, int asupply){
	player.battle.setposition();
	ai.battle.setposition();
	
	Ship[] retreat=new Ship[10];
	int index=0;
	for(int i=0;i<player.battle.numofship;i++){
		if(player.battle.numofship==0){
			break;
		}
	if(player.battle.ships[i].position>=10){
		System.out.println("\n"+player.battle.ships[i].name+" out of battle"+"\n");
		retreat[index]=player.battle.ships[i];
		index++;
	}
	}
	for(int i=0;i<index;i++){
		retreat[i].position=15;
		player.repair.add(retreat[i]);
		player.battle.delete(retreat[i]);
		for(int j=0;j<ai.battle.numofship;j++){
			if(ai.battle.ships[j].target.equals(retreat[i])){
				choosetarget(ai.battle.ships[j],player.battle.ships,player.battle.numofship);
			}
		}
	}
	retreat=new Ship[10];
	index=0;
	
	
	for(int i=0;i<player.battle.numofship;i++){////////////////////////instruction
		if(player.battle.numofship==0){
			break;
		}
		int speedmod=1;
		player.battle.ships[i].tiredness-=psupply;
		if(player.battle.ships[i].tiredness<0){
			player.battle.ships[i].tiredness=0;
		}
		if(player.battle.ships[i].type1.equals("submarine")){
			if(player.battle.ships[i].tiredness>=player.battle.ships[i].endurence){
				player.battle.ships[i].status=1;
			}
			else{
				if(player.battle.ships[i].tiredness<=50){
				if(player.battle.ships[i].status!=-2){
					player.battle.ships[i].status=-1;
				}
				}
			}
			if(player.battle.ships[i].status<0){
			player.battle.ships[i].tiredness+=30;
			}
		}
		else{
		player.battle.ships[i].status=1;
		}
		if(player.battle.ships[i].instruction.equals("forward")){
			if(player.battle.ships[i].position>ai.battle.position){
				move(player.battle.ships[i],speedmod*ver(random(0.5)*(player.battle.ships[i].insspeed)/10),false);////////////////move
			//player.battle.ships[i].position-=ver(random(0.5)*(player.battle.ships[i].insspeed))/10;
			}
			else if(player.battle.ships[i].position<ai.battle.position){
				move(player.battle.ships[i],speedmod*ver(random(0.5)*(player.battle.ships[i].insspeed)/10),true);////////////////move
				//player.battle.ships[i].position+=ver(random(0.5)*(player.battle.ships[i].insspeed))/10;	
			}
		}
		else if(player.battle.ships[i].instruction.equals("backward")){
			move(player.battle.ships[i],speedmod*ver(random(0.5)*(player.battle.ships[i].insspeed)/10),true);////////////////move
			//player.battle.ships[i].position+=ver(random(0.5)*(player.battle.ships[i].insspeed))/10;
		}
		else if(player.battle.ships[i].instruction.equals("retreat")){
			move(player.battle.ships[i],speedmod*ver(random(0.5)*(player.battle.ships[i].insspeed)/5),true);////////////////move
			//player.battle.ships[i].position+=ver(random(0.5)*(player.battle.ships[i].insspeed*2))/10;	
			if(player.battle.ships[i].position-1>ai.battle.lastposition(false)){
				System.out.println("\n"+player.battle.ships[i].name+" out of battle"+"\n");
				retreat[index]=player.battle.ships[i];
				index++;
			}
		}
		else if(player.battle.ships[i].instruction.equals("hunt")){
			if(player.battle.ships[i].position>player.battle.ships[i].target.position){
				move(player.battle.ships[i],speedmod*ver(random(0.5)*(player.battle.ships[i].insspeed)/10),false);////////////////move
				//player.battle.ships[i].position-=ver(random(0.5)*(player.battle.ships[i].insspeed))/10;
				}
				else if(player.battle.ships[i].position<player.battle.ships[i].target.position){
					move(player.battle.ships[i],speedmod*ver(random(0.5)*(player.battle.ships[i].insspeed)/10),true);////////////////move
					//player.battle.ships[i].position+=ver(random(0.5)*(player.battle.ships[i].insspeed))/10;	
				}
		}
		else if(player.battle.ships[i].instruction.equals("defence")){
			if(player.battle.ships[i].position>player.battle.position){
				move(player.battle.ships[i],speedmod*ver(random(0.5)*(player.battle.ships[i].insspeed)/10),false);////////////////move
				//player.battle.ships[i].position-=ver(random(0.5)*(player.battle.ships[i].insspeed))/10;
				}
				else if(player.battle.ships[i].position<player.battle.position){
					move(player.battle.ships[i],speedmod*ver(random(0.5)*(player.battle.ships[i].insspeed)/10),true);////////////////move
					//player.battle.ships[i].position+=ver(random(0.5)*(player.battle.ships[i].insspeed))/10;	
				}
		}	
	}
	for(int i=0;i<index;i++){
		retreat[i].position=15;
		player.repair.add(retreat[i]);
		player.battle.delete(retreat[i]);
		for(int j=0;j<ai.battle.numofship;j++){
			if(ai.battle.ships[j].target.equals(retreat[i])){
				choosetarget(ai.battle.ships[j],player.battle.ships,player.battle.numofship);
			}
		}
	}
	retreat=new Ship[10];
	index=0;
	
	for(int i=0;i<ai.battle.numofship;i++){
		if(ai.battle.numofship==0){
			break;
		}
	if(ai.battle.ships[i].position<=-10){
		System.out.println("\n"+ai.battle.ships[i].name+" out of battle"+"\n");
		retreat[index]=ai.battle.ships[i];
		index++;
	}
	}
	for(int i=0;i<index;i++){
		retreat[i].position=15;
		ai.repair.add(retreat[i]);
		ai.battle.delete(retreat[i]);
		for(int j=0;j<player.battle.numofship;j++){
			if(player.battle.ships[j].target.equals(retreat[i])){
				choosetarget(player.battle.ships[j],ai.battle.ships,ai.battle.numofship);
			}
		}
	}
	retreat=new Ship[10];
	index=0;
	
	for(int i=0;i<ai.battle.numofship;i++){
		if(ai.battle.numofship==0){
			break;
		}
		int speedmod=1;
		ai.battle.ships[i].tiredness-=asupply;
		if(ai.battle.ships[i].tiredness<0){
			ai.battle.ships[i].tiredness=0;
		}
		if(ai.battle.ships[i].type1.equals("submarine")){
			if(ai.battle.ships[i].tiredness>=ai.battle.ships[i].endurence){
				ai.battle.ships[i].status=1;
			}
			else{
				if(ai.battle.ships[i].tiredness<=50){
				if(ai.battle.ships[i].status!=-2){
					ai.battle.ships[i].status=-1;
				}
				}
			}
			if(ai.battle.ships[i].status<0){
			ai.battle.ships[i].tiredness+=30;
			}
		}
		else{
		ai.battle.ships[i].status=1;
		}
		if(ai.battle.ships[i].instruction.equals("forward")){
			if(ai.battle.ships[i].position>player.battle.position){
				move(ai.battle.ships[i],speedmod*ver(random(0.5)*(ai.battle.ships[i].insspeed)/10),false);////////////////move
				//ai.battle.ships[i].position-=ver(random(0.5)*(ai.battle.ships[i].insspeed))/10;
			}
			else if(ai.battle.ships[i].position<player.battle.position){
				move(ai.battle.ships[i],speedmod*ver(random(0.5)*(ai.battle.ships[i].insspeed)/10),true);////////////////move
				//ai.battle.ships[i].position+=ver(random(0.5)*(ai.battle.ships[i].insspeed))/10;	
			}
		}
		if(ai.battle.ships[i].instruction.equals("backward")){
			move(ai.battle.ships[i],speedmod*ver(random(0.5)*(ai.battle.ships[i].insspeed)/10),false);////////////////move
			//ai.battle.ships[i].position-=ver(random(0.5)*(ai.battle.ships[i].insspeed))/10;
		}
		else if(ai.battle.ships[i].instruction.equals("retreat")){
			move(ai.battle.ships[i],speedmod*ver(random(0.5)*(ai.battle.ships[i].insspeed)/5),false);////////////////move
			//ai.battle.ships[i].position-=ver(random(0.5)*(ai.battle.ships[i].insspeed*2))/10;	
			if(ai.battle.ships[i].position+1<player.battle.lastposition(true)){
				System.out.println("\n"+ai.battle.ships[i].name+" out of battle"+"\n");
				retreat[index]=ai.battle.ships[i];
				index++;
			}
		}
		else if(ai.battle.ships[i].instruction.equals("hunt")){
			if(ai.battle.ships[i].position>ai.battle.ships[i].target.position){
				move(ai.battle.ships[i],speedmod*ver(random(0.5)*(ai.battle.ships[i].insspeed)/10),false);////////////////move
				//ai.battle.ships[i].position-=ver(random(0.5)*(ai.battle.ships[i].insspeed))/10;
				}
				else if(ai.battle.ships[i].position<ai.battle.ships[i].target.position){
					move(ai.battle.ships[i],speedmod*ver(random(0.5)*(ai.battle.ships[i].insspeed)/10),true);////////////////move
					//ai.battle.ships[i].position+=ver(random(0.5)*(ai.battle.ships[i].insspeed))/10;	
				}
		}
		else if(ai.battle.ships[i].instruction.equals("defence")){
			if(ai.battle.ships[i].position>ai.battle.position){
				move(ai.battle.ships[i],speedmod*ver(random(0.5)*(ai.battle.ships[i].insspeed)/10),false);////////////////move
				//ai.battle.ships[i].position-=ver(random(0.5)*(ai.battle.ships[i].insspeed))/10;
				}
				else if(ai.battle.ships[i].position<ai.battle.position){
					move(ai.battle.ships[i],speedmod*ver(random(0.5)*(ai.battle.ships[i].insspeed)/10),true);////////////////move
					//ai.battle.ships[i].position+=ver(random(0.5)*(ai.battle.ships[i].insspeed))/10;	
				}
		}
	}
	for(int i=0;i<index;i++){
		retreat[i].position=-15;
		ai.repair.add(retreat[i]);
		ai.battle.delete(retreat[i]);
		for(int j=0;j<player.battle.numofship;j++){
			if(player.battle.ships[j].target.equals(retreat[i])){
				choosetarget(player.battle.ships[j],ai.battle.ships,ai.battle.numofship);
			}
		}
	}
	
	
	
	player.battle.setvalue(true,ai.battle.position);
	ai.battle.setvalue(true,player.battle.position);
	/*if(time-(int)time!=0){
		System.out.print("time "+(int)time+".30   ");
	}
	else{
	System.out.print("time "+(int)time+".00   ");
	}*/
    System.out.print("time "+time);
	if(time<=18&&time>=4){
	System.out.println("day");
	}
	else{
	System.out.println("night");
	if(player.battle.numofship!=0)
	{
	for(int i=0;i<player.battle.numofship;i++){
		if(player.battle.ships[i].type1.equals("carrier")){
			player.battle.ships[i].status=0;	
		}
	}
	}
	
	if(ai.battle.numofship!=0)
	{
	for(int i=0;i<ai.battle.numofship;i++){
		if(ai.battle.ships[i].type1.equals("carrier")){
			ai.battle.ships[i].status=0;	
		}
	}
	}
	
	}
	System.out.println("condition"+" you"+psupply+" ai"+asupply);
	System.out.println("antiair"+player.battle.antiair+" "+ai.battle.antiair
			+"antisub"+player.battle.antisub+" "+ai.battle.antisub
			+"antifire"+player.battle.antifire+" "+ai.battle.antifire
			+"search"+player.battle.search+" "+ai.battle.search+
			" position"+player.battle.position+" "+ai.battle.position);//////to be deleted
	
	//System.out.println("position0"+" "+p[0+15].numofshipaw);//////////////////////////////////////////
	//player.battle.printlist(true);///////////////////////////////////////////////
	/////////////////////////////////////////to delete///////////////
	
	for(int i=0;i<5;i++) {
        Attack att = new Attack();
        att.time=time;
        att.setFleet(player.battle.ships, ai.battle.ships);
        br.push(att);
        if (player.battle.numofship == 0) {
            break;
        }
        if (ai.battle.numofship == 0) {
            break;
        }

        //Attack att = new Attack();
        //att.setFleet(player.battle.ships, ai.battle.ships);
        Ship a;
        Ship b;
        a = player.battle.chooseship();
        b = ai.battle.chooseship();
        if (chooseattack()) {
            if (a.instruction.equals("retreat")) {
                System.out.println("retreating" + 0);
                System.out.println(a.name + a.position + "retreats");
                move(a, ver(random(0.5) * (a.insspeed) / 10), true);////////////////move
                att.setAttack(a, b, true, 0);
                att.type = 3;
                att.setFleet(player.battle.ships, ai.battle.ships);
            } else if (a.tiredness >= a.endurence || a.instruction.equals("rest")) {
                System.out.println("resting" + 0);
                System.out.println(a.name + a.position + "rests" + a.tiredness);
                att.setAttack(a, b, true, 0);
                att.type = 3;
            } else {
                if (a.type1.equals("cruiser")) {
                    if ((a.target.position - a.position) * (a.target.position - a.position) > (a.position
                            - b.position) * (a.position - b.position)) {
                        if (!((b.type1.equals("submarine")) && a.getantisub(true) == 0)) {
                            a.target = b;
                        }
                    }
                }
                if (!((a.target.position - a.position) * (a.target.position - a.position) > (a.position
                        - b.position) * (a.position - b.position))) {
                    b = a.target;
                }
                if (a.type1.equals("carrier")) {
                    if ((a.position - b.position) * (a.position - b.position) >= 4) {
                        b = a.target;
                    }
                }
                attack(a, b, true, ai.battle.position, att);
                if (b.resthealth <= 0) {
                    ai.removefromfleet(b);
                    System.out.println(a.name + " " + a.type1 + a.position + " sinks " + b.name + " " + b.type1 + b.position);
                    a.point = a.point + b.cost;
                    a.levelup();
                    ai.battle.delete(b);
                    ai.setInvRecord(b);
                    ai.removefromfleet(b);
                    ai.battle.setvalue(true, player.battle.position);
                    for (int j = 0; j < player.battle.numofship; j++) {
                        if (player.battle.ships[j].target.equals(b)) {
                            choosetarget(player.battle.ships[j], ai.battle.ships, ai.battle.numofship);
                        }
                    }
                    if (a.instruction.equals("hunt")) {
                        if (a.type1.equals("submarine")) {
                            a.instruction = "forward";
                        } else {
                            a.instruction = "none";
                        }
                    }
                } else {
                    System.out.println(a.name + " " + a.type1 + a.position + " demages " + b.name + " " + b.type1 + b.position);
                    if (b.resthealth*5 <= b.health ) {
                        b.instruction = "retreat";
                    }
                }
            }
        } else {
            if (b.instruction.equals("retreat")) {
                System.out.println("retreating" + 0);
                System.out.println("they are retreating" + b.name + b.position);
                move(b, ver(random(0.5) * (b.insspeed) / 10), false);////////////////move
                att.setAttack(b, a, false, 0);
                att.setFleet(player.battle.ships, ai.battle.ships);
                att.type = 3;
            } else if (b.tiredness >= b.endurence || b.instruction.equals("rest")) {
                System.out.println("resting" + 0);
                System.out.println("they are resting" + b.name + b.position);
                att.setAttack(b, a, false, 0);
                att.type = 3;
            } else {
                if (b.type1.equals("cruiser")) {
                    if ((b.target.position - b.position) * (b.target.position - b.position) > (b.position
                            - a.position) * (b.position - a.position)) {
                        if (!((a.type1.equals("submarine")) && b.getantisub(true) == 0)) {
                            b.target = a;
                        }
                    }
                }
                if (!((b.target.position - b.position) * (b.target.position - b.position) > (b.position
                        - a.position) * (b.position - a.position))) {
                    a = b.target;
                }
                attack(b, a, false, player.battle.position, att);
                if (a.resthealth <= 0) {
                    player.removefromfleet(a);
                    System.out.println(a.name + " " + a.type1 + a.position + " sunk by " + b.name + " " + b.type1 + b.position);
                    b.point += a.cost;
                    b.levelup();
                    player.battle.delete(a);
                    player.removefromfleet(a);
                    player.battle.setvalue(true, ai.battle.position);
                    player.setInvRecord(a);
                    for (int j = 0; j < ai.battle.numofship; j++) {
                        if (ai.battle.ships[j].target.equals(a)) {
                            choosetarget(ai.battle.ships[j], player.battle.ships, player.battle.numofship);
                        }
                    }
                    if (b.instruction.equals("hunt")) {
                        if (b.type1.equals("submarine")) {
                            b.instruction = "forward";
                        } else {
                            b.instruction = "none";
                        }
                    }
                } else {
                    System.out.println(a.name + " " + a.type1 + a.position + " demaged by " + b.name + " " + b.type1 + b.position);
                    if (a.resthealth*5 <= a.health ) {
                        a.instruction = "retreat";
                    }
                }
            }
        }

        if (!cmd) {
            stop = true;
            System.out.println("stop");
            synchronized (stop) {
                //如果继续线程为false，则执行循环
                while (stop) {
                }
            }
        }
        time+=0.05;
        sight=7;
        if (!(time<=18&&time>=4)){
            sight=2;
            //a=1;b=1;
        }
        time=roundTime(time);
        if(time%1>=0.59){
            time-=time%1;
            time++;
        }
        if(time>=24){
            time=0;
        }
    }
	
	boolean tr;
	if(player.battle.numofship==0){
        tr=false;
		System.out.println("you lose,your available has been destroyed");
		//ai.industry=80;//+=(int)(industry*0.8);
		//player.industry=80;//-=industry;
	}
	else if(ai.battle.numofship==0){
        tr=true;
		System.out.println("you win,you have destroyed their available");
		//player.industry=80;//+=(int)(industry*0.8);
		//ai.industry=80;//-=industry;
		if(player.battle.numofship!=0){
		for(int i=0;i<player.battle.numofship;i++){
            if(player.battle.ships[i].type1.equals("cruiser")||player.battle.ships[i].type1.equals("destroyer")){
            	player.battle.ships[i].point+=(player.battle.ships[i].getantiair(true)
            			+player.battle.ships[i].getantisub(true)+
            			player.battle.ships[i].getsearch(true))/3;
			/*if(player.battle.ships[i].getattack(true)!=0){
			player.battle.ships[i].point+=
					ver(player.battle.ships[i].cost/player.battle.ships[i].getattack(true));
			}
			else{
				player.battle.ships[i].point+=
						ver(player.battle.ships[i].cost/1);
			}*/
            }
            if(player.battle.numofship<=2){
            	player.battle.ships[i].point+=player.battle.ships[i].cost;
            }
            player.battle.ships[i].levelup();
		}
		}
	}
	/*else if(aigiveup()){
		System.out.println("you win,they have retreated");
		player.industry=80;//+=(int)(industry*0.8);
		ai.industry=80;//-=industry;
	}*/
	else{
		if(aigiveup()){
            tr=true;
			System.out.println("ai begins to retreat");
			for(int i=0;i<ai.battle.numofship;i++){
				if(ai.battle.numofship==0){
					break;
				}
				ai.battle.ships[i].instruction="retreat";
			}
		}
		System.out.println("your available");
		player.battle.printlist(true);
		System.out.println("their available");
		ai.battle.printlist(true);


		/*time+=0.5;
		if(time>=24){
			time=0;
		}*/
        if(cmd) {
            System.out.println("1:continue");
            System.out.println("2:cheat to retreat");
            System.out.println("3:retreat");
            System.out.println("4:set strategy");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    tr = round(psupply, asupply);
                    break;
                case 2:
                    tr = false;
                    //ai.industry=80;//+=(int)(industry*0.8);
                    //player.industry=80;//-=industry;
                    break;
                case 3:
                    tr = false;
                    for (int j = 0; j < player.battle.numofship; j++) {
                        if (player.battle.numofship == 0) {
                            break;
                        }
                        player.battle.ships[j].instruction = "retreat";
                    }
                    tr = round(psupply, asupply);
                    break;
                case 4:
                    arrangeposition();
                    tr = round(psupply, asupply);
                    break;
                //break;
                default:
                    tr = true;
                    break;
            }
        }
        else{
            tr=round(psupply, asupply);
        }
	}
    return tr;
}












public static boolean chooseattack(){
    double a=player.battle.search;double b=ai.battle.search;
    a+=1;b+=1;
	if((a+5)*random(0.0)>=(b+5)*random(0.0)){
		return true;
	}
	return false;
}
public static void attack(Ship a, Ship b,boolean bo,int bfposition,Attack att){
	int demage=0;
	double antiair;
	double antifire;
	double antisub;
	double positionmod;
	double aspeedmod;
	double bspeedmod;
	int distance2=bfposition-b.position;
	if(distance2<0){
		distance2=0-distance2;
	}
	positionmod=1-distance2*0.2;
	if(positionmod<0){
		positionmod=0;
	}
	int distance3=bfposition-a.position;
	if(distance3<0){
		distance3=0-distance3;
	}
	double atpositionmod=1-distance3*0.2;
	if(atpositionmod<0){
		atpositionmod=0;
	}
	if(bo){
		antiair=ai.battle.getrantiair(!bo,b.position);
		antifire=ai.battle.getAntifire(a.position);
		antisub=ai.battle.getrantisub(!bo,b.position);
	}
	else{
		antiair=player.battle.getrantiair(!bo,b.position);
		antifire=player.battle.getAntifire(a.position);
		antisub=player.battle.getrantisub(!bo,b.position);
	}
	int distance=a.position-b.position;
	aspeedmod=1-(atpositionmod)*antifire*3;
	if(distance<0){
		distance=0-distance;
	}
	bspeedmod=1.6-distance3*0.2;
	if(bspeedmod<0){
		bspeedmod=0;
	}
	if(bspeedmod>1){
		bspeedmod=1;
	}
	if(a.type1.equals("submarine")){
		if(a.status==-2){
			aspeedmod=0;
			bspeedmod=0;
		}
		else{
		aspeedmod=1;
		if(!b.type1.equals("submarine")&&b.antisub==0){
			bspeedmod=0;
		}
		}
	}
	if(b.type1.equals("submarine")){
		if(a.antisub==0){
		bspeedmod=0;
		}
		if(b.status==-2){
			bspeedmod=0;
		}
	}
	if(a.type1.equals("carrier")){
		aspeedmod=0;
		bspeedmod=0;
	}
	if(a.position>=b.position){
		move(b,ver(random(0.5)*(b.insspeed)*bspeedmod/10),false);///////////////move
	//b.position-=ver(random(0.5)*(b.insspeed)*bspeedmod/10);
	}
	else{
		move(b,ver(random(0.5)*(b.insspeed)*bspeedmod/10),true);////////////////move
		//b.position+=ver(random(0.5)*(b.insspeed)*bspeedmod/10);
	}
	if(a.position>b.position){
		move(a,ver(random(0.5)*(a.insspeed)*aspeedmod/10),false);////////////////move
		if(a.position<b.position){
			p[a.position+15].remove();
			a.position=b.position;
			p[a.position+15].add();
		}
		//a.position-=ver(random(0.5)*(a.insspeed)*aspeedmod/10);
		}
		else{
			move(a,ver(random(0.5)*(a.insspeed)*aspeedmod/10),true);////////////////move
			if(a.position>b.position){
				p[a.position+15].remove();
				a.position=b.position;
				p[a.position+15].add();
			}
			//a.position+=ver(random(0.5)*(a.insspeed)*aspeedmod/10);
		}
	
	
	if(b.type1.equals("submarine")){
		if(distance<=1) {
            if (a.type1.equals("destroyer")) {
                if (b.status == -2) {
                    demage = 0;
                } else {
                    demage = ver(10 * random(0.5));
                }
            } else if (a.type1.equals("submarine")) {
                demage = ver(3 * random(0.5));
            } else if (a.antisub > 0) {
                demage = ver(3 * random(0.5));
                if (b.status <= -1) {
                    demage = 0;
                }
            } else {
                demage = ver(1 * random(0.5));
                if (b.status <= -1) {
                    demage = 0;
                }
            }
        }
		else{
			demage=0;
		}
			if(demage==0){
				System.out.print("searching                     status"+b.status);
                att.type=0;
			}
	}
	else {
        if (a.type1.equals("carrier")) {
            boolean canattack = false;
            if (time <= 18 && time >= 4) {
                canattack = true;
            }
            if (a.getattack(bo) >= 28) {
                canattack = true;
            }
            double nightmod = 1;
            if (canattack) {
                a.status = 0;
                nightmod = 1;
                if (!(time <= 18 && time >= 4)) {
                    nightmod = 0.5;
                }
                demage = ver(a.getrealattack(bo, distance, (1.0 - antiair) * nightmod,b) * random(0.5));
                System.out.println("antiair" + antiair);//////////////////////////////////////delete
                a.tiredness += (a.attack - demage);
            } else {
                nightmod = 0;
                System.out.println("                 cannot attack at night");
                demage = ver(a.getrealattack(bo, distance, 0,b) * random(0.5));
                a.tiredness -= 30;
                b.tiredness -= 10;
            }


        } else if (a.type1.equals("battleship") || a.type1.equals("cruiser")
                || a.type1.equals("destroyer")) {
            demage = ver(a.getrealattack(bo, distance, (1.0 - antiair),b) * random(0.5));
        } else {
            double d;
            double an = (antisub);
            System.out.println("                               antisub" + antisub);/////////////////////////////////delete
            double ra = random(0.5);
            d = an * ra;
            if (d > 0.5) {
                demage = 0;
            } else {
                demage = ver(a.getrealattack(bo, distance, 0,b) * random(0.5));//*(1.0-ai.battle.antisub));
            }
            if (a.status == -2) {
                demage = 0;
                //a.tiredness-=30;b.tiredness-=10;
            }
        }
        if (a.getrealattack(bo, distance, (1.0 - antiair),b) == 0) {
            System.out.print("approching");
            if (!a.type1.equals("submarine")) {
                a.tiredness -= 30;
                b.tiredness -= 10;
                att.type = 0;
            }
        } else if (demage == 0) {
            System.out.print("fail");
            att.type = 1;
        }
    }
	
	if(!a.type1.equals("submarine")){
	a.tiredness+=30;
	}
	if(!b.type1.equals("submarine")){
	b.tiredness+=10;
	}
    if(demage!=0) {
        demage -= b.getDefence();
        if (demage < 1) {
            demage = 1;
        }
    }
	b.resthealth-=demage;
    if(bo){
        ai.battle.demage+=demage;
    }
    else{
        player.battle.demage+=demage;
    }
	b.insspeed-=(demage*b.speed/b.health);
	System.out.println(demage+"                           " +
			"                                "+aspeedmod+" "+bspeedmod);/////////////////////////
	if(b.type1.equals("battleship")){
		if(demage>5){
			if((a.position-b.position)*(a.position-b.position)<16){
			b.target=a;
			}
		}
	}
    att.setFleet(player.battle.ships,ai.battle.ships);
        att.setAttack(a, b, bo, demage);
}
public static double random(double d){
	Random r = new Random();
    double rv = d+1.0 * r.nextDouble();
    return rv;
}
public static boolean aigiveup(){
    if(ai.reserve){
        return true;
    }
    boolean allsub=true;
    for(Ship s:ai.battle.ships){
        if(s==null){break;}
        if(!s.type1.equals("submarine")){
            allsub=false;break;
        }
    }
    boolean hasdd=false;
    for(Ship s:player.battle.ships){
        if(s==null){break;}
        if(s.type1.equals("destroyer")){
            hasdd=true;break;
        }
    }
    if(allsub&&!hasdd){
        return false;
    }
	if((player.battle.demage==0)){
        if (ai.battle.getcost() * 2 < player.battle.getcost()) {
            return true;
        }
    }else {
        if (ai.battle.demage> player.battle.demage* ai.battle.numofship) {
            return true;
        }
    }
	return false;
}
public static void arrangeposition(){
	System.out.println("choose ship");
	player.battle.printinstructionlist(true);
	System.out.println(player.battle.numofship+"attack");
	System.out.println(player.battle.numofship+1+"defence");
	System.out.println(player.battle.numofship+2+"normal");
	System.out.println(player.battle.numofship+3+"set commen target");
	System.out.println(player.battle.numofship+4+"cancel");
	Scanner sc = new Scanner(System.in); 
    int i = sc.nextInt();
    if((i<player.battle.numofship)&&(i>=0)){
    	System.out.println("-1:rest");
    	System.out.println("0:hunt");
    	System.out.println("1：forward");
    	System.out.println("2：defence");
    	System.out.println("3：backward");
    	System.out.println("4：retreat");
    	System.out.println("5:none");
    	System.out.println("6:set target");
    	System.out.println("7:set status");
    	System.out.println("8:check weapons");
    	System.out.println("9:cancel");
        int j = sc.nextInt();
        if(j==-1){
        	player.battle.ships[i].instruction="rest";
        }
        if(j==0){
        	player.battle.ships[i].instruction="hunt";
        }
        if(j==1){
        	player.battle.ships[i].instruction="forward";
        }
        if(j==2){
        	player.battle.ships[i].instruction="defence";
        }
        if(j==3){
        	player.battle.ships[i].instruction="backward";
        }
        if(j==4){
        	player.battle.ships[i].instruction="retreat";
        }
        if(j==5){
        	player.battle.ships[i].instruction="none";
        }
        if(j==6){
        	System.out.println("choose target");
        	ai.battle.printlist(true);
        	int k = sc.nextInt();
        	player.battle.ships[i].target=ai.battle.ships[k];
        }
        if(j==7){
        	System.out.println("1:1"+"-1:-1"+"-2:-2");
        	int k = sc.nextInt();
        	player.battle.ships[i].status=k;
        }
        if(j==8){
        	player.battle.ships[i].printweap();
        }
        arrangeposition();
    }
    else if(i==player.battle.numofship){
    	for(int k=0;k<player.battle.numofship;k++){
    		player.battle.ships[k].instruction="forward";
    	}
    	arrangeposition();
    }
    else if(i==player.battle.numofship+1){
    	for(int k=0;k<player.battle.numofship;k++){
    		player.battle.ships[k].instruction="defence";
    	}
    	arrangeposition();
    }
    else if(i==player.battle.numofship+2){
    	for(int k=0;k<player.battle.numofship;k++){
    		player.battle.ships[k].instruction="normal";
    	}
    	arrangeposition();
    }
    else if(i==player.battle.numofship+3){
    	System.out.println("choose target");
    	ai.battle.printlist(true);
    	int k = sc.nextInt();
    	for(int w=0;w<player.battle.numofship;w++){
    		player.battle.ships[w].target=ai.battle.ships[k];
    	}
    	arrangeposition();
    }
}
public static void choosetarget(Ship s,Ship[] sh,int n){
	if(s.type1.equals("destroyer")){
		if(n<=1){
			if(n==0){
			s.target=Null;
			}
			else{
				s.target=sh[0];
			}
		}
		else{
		s.target=sh[n-1-(int)(100*random(0.0))%(n/2)];
		}
	}
	else if(s.type1.equals("cruiser")){
		if(n<=1){
			if(n==0){
				s.target=Null;
				}
				else{
					s.target=sh[0];
				};
		}
		else{
		s.target=sh[(int)(100*random(0.0))%n];
		}
	}
	else{
		if(n<=1){
			if(n==0){
				s.target=Null;
				}
				else{
					s.target=sh[0];
				}
		}
		else{
		s.target=sh[(int)(100*random(0.0))%(n/2)];
		if(s.target.type1.equals("submarine")){
			s.target=sh[(int)(100*random(0.0))%(n/2)];
		}
		if(s.target.type1.equals("submarine")){
			s.target=sh[(int)(100*random(0.0))%(n/2)];
		}
		}
	}
}
///////////////////////battle end///////////
public static void check(){
	//if(player.cash>=-100&&ai.cash>=-100){
		//play();
	//}
	if(player.cash<-100){
		System.out.println("you lose");
		start();
	}
	else if(ai.cash<-100){
		System.out.println("you win");
		start();
	}
	System.out.println("next year?");
	System.out.println("1:yes");
	System.out.println("2:no");
	Scanner sc = new Scanner(System.in); 
    int i = sc.nextInt();
	switch(i)
	{
	case 1:play();break;
	case 2:start();break;
	}
}
public static void move(Ship sh,int rspeed,boolean direction){
	try{
	p[sh.position+15].remove();
	if(!direction){
		rspeed=ver(rspeed*(1-0.2*p[sh.position+15-1].numofshipaw)/0.8);
		if(rspeed<0){
			rspeed=0;
		}
		rspeed=0-rspeed;
	}
	else{
		rspeed=ver(rspeed*(1-0.2*p[sh.position+15+1].numofshipaw)/0.8);
		if(rspeed<0){
			rspeed=0;
		}
	}
	sh.position+=rspeed;
	p[sh.position+15].add();
	}
	catch(Exception e){
		System.out.println("indexoutofbound index"+sh.position+"+15");
	}
	
}
////////////////////////////////further helper////////////////////////////////
public static void checkfleet(){
	System.out.println("1:available");
	System.out.println("2:under repair");
	Scanner sc = new Scanner(System.in); 
    int i = sc.nextInt();
    int j;
	switch(i)
	{
	case 1:
	if(player.available.numofship==0){System.out.println("no ship");
	break;}
	player.available.printlist(true);
	System.out.println("choose ship");
	j = sc.nextInt();
	player.available.printweap(j);
	break;
	case 2:
		if(player.repair.numofship==0){System.out.println("no ship");
		break;}
		player.repair.printlist(true);
		System.out.println("choose ship");
		j = sc.nextInt();
		player.repair.printweap(j);	
	break;
	default:break;
	}
}
public static int ver(double d){
	int i=(int)d;
	d=d-i;
	if(d>0.5){
		return(i+1);
	}
	return i;
}
    public static double roundTime(double t){
        return ver(t*100)/100.0;
    }
    public static double ditanza(int x1,int y1,int x2,int y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
}
