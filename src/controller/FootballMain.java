/**
 * Main class, instantiates Controller.
 * @author joshstringfellow
 */
package uk.ac.kingston.ci5100.football.a1.controller;

import uk.ac.kingston.ci5100.football.a1.model.ApplicationModel;
import uk.ac.kingston.ci5100.football.a1.utils.DataFiles;
import uk.ac.kingston.ci5100.football.a1.view.ApplicationViewer;

public class FootballMain {
    
    public static void main(String[] args) {
        String[] teamCSV = DataFiles.readCSV("data/football_teams.txt");
        String[] matchCSV = DataFiles.readCSV("data/football_matches.txt");
        
        ApplicationModel appModel = new ApplicationModel(teamCSV, matchCSV);
        ApplicationViewer appView = new ApplicationViewer(appModel);
        
        ApplicationControl appControl = new ApplicationControl(appModel, appView);
    }
}
