package baseball.baseball.controllers;

import baseball.baseball.controllers.GameManager;
import baseball.baseball.controllers.TeamManager;
import baseball.baseball.layouts.GameView;
import baseball.baseball.layouts.NewTeamView;
import baseball.baseball.layouts.TeamsView;
import baseball.baseball.models.Game;
import baseball.baseball.models.Team;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class GameController {
    public enum GameState{SelectTeamsMenu, SelectPlayersMenu, SelectPitchersMenu, GameMenu};

    private Team team1;
    private Team team2;
    private static GameManager gm;
    private static TeamManager team_man;
    private static GameView gameView;
    private static String directory;
    public GameController(String dir_name, GameManager manager, GameView view) {
        gm = manager;
        gameView = view;
        team_man = new TeamManager(false);
        directory = dir_name;
        setupTeamsViewController(gameView.getTeamsView(), gameView.getNewTeamsView());
    }

    private void updateList(String newName) {
        gameView.getTeamsView().updateComponent(newName);
    }
    private void setupTeamsViewController(TeamsView selectTeamsMenu, NewTeamView newTeamView) {

        selectTeamsMenu.select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String team = (String) selectTeamsMenu.list.getSelectedValue();
//                selectTeamsMenu.team1_text.setText(team);
//                team1 = gm.getTeam(selectTeamsMenu.list.getSelectedIndex());
//                gameModel.setTeamA(t1);
            }
        });

        selectTeamsMenu.createNewTeam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newTeamView.setVisible(true);
            }
        });

        newTeamView.create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                team_man.addNewEntryToList(new Team(newTeamView.field.getText()));
                updateList(newTeamView.field.getText());
                newTeamView.dispose();
            }
        });
    }
    public void listenForCommandLine() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Command Line for baseball game");
        while(true) {
            System.out.println("Give me a command!");
            String input = reader.nextLine();
            switch(input) {
                case("exit"):
                    break;
                case("Add new team"):
                    System.out.println("Please enter the name of the team that would like to add:");
                    String name = reader.nextLine();
                    team_man.addNewEntryToList(new Team(name));
                    if(team_man.getFromListByName(name) != null) {
                        System.out.printf("Successfully added %s to teams\n", name);
                    }
                    break;
                case("List teams"):
                    break;
            }
            if(input.equals("exit")) {
                System.out.println("Goodbye");
                break;
            }
        }
    }

}
