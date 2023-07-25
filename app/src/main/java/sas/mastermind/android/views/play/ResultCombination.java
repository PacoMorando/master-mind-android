package sas.mastermind.android.views.play;

import sas.mastermind.android.R;
import sas.mastermind.android.views.CombinationColors;

public class ResultCombination {
    private final int whiteResource = R.drawable.token_white;
    private final int blackResource = R.drawable.token_black;
    private final int emptyResource = R.drawable.token_empty;
    private final int[] resultResources = new int[CombinationColors.COMBINATION_SIZE];

    public ResultCombination(int blacks, int whites) {
        this.setResultResources(blacks, whites);
    }

    private void setResultResources(int blacks, int whites) {
        this.setBlacks(blacks);
        this.setWhites(blacks, whites);
        this.setEmpties(blacks, whites);
    }

    private void setBlacks(int blacks) {
        if (blacks > 0) {
            for (int i = 0; i < blacks; i++) {
                this.resultResources[i] = this.blackResource;
            }
        }
    }

    private void setWhites(int blacks, int whites) {
        if (whites > 0) {
            for (int i = blacks; i < whites + blacks; i++) {
                this.resultResources[i] = this.whiteResource;
            }
        }
    }

    private void setEmpties(int blacks, int whites) {
        for (int i = blacks + whites; i < CombinationColors.COMBINATION_SIZE; i++) {
            this.resultResources[i] = this.emptyResource;
        }
    }

    public int getResultResource(int i) {
        return this.resultResources[i];
    }
}