package sas.mastermind.android.dao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Game {
    @PrimaryKey
    public String name;
    @ColumnInfo(name = "secret_combination")
    public String secretCombination;
    public ArrayList<String> proposedCombination;
}
