package baseball.baseball;

import baseball.baseball.controllers.GameController;
import baseball.baseball.controllers.GameManager;
import baseball.baseball.layouts.GameView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //user MUST provide a String argument of a path where CSV files are written/stored to

        SwingUtilities.invokeLater(()-> {
            System.out.println(args[0]);
            GameManager gm = new GameManager();

            GameView view = new GameView("Penguin Baseball");
            GameController controller = new GameController(args[0], gm, view);
//            controller.listenForCommandLine();

            view.setVisible(true);
        });

    }
}