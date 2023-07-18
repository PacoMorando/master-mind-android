package sas.mastermind.android.dao;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ProposedCombination {

    @PrimaryKey(autoGenerate = true)
    public int Id;
    public String gameName;
    public String combination;

    public ProposedCombination(String gameName, String combination) {
        this.gameName = gameName;
        this.combination = combination;
    }
}
