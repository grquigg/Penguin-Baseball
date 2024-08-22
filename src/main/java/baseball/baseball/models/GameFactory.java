package baseball.baseball.models;

public interface GameFactory {
    AbstractGame createAbstractGame(Team teamA, Team teamB);
}

