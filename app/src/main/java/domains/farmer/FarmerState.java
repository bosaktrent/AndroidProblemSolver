/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.farmer;
import framework.problem.State;
import java.util.Objects;

/**
 *
 * @author Trent Bosak
 * @section 2
 */
public class FarmerState implements State {

    public FarmerState(String f, String w, String g, String c) {
        this.farmer = f;
        this.wolf = w;
        this.goat = g;
        this.cabbage = c;
    }

    public String [] getPosition() {
        String [] arr = {farmer, wolf, goat, cabbage};
        return arr;
    }

    @Override
    public boolean equals (Object other) {
        FarmerState otherFarmer = (FarmerState) other;
        if (otherFarmer == null) {
            return false;
        }
        return (otherFarmer.farmer == this.farmer && otherFarmer.wolf == this.wolf
                && otherFarmer.goat == this.goat && otherFarmer.cabbage == this.cabbage);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.farmer);
        hash = 17 * hash + Objects.hashCode(this.wolf);
        hash = 17 * hash + Objects.hashCode(this.goat);
        hash = 17 * hash + Objects.hashCode(this.cabbage);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();

        build.append("   |  |   \n");
        if (farmer == "West") {
            build.append(" F |  |   \n");
        }
        else if (farmer == "East") {
            build.append("   |  | F \n");
        }
        if (wolf == "West") {
            build.append(" W |  |   \n");
        }
        else if (wolf == "East") {
            build.append("   |  | W \n");
        }
        if (goat == "West") {
            build.append(" G |  |   \n");
        }
        else if (goat == "East") {
            build.append("   |  | G \n");
        }
        if (cabbage == "West") {
            build.append(" C |  |   \n");
        }
        else if (cabbage == "East") {
            build.append("   |  | C \n");
        }
        build.append("   |  |   ");

        return build.toString();
    }

    @Override
    public int getHeuristic(State goal) {
        return 0;
    }

    private String farmer;
    private String wolf;
    private String goat;
    private String cabbage;
}
