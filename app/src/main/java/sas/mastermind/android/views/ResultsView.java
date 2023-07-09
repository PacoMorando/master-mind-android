package sas.mastermind.android.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import sas.mastermind.android.databinding.ResultsViewBinding;
import sas.mastermind.core.controllers.PlayController;
import sas.mastermind.core.models.ProposedCombination;

public class ResultsView extends Fragment {
    private ResultsViewBinding binding;
    private final ResultsRecyclerAdapter resultsRecyclerAdapter;

    public ResultsView(PlayController playController) {
        this.resultsRecyclerAdapter = new ResultsRecyclerAdapter(playController);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = ResultsViewBinding.inflate(inflater, container, false);
        this.binding.setResultsView(this);
        this.setResultsRecyclerView();
        return this.binding.getRoot();
    }

    private void setResultsRecyclerView() {
        this.binding.resultsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.binding.resultsRecyclerView.setAdapter(this.resultsRecyclerAdapter);
    }

    public void showProposedCombinationsResult() {
            this.resultsRecyclerAdapter.notifyDataSetChanged();
    }
}