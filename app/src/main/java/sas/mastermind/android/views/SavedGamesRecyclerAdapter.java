package sas.mastermind.android.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import sas.mastermind.android.R;

public class SavedGamesRecyclerAdapter extends RecyclerView.Adapter<SavedGamesRecyclerAdapter.ViewHolder> {
    private OpenDialog openDialog; //TODO Analizar si esto genera un ciclo y es por eso mejor declarar la interfaz
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
            if (this.openDialog != null) {
                this.openDialog.showGameNameClicked((String) holder.savedGame.getText());
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

    public void setOpenDialog (OpenDialog openDialog){
        this.openDialog = openDialog;
    }
}
