package baseball.baseball.layouts;

import baseball.baseball.controllers.TeamManager;
import baseball.baseball.models.Team;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class TeamsView extends JPanel {
    private DefaultListModel listModel;
    public JList list;
    public JLabel team1_text;
    public JLabel team2_text;
    public JButton select;
    JButton select2;
    public JButton createNewTeam;
    JButton playerSelectionButton;
    private ArrayList<Team> teams;

    public TeamsView(String text) {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        listModel = new DefaultListModel();
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
        JLabel team = new JLabel("Available Teams: ");
        select = new JButton("Select Team 1: ");
        select2 = new JButton("Select Team 2: ");
//        select.addActionListener(this);
//        select2.addActionListener(this);
//        list.addListSelectionListener(this);
        team1_text = new JLabel("Team 1");
        team2_text = new JLabel("Team 2");

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = gc.SOUTHWEST;
        gc.gridx = 1;
        gc.gridy = 0;
        gc.weighty = 0.25;
        add(team, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.ipadx = 100;
        //gc.weighty = 0.25;
        gc.anchor = gc.NORTH;
        gc.ipady = 50;
        gc.fill = GridBagConstraints.NONE;
        add(listScrollPane, gc);

        gc.ipadx = 0;
        gc.ipady = 0;
        gc.insets = new Insets(0, 10, 0, 0);
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = gc.WEST;
        add(team1_text, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        gc.ipadx = 0;
        gc.weighty = 0.25;
        gc.insets = new Insets(0, 10, 0, 0);
        add(select2, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = gc.WEST;
        add(team2_text, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(select, gc);

        gc.anchor = gc.EAST;
        createNewTeam = new JButton("Create new team");
//        createNewTeam.addActionListener(this);
        gc.gridx = 2;
        gc.gridy = 2;
        gc.weighty = 0.25;
        gc.insets = new Insets(0, 0, 0, 10);
        add(createNewTeam, gc);

        playerSelectionButton = new JButton("Choose players");
//        playerSelectionButton.addActionListener(this);
        gc.gridx = 2;
        gc.gridy = 3;
        gc.weighty = 0.25;
        add(playerSelectionButton, gc);

        setSize(400, 300);
    }

    public void updateComponent(String name) {
        listModel.addElement(name);
    }
}
