package com.trentbosak.problemsolver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import domains.puzzle.PuzzleProblem;
import domains.puzzle.PuzzleState;
import framework.problem.Problem;
import framework.problem.State;
import framework.solution.AStarSolver;
import framework.solution.Solution;
import framework.solution.Solver;
import framework.solution.SolvingAssistant;

public class PuzzleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);
        Intent intent = getIntent();
        problem = new PuzzleProblem();
        solver = new SolvingAssistant(problem);
        stepSolver = new AStarSolver(problem);
        TextView congrats = findViewById(R.id.congrats);
        congrats.setVisibility(View.GONE);
        TextView moveCount = findViewById(R.id.moveCountNum);
        moveCount.setText(" " + solver.getMoveCount());
        Button next = findViewById(R.id.nextButton);
        next.setEnabled(false);
        hideError();
    }

    public void resetProblem(View view) {
        solver.reset();
        Button solveButton = findViewById(R.id.solveButton);
        solveButton.setEnabled(true);
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setEnabled(false);
        reload();
    }

    public void nextMove(View view) {
        solver.update((State)solution.next().getData());
        PuzzleState curState = (PuzzleState)problem.getCurrentState();
        TextView moveCount = findViewById(R.id.moveCountNum);
        moveCount.setText(" " + solver.getMoveCount());

        Button tileOne = findViewById(R.id.tileOne);
        PuzzleState.Location loc1 = curState.getLocation(1);
        tileOne.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc1.getRow()), GridLayout.spec(loc1.getColumn())));
        ViewGroup.LayoutParams params1 = tileOne.getLayoutParams();
        params1.height = SIZE;
        params1.width = SIZE;

        Button tileTwo = findViewById(R.id.tileTwo);
        PuzzleState.Location loc2 = curState.getLocation(2);
        tileTwo.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc2.getRow()), GridLayout.spec(loc2.getColumn())));
        ViewGroup.LayoutParams params2 = tileTwo.getLayoutParams();
        params2.height = SIZE;
        params2.width = SIZE;

        Button tileThree = findViewById(R.id.tileThree);
        PuzzleState.Location loc3 = curState.getLocation(3);
        tileThree.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc3.getRow()), GridLayout.spec(loc3.getColumn())));
        ViewGroup.LayoutParams params3 = tileThree.getLayoutParams();
        params3.height = SIZE;
        params3.width = SIZE;

        Button tileFour = findViewById(R.id.tileFour);
        PuzzleState.Location loc4 = curState.getLocation(4);
        tileFour.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc4.getRow()), GridLayout.spec(loc4.getColumn())));
        ViewGroup.LayoutParams params4 = tileFour.getLayoutParams();
        params4.height = SIZE;
        params4.width = SIZE;

        Button tileFive = findViewById(R.id.tileFive);
        PuzzleState.Location loc5 = curState.getLocation(5);
        tileFive.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc5.getRow()), GridLayout.spec(loc5.getColumn())));
        ViewGroup.LayoutParams params5 = tileFive.getLayoutParams();
        params5.height = SIZE;
        params5.width = SIZE;

        Button tileSix = findViewById(R.id.tileSix);
        PuzzleState.Location loc6 = curState.getLocation(6);
        tileSix.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc6.getRow()), GridLayout.spec(loc6.getColumn())));
        ViewGroup.LayoutParams params6 = tileSix.getLayoutParams();
        params6.height = SIZE;
        params6.width = SIZE;

        Button tileSeven = findViewById(R.id.tileSeven);
        PuzzleState.Location loc7 = curState.getLocation(7);
        tileSeven.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc7.getRow()), GridLayout.spec(loc7.getColumn())));
        ViewGroup.LayoutParams params7 = tileSeven.getLayoutParams();
        params7.height = SIZE;
        params7.width = SIZE;

        Button tileEight = findViewById(R.id.tileEight);
        PuzzleState.Location loc8 = curState.getLocation(8);
        tileEight.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc8.getRow()), GridLayout.spec(loc8.getColumn())));
        ViewGroup.LayoutParams params8 = tileEight.getLayoutParams();
        params8.height = SIZE;
        params8.width = SIZE;

        if (solver.isProblemSolved()) {
            TextView congrats = findViewById(R.id.congrats);
            congrats.setVisibility(View.VISIBLE);
            Button nextButton = findViewById(R.id.nextButton);
            nextButton.setEnabled(false);
        }
    }

    public void solveProblem(View view) {
        Button solveButton = findViewById(R.id.solveButton);
        solveButton.setEnabled(false);
        Button tileOne = findViewById(R.id.tileOne);
        tileOne.setClickable(false);
        Button tileTwo = findViewById(R.id.tileTwo);
        tileTwo.setClickable(false);
        Button tileThree = findViewById(R.id.tileThree);
        tileThree.setClickable(false);
        Button tileFour = findViewById(R.id.tileFour);
        tileFour.setClickable(false);
        Button tileFive = findViewById(R.id.tileFive);
        tileFive.setClickable(false);
        Button tileSix = findViewById(R.id.tileSix);
        tileSix.setClickable(false);
        Button tileSeven = findViewById(R.id.tileSeven);
        tileSeven.setClickable(false);
        Button tileEight = findViewById(R.id.tileEight);
        tileEight.setClickable(false);
        Button next = findViewById(R.id.nextButton);
        next.setEnabled(true);
        stepSolver.solve();
        solution = stepSolver.getSolution();
        solution.next();
        TextView textView = findViewById(R.id.statisticsText);
        textView.setText(stepSolver.getStatistics().toString());
    }

    public void reload() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }

    private void displayError() {
        TextView error = findViewById(R.id.errorMessage);
        error.setVisibility(View.VISIBLE);
    }

    private void hideError() {
        TextView error = findViewById(R.id.errorMessage);
        error.setVisibility(View.GONE);
    }

    public void slideTile1(View view) {
        solver.tryMove("Slide Tile 1");
        if (solver.isMoveLegal()) {
            hideError();
            TextView moveCount = findViewById(R.id.moveCountNum);
            moveCount.setText(" " + solver.getMoveCount());
            PuzzleState curState = (PuzzleState)problem.getCurrentState();
            PuzzleState.Location loc = curState.getLocation(1);
            Button tile = findViewById(R.id.tileOne);
            tile.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc.getRow()), GridLayout.spec(loc.getColumn())));
            ViewGroup.LayoutParams params = tile.getLayoutParams();
            params.height = SIZE;
            params.width = SIZE;
        }
        else {
            displayError();
        }
    }

    public void slideTile2(View view) {
        solver.tryMove("Slide Tile 2");
        if (solver.isMoveLegal()) {
            hideError();
            TextView moveCount = findViewById(R.id.moveCountNum);
            moveCount.setText(" " + solver.getMoveCount());
            PuzzleState curState = (PuzzleState)problem.getCurrentState();
            PuzzleState.Location loc = curState.getLocation(2);
            Button tile = findViewById(R.id.tileTwo);
            tile.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc.getRow()), GridLayout.spec(loc.getColumn())));
            ViewGroup.LayoutParams params = tile.getLayoutParams();
            params.height = SIZE;
            params.width = SIZE;
        }
        else {
            displayError();
        }
    }

    public void slideTile3(View view) {
        solver.tryMove("Slide Tile 3");
        if (solver.isMoveLegal()) {
            hideError();
            TextView moveCount = findViewById(R.id.moveCountNum);
            moveCount.setText(" " + solver.getMoveCount());
            PuzzleState curState = (PuzzleState)problem.getCurrentState();
            PuzzleState.Location loc = curState.getLocation(3);
            Button tile = findViewById(R.id.tileThree);
            tile.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc.getRow()), GridLayout.spec(loc.getColumn())));
            ViewGroup.LayoutParams params = tile.getLayoutParams();
            params.height = SIZE;
            params.width = SIZE;
        }
        else {
            displayError();
        }
    }

    public void slideTile4(View view) {
        solver.tryMove("Slide Tile 4");
        if (solver.isMoveLegal()) {
            hideError();
            TextView moveCount = findViewById(R.id.moveCountNum);
            moveCount.setText(" " + solver.getMoveCount());
            PuzzleState curState = (PuzzleState)problem.getCurrentState();
            PuzzleState.Location loc = curState.getLocation(4);
            Button tile = findViewById(R.id.tileFour);
            tile.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc.getRow()), GridLayout.spec(loc.getColumn())));
            ViewGroup.LayoutParams params = tile.getLayoutParams();
            params.height = SIZE;
            params.width = SIZE;
        }
        else {
            displayError();
        }
    }

    public void slideTile5(View view) {
        solver.tryMove("Slide Tile 5");
        if (solver.isMoveLegal()) {
            hideError();
            TextView moveCount = findViewById(R.id.moveCountNum);
            moveCount.setText(" " + solver.getMoveCount());
            PuzzleState curState = (PuzzleState)problem.getCurrentState();
            PuzzleState.Location loc = curState.getLocation(5);
            Button tile = findViewById(R.id.tileFive);
            tile.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc.getRow()), GridLayout.spec(loc.getColumn())));
            ViewGroup.LayoutParams params = tile.getLayoutParams();
            params.height = SIZE;
            params.width = SIZE;
        }
        else {
            displayError();
        }
    }

    public void slideTile6(View view) {
        solver.tryMove("Slide Tile 6");
        if (solver.isMoveLegal()) {
            hideError();
            TextView moveCount = findViewById(R.id.moveCountNum);
            moveCount.setText(" " + solver.getMoveCount());
            PuzzleState curState = (PuzzleState)problem.getCurrentState();
            PuzzleState.Location loc = curState.getLocation(6);
            Button tile = findViewById(R.id.tileSix);
            tile.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc.getRow()), GridLayout.spec(loc.getColumn())));
            ViewGroup.LayoutParams params = tile.getLayoutParams();
            params.height = SIZE;
            params.width = SIZE;
        }
        else {
            displayError();
        }
    }

    public void slideTile7(View view) {
        solver.tryMove("Slide Tile 7");
        if (solver.isMoveLegal()) {
            hideError();
            TextView moveCount = findViewById(R.id.moveCountNum);
            moveCount.setText(" " + solver.getMoveCount());
            PuzzleState curState = (PuzzleState)problem.getCurrentState();
            PuzzleState.Location loc = curState.getLocation(7);
            Button tile = findViewById(R.id.tileSeven);
            tile.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc.getRow()), GridLayout.spec(loc.getColumn())));
            ViewGroup.LayoutParams params = tile.getLayoutParams();
            params.height = SIZE;
            params.width = SIZE;
        }
        else {
            displayError();
        }
    }

    public void slideTile8(View view) {
        solver.tryMove("Slide Tile 8");
        if (solver.isMoveLegal()) {
            hideError();
            TextView moveCount = findViewById(R.id.moveCountNum);
            moveCount.setText(" " + solver.getMoveCount());
            PuzzleState curState = (PuzzleState)problem.getCurrentState();
            PuzzleState.Location loc = curState.getLocation(8);
            Button tile = findViewById(R.id.tileEight);
            tile.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(loc.getRow()), GridLayout.spec(loc.getColumn())));
            ViewGroup.LayoutParams params = tile.getLayoutParams();
            params.height = SIZE;
            params.width = SIZE;
        }
        else {
            displayError();
        }
    }


    private PuzzleProblem problem;
    private SolvingAssistant solver;
    private Solver stepSolver;
    private Solution solution;
    private static int SIZE = 235;
}
