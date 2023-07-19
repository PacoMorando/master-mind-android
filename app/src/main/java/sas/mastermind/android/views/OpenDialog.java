package sas.mastermind.android.views;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import sas.mastermind.android.R;

public class OpenDialog extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(requireContext()).inflate(R.layout.open_game, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        RecyclerView savedGamesRecyclerView = view.findViewById(R.id.savedGames);
        savedGamesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        savedGamesRecyclerView.setAdapter(new SavedGamesRecyclerAdapter());
        builder.setTitle("Select Game")
                .setView(view);
        return builder.create();
    }
}
