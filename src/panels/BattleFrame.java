package panels;

import fleets.Fleet;
import game.BattleRecord;
import game.Place;
import game.Startgame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Win7uX32 on 2015/8/3.
 */
public class BattleFrame implements Runnable {
    public static ArrayList<Fleet> PFS;
    public static ArrayList<Fleet> AFS;
    public static String placeName;
    //public static Boolean stop=false;
    public BattleFrame(){

    }
    public void start() {

        Startgame.play();
        Place[] seaarea=new Place[15];
        for(int i=0;i<15;i++){
            seaarea[i]=new Place(Startgame.place[i]);
        }
        ArrayList<Fleet> pfs=Startgame.player.getfleets();
        ArrayList<Fleet> afs=Startgame.ai.getfleets();
        for(Fleet f:pfs){
            if(f.instr==2&&f.outport){
                int r=(int)(15*Math.random());
                if(seaarea[r].playerFleets.size()>0){
                    r=(int)(15*Math.random());
                }
                seaarea[r].playerFleets.add(f);
                seaarea[r].pub=false;
            }
        }
        for(Fleet f:afs){
            if(f.instr==2&&f.outport){
                int r=(int)(15*Math.random());
                if(seaarea[r].playerFleets.size()>0||seaarea[r].aiFleets.size()>0){
                    r=(int)(15*Math.random());
                }
                seaarea[r].aiFleets.add(f);
                seaarea[r].pub=false;
            }
        }
        for(int i=0;i<15;i++){
            if(seaarea[i].playerFleets.size()!=0&&seaarea[i].aiFleets.size()!=0) {

                placeName=Startgame.place[i];
                PFS=seaarea[i].playerFleets;
                AFS=seaarea[i].aiFleets;
                System.out.println("place " + Startgame.place[i]);
                Startgame.ai.newbattle();
                Startgame.player.newbattle();
                for (Fleet pf : seaarea[i].playerFleets) {
                    Startgame.player.addtobattle(pf);
                    System.out.print(pf.name);
                    Startgame.player.battle.printlist(true);
                }
                for (Fleet af : seaarea[i].aiFleets) {
                    Startgame.ai.addtobattle(af);
                    System.out.print(af.name);
                    Startgame.ai.battle.printlist(true);
                }
                Startgame.br=new BattleRecord();

                Preparep.battlePane.refresh();
                Startgame.stop=true;
                System.out.println("stop");
                synchronized (Startgame.stop) {
                    //如果继续线程为false，则执行循环
                    while (Startgame.stop) {
                    }
                }
                System.out.println("run");
                boolean winner = Startgame.battle(Startgame.place[i]);
                if (winner) {
                    seaarea[i].aiFleets = new ArrayList<Fleet>();
                } else {
                    seaarea[i].playerFleets = new ArrayList<Fleet>();
                }
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
        for(Fleet f:Startgame.player.getfleets()){
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


                    PFS=new ArrayList<Fleet>();
                    PFS.add(f);
                    AFS=seaarea[r].aiFleets;

                    Startgame.ai.newbattle();
                    Startgame.player.newbattle();
                    for (Fleet af : seaarea[r].aiFleets) {
                        Startgame.ai.addtobattle(af);
                        System.out.print(af.name);
                        Startgame.ai.battle.printlist(true);
                    }
                    Startgame.player.addtobattle(f);
                    System.out.println(Startgame.place[r]);

                    placeName=Startgame.place[r];

                    Startgame.br=new BattleRecord();
                    Preparep.battlePane.refresh();
                    Startgame.stop=true;
                    System.out.println("stop");
                    synchronized (Startgame.stop) {
                        //如果继续线程为false，则执行循环
                        while (Startgame.stop) {
                        }
                    }
                    System.out.println("run");
                    boolean winner = Startgame.battle(Startgame.place[r]);
                    if(winner&&seaarea[r].aiTp>0){
                        System.out.println(f.name+"sinks "+seaarea[r].aiTp+" Tp");
                        JOptionPane.showMessageDialog(MainFrame.f,f.name+" sinks "+seaarea[r].aiTp+" Tp");
                        seaarea[r].aiTp=0;
                    }
                }
                else{
                    if(seaarea[r].aiTp>0){
                        System.out.println(f.name+"sinks "+seaarea[r].aiTp+" Tp");
                        JOptionPane.showMessageDialog(MainFrame.f,f.name+" sinks "+seaarea[r].aiTp+" Tp");
                        seaarea[r].aiTp=0;
                    }
                }
            }
        }
        for(Fleet f:Startgame.ai.getfleets()){
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

                    PFS=seaarea[r].playerFleets;
                    AFS=new ArrayList<Fleet>();
                    AFS.add(f);


                    Startgame.ai.newbattle();
                    Startgame.player.newbattle();
                    for (Fleet pf : seaarea[r].playerFleets) {
                        Startgame.player.addtobattle(pf);
                        System.out.print(pf.name);
                        Startgame.player.battle.printlist(true);
                    }
                    Startgame.ai.addtobattle(f);
                    System.out.println(Startgame.place[r]);


                    Startgame.br=new BattleRecord();
                    Startgame.stop=true;
                    System.out.println("stop");
                    placeName=Startgame.place[r];
                    Preparep.battlePane.refresh();
                    synchronized (Startgame.stop) {
                        //如果继续线程为false，则执行循环
                        while (Startgame.stop) {
                        }
                    }
                    System.out.println("run");
                    boolean winner = Startgame.battle(Startgame.place[r]);
                    if(!winner&&seaarea[r].playerTp>0){
                        System.out.println(f.name+" sinks "+seaarea[r].playerTp+" Tp");
                        JOptionPane.showMessageDialog(MainFrame.f,f.name+"sinks "+seaarea[r].playerTp+" Tp");
                        seaarea[r].playerTp=0;
                    }
                }
                else{
                    if(seaarea[r].playerTp>0){
                        System.out.println(f.name+" sinks "+seaarea[r].playerTp+" Tp");
                        JOptionPane.showMessageDialog(MainFrame.f,f.name+"sinks "+seaarea[r].playerTp+" Tp");
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
        for(Fleet f:Startgame.player.getfleets()){
            if(f.outport==false||f.instr!=1){continue;}
            System.out.print(f.name+" ready to attack ");

            AFS=new ArrayList<Fleet>();
            PFS=new ArrayList<Fleet>();
            PFS.add(f);

            Preparep.battlePane.select();
            Startgame.stop=true;
            System.out.println("stop");
            synchronized (Startgame.stop) {
                //如果继续线程为false，则执行循环
                while (Startgame.stop) {
                }
            }

            for(Fleet f2:Startgame.ai.getfleets()){
                if(f2.outport==false){
                    continue;
                }
                System.out.println(f2.name);
            }
            /*Scanner sc = new Scanner(System.in);
            String fn = sc.nextLine();*/
            Fleet f2;
            if(AFS.size()==0){
                f2=null;
            }
            else {
                f2 = AFS.get(0);//Startgame.ai.fleets.get("");
            }
            if(Math.random()>0.6&&f2!=null) {

                //PFS=new ArrayList<Fleet>();
                //PFS.add(f);
                //AFS=new ArrayList<Fleet>();
                //AFS.add(f2);
                int r = (int) (Math.random() * 15);
                placeName=Startgame.place[r];

                Startgame.ai.newbattle();
                Startgame.player.newbattle();
                Startgame.player.addtobattle(f);
                System.out.print(f.name);
                Startgame.player.battle.printlist(true);
                Startgame.ai.addtobattle(f2);
                Startgame.ai.battle.printlist(true);

                Startgame.br=new BattleRecord();
                Preparep.battlePane.refresh();
                Startgame.stop=true;
                System.out.println("stop");
                synchronized (Startgame.stop) {
                    //如果继续线程为false，则执行循环
                    while (Startgame.stop) {
                    }
                }
                System.out.println("run");
                boolean winner = Startgame.battle(Startgame.place[r]);
            }
            else{
                JOptionPane.showMessageDialog(MainFrame.f,"miss");
            }
        }
        for(Fleet f:Startgame.ai.getfleets()){
            if(f.outport==false||f.instr!=1){continue;}
            System.out.print(f.name+" ready to attack ");
            ArrayList<Fleet> ca=new ArrayList<Fleet>();
            for(Fleet f2:Startgame.player.getfleets()){
                if(f2.outport){
                    ca.add(f2);
                }
            }
            if(Math.random()>0.6) {
                JOptionPane.showMessageDialog(MainFrame.f,"your fleet caught by enemy");
                int r = (int) (Math.random() * ca.size());
                Fleet f2 = ca.get(r);
                Startgame.ai.newbattle();
                Startgame.player.newbattle();
                Startgame.player.addtobattle(f2);
                System.out.print(f2.name);
                Startgame.player.battle.printlist(true);
                Startgame.ai.addtobattle(f);
                Startgame.ai.battle.printlist(true);
                r = (int) (Math.random() * 15);

                PFS=new ArrayList<Fleet>();
                PFS.add(f2);
                AFS=new ArrayList<Fleet>();
                AFS.add(f);
                placeName=Startgame.place[r];

                Startgame.br=new BattleRecord();
                Preparep.battlePane.refresh();
                Startgame.stop=true;
                System.out.println("stop");
                synchronized (Startgame.stop) {
                    //如果继续线程为false，则执行循环
                    while (Startgame.stop) {
                    }
                }
                System.out.println("run");
                boolean winner = Startgame.battle(Startgame.place[r]);
            }
            else{
                System.out.println("miss");
            }
        }

        Startgame.player.industry=65+5*playerTp;
        Startgame.ai.industry=60+5*aiTp;
        System.out.println("Control:"+playerControl+":"+aiControl+";Tp"+playerTp+":"+aiTp);
        System.out.println("Cash:"+Startgame.player.cash+":"+Startgame.ai.cash+";Industry"+
                Startgame.player.industry+":"+Startgame.ai.industry);

        Startgame.passyear();
        MainFrame.set(new Preparep());
        JOptionPane.showMessageDialog(MainFrame.f,"Control:"+playerControl+":"+aiControl+";Tp"+playerTp+":"+aiTp+"\n"
                +"Industry:"+Startgame.player.industry+":"+Startgame.ai.industry);
        Startgame.write();
    }

    @Override
    public void run() {
        start();
    }
}
