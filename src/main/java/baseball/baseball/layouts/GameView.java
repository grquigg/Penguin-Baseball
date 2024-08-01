package baseball.baseball.layouts;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    private JPanel selectPlayersMenu;
    private JPanel selectPitchersMenu;
    private TeamsView teamsView;

    private NewTeamView newTeamView;
    public GameView(String windowTitle) {
        setTitle("Penguin Baseball");
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        teamsView = new TeamsView("Select Teams");
        newTeamView = new NewTeamView("Create New Team");
        teamsView.setBackground(Color.LIGHT_GRAY);
        selectPlayersMenu = new SelectPlayersView("Select Players");
        selectPitchersMenu = new SelectPitchersView("Select Pitchers");
        selectPitchersMenu.setBackground(Color.LIGHT_GRAY);
        cardPanel.add(teamsView, "selectTeams");
        cardPanel.add(selectPitchersMenu, "selectPitchers");
        cardPanel.add(selectPlayersMenu, "selectPlayers");
        add(cardPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500, 500);
    }

    public TeamsView getTeamsView() {
        return teamsView;
    }

    public NewTeamView getNewTeamsView() { return newTeamView; }
    public JPanel getSelectPlayersMenu() {
        return selectPlayersMenu;
    }

    public JPanel getSelectPitchersMenu() {
        return selectPitchersMenu;
    }
}
