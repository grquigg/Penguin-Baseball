package baseball.baseball.models;

import java.util.ArrayList;

public class Game implements AbstractGame {
    private Team teamA;
    private Team teamB;
    public Game() {

    }

    @Override
    public AbstractInning createAbstractInning(Team teamA, Team teamB) {
        return null;
    }
}
