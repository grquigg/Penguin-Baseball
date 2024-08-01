import baseball.baseball.controllers.TeamManager;
import baseball.baseball.models.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTeamManager {
    //what assumptions can we make about a teamManager instance?
    private TeamManager tm;
    private static final String dir_name = "data";
    @BeforeEach
    void setUp() {
        tm = new TeamManager(false);
    }

    void tearDown() {
        tm.clear();
    }
    //When a team is added to the list, the size of the list should increase by 1 and is empty should be false
    @Test
    void testAddTeamToList() {
        Team test = new Team("Red Sox");
        tm.addNewEntryToList(test);
        assertEquals(tm.size(), 1);
        assertFalse(tm.isListEmpty());
    }

    //When the list has only one element and that team is removed from the list, the size of the list should decrease by 1 and is empty should be set to true
    @Test
    void testRemoveTeamFromList() {
        Team test = new Team("Red Sox");
        tm.addNewEntryToList(test);
        tm.deleteEntry(test);
        assertEquals(tm.size(), 0);
        assertTrue(tm.isListEmpty());
    }

    //Retrieving an element added to the list should give us the same Team that we added
    //users should be able to query the team object based on the name
    @Test
    void testGetTeamFromList() {
        Team test = new Team("Red Sox");
        tm.addNewEntryToList(test);
        Team newTeam = tm.getFromListByName("Red Sox");
        assertNotNull(newTeam);
        assertEquals("Red Sox", newTeam.name);
        //some other identifiers
    }

    //Trying to an insert a second team with a team name that is already being managed by the team manager should not result in the existing entry being changed at all
    @Test
    void testInsertNewTeamWithSameName() {
        Team test = new Team("Red Sox");
        tm.addNewEntryToList(test);
        tm.addNewEntryToList(new Team("Red Sox"));
        assertEquals(tm.size(), 1);
        assertEquals(tm.getFromListByName("Red Sox"), test);
    }

    //Manager should be able to multiple teams
    @Test
    void testInsertMultipleTeams() {
        Team test = new Team("Red Sox");
        Team b = new Team("White Sox");
        tm.addNewEntryToList(test);
        tm.addNewEntryToList(b);
        assertEquals(tm.size(), 2);
        assertEquals(tm.getFromListByName("Red Sox"), test);
        assertEquals(tm.getFromListByName("White Sox"), b);
    }

    //Manager should be able to clear the list of teams
    @Test
    void testClearTeamsFromList() {
        Team test = new Team("Red Sox");
        Team b = new Team("White Sox");
        tm.addNewEntryToList(test);
        tm.addNewEntryToList(b);
        tm.clear();
        assertEquals(tm.size(), 0);
        assertTrue(tm.isListEmpty());
    }

    @Test
    void testReadDataFromExistingFile() {
        TeamManager tFile = new TeamManager(true, "C:\\Users\\grego\\Documents\\JavaProjects\\PenguinBaseball\\src\\main\\resources\\test.csv");
        assertEquals(tFile.size(), 1);
    }

    @Test
    void testSaveNewTeamsToFile() {
        TeamManager tFile = new TeamManager(true, "C:\\Users\\grego\\Documents\\JavaProjects\\PenguinBaseball\\src\\main\\resources\\test.csv");
        assertEquals(tFile.size(), 1);
        tFile.addNewEntryToList(new Team("Red Sox"));
        tFile.commitChangesToFile("C:\\Users\\grego\\Documents\\JavaProjects\\PenguinBaseball\\src\\main\\resources\\test.csv");
        TeamManager tFile2 = new TeamManager(true, "C:\\Users\\grego\\Documents\\JavaProjects\\PenguinBaseball\\src\\main\\resources\\test.csv");
        assertEquals(tFile2.size(), 2);
    }
}
