package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.KillPlayer;
import edu.chl.roborally.model.tiles.GameTile;
import edu.chl.roborally.utilities.Constants;

import java.awt.*;

/**
 * Created by axel on 2015-03-31.
 */
public class StartAttribute implements Attribute {

    private String name = "S";

    @Override
    public void beforeAction(Player player) {

    }

    public void doAction(Player p){}

    public String toString() {
        return name;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.MAGENTA);
        g.fillRect(x,y, Constants.TILE_SIZE, Constants.TILE_SIZE);
        g.setColor(Color.BLACK);
        char[] message = "S".toCharArray();
        g.drawChars(message,0,message.length,x,y+10);
    }
}
