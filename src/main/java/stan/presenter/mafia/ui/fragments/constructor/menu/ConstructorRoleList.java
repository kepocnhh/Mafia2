package stan.presenter.mafia.ui.fragments.constructor.menu;

import android.view.View;

import stan.presenter.mafia.R;
import stan.presenter.mafia.listeners.fragments.constructor.menu.IConstructorRoleClick;
import stan.presenter.mafia.ui.fragments.StanFragment;

public class ConstructorRoleList
        extends StanFragment
{
    static public ConstructorMenu newInstance()
    {
        return new ConstructorMenu();
    }

    public ConstructorRoleList()
    {
        super(R.layout.constructor_role_list, R.string.ConstructorRoleList);
    }

    @Override
    protected void findViews(View v)
    {
        super.findViews(v);
        init();
    }
    private void init()
    {

    }

    private IConstructorRoleClick getClickListener()
    {
        return (IConstructorRoleClick) clickListener;
    }
}