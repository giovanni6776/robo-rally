package edu.chl.roborally.model;

/**
 * Created by fredrikkindstrom on 26/03/15.
 */
public class RegisterCard {

    private enum MoveTypes {

        MOVE_ONE,
        MOVE_TWO,
        MOVE_THREE,
        BACKUP,
        TURN_LEFT,
        TURN_RIGHT,
        U_TURN;
    }

    private MoveTypes type;
    private int points;

    protected RegisterCard(MoveTypes type,int points) {
        this.type = type;
        this.points = points;
    }
}