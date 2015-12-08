package stan.presenter.mafia.ui.fragments.main;

import android.view.View;

import stan.presenter.mafia.R;
import stan.presenter.mafia.listeners.fragments.main.IMainFragmentClick;
import stan.presenter.mafia.ui.fragments.StanFragment;

public class MainFragment
        extends StanFragment
{
    static public MainFragment newInstance()
    {
        return new MainFragment();
    }

    public MainFragment()
    {
        super(R.layout.main_fragment, R.string.MainFragment);
    }

    @Override
    protected void findViews(View v)
    {
        super.findViews(v);
        v.findViewById(R.id.main_constructor).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getClickListener().constructor();
            }
        });
        init();
    }
    private void init()
    {

    }

    private IMainFragmentClick getClickListener()
    {
        return (IMainFragmentClick) clickListener;
    }
}