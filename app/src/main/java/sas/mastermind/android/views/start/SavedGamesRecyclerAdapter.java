package sas.mastermind.android.views.start;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import sas.mastermind.android.R;

public class SavedGamesRecyclerAdapter extends RecyclerView.Adapter<SavedGamesRecyclerAdapter.ViewHolder> {
    private OnSavedGameClickListener savedGameClickListener;
    private final String[] gamesNames;

    public SavedGamesRecyclerAdapter(String[] gamesNames) {
        this.gamesNames = gamesNames;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_saved_game, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(view -> {
            if (this.savedGameClickListener != null) {
                this.savedGameClickListener.onClickListener((String) holder.savedGame.getText());
            }
        });

        holder.savedGame.setText(gamesNames[position]);
    }

    @Override
    public int getItemCount() {
        return gamesNames.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView savedGame;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.savedGame = itemView.findViewById(R.id.savedGame);
        }
    }

    public void setSavedGameClickListener(OnSavedGameClickListener savedGameClickListener){
        this.savedGameClickListener = savedGameClickListener;
    }

    public interface OnSavedGameClickListener{
        void onClickListener(String name);
    }
}
