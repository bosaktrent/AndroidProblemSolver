/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.solution;

import framework.graph.Vertex;
import java.util.Stack;

/**
 *
 * @author Trent Bosak
 * @section 2
 */
public class Solution {

    /**
     * Creates an object that represents a path from a start
     * vertex to an end vertex in a problem solving domain.
     * This constructor will be called after a search has been
     * initiated on the start vertex.
     * If a path from start to end exists, it can be constructed
     * from the predecessor information stored in the end vertex.
     * @param start the start vertex
     * @param end the end vertex
     */
    public Solution(Vertex start, Vertex end) {
        startVertex = start;
        endVertex = end;
        theStack = new Stack<>();
        Vertex vertexToAdd = endVertex;
        while (vertexToAdd != start) {
            theStack.push(vertexToAdd);
            vertexToAdd = vertexToAdd.getPredecessor();
        }
        theStack.push(start);
    }

    /**
     * Gets the length of the solution, that is, the number of moves
     * to get to the end state from the start.
     * @return the solution length
     */
    public int getLength() {
        return theStack.size() - 1;
    }

    /**
     * Checks whether there are more vertices in this solution.
     * @return true if there are more vertices in this solution, false
     * otherwise
     */
    public boolean hasNext() {
        return !theStack.isEmpty();
    }

    /**
     * Removes and returns the next vertex in this solution.
     * @return the next vertex in this solution
     * @throws RuntimeException if there are no more vertices
     */
    public Vertex next() {
        if (theStack.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        else {
            return theStack.pop();
        }
    }

    private final Vertex startVertex;
    private final Vertex endVertex;
    private final Stack<Vertex> theStack;

    /* private instance fields and methods here */
}