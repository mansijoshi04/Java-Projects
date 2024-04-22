/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Section #: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 *
 */
package rallyPkg;

public class RallyTeam implements Comparable<RallyTeam> {
    private String teamName;
    private int time;
    private int leg;

    public RallyTeam(String teamName, int time, int leg) {
        this.teamName = teamName;
        this.time = time;
        this.leg = leg;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTime() {
        return time;
    }

    public int getLeg() {
        return leg;
    }

    @Override
    public int compareTo(RallyTeam other) {
        // Implement compareTo based on your sorting criteria
        return Integer.compare(this.getTime(), other.getTime());
    }
}
