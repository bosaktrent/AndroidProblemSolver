/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.farmer;

import framework.graph.Graph;
import framework.graph.Vertex;

/**
 * A graph for the FWGC problem.
 * @author Trent Bosak 
 * @section 2
 */
public class FarmerGraph extends Graph {
    
    public FarmerGraph() {
        start = new Vertex(new FarmerState("West", "West", "West", "West"));
        end = new Vertex(new FarmerState("East", "East", "East", "East"));
        vertex1 = new Vertex(new FarmerState("East", "West", "East", "West"));
        vertex2 = new Vertex(new FarmerState("West", "West", "East", "West"));
        vertex3 = new Vertex(new FarmerState("East", "East", "East", "West"));
        vertex4 = new Vertex(new FarmerState("West", "East", "West", "West"));
        vertex5 = new Vertex(new FarmerState("East", "East", "West", "East"));
        vertex6 = new Vertex(new FarmerState("West", "East", "West", "East"));
        vertex7 = new Vertex(new FarmerState("East", "West", "East", "East"));
        vertex8 = new Vertex(new FarmerState("West", "West", "West", "East"));
        
        addEdge(start, vertex1);
        addEdge(vertex1, start);
        addEdge(vertex1, vertex2);
        addEdge(vertex2, vertex1);
        addEdge(vertex2, vertex3);
        addEdge(vertex3, vertex2);
        addEdge(vertex3, vertex4);
        addEdge(vertex4, vertex3);
        addEdge(vertex4, vertex5);
        addEdge(vertex5, vertex4);
        addEdge(vertex5, vertex6);
        addEdge(vertex6, vertex5);
        addEdge(vertex6, end);
        addEdge(end, vertex6);
        addEdge(vertex2, vertex7);
        addEdge(vertex7, vertex2);
        addEdge(vertex7, vertex8);
        addEdge(vertex8, vertex7);
        addEdge(vertex8, vertex5);
        addEdge(vertex5, vertex8);
        
    }
    
    public Vertex getStart() {
        return start;
    }
    
    public Vertex getEnd() {
        return end;
    }
    
    Vertex start;
    Vertex end;
    Vertex vertex1;
    Vertex vertex2;
    Vertex vertex3;
    Vertex vertex4;
    Vertex vertex5;
    Vertex vertex6;
    Vertex vertex7;
    Vertex vertex8;
    
}