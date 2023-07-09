package sas.mastermind.android.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    }

    @Override
    public int getItemCount() {
        return this.PROPOSED_COMBINATIONS_SIZE;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView results;
        ArrayList<TextView> proposedColors = new ArrayList<>();

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.results = itemView.findViewById(R.id.results);
            this.proposedColors.add(itemView.findViewById(R.id.colorOne));
            this.proposedColors.add(itemView.findViewById(R.id.colorTwo));
            this.proposedColors.add(itemView.findViewById(R.id.colorThree));
            this.proposedColors.add(itemView.findViewById(R.id.colorFour));
        }

        protected void showProposedCombinations(int position, ArrayList<ProposedCombination> proposedCombinations) { //TODO REFACTORIZAR ESTE METODO
            if (proposedCombinations.size() > position) {
                for (int i = 0; i < this.proposedColors.size(); i++) {
                    this.proposedColors.get(i).setText(String.valueOf(proposedCombinations.get(position).toString().charAt(i)));
                }
                int whites = playController.calculateWhites(proposedCombinations.get(position));
                int blacks = playController.calculateBlacks(proposedCombinations.get(position));
                this.results.setText("W=" + whites + "\nB=" + blacks);
            }
            /*if (proposedCombinations.size() == 0) {
                for (int i = 0; i < this.proposedColors.size(); i++) {
                    this.proposedColors.get(i).setText("*");
                }
                this.results.setText("");
            }*/
        }
    }
}