package game;

import fleets.Fleet;

import java.util.ArrayList;

/**
 * Created by Win7uX32 on 2015/7/31.
 */
public class Place {
    public String name;
    public boolean pub;
    public ArrayList<Fleet> playerFleets;
    public ArrayList<Fleet> aiFleets;
    public int playerTp;
    public int aiTp;

    public Place(String name){
        playerTp=0;
        aiTp=0;
        this.name=name;
        pub=true;
        playerFleets=new ArrayList<Fleet>();
        aiFleets=new ArrayList<Fleet>();
    }
}
