package sas.mastermind.android.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Game.class, ProposedCombination.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract GameDao gameDao();
    public abstract ProposedCombinationDAO proposedCombinationDAO();

}
