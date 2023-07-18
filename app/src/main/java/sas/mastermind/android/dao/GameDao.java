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

    @Insert
    void insertAll(Game... games);

    @Delete
    void deleteAll(Game... user);

    @Query("SELECT * FROM game")
    List<GameWithProposedCombinations> gameWithProposedCombinations();
}