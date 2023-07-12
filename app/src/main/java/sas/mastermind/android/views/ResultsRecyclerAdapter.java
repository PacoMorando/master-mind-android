package sas.mastermind.android.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sas.mastermind.android.R;
import sas.mastermind.core.controllers.PlayController;
import sas.mastermind.core.models.ProposedCombination;

public class ResultsRecyclerAdapter extends RecyclerView.Adapter<ResultsRecyclerAdapter.ViewHolder> {
    private final int PROPOSED_COMBINATIONS_SIZE = 10;
    private static PlayController playController;
    private final ArrayList<ProposedCombination> proposedCombinations;
    private int itemHeight;

    public ResultsRecyclerAdapter(PlayController playController) {
        ResultsRecyclerAdapter.playController = playController;
        this.proposedCombinations = ResultsRecyclerAdapter.playController.getProposeCombinations();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_combination_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.showProposedCombinations(position, this.proposedCombinations);
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
        LinearLayout results;
        ArrayList<ImageView> proposedColors = new ArrayList<>();

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.results = itemView.findViewById(R.id.results);
            this.proposedColors.add(itemView.findViewById(R.id.colorOne));
            this.proposedColors.add(itemView.findViewById(R.id.colorTwo));
            this.proposedColors.add(itemView.findViewById(R.id.colorThree));
            this.proposedColors.add(itemView.findViewById(R.id.colorFour));
        }

        protected void showProposedCombinations(int position, ArrayList<ProposedCombination> proposedCombinations) { //TODO REFACTORIZAR ESTE METODO YA QUE ESTE EL DISEÑO
            if (proposedCombinations.size() > position) {
                for (int i = 0; i < this.proposedColors.size(); i++) {
                    this.proposedColors.get(i).setImageResource(getColorResource(position, proposedCombinations, i));
                }
                int whites = playController.calculateWhites(proposedCombinations.get(position));
                int blacks = playController.calculateBlacks(proposedCombinations.get(position));
                //this.results.setText("W=" + whites + "\nB=" + blacks);
            }
        }

        private int getColorResource(int position, ArrayList<ProposedCombination> proposedCombinations, int i) {
            return Colors.valueOf(String.valueOf(proposedCombinations.get(position).toString().charAt(i))).getColorResource();
        }
    }
}