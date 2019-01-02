/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.graph;

import framework.problem.Problem;
import framework.problem.State;
import java.util.List;
import java.util.Stack;

/**
 * @author Trent Bosak
 * @section 2
 */
public class GraphCreator {

    public Graph createGraphFor(Problem problem) {
        graph = new Graph();
        stack = new Stack<>();
        start = new Vertex(problem.getInitialState());
        stack.push(start);
        moves = problem.getMover().getMoveNames();
        while (!stack.empty()) {
            curVertex = stack.pop();
            for (String move : moves) {
                next = problem.getMover().doMove(move, (State) curVertex.getData());
                if (next != null) {
                    newVertex = new Vertex(next);
                    if (graph.getVertices().containsKey(newVertex)) {
                        newVertex = graph.getVertices().get(newVertex);
                        //System.out.println("if");
                    }
                    else {
                        stack.push(newVertex);
                        //System.out.println("Push");
                    }
                    graph.addEdge(curVertex, newVertex);
                }
            }
        }

        return graph;

    }

    private Graph graph = null;
    private Stack<Vertex> stack = null;
    private Vertex start;
    private List<String> moves;
    private Vertex curVertex;
    private Vertex newVertex;
    private State next;
}
