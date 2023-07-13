package sas.mastermind.android.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sas.mastermind.android.R;
import sas.mastermind.core.controllers.PlayController;
import sas.mastermind.core.models.ProposedCombination;

public class ResultsRecyclerAdapter extends RecyclerView.Adapter<ResultsRecyclerAdapter.ViewHolder> {
    private final int PROPOSED_COMBINATIONS_SIZE = 10;
    private static PlayController playController;
    private static ArrayList<ProposedCombination> proposedCombinations;
    private static ArrayList<ResultCombination> resultsCombinations;
    private int itemHeight;

    public ResultsRecyclerAdapter(PlayController playController) {
        ResultsRecyclerAdapter.playController = playController;
        proposedCombinations = ResultsRecyclerAdapter.playController.getProposeCombinations();
        resultsCombinations = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_combination_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, this.itemHeight));
        this.setResults();
        holder.showProposedCombinationsResult();
    }

    private void setResults() {
        resultsCombinations.clear();
        for (ProposedCombination proposedCombination : proposedCombinations) {
            resultsCombinations.add(new ResultCombination(playController.calculateBlacks(proposedCombination), playController.calculateWhites(proposedCombination)));
        }
    }

    @Override
    public int getItemCount() {
        return this.PROPOSED_COMBINATIONS_SIZE;
    }

    public void setItemHeight(int recyclerHeight) {
        this.itemHeight = recyclerHeight / this.PROPOSED_COMBINATIONS_SIZE;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ArrayList<ImageView> proposedColors = new ArrayList<>();
        ArrayList<ImageView> resultsColors = new ArrayList<>();

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.proposedColors.add(itemView.findViewById(R.id.colorOne));
            this.proposedColors.add(itemView.findViewById(R.id.colorTwo));
            this.proposedColors.add(itemView.findViewById(R.id.colorThree));
            this.proposedColors.add(itemView.findViewById(R.id.colorFour));
            this.resultsColors.add(itemView.findViewById(R.id.resultOne));
            this.resultsColors.add(itemView.findViewById(R.id.resultTwo));
            this.resultsColors.add(itemView.findViewById(R.id.resultThree));
            this.resultsColors.add(itemView.findViewById(R.id.resultFour));
        }

        protected void showProposedCombinationsResult() {
            if (proposedCombinations.size() > getLayoutPosition()) {
                this.showProposedCombinations();
                this.showResults();
            }
        }

        private void showProposedCombinations() {
            for (int i = 0; i < this.proposedColors.size(); i++) {
                this.proposedColors.get(i).setImageResource(getColorResource(i));
            }
        }

        private int getColorResource(int i) {
            return CombinationColors.valueOf(String.valueOf(proposedCombinations.get(getLayoutPosition()).toString().charAt(i))).getColorResource();
        }

        private void showResults() {
            for (int i = 0; i < this.resultsColors.size(); i++) {
                this.resultsColors.get(i).setImageResource(this.getResultImageResource(i));
            }
        }

        private int getResultImageResource(int i) {
            return resultsCombinations.get(getLayoutPosition()).getResultResource(i);
        }
    }
}