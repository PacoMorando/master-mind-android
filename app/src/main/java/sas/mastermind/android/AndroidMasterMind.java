package sas.mastermind.android;

import androidx.fragment.app.FragmentManager;

import sas.mastermind.android.dao.SessionDAO;
import sas.mastermind.core.MasterMind;
import sas.mastermind.core.controllers.Logic;
import sas.mastermind.core.controllers.LogicImplementation;
import sas.mastermind.core.views.View;

public class AndroidMasterMind extends MasterMind {

    @Override
    protected Logic createLogic() {
        return new LogicImplementation(new SessionDAO());//Falta implementar el DAO
    }

    @Override
    protected View createView() {
        return new sas.mastermind.android.views.View();
    }

    @Override
    protected void play() {
        super.play();
    }
}