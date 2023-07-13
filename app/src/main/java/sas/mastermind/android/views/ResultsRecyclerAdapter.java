package sas.mastermind.android.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

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
    private int itemHeight;

    public ResultsRecyclerAdapter(PlayController playController) {
        ResultsRecyclerAdapter.playController = playController;
        proposedCombinations = ResultsRecyclerAdapter.playController.getProposeCombinations();
        // this.proposedCombinations = ResultsRecyclerAdapter.playController.getProposeCombinations();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_combination_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.showProposedCombinations(position);
        holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, this.itemHeight));
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

        protected void showProposedCombinations(int position) { //TODO REFACTORIZAR ESTE METODO YA QUE ESTE EL DISEÑO
            if (proposedCombinations.size() > position) {
                for (int i = 0; i < this.proposedColors.size(); i++) {
                    this.proposedColors.get(i).setImageResource(getColorResource(position, i));
                }
                this.setWhitesAndBlacks(position);
            }
        }

        private void setWhitesAndBlacks(int position) {
            int whites = playController.calculateWhites(proposedCombinations.get(position));
            int blacks = playController.calculateBlacks(proposedCombinations.get(position));
            this.setWhites(whites);
            this.setBlacks(blacks, whites);
        }

        private void setWhites(int whites) {
            if (whites > 0) {
                for (int i = 0; i < whites; i++) {
                    this.resultsColors.get(i).setImageResource(R.drawable.token_white);
                }
            }
        }

        private void setBlacks(int blacks, int whites) {
            if (blacks > 0) {
                for (int i = whites; i < blacks + whites; i++) {
                    this.resultsColors.get(i).setImageResource(R.drawable.token_black);
                }
            }
        }

        private int getColorResource(int position, int i) {
            return Colors.valueOf(String.valueOf(proposedCombinations.get(position).toString().charAt(i))).getColorResource();
        }
    }
}