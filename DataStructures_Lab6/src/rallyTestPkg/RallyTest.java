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
package rallyTestPkg;

import rallyPkg.RallyTeam;
import rallyPkg.RallyHeap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RallyTest {

	    public static void main(String[] args) {
	        List<RallyTeam> rallyTeams = readRallyResults("RallyResults.csv");

	        // Display results for each leg
	        for (int leg = 1; leg <= 4; leg++) {
	            System.out.println("Team Rankings for Rally Leg " + leg);
	            List<RallyTeam> legResults = getLegResults(rallyTeams, leg);

	            // Heap sort
	            RallyHeap<RallyTeam> heap = new RallyHeap<>();
	            heap.heapSort(legResults);

	            // Display sorted results
	            displayResults(legResults);
	            System.out.println();
	        }
	    }

	    private static List<RallyTeam> readRallyResults(String filePath) {
	        List<RallyTeam> rallyTeams = new ArrayList<>();

	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] values = line.split(",");
	                int leg = Integer.parseInt(values[0]);
	                String teamName = values[1];
	                int time = Integer.parseInt(values[2]);
	                rallyTeams.add(new RallyTeam(teamName, time, leg));
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return rallyTeams;
	    }

	    private static List<RallyTeam> getLegResults(List<RallyTeam> rallyTeams, int leg) {
	        List<RallyTeam> legResults = new ArrayList<>();
	        for (RallyTeam team : rallyTeams) {
	            if (team.getLeg() == leg) {
	                legResults.add(team);
	            }
	        }
	        return legResults;
	    }

	    private static void displayResults(List<RallyTeam> rallyTeams) {
	        for (RallyTeam team : rallyTeams) {
	            System.out.printf("\t%-20s %d%n", team.getTeamName(), team.getTime());
	        }
	    }
	    
	}

