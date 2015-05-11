package edu.chl.roborally.model.maps;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.tiles.*;

/**
 * Created by axel on 2015-03-30.
 */
public class IslandKingMap extends GameBoard {

    private int[][] map;
    public IslandKingMap() {
        super("Island King");

        /**
         * Blank = 0
         * ConVey N,W,S,E : NW,NE,SW,SE = 11,12,13,14 : 15,16,17,18
         * RotTile W,E = 21,22
         * WallTile N,W,S,E = 31,32,33,34
         * PitTile = 4
         * StarTile = 5
         */              //1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16
        map = new int[][]{{0, 5, 0, 0, 0, 0, 31, 0, 31, 0, 0, 31, 0, 31, 0, 0},
                          {0, 5, 0, 0, 0, 4, 4, 0, 0, 0, 0, 0, 0, 4, 4, 0},
                          {32, 0, 0, 34, 0, 4, 11, 14, 14, 14, 14, 14, 14, 22, 4, 34},
                          {0, 5, 0, 0, 0, 0, 11, 21, 12, 12, 12, 12, 21, 13, 0, 0},
                          {32, 33, 0, 34, 0, 0, 11, 13, 4, 4, 11, 0, 11, 13, 0, 34},
                          {0, 5, 0, 0, 0, 0, 11, 13, 4, 0, 11, 0, 11, 13, 0, 0},
                          {0, 5, 0, 0, 0, 0, 11, 13, 0, 13, 0, 4, 11, 13, 0, 34},
                          {32, 31, 0, 34, 0, 0, 11, 13, 0, 13, 4, 4, 11, 13, 0, 34},
                          {0, 5, 0, 0, 0, 0, 11, 21, 14, 14, 14, 14, 21, 13, 0, 0},
                          {0, 31, 0, 34, 0, 4, 12, 12, 12, 12, 12, 12, 12, 22, 4, 34},
                          {0, 5, 0, 0, 0, 4, 4, 0, 0, 0, 0, 0, 0, 4, 4, 0},
                          {0, 5, 0, 0, 0, 0, 33, 0, 33, 0, 0, 33, 0, 33, 0, 0}};
        generateMap(map);
    }
}
