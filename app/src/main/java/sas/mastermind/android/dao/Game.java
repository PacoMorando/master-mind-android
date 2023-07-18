package sas.mastermind.android.dao;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Game {
    @PrimaryKey
    @NonNull
    public String name;
    public String secretCombination;


    public Game(@NonNull String name, String secretCombination) {
        this.name = name;
        this.secretCombination = secretCombination;
    }
}