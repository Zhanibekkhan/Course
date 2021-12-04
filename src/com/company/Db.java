package com.company;

import java.util.ArrayList;

/**
 * Interface db.java классы әдістерді қамтиды
 */
public interface Db {
    /**
     * Базадан ақпаратты алу әдісі. Database.java классында қайта анықталған
     * @param players ArrayList<Player> players
     */
    void savePlayer(ArrayList<Player> players);
    ArrayList<Player> getAllPlayer();
    ArrayList<GameResult> getResult();
    void saveGame(ArrayList<GameResult> gameResults);
}
