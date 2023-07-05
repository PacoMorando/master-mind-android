package sas.mastermind.android;

import sas.mastermind.android.dao.SessionDAO;
import sas.mastermind.core.controllers.AcceptorController;
import sas.mastermind.core.controllers.Logic;
import sas.mastermind.core.controllers.LogicImplementation;
import sas.mastermind.core.views.View;

public class AndroidMasterMind {
    private final Logic logic;//Falta implementar el DAO
    private final View view;

    public AndroidMasterMind() {
        this.logic = new LogicImplementation(new SessionDAO());//Falta implementar el DAO
        this.view = new sas.mastermind.android.views.View();
    }

    protected void play() {
        AcceptorController acceptorController;
        acceptorController = this.logic.getController();
        if (acceptorController != null) {
            this.view.interact(acceptorController);
        }
    }
}