/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.problem;

/**
 *
 * @author Trent Bosak
 * @section 02
 */
public class Benchmark {

    public Benchmark(String name, State start, State goal) {
        benchName = name;
        startState = start;
        goalState = goal;
    }

    public String getName() {
        return benchName;
    }

    public State getStartState() {
        return startState;
    }

    public State getGoalState() {
        return goalState;
    }

    @Override
    public String toString() {
        return benchName;
    }

    /** Private data members */
    private final String benchName;
    private final State startState;
    private final State goalState;

}