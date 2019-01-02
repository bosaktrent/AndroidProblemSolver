/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.puzzle;

import framework.problem.Benchmark;
import framework.problem.Problem;
import framework.problem.State;
import java.util.ArrayList;

/**
 *
 * @author Trent Bosak
 * @section 2
 */
public class PuzzleProblem extends Problem {

    public PuzzleProblem() {
        super();
        super.setName("Puzzle");
        super.setIntroduction(INTRO);
        super.setMover(new PuzzleMover());
        super.setInitialState(makeInitialState());
        super.setCurrentState(super.getInitialState());
        super.setFinalState(makeFinalState());
    }

    private PuzzleState makeInitialState() {
        PuzzleState state = new PuzzleState(
                new int[][]{new int[]{5, 2, 7},
                        new int[]{8, 0, 4},
                        new int[]{3, 6, 1}});
        return state;
    }

    private PuzzleState makeFinalState() {
        int [][] arr = new int[3][3];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][0] = 8;
        arr[1][1] = 0;
        arr[1][2] = 4;
        arr[2][0] = 7;
        arr[2][1] = 6;
        arr[2][2] = 5;
        return new PuzzleState(arr);
    }

    private static final String INTRO = "You are given a board in which numbered "
            + "tiles can slide around."
            + "There is one blank space that holds no tile."
            + "A legal move consists of sliding a tile into the blank space "
            + "if the tile is adjacent to it. "
            + "The goal is to move tiles around until the board looks like the "
            + "final state below. \n";


}
