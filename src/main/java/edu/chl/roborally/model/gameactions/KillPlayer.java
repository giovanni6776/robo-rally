package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;

/**
 * Created by henriknilson on 31/03/15.
 */
public class KillPlayer implements GameAction{

    @Override
    public void doAction(Player p) {
        p.kill();
    }
}
