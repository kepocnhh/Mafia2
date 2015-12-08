package stan.presenter.mafia.ui.fragments.constructor.menu;

import android.view.View;

import stan.presenter.mafia.R;
import stan.presenter.mafia.listeners.fragments.constructor.menu.IConstructorMenuClick;
import stan.presenter.mafia.ui.fragments.StanFragment;

public class ConstructorMenu
        extends StanFragment
{
    static public ConstructorMenu newInstance()
    {
        return new ConstructorMenu();
    }

    public ConstructorMenu()
    {
        super(R.layout.constructor_menu, R.string.ConstructorMenu);
    }

    @Override
    protected void findViews(View v)
    {
        super.findViews(v);
        v.findViewById(R.id.to_roles).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getClickListener().toRoles();
            }
        });
        v.findViewById(R.id.to_actions).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getClickListener().toActions();
            }
        });
        init();
    }
    private void init()
    {

    }

    private IConstructorMenuClick getClickListener()
    {
        return (IConstructorMenuClick) clickListener;
    }
}