package stan.presenter.mafia.ui.activities;

import android.app.Activity;
import android.content.Intent;

import stan.presenter.mafia.R;
import stan.presenter.mafia.listeners.fragments.constructor.menu.IConstructorActionClick;
import stan.presenter.mafia.listeners.fragments.constructor.menu.IConstructorMenuClick;
import stan.presenter.mafia.listeners.fragments.constructor.menu.IConstructorRoleClick;
import stan.presenter.mafia.ui.fragments.constructor.menu.ConstructorActionList;
import stan.presenter.mafia.ui.fragments.constructor.menu.ConstructorMenu;
import stan.presenter.mafia.ui.fragments.constructor.menu.ConstructorRoleList;

public class Constructor
        extends StanActivity
        implements IConstructorMenuClick, IConstructorRoleClick, IConstructorActionClick
{
    static public final int ConstructorRequestCode = 1;

    static public void startConstructor(Activity activity)
    {
        activity.startActivityForResult(new Intent(activity, Constructor.class), ConstructorRequestCode);
    }

    //_______________VIEWS

    //_______________FRAGMENTS

    //_______________FIELDS

    public Constructor()
    {
        super(R.layout.constructor, R.id.constructor_frame);
    }

    @Override
    protected void initViews()
    {

    }

    @Override
    protected void init()
    {
        addFragment(ConstructorMenu.newInstance());
    }

    @Override
    public void toRoles()
    {
        replaceFragmentTag(ConstructorRoleList.newInstance());
    }

    @Override
    public void toActions()
    {
        replaceFragmentTag(ConstructorActionList.newInstance());
    }
}