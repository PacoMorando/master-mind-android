package sas.mastermind.android.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GameDao {
    @Query("SELECT * FROM game")
    List<Game> getGames();
    @Query("SELECT * FROM game WHERE name = :name")
    Game getGame(String name);

    @Insert
    void insert(Game game);

    @Delete
    void deleteAll(Game... user);

    @Query("SELECT * FROM game")
    List<GameWithProposedCombinations> gameWithProposedCombinations();
}