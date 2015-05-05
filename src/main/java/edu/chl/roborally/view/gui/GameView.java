package edu.chl.roborally.view.gui;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.model.tiles.BlankTile;
import edu.chl.roborally.model.tiles.GameTile;

import javax.swing.*;
import java.awt.*;

/**
 * Created by fredrikkindstrom on 21/04/15.
 */
public class GameView extends JPanel {

    private RoboRally model;
    private GameBoard board;
    private int tileSize = 40;
    private int width = tileSize*Constants.NUM_COLS;
    private int height = tileSize*Constants.NUM_ROWS;

    public GameView(RoboRally model) {
        this.model = model;
        board = model.getGameBoard();
        setSize(width,height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
    }

    private void drawGrid(Graphics g) {
        // Vertical Lines
        g.drawLine(0,0,0,height);
        g.drawLine(width,0,width,height);
        int x = tileSize;
        for (int i = 1; i <= Constants.NUM_COLS; i++) {
            g.drawLine(x,0,x,height);
            x = x + tileSize;
        }
        // Horizontal Lines
        g.drawLine(0,0,width,0);
        g.drawLine(0,height,width,height);
        int y = tileSize;
        for (int i = 1; i <= Constants.NUM_ROWS; i++) {
            g.drawLine(0,y,width,y);
            y = y + tileSize;
        }
    }
}