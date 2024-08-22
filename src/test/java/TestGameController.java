import baseball.baseball.controllers.GameController;
import baseball.baseball.controllers.GameManager;
import baseball.baseball.controllers.TeamManager;
import baseball.baseball.models.Team;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestGameController {

    private GameController gc;
    private GameManager gm;


    @BeforeEach
    void setUp() {
        gc = new GameController("", gm, null);
    }

    @Test
    void testSelectTeamFromList() {

    }
}
