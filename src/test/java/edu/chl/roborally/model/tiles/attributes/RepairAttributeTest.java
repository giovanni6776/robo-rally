package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.gameactions.GameAction;
import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.model.maps.IslandKingMap;
import edu.chl.roborally.model.robot.Robot;
import edu.chl.roborally.utilities.Position;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Pertta on 15-05-31.
 */
public class RepairAttributeTest {

    private Player player;
    private RoboRally model;
    private GameBoard map;

    @Before
    public void setUp() throws Exception {
        player = new Player(1,new Robot("TestRobot1", Color.ORANGE));
        map = new IslandKingMap();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        player.takeDamage(2);
        model = new RoboRally(players,map);
        System.out.println(player.getName() + " starts at position " + player.getPosition() + " and has " + player.getDamageTokens() + " damageTokens");
    }

    public void executeAction(Player player) {
        for (GameAction action : map.getTile(player.getPosition()).getActions()) {
            action.doAction(player);
        }
    }

    @Test
    public void testDoAction() throws Exception {
        //Player standing on repairTile, should lose one damageToken
        player.setPosition(new Position(10, 6));
        executeAction(player);
        System.out.println(player.getName() + " has " + player.getDamageTokens() + " damageTokens");
        assertTrue(player.getDamageTokens() == 1);
        System.out.println("  ");
    }

}