///**
// * Test Class
// * @author joshstringfellow
// */
//package uk.ac.kingston.ci5100.football.a1.test;
//
//import java.util.ArrayList;
//import uk.ac.kingston.ci5100.football.a1.model.Match;
//import uk.ac.kingston.ci5100.football.a1.model.Team;
//import uk.ac.kingston.ci5100.football.a1.utils.DataFiles;
//
//public class test {
//
//    public static void main(String[] args){
//        
//        DataFiles readWrite = new DataFiles();
//        
//        Team aTeam = new Team();
//        aTeam.setTeamName("Chelsea Sucks");
//        
//        System.out.println(aTeam.getTeamName());
//        
//        String coachString = "Jon Bryer:Abe Meza:Stan Policastro:Joan Shiring:Silas Dearmas:Cedric Twombly";
//        String[] coachArray = coachString.split(":");
//        Team team1 = new Team("Chelsea", coachArray, "National", 1, true);
//        System.out.println(team1.toString());
//        
//        
//        String teamLine1 = "Ashton Athletic,Oliver Talty:Wilfredo Ruddell:Danial Brock:Modesto Blose:Marty Pegram,National,1,yes";
//        Team team2 = new Team(teamLine1);
//        System.out.println(team2.toString());
//        System.out.println(team2.toCSVString());
//        
//        Team team3 = new Team(team2.toCSVString());
//        System.out.println(team3.toString());
//        System.out.println(team3.toCSVString());
//        
//        ArrayList<Team> teamList = new ArrayList<>();
//        
//        String[] teamCSV = DataFiles.readCSV("/Users/joshstringfellow/Documents/NetBeansProjects/FootballProject/data/football_teams.txt");
//        getTeamList(teamCSV, teamList);
//        
//        for (Team t: teamList){
//            System.out.println(t.toCSVString());
//        }
//
//        //Match aMatch = new Match();
//        
//        //Match match1 = new Match("Kronos United,2-3,16/05/2011,Dedfield United,2829");
//        //System.out.println(match1.toString());
//        
//        ArrayList<Match> matchList = new ArrayList<>();
//        String[] matchCSV = DataFiles.readCSV("/Users/joshstringfellow/Documents/NetBeansProjects/FootballProject/data/football_matches.txt");
//        getMatchList(matchCSV, matchList);
//        
//        for (Match m: matchList){
//            System.out.println(m.toCSVString());
//        }
//    }
//    
//    public static void getTeamList(String[] csvList, ArrayList<Team> teamList) {
//        for(String s: csvList){
//            Team tempTeam = new Team(s);
//            //System.out.println(tempTeam.toString());
//            teamList.add(tempTeam);
//        }
//    }
//    
//    public static void getMatchList(String[] csvList, ArrayList<Match> matchList) {
//        for(String s: csvList){
//            Match tempMatch = new Match(s);
//            //System.out.println(tempMatch.toString());
//            matchList.add(tempMatch);
//        }
//    }
//}
