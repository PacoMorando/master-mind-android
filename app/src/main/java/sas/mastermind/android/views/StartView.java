package sas.mastermind.android.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import sas.mastermind.android.R;
import sas.mastermind.core.controllers.StartController;

public class StartView extends Fragment {
    public void interact(StartController startController) {

    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.start_view, container, false);
    }
}