/*
 * Object for holding and structuring Team Data
 * @author joshstringfellow
 */
package uk.ac.kingston.ci5100.football.a1.model;

import static java.lang.Integer.parseInt;

public final class Team {
    private String teamName;
    private String[] coaches;
    private String league;
    private int division;
    private boolean fullTime;

    /**
     * Empty constructor for testing.
     */
    public Team(){        
    }
    
    /**
     * Constructor for creating an object from a csvString/csvLine.
     * Could create another constructor that's the same as below except expects
     * strings for everything, and just call that within this constructor.
     * Call to 'this' must be first line, doesn't work.
     * @param csvString 
     */
    public Team(String csvString){
      String[] attributes = csvString.split(",");
      int i = 0;
      for (String s : attributes){
          switch (i){
              case 0:
                  this.teamName = s;
                  break;
              case 1:
                  this.coaches = getStringAsArray(s);
                  break;
              case 2:
                  this.league = s;
                  break;
              case 3:
                  setDivision(s);
                  break;  
              case 4:
                  setFullTime(s);
                  break;  
          }
          i++;          
      }
    }
    
    /**
     * Call to 'this' must be first line of constructor, doesn't work.
     */
//    public Team(String csvString){
//        String[] attributes = csvString.split(",");
//        this(attributes[0], attributes[1],attributes[2],attributes[3], attributes[4]);
//    }
    
    /**
     * Constructor for passing in all attributes with expected data types
     * @param teamName
     * @param coaches
     * @param league
     * @param division
     * @param fullTime 
     */
    public Team(String teamName, String[] coaches, String league, int division, boolean fullTime){
        setTeamName(teamName);
        setCoaches(coaches);
        setLeague(league);
        setDivision(division);
        setFullTime(fullTime);
    }
    
    public Team(String teamName, String coaches, String league, String division, String fullTime){
        setTeamName(teamName);
        setCoaches(coaches);
        setLeague(league);
        setDivision(division);
        setFullTime(fullTime);
    }
    
    /**
     * Getters and Setters 
     * @return 
     */
    
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String[] getCoaches() {
        return coaches;
    }
    
    public String getCoachesString() {
        String coachString = getArrayAsString(this.coaches);
        return coachString;
    }
    
    public int getCoachesNumber() {
        return coaches.length;
    }

    public void setCoaches(String[] coaches) {
        this.coaches = coaches;
    }
    
    public void setCoaches(String coaches) {
        this.coaches = getStringAsArray(coaches);
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }
    
    public void setDivision(String division) {
        this.division = parseInt(division);
    }

    public boolean isFullTime() {
        return fullTime;
    }
    
    public String getFullTime() {
        if (fullTime == true){
            return "yes";
        } else {
            return "false";
        }
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }
    
    public void setFullTime(String fullTime) {
        if (fullTime.equals("yes")) {
            this.fullTime = true;
        }
        else {
            this.fullTime = false;
        }         
    }
    
    /**
     * Extended Class/Model logic
     */
    
    private String[] getStringAsArray(String s) {
        String[] result = s.split(":");
        return result;
        
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
    
    @Override
//    public String toString()
//    {
//       return teamName + "\t" + getArrayAsString(coaches) + "\t" 
//              + league + "\t" + division + "\t" 
//               + getFullTime() + "\n";       
//    }
    public String toString(){
        return setStringLength(teamName, 25) + "\t" + setStringLength(getArrayAsString(coaches), 90) + "\t" + setStringLength(league, 20) + "\t" + division + setStringLength(" ", 8) + "\t" + getFullTime() + "\n";
    }    
    public String toCSVString()
    {
       return teamName + "," + getArrayAsString(coaches) + "," 
              + league + "," + division + "," 
               + getFullTime();       
    }

}