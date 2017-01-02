/*
 * Object for holding and structuring Match Data
 * @author joshstringfellow
 */
package uk.ac.kingston.ci5100.football.a1.model;

import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Match {
    private String teamName;
    private int[] result;
    private Date date;
    private String opponent;
    private int attendance;

    /**
     * Empty constructor for testing.
     */
    public Match(){        
        this.result = new int[2];
    }
    
    /**
     * Constructor for creating an object from a csvString/csvLine.
     * @param csvString 
     */
    public Match(String csvString){
        this.result = new int[2];
        String[] attributes = csvString.split(",");
        int i = 0;
        for (String s : attributes){
          switch (i){
              case 0:
                  this.teamName = s;
                  break;
              case 1:
                  setResult(s);
                  break;
              case 2:
                  setDate(s);
                  break;
              case 3:
                  this.opponent = s;
                  break;  
              case 4:
                  setAttendance(s);
                  break;  
          }
          i++;          
      }
    }
    
    /**
     * Constructor for passing in all attributes with expected data types
     * @param teamName
     * @param result
     * @param date
     * @param opponent
     * @param attendance 
     */
    public Match(String teamName, int[] result, Date date, String opponent, int attendance){
        this.result = new int[2];
        setTeamName(teamName);
        setResult(result);
        setDate(date);
        setOpponent(opponent);
        setAttendance(attendance);
    }
    
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int[] getResult() {
        return result;
    }
    
    public int getResult(int side){
        return result[side];
    }

    public void setResult(int[] result) {
        this.result = result;
    }
    
    public void setResult(String result) {
        String[] scoreHolder = result.split("-");
        this.result[0] = parseInt(scoreHolder[0]);
        this.result[1] = parseInt(scoreHolder[1]);
    }

    public Date getDate() {
        return date;
    }
    
    public String getDateString(){
        String dateStringHolder = date.toString();
        String dateString;
        dateString = dateStringHolder.substring(0,10) + dateStringHolder.substring(23, dateStringHolder.length());
        return dateString;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.date = dateFormat.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Match.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }
    
    public void setAttendance(String attendance) {
        this.attendance = parseInt(attendance);
    }
    
    private String getArrayAsString(int[] a) {
        String result = "";
        for(int s: a) {
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
//    public String toString(){
//       return teamName + "\t" + getArrayAsString(result) + "\t" 
//              + getDateString() + "\t" + opponent + "\t" 
//               + attendance + "\n";       
//    }
    public String toString(){
        return setStringLength(teamName, 25) + "\t" + getResult(0) + "-" + getResult(1) + "\t" + setStringLength(getDateString(), 30) + "\t" + setStringLength(opponent, 25) + "\t" + attendance + "\n";
    }
    
    public String toCSVString()
    {
       return teamName + "," + getArrayAsString(result) + "," 
              + date + "," + opponent + "," 
               + attendance;       
    }
    
    
}