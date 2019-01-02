/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.puzzle;

import framework.problem.Mover;
import framework.problem.State;
import domains.puzzle.PuzzleState.Location;

/**
 *
 * @author Trent Bosak
 * @section 2
 */
public class PuzzleMover extends Mover {

    public PuzzleMover() {
        super.addMove(slideTile1, s -> trySlide1(s));
        super.addMove(slideTile2, s -> trySlide2(s));
        super.addMove(slideTile3, s -> trySlide3(s));
        super.addMove(slideTile4, s -> trySlide4(s));
        super.addMove(slideTile5, s -> trySlide5(s));
        super.addMove(slideTile6, s -> trySlide6(s));
        super.addMove(slideTile7, s -> trySlide7(s));
        super.addMove(slideTile8, s -> trySlide8(s));
    }

    private State trySlide1(State state) {
        PuzzleState p = (PuzzleState) state;
        Location numLocation = p.getLocation(1);
        Location spaceLocation = p.getLocation(0);

        if(isLegal(numLocation, spaceLocation)) {
            return new PuzzleState(p, numLocation, spaceLocation);
        }
        else {
            return null;
        }
    }

    private State trySlide2(State state) {
        PuzzleState p = (PuzzleState) state;
        Location numLocation = p.getLocation(2);
        Location spaceLocation = p.getLocation(0);

        if(isLegal(numLocation, spaceLocation)) {
            return new PuzzleState(p, numLocation, spaceLocation);
        }
        else {
            return null;
        }
    }

    private State trySlide3(State state) {
        PuzzleState p = (PuzzleState) state;
        Location numLocation = p.getLocation(3);
        Location spaceLocation = p.getLocation(0);

        if(isLegal(numLocation, spaceLocation)) {
            return new PuzzleState(p, numLocation, spaceLocation);
        }
        else {
            return null;
        }
    }

    private State trySlide4(State state) {
        PuzzleState p = (PuzzleState) state;
        Location numLocation = p.getLocation(4);
        Location spaceLocation = p.getLocation(0);

        if(isLegal(numLocation, spaceLocation)) {
            return new PuzzleState(p, numLocation, spaceLocation);
        }
        else {
            return null;
        }
    }

    private State trySlide5(State state) {
        PuzzleState p = (PuzzleState) state;
        Location numLocation = p.getLocation(5);
        Location spaceLocation = p.getLocation(0);

        if(isLegal(numLocation, spaceLocation)) {
            return new PuzzleState(p, numLocation, spaceLocation);
        }
        else {
            return null;
        }
    }

    private State trySlide6(State state) {
        PuzzleState p = (PuzzleState) state;
        Location numLocation = p.getLocation(6);
        Location spaceLocation = p.getLocation(0);

        if(isLegal(numLocation, spaceLocation)) {
            return new PuzzleState(p, numLocation, spaceLocation);
        }
        else {
            return null;
        }
    }

    private State trySlide7(State state) {
        PuzzleState p = (PuzzleState) state;
        Location numLocation = p.getLocation(7);
        Location spaceLocation = p.getLocation(0);

        if(isLegal(numLocation, spaceLocation)) {
            return new PuzzleState(p, numLocation, spaceLocation);
        }
        else {
            return null;
        }
    }

    private State trySlide8(State state) {
        PuzzleState p = (PuzzleState) state;
        Location numLocation = p.getLocation(8);
        Location spaceLocation = p.getLocation(0);

        if(isLegal(numLocation, spaceLocation)) {
            return new PuzzleState(p, numLocation, spaceLocation);
        }
        else {
            return null;
        }
    }

    /**
     *
     * @param spaceLocation location of the empty space
     * @param numLocation location of the number
     * @return
     */
    private boolean isLegal(Location numLocation, Location spaceLocation) {
        if ((numLocation.getRow() == spaceLocation.getRow()) && (numLocation.getColumn() + 1 == spaceLocation.getColumn()
                || numLocation.getColumn() - 1 == spaceLocation.getColumn())) {
            return true;
        }
        else if (numLocation.getColumn() == spaceLocation.getColumn() &&
                numLocation.getRow() + 1 == spaceLocation.getRow()) {
            return true;
        }
        else if (numLocation.getColumn() == spaceLocation.getColumn() &&
                numLocation.getRow() - 1 == spaceLocation.getRow()) {
            return true;
        }
        else {
            return false;
        }
    }


    private static String slideTile1 = "Slide Tile 1";
    private static String slideTile2 = "Slide Tile 2";
    private static String slideTile3 = "Slide Tile 3";
    private static String slideTile4 = "Slide Tile 4";
    private static String slideTile5 = "Slide Tile 5";
    private static String slideTile6 = "Slide Tile 6";
    private static String slideTile7 = "Slide Tile 7";
    private static String slideTile8 = "Slide Tile 8";

}
