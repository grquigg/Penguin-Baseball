package baseball.baseball.models;

public interface GameFactory {
    Game createAbstractGame();
    AbstractInning createAbstractInning();
}

