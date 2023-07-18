package sas.mastermind.android.dao;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class GameWithProposedCombinations {
    @Embedded
    public Game game;

    @Relation(parentColumn = "name", entityColumn = "gameName")
    public List<ProposedCombination> proposedCombinations;
}