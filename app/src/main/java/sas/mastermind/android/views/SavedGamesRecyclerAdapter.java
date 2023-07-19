package sas.mastermind.android.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import sas.mastermind.android.R;

public class SavedGamesRecyclerAdapter extends RecyclerView.Adapter<SavedGamesRecyclerAdapter.ViewHolder> {
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_saved_game, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.savedGame.setText("Game" + position);
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView savedGame;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.savedGame = itemView.findViewById(R.id.savedGame);
        }
    }
}
