package edu.chl.roborally.model;

/**
 * Created by axel on 2015-03-26.
 */
public abstract class GameBoard {

    private GameTile [][] board;
    private GameTile [][] startBoard;


    public GameBoard (){

        this.startBoard = new GameTile[4][12];
        this.board = new GameTile[12][12];

    }

}