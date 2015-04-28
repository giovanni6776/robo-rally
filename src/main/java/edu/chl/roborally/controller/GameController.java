package edu.chl.roborally.controller;

import edu.chl.roborally.EventTram;
import edu.chl.roborally.model.*;
import edu.chl.roborally.model.maps.MapFactory;
import edu.chl.roborally.view.UI;

import java.util.ArrayList;

/**
 * Created by Pertta on 15-04-23.
 *
 * The GameController is the game master. The flow of the game
 * is controlled here.
 *
 */
public class GameController implements EventTram.IEventHandler{

    private UI ui;
    private RoboRally model;
    private MapFactory mapFactory;

    public GameController(UI ui) {
        this.mapFactory = new MapFactory();
        this.ui = ui;

        EventTram.getInstance().register(this);

    }

    /**
     * The initGame method setups up all the
     * dependencies for the game
     */
    private void initGame(){
        //Create players
        ArrayList<Player> tempPlayers = new ArrayList<>();
        ArrayList<String> tempNames = ui.getPlayerNames();
        for(int i = 0; i < tempNames.size(); i++){
            tempPlayers.add(new Player(i, tempNames.get(i)));
        }
        //Choose map
        int mapId = ui.chooseMap(mapFactory.getMaps());
        //Create game
        this.model = new RoboRally(tempPlayers, mapFactory.createMap(mapId), ui);
    }

    /**
     * runGame keeps track of rounds and turns
     * asks the model if the game
     * should continue
     */
    private void runGame() {
        //TODO Ask model if i should run the game
        while(model.shouldIContinue()) {

            new Round(model, ui);

            for (int i = 1; i< Constants.NUMBER_OF_TURNS; i++) {
                // TODO check end conditions befre new turn
                new Turn(model, i, ui);
            }
        }
    }


    @Override
    public void onEvent(EventTram.Event evt, Object o) {
        if(evt == )
    }
}
