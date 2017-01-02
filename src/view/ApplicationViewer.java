/**
 * Class for UI and user interaction.
 * @author joshstringfellow
 */
package uk.ac.kingston.ci5100.football.a1.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import uk.ac.kingston.ci5100.football.a1.model.ApplicationModel;

public class ApplicationViewer extends JFrame {

    private final JTabbedPane tabs = new JTabbedPane();
    private final JPanel teamPanel = new JPanel(new BorderLayout());
    private final JPanel matchPanel = new JPanel(new BorderLayout());
    private final JPanel teamButtonPanel = new JPanel();
    private JTextArea teams = new JTextArea();
    private JTextArea matches = new JTextArea();
    private final JScrollPane teamSPane;
    private final JScrollPane matchSPane;
    private final JButton sortDivision = new JButton("Division");
    private final JButton sortLeague = new JButton("League");
    private final JButton coachSummary = new JButton("Coach Summary");   
    
    
    public ApplicationViewer(ApplicationModel appModel){
//        JFrame frame = new JFrame();
//        frame.setLayout(new BorderLayout());

        this.setLayout(new BorderLayout());
        this.setSize(1000, 700);
        this.setTitle("Football Data Viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        teams = new JTextArea(appModel.returnTeamsList());
        teams.setFont(new Font("monospaced", Font.PLAIN, 12));
        matches = new JTextArea(appModel.returnMatchList());
        matches.setFont(new Font("monospaced", Font.PLAIN, 12));
        
        teamSPane = new JScrollPane(teams);
        matchSPane = new JScrollPane(matches);
        
        teamPanel.add(teamSPane, BorderLayout.CENTER);
        teamButtonPanel.setLayout(new GridLayout(1, 3));
        teamButtonPanel.add(sortDivision);
        teamButtonPanel.add(sortLeague);
        teamButtonPanel.add(coachSummary);
        teamPanel.add(teamButtonPanel, BorderLayout.SOUTH);
        matchPanel.add(matchSPane);
        
        //spane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //teams.add(new JScrollPane(teams));
        //matches.add(new JScrollPane(matches));
        
        
        tabs.add("Teams",teamPanel);
        tabs.add("Matches",matchPanel);
        
        this.add(tabs);
        this.setVisible(true);
    }
    
    public void addSortDivisionListener(ActionListener listenForDivisionSort) {
        sortDivision.addActionListener(listenForDivisionSort);
    }
    
    public void addSortLeagueListener(ActionListener listenForLeagueSort) {
        sortLeague.addActionListener(listenForLeagueSort);
    }
        
    public void addCoachSummaryListener(ActionListener listenForCoachSummary) {
        coachSummary.addActionListener(listenForCoachSummary);
    }
    
    public void setTeamTextArea(String updateData) {
        teams.setText(updateData);
    }
}