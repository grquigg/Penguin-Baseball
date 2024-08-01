package baseball.baseball.controllers;

/*
It is generally a good idea to have a generic interface for managing all of the different attributes of this program.
There are going to be at least a few different lists of different objects (Teams, Players, Pitchers, Games, Innings, Plays, etc.) that need to be
handled, so it's good to just have a one size fits all approach to it
 */
public interface Manager<T> {
    public T getFromList();
    public void addNewEntryToList(T t);

    public void deleteEntry(T t);
    public boolean isListEmpty();
    public int size();

}
