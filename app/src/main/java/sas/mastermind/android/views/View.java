package sas.mastermind.android.views;

import sas.mastermind.android.R;
import sas.mastermind.core.controllers.PlayController;
import sas.mastermind.core.controllers.ResumeController;
import sas.mastermind.core.controllers.SaveController;
import sas.mastermind.core.controllers.StartController;

public class View extends sas.mastermind.core.views.View {
    private final StartView startView;
    private final PlayView playView;
    private final SaveView saveView;
    private final ResumeView resumeView;

    public View() {
        this.startView = new StartView();
        this.playView = new PlayView();
        this.saveView = new SaveView();
        this.resumeView = new ResumeView();
    }

    @Override
    public void visit(StartController startController) {
        Activity.setFragmentView(R.id.fragment_container_view, this.startView);
        this.startView.interact(startController);
    }

    @Override
    public void visit(PlayController playController) {
        Activity.setFragmentView(R.id.fragment_container_view, this.playView);
        this.playView.interact(playController);
    }

    @Override
    public void visit(SaveController saveController) {
        Activity.setFragmentView(R.id.fragment_container_view, this.saveView);
        this.saveView.interact(saveController);
    }

    @Override
    public void visit(ResumeController resumeController) {
        Activity.setFragmentView(R.id.fragment_container_view, this.resumeView);
        this.resumeView.interact(resumeController);
    }
}