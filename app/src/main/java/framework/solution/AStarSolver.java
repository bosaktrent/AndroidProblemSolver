package framework.solution;

import framework.graph.Vertex;
import framework.problem.Problem;
import framework.problem.State;
import java.util.Comparator;
import java.util.PriorityQueue;

/* imports go here */

/**
 * This class represents an A* solver by extending the StateSpaceSolver
 * class.
 * @author Trent Bosak Section 2
 */
public class AStarSolver extends StateSpaceSolver {

    /**
     * Creates an A* solver.
     * This constructor should set the queue to a priority queue (PQ)
     * and set the statistics header.
     * @param problem
     */
    public AStarSolver(Problem problem) {
        super(problem, false);
        pq = new PriorityQueue(SIZE, getComparator());
        super.setQueue(pq);
        super.setHeader("A* Search");
        /* you must provide */
    }

    /**
     * Adds a vertex to the PQ.
     * @param v the vertex to be added
     */
    @Override
    public void add(Vertex v) {
        /* you must provide */
        pq.add(v);
    }

    /**
     * Creates a comparator object that compares vertices for ordering
     * in a PQ during A* search.
     * This should be used when creating the PQ.
     * @return the comparator object
     */
    public final Comparator<Vertex> getComparator() {
        /* you must provide */
        return (v1, v2) -> {
            State goal = getProblem().getFinalState();
            State s1 = (State)v1.getData();
            State s2 = (State)v2.getData();
            int h1 = s1.getHeuristic(goal) + v1.getDistance();
            int h2 = s2.getHeuristic(goal) + v2.getDistance();
            return h1 - h2;
        };
    }

    /* Private instance fields here */
    private PriorityQueue pq;
    private final int SIZE = 9999999;
}