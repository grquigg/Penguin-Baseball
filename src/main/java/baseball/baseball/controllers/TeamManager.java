package baseball.baseball.controllers;

import baseball.baseball.models.Team;
import java.util.HashMap;

public class TeamManager implements Manager<Team> {

    private HashMap<String, Team> teamList;
    private boolean canWriteToFile;

    public TeamManager(boolean writeFiles) {
        teamList = new HashMap<String, Team>();
        canWriteToFile = writeFiles;
    }
    @Override
    public Team getFromList() {
        return null;
    }
    @Override
    public void addNewEntryToList(Team team) {
        if(isEntryInList(team.name)) {
            return;
        }
        teamList.put(team.name, team);
    }
    private boolean isEntryInList(String name) {
        return teamList.containsKey(name);
    }
    @Override
    public void deleteEntry(Team team) {
        teamList.remove(team.name);
    }
    @Override
    public boolean isListEmpty() {
        return teamList.isEmpty();
    }
    @Override
    public int size() {
        return teamList.size();
    }

    public void clear() {
        teamList.clear();
    }

    public Team getFromListByName(String name) {
        if(isEntryInList(name)) {
            return teamList.get(name);
        }
        return null;
    }

    public HashMap<String, Team> getTeams() {return this.teamList;}
}
