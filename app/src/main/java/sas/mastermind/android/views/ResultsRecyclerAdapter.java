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
    private final PlayController playController;
    private final ArrayList<ProposedCombination> proposedCombinations;
    private final ArrayList<ResultCombination> resultsCombinations;
    private int itemHeight;

    public ResultsRecyclerAdapter(PlayController playController) {
        this.playController = playController;
        this.proposedCombinations = this.playController.getProposeCombinations();
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
        this.setItemViewCombinationsResults(holder, position);
        holder.showProposedCombinationsResult();
        holder.testCombination();
    }

    private void setItemViewCombinationsResults(@NonNull ViewHolder holder, int position) {
        if (this.proposedCombinations.size() > position) {
            holder.setProposedCombination(this.proposedCombinations.get(position).toString());
            this.setResults();
            holder.setResultCombination(this.resultsCombinations.get(position));
        }
    }

    private void setResults() {
        this.resultsCombinations.clear();
        for (ProposedCombination proposedCombination : this.proposedCombinations) {
            this.resultsCombinations.add(new ResultCombination(this.playController.calculateBlacks(proposedCombination), this.playController.calculateWhites(proposedCombination)));
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
        private final ArrayList<ImageView> proposedColors = new ArrayList<>();
        private final ArrayList<ImageView> resultsColors = new ArrayList<>();
        private String proposedCombination;
        private ResultCombination resultCombination;

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

        public void setProposedCombination(String proposedCombination) {
            this.proposedCombination = proposedCombination;
        }

        public void setResultCombination(ResultCombination resultCombination) {
            this.resultCombination = resultCombination;
        }

        protected void showProposedCombinationsResult() {
            if (this.proposedCombination != null) {
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
            return CombinationColors.valueOf(String.valueOf(this.proposedCombination.charAt(i))).getColorResource();
        }

        private void showResults() {
            for (int i = 0; i < this.resultsColors.size(); i++) {
                this.resultsColors.get(i).setImageResource(this.getResultImageResource(i));
            }
        }

        private int getResultImageResource(int i) {
            return this.resultCombination.getResultResource(i);
        }

        public void testCombination() {//TODO Borrar esto despues de que el adapter este funcionando y refactorizado
            if (this.proposedCombination != null) {
                System.out.println(this.proposedCombination);
            } else {
                System.out.println("NULL");
            }
        }
    }
}