/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.farmer;

import java.util.function.UnaryOperator;

import framework.problem.Mover;
import framework.problem.State;

/**
 *
 * @author Trent Bosak
 * @section 2
 */
public class FarmerMover extends Mover {

    public FarmerMover() {
        super.addMove(goesAlone, s -> tryAlone(s));
        super.addMove(takesWolf, s -> tryWolf(s));
        super.addMove(takesGoat, s -> tryGoat(s));
        super.addMove(takesCabbage, s -> tryCabbage(s));
    }

    private State tryAlone(State state) {
        FarmerState s = (FarmerState) state;
        String [] pos = s.getPosition();
        FarmerState newState = new FarmerState(move(pos[0]), pos[1], pos[2], pos[3]);
        if (!checkLegal(newState)) {
            return null;
        }
        else {
            return newState;
        }
    }

    private State tryWolf(State state) {
        FarmerState s = (FarmerState) state;
        String [] pos = s.getPosition();
        FarmerState newState = new FarmerState(move(pos[0]), move(pos[1]), pos[2], pos[3]);
        if (!checkLegal(newState)) {
            return null;
        }
        else {
            return newState;
        }
    }

    private State tryGoat(State state) {
        FarmerState s = (FarmerState) state;
        String [] pos = s.getPosition();
        FarmerState newState = new FarmerState(move(pos[0]), pos[1], move(pos[2]), pos[3]);
        if (!checkLegal(newState)) {
            return null;
        }
        else {
            return newState;
        }
    }

    private State tryCabbage(State state) {
        FarmerState s = (FarmerState) state;
        String [] pos = s.getPosition();
        FarmerState newState = new FarmerState(move(pos[0]), pos[1], pos[2], move(pos[3]));
        if (!checkLegal(newState)) {
            return null;
        }
        else {
            return newState;
        }
    }

    private boolean checkLegal (State state) {
        boolean isLegal = true;
        FarmerState s = (FarmerState) state;
        String [] pos = s.getPosition();
        if (pos[1] == pos[2] && pos[1] != pos[0]) {
            isLegal = false;
        }
        else if (pos[2] == pos[3] && pos[2] != pos[0]) {
            isLegal = false;
        }
        return isLegal;
    }

    private String move(String currentSide) {
        String newSide = null;
        if (currentSide == "East") {
            newSide = "West";
        }
        else if (currentSide == "West") {
            newSide = "East";
        }
        return newSide;
    }

    private final String goesAlone = "Farmer Goes Alone";
    private final String takesWolf = "Farmer Takes Wolf";
    private final String takesGoat = "Farmer Takes Goat";
    private final String takesCabbage = "Farmer Takes Cabbage";
}