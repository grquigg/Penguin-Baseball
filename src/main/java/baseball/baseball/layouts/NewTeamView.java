package baseball.baseball.layouts;

import baseball.baseball.controllers.GameController;

import javax.swing.*;
import java.awt.*;

public class NewTeamView extends JFrame {

    public JButton create;
    public JTextField field;

    public GameController controller;
    public NewTeamView(String text) {

        super(text);
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = gc.CENTER;
        gc.gridx=0;
        gc.gridy=0;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0, 0, 0, 5);
        field = new JTextField("New Team");
        create = new JButton("Create Team");
        gc.ipady = 7;
        gc.ipadx = 30;
        add(field, gc);
        gc.gridx=1;
        gc.ipady = 0;
        gc.ipadx = 0;
        add(create, gc);

        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
