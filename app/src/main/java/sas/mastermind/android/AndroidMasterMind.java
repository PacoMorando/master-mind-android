package sas.mastermind.android;

import androidx.fragment.app.FragmentManager;

import sas.mastermind.android.dao.SessionDAO;
import sas.mastermind.core.controllers.AcceptorController;
import sas.mastermind.core.controllers.Logic;
import sas.mastermind.core.controllers.LogicImplementation;
import sas.mastermind.core.views.View;

public class AndroidMasterMind {
    private final Logic logic;//TODO Falta implementar el DAO
    private final View view;

    public AndroidMasterMind(FragmentManager supportFragmentManager) {
        this.logic = new LogicImplementation(new SessionDAO());//Falta implementar el DAO
        this.view = new sas.mastermind.android.views.View(supportFragmentManager);
    }

    protected void play() {
        AcceptorController acceptorController;
        acceptorController = this.logic.getController();
        if (acceptorController != null) {
            this.view.interact(acceptorController);
        }
    }
}