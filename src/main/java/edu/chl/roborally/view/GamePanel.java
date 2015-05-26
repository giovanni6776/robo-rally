package edu.chl.roborally.view;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.utilities.GlobalImageHolder;

import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by axel on 2015-05-06.
 */
public class GamePanel extends JPanel {

    private BufferedImage imageBG;
    private BufferedImage textBG;
    private BoardView boardView;
    private ConsoleView consoleView;
    private ControlView controlView;
    private Player player;

    protected GamePanel(GameBoard board, ArrayList<Player> players, Player player){
        imageBG = GlobalImageHolder.getInstance().getMainBackgroundImage();
        initImages();
        setOpaque(false);
        setLayout(null);
        this.player = player;
        boardView = new BoardView(board,players);
        controlView = new ControlView(player);
        consoleView = new ConsoleView();
        add(boardView);
        boardView.setLocation(8, 23);
        add(consoleView);
        consoleView.setLocation(678, 23);
        add(controlView);
        controlView.setLocation(8, 543);
    }

    /*
    Getters
     */
    protected BoardView getBoardView(){
        return this.boardView;
    }
    protected ControlView getControlView(){
        return this.controlView;
    }
    protected Player getPlayer() {
        return player;
    }

    /*
    Help methods and classes
     */
    private void initImages() {
        imageBG = GlobalImageHolder.getInstance().getMainBackgroundImage();
        try {
            textBG = ImageIO.read(this.getClass().getClassLoader().getResource("game_background_text.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Images could not be read");
        }
    }

    /*
    Painters
     */
    private void paintBorders(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(4, 19, 664, 500);
        g.fillRect(674, 19, 322, 500);
        g.fillRect(4, 539, 992, 179);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageBG, 0, 0, 1001, 730, this);
        paintBorders(g);
    }
    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g);
        g.drawImage(textBG, 0, 1, 1000, 730, this);
    }
}
