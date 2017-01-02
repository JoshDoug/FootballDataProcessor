/**
 * Class for handling model and viewer classes.
 * @author joshstringfellow
 */
package uk.ac.kingston.ci5100.football.a1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import uk.ac.kingston.ci5100.football.a1.model.*;
import uk.ac.kingston.ci5100.football.a1.view.ApplicationViewer;

/**
 *
 * @author joshstringfellow
 */
public class ApplicationControl {
    
    private ApplicationModel appModel;
    private ApplicationViewer appView;
    
//    public static void main(String[] args) throws UnsupportedLookAndFeelException{
//        String[] teamCSV = DataFiles.readCSV("data/football_teams.txt");
//        String[] matchCSV = DataFiles.readCSV("data/football_matches.txt");
//
//        ApplicationModel appModel = new ApplicationModel(teamCSV, matchCSV);
//        
//        ApplicationViewer appView = new ApplicationViewer(appModel);
//        appView.addSortDivisionListener(new SortDivisionListener());
//    }
    
    public ApplicationControl(ApplicationModel appModel, ApplicationViewer appView) {
        this.appModel = appModel;
        this.appView = appView;
        
        this.appView.addSortDivisionListener(new SortDivisionListener());
        this.appView.addSortLeagueListener(new SortLeagueListener());
        this.appView.addCoachSummaryListener(new CoachSummaryListener());
    }
    
    class SortDivisionListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Collections.sort(appModel.getTeamArray(), new TeamCompareDivision());
            appView.setTeamTextArea(appModel.returnTeamsList());
        }
        
    }
    
    class SortLeagueListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Collections.sort(appModel.getTeamArray(), new TeamCompareLeague());
            appView.setTeamTextArea(appModel.returnTeamsList());
        }
        
    }
    
    class CoachSummaryListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Collections.sort(appModel.getTeamArray(), new TeamCompareLeague());
            appView.setTeamTextArea(appModel.getCoachSummary());
        }
    }
}
