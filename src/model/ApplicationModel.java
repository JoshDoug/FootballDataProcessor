/**
 * Class for storing team and match objects.
 * @author joshstringfellow
 */
package uk.ac.kingston.ci5100.football.a1.model;

import java.util.ArrayList;
import java.util.Date;

public final class ApplicationModel {
    private ArrayList<Team> teamArray;
    private ArrayList<Match> matchArray;
    private String teamHeader[] = {"Name","Coaches","League","Division","Fulltime"};
    private String matchHeader[] = {"Teamname","Team Result", "Opponent Result","Date","Opponent","Attendence"};

    public ApplicationModel() {
    }
    
    public ApplicationModel(String[] teamCSV) {
        this.teamArray = new ArrayList<>();
        setTeamList(teamCSV);
    }
    
    public ApplicationModel(String[] teamCSV,String[] matchCSV) {
        this(teamCSV);
        this.matchArray = new ArrayList<>();
        setMatchList(matchCSV);
    }
    
    public ArrayList<Team> getTeamArray() {
        return teamArray;
    }    
    
    public void setTeamList(String[] csvList){
        for(String s: csvList){
            Team tempTeam = new Team(s);
            getTeamArray().add(tempTeam);
        }
    }
    
    public ArrayList<Match> getMatchArray() {
        return matchArray;
    }    
    
    public void setMatchList(String[] csvList){
        for(String s: csvList){
            Match tempMatch = new Match(s);
            getMatchArray().add(tempMatch);
        }
    }
    
    public String printTeamsList(){
        String csvString = String.join(",", teamHeader) + "\n";
        for (Team t: getTeamArray()){
            csvString += t.toCSVString() + "\n";
        }
        return csvString;
    }
    
    public String returnTeamsList(){
        String teamString = getTeamHeaderString() + "\n";
        for (Team t: getTeamArray()){
            teamString += t.toString();
        }
        return teamString;
    }
    
    public void printMatchList(){
        for (Match m: getMatchArray()){
            System.out.println(m.toCSVString());
        }
    }
    
    public String returnMatchList(){
        String matchString = getTeamHeaderString() + "\n";
        for (Match m: getMatchArray()){
            matchString += m.toString();
        }
        return matchString;
    }

    private String getArrayAsString(String[] a) {
        String result = "";
        for(String s: a) {
            result += s + ":";
        }
        result = result.trim();
        return result;
    }
    
    private String setStringLength(String oddString, int newLength){
        String newStringLength = oddString;
        while(newStringLength.length() < newLength){
            newStringLength += " ";
        }
        return newStringLength;
    }    
    
    public String[] getTeamHeader() {
        return teamHeader;
    }
    
    public String getTeamHeaderString() {
        //return getArrayAsString(teamHeader);
        return setStringLength(teamHeader[0], 25) + "\t" + setStringLength(teamHeader[1], 90) + "\t" + setStringLength(teamHeader[2], 20) + "\t" + teamHeader[3] + "\t" + teamHeader[4] + "\n";
    }

    public String[] getMatchHeader() {
        return matchHeader;
    }
    
    public String getMatchHeaderString() {
        return getArrayAsString(matchHeader);
    }
    
    public String getCoachSummary() {
        String coachSummary = "Name, \t\t Number of Coaches, \t League\n";
        double avgCoachNumber = 0;
        double confDivisionCoaches = 0;
        int confNumber = 0;
        double natiDivisionCoaches = 0;
        int natiNumber = 0;
        
        for (Team t: getTeamArray()){
            coachSummary += setStringLength(t.getTeamName(), 25) + "\t" + t.getCoachesNumber() + "\t" + t.getLeague() + "\n";
            avgCoachNumber += t.getCoachesNumber();
            if(t.getLeague().equalsIgnoreCase("Conference")) {
                confDivisionCoaches += t.getCoachesNumber();
                confNumber++;
            } else if(t.getLeague().equals("National")) {
                natiDivisionCoaches += t.getCoachesNumber();
                natiNumber++;
            }
        }
        
        avgCoachNumber = avgCoachNumber/teamArray.size();
        confDivisionCoaches = confDivisionCoaches/confNumber;
        natiDivisionCoaches = natiDivisionCoaches/natiNumber;
        
        coachSummary += "The average number of coaches is: " + Math.round(avgCoachNumber) + "\t (" + String.format("%.2f", avgCoachNumber) + ")\n";
        coachSummary += "The average number of coaches for teams in the conference league is: " + Math.round(confDivisionCoaches) + "\t (" + String.format("%.2f", confDivisionCoaches) + ")\n";
        coachSummary += "The average number of coaches for teams in the national league is: " + Math.round(natiDivisionCoaches) + "\t (" + String.format("%.2f", natiDivisionCoaches) + ")\n";
        
        return coachSummary;
    }
}