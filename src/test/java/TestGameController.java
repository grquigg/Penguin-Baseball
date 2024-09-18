import baseball.baseball.controllers.GameController;
import baseball.baseball.controllers.GameManager;
import baseball.baseball.controllers.TeamManager;
import baseball.baseball.layouts.GameView;
import baseball.baseball.models.Team;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestGameController {

    private GameController gc;
    private GameManager gm;
    private GameView gv;

    @BeforeEach
    void setUp() {
        gv = new GameView("Test Game View");
        gv.setVisible(false);
        gm = new GameManager();
        gc = new GameController("C://Users/grego/Documents/JavaProjects/PenguinBaseball/src/main/resources/test.csv", gm, gv, true);
    }


    @Test
    void testLoadEntriesFromList() {
        assertEquals(1, gc.returnTeamManager().size());
    }

    /*
    In order to properly verify that this works, we need to ensure that
    there are valid entries in the list
     */
    @Test
    void testSelectTeamFromList() {

    }
}
