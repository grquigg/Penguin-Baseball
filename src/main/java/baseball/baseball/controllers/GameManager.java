package baseball.baseball.controllers;

import baseball.baseball.models.Game;

import java.util.ArrayList;

public class GameManager implements Manager<Game> {

    private ArrayList<Game> gameList;
    public GameManager() {

    }
    @Override
    public Game getFromList() {
        return null;
    }

    @Override
    public void addNewEntryToList(Game g) {

    }

    public boolean isEntryInList(Game gameModel) {
        return false;
    }

    @Override
    public void deleteEntry(Game gameModel) {

    }

    @Override
    public boolean isListEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
