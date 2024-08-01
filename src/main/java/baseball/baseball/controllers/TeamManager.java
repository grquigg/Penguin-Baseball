package baseball.baseball.controllers;

import baseball.baseball.models.Team;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class TeamManager implements Manager<Team> {

    private HashMap<String, Team> teamList;
    private boolean canWriteToFile;

    public TeamManager(boolean writeFiles) {
        teamList = new HashMap<String, Team>();
        canWriteToFile = writeFiles;
    }

    public TeamManager(boolean writeFiles, String filePath) {
        this(writeFiles);
        if(canWriteToFile) {
            loadTeamsFromFile(filePath);
        }
    }

    private void loadTeamsFromFile(String filePath) {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(filePath));
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                // Process each line
                Team t = new Team(line[1]);
                addNewEntryToList(new Team(line[1]));
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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

    public void commitChangesToFile(String filePath) {
        CSVWriter writer = null;
        try {
            writer = new CSVWriter(new FileWriter(filePath));

            // Writing header
            String[] header = {"Id", "Team Name"};
            writer.writeNext(header);
            int id = 1;
            for (String key : teamList.keySet()) {
                writer.writeNext(new String[]{Integer.toString(id), key});
                id++;
            }
            // Add more data as needed

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
