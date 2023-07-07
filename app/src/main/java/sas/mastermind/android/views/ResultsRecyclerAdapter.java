package sas.mastermind.android.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import sas.mastermind.android.R;

public class ResultsRecyclerAdapter extends RecyclerView.Adapter<ResultsRecyclerAdapter.ViewHolder> {
    private final int PROPOSED_COMBINATIONS_SIZE = 10;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_combination_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.PROPOSED_COMBINATIONS_SIZE;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout boardRoad;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.boardRoad = itemView.findViewById(R.id.boardRoad);
        }
    }
}
