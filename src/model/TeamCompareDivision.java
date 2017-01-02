/*
 * Object for holding and structuring Team Data
 * @author joshstringfellow
 */
package uk.ac.kingston.ci5100.football.a1.model;

import java.util.Comparator;

public class TeamCompareDivision implements Comparator<Team> {
    
    @Override
    public int compare(Team team1, Team team2) {
        return team1.getDivision() - team2.getDivision();
    }   
}