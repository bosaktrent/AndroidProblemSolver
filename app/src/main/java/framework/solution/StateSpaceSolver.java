package framework.solution;

import framework.graph.Vertex;
import framework.problem.Mover;
import framework.problem.Problem;
import framework.problem.State;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/* imports go here */

/**
 * This class represents a state space solver by extending the abstract
 * Solver class.
 * @author Trent Bosak Section 02
 */
public class StateSpaceSolver extends Solver {

    /**
     * Creates a BFS or DFS state space solver.
     * This constructor should set the queue to a double-ended queue (DEQUE)
     * and set the statistics header.
     * @param problem the problem being solved
     * @param bfs a boolean flag indicating whether BFS is to be performed
     */
    public StateSpaceSolver(Problem problem, boolean bfs) {
        super(problem);
        deque = new LinkedList<>();
        super.setQueue(deque);
        stats = super.getStatistics();
        problemType = problem;
        isBfs = bfs;
        if (bfs) {
            setHeader("Breadth-First Search");
        }
        else {
            setHeader("Depth-First Search");
        }

    }

    protected void setHeader(String header) {
        stats.setHeader(header);
    }

    /**
     * Adds a vertex to the DEQUE.
     * If BFS is being performed, the vertex should be added to the
     * end of the DEQUE, so the DEQUE acts like an ordinary queue.
     * If DFS is being performed, the vertex should be added to the
     * front of the DEQUE, so the DEQUE acts like a stack.
     * @param v
     */
    @Override
    public void add(Vertex v) {
        if (isBfs) {
            deque.addLast(v);
        }
        else if (!isBfs) {
            deque.addFirst(v);
        }
    }

    /**
     * This method implements the expand operation required by the
     * state space search algorithm:

     Expand(u)
     children = {}
     for each name âˆˆ moveNames do
     child = mover.doMove(name, u)
     if child â‰  null and not OccursOnPath(child, u)
     then d[child] = d[u] + 1
     pred[child] = u
     add child to children
     return children

     * @param u the vertex being expanded
     * @return
     */
    @Override
    public List<Vertex> expand(Vertex u) {
        List<Vertex> children = new LinkedList<>();
        Vertex child;
        Mover mover = problemType.getMover();
        for (String moveName : mover.getMoveNames()) {
            child = new Vertex(mover.doMove(moveName, (State)u.getData()));
            if ((State)child.getData() != null && !occursOnPath(child, u)) {
                child.setDistance(u.getDistance() + 1);
                child.setPredecessor(u);
                children.add(child);
            }
        }

        return children;
    }

    /**
     * Checks whether a given vertex appears on the predecessor path
     * of a given ancestor.
     * @param v the vertex to check
     * @param ancestor the ancestor vertex of v
     * @return true if v occurs on the predecessor path of ancestor,
     * false otherwise
     */
    public static boolean occursOnPath(Vertex v, Vertex ancestor) {
        boolean occursOnPath = false;
        Vertex p = ancestor;
        int distance = ancestor.getDistance();
        while (!occursOnPath && p != null) {
            if (p.equals(v)) {
                occursOnPath = true;
            }
            else {
                p = p.getPredecessor();
            }
        }
        return occursOnPath;
    }

    /* private instance fields here */
    private final boolean isBfs;
    private final Deque<Vertex> deque;
    private final Statistics stats;
    private final Problem problemType;
}