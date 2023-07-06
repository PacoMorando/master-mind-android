package sas.mastermind.android.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import sas.mastermind.android.R;
import sas.mastermind.android.databinding.PlayViewBinding;

public class BoardRecyclerAdapter extends RecyclerView.Adapter<BoardRecyclerAdapter.ViewHolder> {
    private static final int PROPOSED_COMBINATIONS_SIZE = 10;
    private PlayViewBinding binding;

    /*public BoardAdapter(PlayViewBinding binding) {
        this.binding = binding;
    }*/

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.proposed_combination_row, parent, false);
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
