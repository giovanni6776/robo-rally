package edu.chl.roborally.model;

import edu.chl.roborally.controller.*;
import edu.chl.roborally.view.*;
import edu.chl.roborally.model.maps.*;

import java.util.*;

public class RoboRally {

    // Variables

    private Controller controller;
    private View view;
    private GameBoard gameBoard;

    public ArrayList<Player> players = new ArrayList<>();
    private int numbersOfPlayers;
    private CardDeck deck;

    // Constructor

    public RoboRally() {

    }

    // Game logic

    public void setController(Controller c) {
        this.controller = c;
    }

    public void setView(View v) {
        this.view = v;
    }

    public void newGame() {
        view.print("How many players?");
        numbersOfPlayers = controller.userInputInt();
        setNames();
        view.print("Starting new game with " + numbersOfPlayers + " players");

        int j = 1;
        for (Player p : players) {
            view.print("Player " + j + " : " + p.getName());
            j++;
        }

        resetDeck();
        initMap("Blank");
        initStartPositions();
        initRound();
    }

    private void resetDeck() {
        if (deck == null) {
            deck = new CardDeck();
        } else {
            deck.reset();
        }
    }

    private void initMap(String map) {
        if (map.equals("Blank")) {
            gameBoard = new BlankMap();
        }
    }

    private void initStartPositions() {
        ArrayList<Position> start = gameBoard.getStartPosition(numbersOfPlayers);
        for (int i = 0; i<players.size(); i++) {
            players.get(i).setCheckpoint(start.get(i));
        }
    }

    private void initRound() {
        deck.shuffle();
        for (Player p : players) {
            // TODO check p damagetokens and return right nbr of cards
            p.setHand(deck.getCards(9));
        }
        for (Player p : players) {
            for(RegisterCard c : p.getHand()) {
                System.out.println(c.toString() + " | ");
            }
        }
        // TODO wait for players to pick cards
        for (int i = 1; i <= 5; i++) {
            initTurn();
        }
    }

    private void initTurn() {
        // TODO move players in order
        // TODO execute actions on game board
        // TODO update player status (life tokens, damage etc)
    }

    //Getters

    public int getNumbersOfPlayers() {
        return numbersOfPlayers;
    }

    //Setters

    private void setNumbersOfPlayers(int i) {
        this.numbersOfPlayers = i;
    }

    private void setNames() {
        for (int i = 1; i < numbersOfPlayers+1; i++) {
            System.out.println("Name on Player " + i + "?");
            players.add(new Player(i, controller.userInputString()));
        }
    }
}