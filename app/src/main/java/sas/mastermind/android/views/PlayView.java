package sas.mastermind.android.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import sas.mastermind.android.R;
import sas.mastermind.core.controllers.PlayController;

public class PlayView extends Fragment {
    //private PlayViewBinding playViewBinding;
    public void interact(PlayController playController) {
        MainFragmentManager.setView(R.id.fragment_container_view, PlayView.class);
        playController.next();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.play_view, container, false);
    }
}
