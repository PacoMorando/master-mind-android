package sas.mastermind.android.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProposedCombinationDAO {
    @Insert
    void insert(ProposedCombination combination);

    @Update
    void update(ProposedCombination combination);

    @Delete
    void delete(ProposedCombination combination);

    @Query("SELECT * FROM ProposedCombination WHERE gameName = :gameName")
    List<ProposedCombination> gameProposedCombinations(String gameName);
}